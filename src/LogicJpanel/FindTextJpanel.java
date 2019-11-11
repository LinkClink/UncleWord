package LogicJpanel;

import SubGui.FindTextJframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindTextJpanel implements ActionListener
{
    JTextArea jTextArea;

    public FindTextJpanel(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new FindTextJframe().create(jTextArea);
    }
}