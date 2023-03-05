package port;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JLabel IDLabel;
    private JTextField IDTextField;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextArea descriptionIsShownHereTextArea1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JRadioButton a1RadioButton;
    private JCheckBox checkBox1;
    private JTextArea textArea2;
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


    public MainFrame(){
        setTitle("Port Management");
        setContentPane(mainPanel);
        setSize(1000,850);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame= new MainFrame();
    }
}
