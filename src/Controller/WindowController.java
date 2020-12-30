package Controller;

import View.MainView;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WindowController implements ActionListener, MenuListener {
    private MainController mc;
    private MainView mv;

    private String id;

    private int buttonCounter = 0;

    private ArrayList<Component> addedComponents;
    private ArrayList<String> addedComponentIDs;
    private ArrayList<String> addedToIDs;

    private String selectedMenu = "";


    public WindowController(MainController mc, MainView mv, String id) {
        this.mc = mc;
        this.mv = mv;
        this.id = id;
        addedComponents = new ArrayList<Component>();
        addedComponentIDs = new ArrayList<String>();
        addedToIDs = new ArrayList<String>();
    }

    @Override
    public void menuSelected(MenuEvent e) {
        selectedMenu = ((JMenu) e.getSource()).getActionCommand();
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionPerformed = ((AbstractButton)e.getSource()).getActionCommand();
        System.out.println("ActionPerformed:"+actionPerformed+", SelectedMenu:"+selectedMenu);
        switch (actionPerformed) {
            case "New":
                mc.openCreateDialog();
                break;
            default:
                if (selectedMenu != "") {
                    switch (selectedMenu) {
                        case "Add":
                            buttonCounter++;
                            String buttonName = "Button"+buttonCounter;

                            JButton aux = new JButton(buttonName);
                            mv.addGUI(aux, BorderLayout.CENTER);
                            addedComponents.add(aux);
                            addedComponentIDs.add(buttonName);

                            updateMainViewMenu();
                            break;
                        case "Remove":
                            //Remove action command follows Remove::<Name> format
                            //We split the action command and keep the 2nd ([1]) part as name
                            String name = actionPerformed.split("::")[1];
                            System.out.println("CompName:"+name);
                            int index = addedComponentIDs.indexOf(name);
                            //We remove the component from the mainview
                            mv.discard(addedComponents.get(index));
                            //We remove the component id and the component itself
                            addedComponentIDs.remove(index);
                            addedComponents.remove(index);
                            updateMainViewMenu();
                            break;
                    }
                }
        }
    }

    public void updateMainViewMenu () {
        mv.updateRemoveMenu(addedComponentIDs);
        //Register each of the new menu items in RemoveMenu
        int menuSize = mv.getjMenuRemove().getItemCount();
        for (int i = 0; i < menuSize; i++) {
            mv.getjMenuRemove().getItem(i).addActionListener(this);
        }
    }
}
