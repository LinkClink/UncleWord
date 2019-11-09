package LogicJpanel;

import SubGui.ReplaceTextJframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceTextJpanel implements ActionListener
{
    JTextArea jTextArea;

    public ReplaceTextJpanel(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(new ReplaceTextJframe().getWindowsVisible() == false)
        new ReplaceTextJframe().create(jTextArea);
    }
}
