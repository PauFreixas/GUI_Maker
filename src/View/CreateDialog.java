package View;

import javax.swing.*;
import java.awt.*;

public class NewDialog extends JDialog {
    public static final String title = "Name your panel.";
    public static final String instructions = "Please name the UI panel you want to create:";

    private JTextField jtfName;
    private JButton jbCreate;

    public NewDialog() {
        JLabel jlInstructions = new JLabel(instructions);
        this.getContentPane().add(jlInstructions, BorderLayout.PAGE_START);

        jtfName = new JTextField(20);
        this.getContentPane().add(jtfName, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jbCreate = new JButton("Create");
        panel.add(jbCreate);
        this.getContentPane().add(panel, BorderLayout.PAGE_END);

        this.setLocationRelativeTo(null);
        this.setTitle(title);
        this.pack();
        this.setVisible(true);
    }
}
