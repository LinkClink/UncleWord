package SubGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JPanel
{
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JPanel Jpanel;


    public test()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public void  create()
    {
        JFrame test = new JFrame();
        test.setContentPane(new test().Jpanel);
        test.setVisible(true);
        test.setResizable(false);
        test.setSize(204,154);
    }
}
