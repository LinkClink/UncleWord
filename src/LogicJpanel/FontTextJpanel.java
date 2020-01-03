package LogicJpanel;

import SubGui.FontTextJframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontTextJpanel implements ActionListener
{
    JTextArea jTextArea;

    public FontTextJpanel(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new FontTextJframe().create(jTextArea);
    }
}
