package Controller;

import Model.Model;
import View.MainView;
import View.CreateDialog;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainController extends KeyAdapter implements ActionListener {
    private Model model;
    private ArrayList<WindowController> wControlers;
    private CreateDialog createDialog;

    public MainController() {
        this.model = new Model();
        this.wControlers = new ArrayList<WindowController>();
        this.createDialog = new CreateDialog();

        this.createDialog.getJbCreate().addKeyListener(this);
        this.createDialog.getJbCreate().addActionListener(this);
    }

    public void createNewView(String text) {
        MainView newView = new MainView(text);
        WindowController wc = new WindowController(this, newView, text);
        //Register menubar MenuListeners
        int menuBarSize = newView.getjMenuBar().getMenuCount();
        for (int i = 0; i < menuBarSize; i++) {
            int menuSize = newView.getjMenuBar().getMenu(i).getItemCount();

            newView.getjMenuBar().getMenu(i).addMenuListener(wc);
            //Register menuitems ActionListeners
            for (int j = 0; j < menuSize; j++) {
                newView.getjMenuBar().getMenu(i).getItem(j).addActionListener(wc);
            }
        }
    }

    public void init() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionPerformed = ((AbstractButton)e.getSource()).getActionCommand();
        if (actionPerformed == "Create") {
            createDialog.setVisible(false);
            createNewView(createDialog.getText());
        }
    }

    public void openCreateDialog() {
        createDialog.openDialog(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed");
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Hello");
        }
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
