package LogicJpanel;

import SubGui.ReplaceTextJframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceTextJpanel implements ActionListener

{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        new ReplaceTextJframe().create();
    }
}
