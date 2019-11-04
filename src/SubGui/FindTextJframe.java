package SubGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindTextJframe extends JPanel
{
    private JRadioButton markRadioButton;
    private JRadioButton selectRadioButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton resetButton;
    private JButton findButton;
    private JPanel Jpanel;

    public FindTextJframe()
    {
       setVisible(true);

        findButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

    public void  create()
    {
        JFrame test = new JFrame();
        test.setContentPane(new FindTextJframe().Jpanel);
        test.setVisible(true);
        test.setResizable(false);
        test.setSize(299,104);
    }


}
