package SubGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramStyle extends JFrame
{
    private JComboBox boardcolor;
    private JComboBox textcolor;
    private JComboBox menucolor;
    private JButton applyButton;
    private JButton resetButton;
    private JComboBox menufont;
    private JPanel jpanel;

    static JTextArea jTextArea;
    static JMenu jMenu1;
    static JMenu jMenu2;
    static JMenu jMenu3;
    static JMenu jMenu4;

    JFrame jFrame = new JFrame();

    public void create (JTextArea jTextArea, JMenu jMenu1, JMenu jMenu2, JMenu jMenu3, JMenu jMenu4)
    {
        this.jTextArea = jTextArea;
        this.jMenu1 = jMenu1;
        this.jMenu2 = jMenu2;
        this.jMenu3 = jMenu3;
        this.jMenu4 = jMenu4;

        jFrame.setContentPane(new ProgramStyle().jpanel);
        jFrame.setTitle("Replace:");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(380,100);
        jFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 380) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 100) / 2);
    }

    public ProgramStyle()
    {
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SubGuiLogic.ProgramStyle programStyle = new SubGuiLogic.ProgramStyle();
                programStyle.ResetStyle(jTextArea,jMenu1,jMenu2,jMenu3,jMenu4);
            }
        });
        applyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SubGuiLogic.ProgramStyle programStyle = new SubGuiLogic.ProgramStyle();
                programStyle.SetStyle(jTextArea,jMenu1,jMenu2,jMenu3,jMenu4,(String) boardcolor.getSelectedItem(), (String) textcolor.getSelectedItem(),
                                                                              (String) menucolor.getSelectedItem(),(String) menufont.getSelectedItem());
            }
        });
    }
}
