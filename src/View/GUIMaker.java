package View;

import javax.swing.*;

public final class GUIMaker {
    public static final String[] swingComponents = { "JButton", "JCheckBox", "JComboBox", "JList", "JMenu", "JRadioButton", "JSLider","JSpinner", "JTextField", "JPasswordField" };
    public static final String[] positions = { "Top", "Bottom", "Center", "Left", "Right" };



    public String[] getSwingComponents() {
        return swingComponents;
    }

    public String[] getPositions() {
        return positions;
    }
}
