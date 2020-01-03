package LogicJpanel;

import SubGui.ProgramStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramStyleJpanel implements ActionListener
{
    JTextArea jTextArea;

    JMenu jMenu1;
    JMenu jMenu2;
    JMenu jMenu3;
    JMenu jMenu4;

    public ProgramStyleJpanel(JTextArea jTextArea, JMenu jMenu1, JMenu jMenu2, JMenu jMenu3, JMenu jMenu4)
    {
        this.jTextArea = jTextArea;
        this.jMenu1 = jMenu1;
        this.jMenu2 = jMenu2;
        this.jMenu3 = jMenu3;
        this.jMenu4 = jMenu4;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    { new ProgramStyle().create(jTextArea,jMenu1,jMenu2,jMenu3,jMenu4); }
}
