package port;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrame extends JFrame {
    private JLabel IDLabel;
    private JTextField IDTextField;
    private JPanel mainPanel;
    private JTextField getWeightField;
    private JTextArea containerDescriptionField;
    private JTextField remitentCompanyField;
    private JTextField receiverCompanyField;
    private JComboBox comboBox1;
    private JRadioButton a1RadioButton;
    private JCheckBox checkBox1;
    private JTextArea a1TextArea;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JPanel operationsPanel;
    private JTextField columnNumberTextField;
    private JButton pileButton;
    private JButton unpileButton;
    private JButton showContainerDescriptionButton;
    private JTextArea descriptionIsShownHereTextArea;
    private JButton numberOfContainersButton;
    private JComboBox comboBox2;
    private JTextField putNumberHereTextField;
    Font niceFont = new Font("Andaluz", Font.BOLD, 22);


    public MainFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setFont(niceFont);
        int screenWidth = screenSize.width - 10;
        int screenHeight = screenSize.height - 10;
        setTitle("Valencia Port Management");
        setContentPane(mainPanel);
        getContentPane().setFont(niceFont);
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hub hub = new Hub();
                String str = "";
                //hub.setIDNumber(Integer.parseInt(IDTextField.getText()));
                descriptionIsShownHereTextArea.append(IDTextField.getText());
                descriptionIsShownHereTextArea.append("; " + getWeightField.getText());
                Container container = new Container(Integer.parseInt(IDTextField.getText()));
                container.setWeight(Integer.parseInt(getWeightField.getText()));
                descriptionIsShownHereTextArea.append("; " + remitentCompanyField.getText());
                descriptionIsShownHereTextArea.append("; " + receiverCompanyField.getText());
                container.setDescription(containerDescriptionField.getText());
                descriptionIsShownHereTextArea.append(containerDescriptionField.getText());
                if (a1RadioButton.isSelected()) {
                    container.setPriority(1);
                    descriptionIsShownHereTextArea.append("; " + "Priority 1");
                } else if (a2RadioButton.isSelected()) {
                    container.setPriority(2);
                    descriptionIsShownHereTextArea.append("; " + "Priority 2");
                } else if (a3RadioButton.isSelected()) {
                    container.setPriority(3);
                    descriptionIsShownHereTextArea.append("; " + "Priority 3");
                }
                if (checkBox1.isSelected()) {
                    container.setInspection(true);
                    descriptionIsShownHereTextArea.append("; " + "Is inspected");
                } else {
                    container.setInspection(false);
                }
                try {
                    hub.stackContainer(container);//pile();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                descriptionIsShownHereTextArea.setVisible(true);
            }
        });
        checkBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox1.isSelected()) {
                    checkBox1.setText("Yes");
                } else {
                    checkBox1.setText("No");
                }
            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(6, 10, new Insets(0, 0, 0, 0), -1, -1));
        IDTextField = new JTextField();
        IDTextField.setText("1");
        mainPanel.add(IDTextField, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Weight (tons)");
        mainPanel.add(label1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getWeightField = new JTextField();
        getWeightField.setText("");
        mainPanel.add(getWeightField, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Description");
        mainPanel.add(label2, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        containerDescriptionField = new JTextArea();
        containerDescriptionField.setLineWrap(false);
        containerDescriptionField.setText(" Description is shown here");
        mainPanel.add(containerDescriptionField, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Remitent company");
        mainPanel.add(label3, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        remitentCompanyField = new JTextField();
        remitentCompanyField.setText("1");
        mainPanel.add(remitentCompanyField, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Receiver company");
        mainPanel.add(label4, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        receiverCompanyField = new JTextField();
        receiverCompanyField.setText("");
        mainPanel.add(receiverCompanyField, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Country");
        mainPanel.add(label5, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Albania");
        defaultComboBoxModel1.addElement("Belarussia");
        defaultComboBoxModel1.addElement("Belgium");
        defaultComboBoxModel1.addElement("Chipre");
        defaultComboBoxModel1.addElement("Danmark");
        defaultComboBoxModel1.addElement("Germany");
        defaultComboBoxModel1.addElement("Italy");
        defaultComboBoxModel1.addElement("Spain");
        comboBox1.setModel(defaultComboBoxModel1);
        mainPanel.add(comboBox1, new GridConstraints(0, 6, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Priority");
        mainPanel.add(label6, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a1RadioButton = new JRadioButton();
        a1RadioButton.setSelected(true);
        a1RadioButton.setText("1");
        mainPanel.add(a1RadioButton, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Custom inspection");
        mainPanel.add(label7, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkBox1 = new JCheckBox();
        checkBox1.setSelected(true);
        checkBox1.setText("");
        mainPanel.add(checkBox1, new GridConstraints(3, 6, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("State (hub plan)");
        mainPanel.add(label8, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a1TextArea = new JTextArea();
        a1TextArea.setText("1");
        mainPanel.add(a1TextArea, new GridConstraints(2, 6, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        a2RadioButton = new JRadioButton();
        a2RadioButton.setText("2");
        mainPanel.add(a2RadioButton, new GridConstraints(1, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a3RadioButton = new JRadioButton();
        a3RadioButton.setText("3");
        mainPanel.add(a3RadioButton, new GridConstraints(1, 8, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        operationsPanel = new JPanel();
        operationsPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(operationsPanel, new GridConstraints(5, 4, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        columnNumberTextField = new JTextField();
        columnNumberTextField.setText("Column number");
        operationsPanel.add(columnNumberTextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pileButton = new JButton();
        pileButton.setText("Pile");
        operationsPanel.add(pileButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        unpileButton = new JButton();
        unpileButton.setText("Unpile");
        operationsPanel.add(unpileButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showContainerDescriptionButton = new JButton();
        showContainerDescriptionButton.setText("Show Container description");
        operationsPanel.add(showContainerDescriptionButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        descriptionIsShownHereTextArea = new JTextArea();
        descriptionIsShownHereTextArea.setText("Description is shown here");
        operationsPanel.add(descriptionIsShownHereTextArea, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        numberOfContainersButton = new JButton();
        numberOfContainersButton.setText("Number of containers");
        operationsPanel.add(numberOfContainersButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Albania");
        comboBox2.setModel(defaultComboBoxModel2);
        operationsPanel.add(comboBox2, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        putNumberHereTextField = new JTextField();
        putNumberHereTextField.setText("Put number here");
        operationsPanel.add(putNumberHereTextField, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Operations");
        mainPanel.add(label9, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Company logo");
        mainPanel.add(label10, new GridConstraints(0, 9, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 128), null, 0, false));
        IDLabel = new JLabel();
        IDLabel.setText(" ID Number");
        mainPanel.add(IDLabel, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
