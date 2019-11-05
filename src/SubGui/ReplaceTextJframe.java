package SubGui;

import SubGuiLogic.ReplaceText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceTextJframe extends JFrame
{
    private JTextField textField1;
    private JTextField textField2;
    private JButton allButton;
    private JButton replaceButton;
    private JPanel Jpanel;

    public ReplaceTextJframe()
    {


        allButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ReplaceText replaceText = new ReplaceText();
                replaceText.ReplaceText();
            }
        });
    }

    public void  create()
    {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new ReplaceTextJframe().Jpanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(200,154);
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public String getTextField2() {
        return textField2.getText();
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

}

