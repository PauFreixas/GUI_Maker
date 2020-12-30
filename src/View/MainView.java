package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
    private String[] menuNames = {"File","Add", "Add to...", "Remove", "BorderLayout"};
    private String[][] menuItems = {{"New", "Save", "Save as...", "Load"},{"JButton", "JRadioButton"},{},{},{}};

    private JMenuBar jMenuBar;
    private JMenu jMenuRemove;

    private JPanel GUIPane;


    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Create menu bar from the literal Strings in menuNames
        for (int i = 0; i < menuNames.length; i++) {
            switch(menuNames[i]) {
                //Since remove will be updated we assign it to the private JMenu variable
                case "Remove":
                    jMenuRemove = new JMenu("Remove");
                    jMenuRemove.setEnabled(false);

                    menuBar.add(jMenuRemove);
                    break;
                default:
                    //Create new menu with the name given by the literals
                    JMenu menu = new JMenu(menuNames[i]);

                    //Fill menu with its items from the literal Strings in menuItems
                    for (int j = 0; j < menuItems[i].length; j++) {
                        JMenuItem item = new JMenuItem(menuItems[i][j]);
                        item.setActionCommand(menuItems[i][j]);
                        menu.add(item);
                    }

                    menuBar.add(menu);
                    break;
            }
        }
        return menuBar;
    }

    public MainView(String title) throws HeadlessException {
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jMenuBar = createMenuBar();

        this.getContentPane().add(jMenuBar, BorderLayout.PAGE_START);

        GUIPane = new JPanel();
        GUIPane.setSize(100,100);
        this.getContentPane().add(this.GUIPane, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }


    public JMenuBar getjMenuBar() {
        return this.jMenuBar;
    }

    public void addGUI(Component component, Object constraints) {
        GUIPane.add(component, constraints);
        this.revalidate();
        this.pack();
    }

    public JMenu getjMenuRemove() {
        return jMenuRemove;
    }

    public void updateRemoveMenu(ArrayList<String> addedItems) {
        jMenuRemove.removeAll();

        if (addedItems.size() > 0) {
            jMenuRemove.setEnabled(true);
            //Fill menu with its items from the literal Strings in menuItems
            for (int j = 0; j < addedItems.size(); j++) {
                JMenuItem item = new JMenuItem(addedItems.get(j));
                //For removing elements the action command format is Remove::<Name>
                item.setActionCommand("Remove"+"::"+addedItems.get(j));
                jMenuRemove.add(item);
            }

            jMenuRemove.revalidate();

        } else {
            //If there are no added components we should diable the menu
            jMenuRemove.setEnabled(false);
        }
    }

    public void discard (Component comp) {
        GUIPane.remove(comp);
        GUIPane.revalidate();
        GUIPane.repaint();
        this.pack();
    }
}