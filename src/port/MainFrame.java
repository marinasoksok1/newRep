package port;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
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
        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Container container = new Container();
            container.setIDNumber(Integer.parseInt(IDTextField.getText()));
            descriptionIsShownHereTextArea.append(IDTextField.getText());
            descriptionIsShownHereTextArea.append("; "+getWeightField.getText());

            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame= new MainFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
