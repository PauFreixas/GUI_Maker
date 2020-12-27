package View;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainView extends GUIWindow {

    private JButton jbutton;

    private JComboBox jcbSwingComp;

    private JComboBox jcbPositions;

    private JTextField jtfButtonName;

    private JTextField jtfAdd;
    private JButton jbAdd;
    private ArrayList<String> listOptions;

    private JPanel jpAddedOptions;

    private JPanel cards;


    public MainView() throws HeadlessException {
        listOptions = new ArrayList<String>();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jbutton = new JButton("ADD");
        jcbSwingComp = new JComboBox(getSwingComponents());
        jcbPositions = new JComboBox(getPositions());

        JPanel buttonOptionsCard = new JPanel();
        buttonOptionsCard.setLayout(new GridLayout(2,1));
        JPanel jpName = new JPanel();
        JLabel jlName = new JLabel("Name: ");
        jtfButtonName = new JTextField(10);
        jpName.add(jlName);
        jpName.add(jtfButtonName);
        /*JPanel jpIcon = new JPanel();
        JLabel jlIcon = new JLabel("Icon:");
        JFileChooser jfcIcon = new JFileChooser();
        jpIcon.add(jlIcon);
        jpIcon.add(jfcIcon);

        buttonOptionsCard.add(jpIcon);*/
        buttonOptionsCard.add(jpName);

        JPanel listOptionsCard = new JPanel();
        listOptionsCard.setLayout(new BoxLayout(listOptionsCard, BoxLayout.Y_AXIS));
        JPanel jpAddOption = new JPanel();
        jtfAdd = new JTextField(10);
        jbAdd = new JButton("Add");
        jpAddOption.add(jtfAdd);
        jpAddOption.add(jbAdd);
        jpAddedOptions = new JPanel();
        jpAddedOptions.setLayout(new BoxLayout(jpAddedOptions, BoxLayout.Y_AXIS));
        listOptionsCard.add(jpAddOption);
        listOptionsCard.add(jpAddedOptions);

        cards = new JPanel(new CardLayout());
        cards.add(buttonOptionsCard, "1");
        cards.add(listOptionsCard, "2");





        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(jcbSwingComp);
        this.getContentPane().add(jcbPositions);

        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards,"1");

        this.add(cards);

        this.getContentPane().add(jbutton);

        this.pack();
        this.setVisible(true);
    }

    public JButton getJbutton() {
        return jbutton;
    }

    public String getSelectedComponent () {
        return (String) jcbSwingComp.getSelectedItem();
    }

    public String getSelectedPosition () {
        return (String) jcbPositions.getSelectedItem();
    }

    public JComboBox getJcbSwingComp() {
        return jcbSwingComp;
    }

    public JComboBox getJcbPositions() {
        return jcbPositions;
    }

    public String getJtfButtonName() {
        return jtfButtonName.getText();
    }

    public void updateViewComponentType() {
        CardLayout cl = (CardLayout) cards.getLayout();
        switch ((String)jcbSwingComp.getSelectedItem()) {
            case "JButton":
                cl.show(cards,"1");
                break;
            default:
                cl.show(cards,"2");
                jpAddedOptions.removeAll();
                listOptions.clear();
                break;
        }
    }

    public String getJtfAddText() {
        return jtfAdd.getText();
    }

    public JButton getJbAdd() {
        return jbAdd;
    }

    public void addToOptionList(String s) {
        listOptions.add(s);
        jpAddedOptions.add(new JLabel(s));
        System.out.println(listOptions);
        this.pack();
        this.revalidate();
    }

    public ArrayList<String> getListOptions() {
        return listOptions;
    }
}
