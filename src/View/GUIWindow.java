package View;

import javax.swing.*;

public class GUIWindow extends JFrame {
    private String[] swingComponents = { "JButton", "JCheckBox", "JComboBox", "JList", "JMenu", "JRadioButton", "JSLider","JSpinner", "JTextField", "JPasswordField" };
    private String[] positions = { "Top", "Bottom", "Center", "Left", "Right" };

    public String[] getSwingComponents() {
        return swingComponents;
    }

    public String[] getPositions() {
        return positions;
    }
}
