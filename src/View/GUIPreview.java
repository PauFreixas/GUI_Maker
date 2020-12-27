package View;

import com.company.Main;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class GUIPreview extends GUIWindow {

    private MainView mainView;

    public GUIPreview(MainView mainView) throws HeadlessException {
        this.mainView = mainView;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
        this.getContentPane().setLayout(new BorderLayout());
    }

    public void addGUI(String selectedComponent, String selectedPosition) {
        System.out.println("Reached");
        String position = "";

        switch (selectedPosition) {
            //Top
            case "Top":
                position = BorderLayout.PAGE_START;
                break;
            //Bottom
            case "Bottom":
                position = BorderLayout.PAGE_END;
                break;
            case "Left":
                position = BorderLayout.LINE_START;
                break;
            case "Right":
                position = BorderLayout.LINE_END;
                break;
            default:
                position = BorderLayout.CENTER;
                break;
        }

        switch (selectedComponent) {
            case "JButton":
                System.out.println("Reached2, pos:"+ position);
                this.getContentPane().add(new JButton(mainView.getJtfButtonName()), position);
                break;
            default:

                //this.getContentPane().add(new Checkbox(mainView.getListOptions()), position);
                break;
        }
        this.pack();
        this.getContentPane().revalidate();
    }
}
