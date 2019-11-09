package SubGui;

import SubGuiLogic.ReplaceText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReplaceTextJframe extends JFrame
{
    private JTextField textField1;
    private JTextField textField2;
    private JButton allButton;
    private JButton replaceButton;
    private JPanel Jpanel;

    static Boolean windowsVisible = false;
    static JFrame jFrame = new JFrame();
    static JTextArea jTextArea;

    public void  create(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;

        jFrame.setContentPane(new ReplaceTextJframe().Jpanel);
        jFrame.setTitle("Replace:");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(250,180);
        jFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 250) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 180) / 2);

        windowsVisible = true;
    }
    public ReplaceTextJframe()
    {
        allButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ReplaceText replaceText = new ReplaceText();
                replaceText.ReplaceText(textField1,textField2);
            }
        });
        jFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                onClose();
                super.windowClosing(e);
            }
        });
    }

    public Boolean getWindowsVisible()
    {
        return windowsVisible;
    }

    public void onClose()
    {
     windowsVisible = false;
    }

    public JTextArea getjTextArea()
    {
        return jTextArea;
    }
}

