package SubGui;

import SubGuiLogic.FindText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindTextJframe extends JFrame
{
    private JRadioButton markRadioButton;
    private JRadioButton selectRadioButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton resetButton;
    private JButton findButton;
    private JPanel Jpanel;

    static JTextArea jTextArea = new JTextArea();
    static JFrame jFrame = new JFrame();

    public void  create(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;

        jFrame.setContentPane(new FindTextJframe().Jpanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle("Find:");
        jFrame.setSize(350,110);
        jFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 310) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 114) / 2);
    }

    public FindTextJframe()
    {

        findButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FindText findText = new FindText();
                findText.findtext(textField1);
            }
        });
    }

    public JTextArea getjTextArea()
    {
        return jTextArea;
    }

}
