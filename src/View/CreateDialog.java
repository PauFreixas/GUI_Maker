package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateDialog extends JFrame {
    public static final String title = "Name your panel.";
    public static final String instructions = "Please name the UI panel you want to create:";

    private JTextField jtfName;
    private JButton jbCreate;

    public CreateDialog() {
        JLabel jlInstructions = new JLabel(instructions);
        this.getContentPane().add(jlInstructions, BorderLayout.PAGE_START);

        jtfName = new JTextField(20);
        this.getContentPane().add(jtfName, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jbCreate = new JButton("Create");
        jbCreate.setMnemonic(KeyEvent.VK_ENTER);
        jbCreate.setActionCommand("Create");

        panel.add(jbCreate);
        this.getContentPane().add(panel, BorderLayout.PAGE_END);

        this.getRootPane().setDefaultButton(jbCreate);

        this.setLocationRelativeTo(null);
        this.setTitle(title);
        this.pack();
        openDialog(true);
    }

    public void openDialog(boolean visible) {
        this.setVisible(visible);
        this.toFront();
        this.requestFocus();
        if (visible) {
            reset();
        }
    }

    public JButton getJbCreate() {
        return jbCreate;
    }

    public void reset() {
        jtfName.setText("");
    }

    public String getText() {
        return jtfName.getText();
    }
}
