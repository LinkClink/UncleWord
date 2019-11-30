package LogicJpanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutProgram implements ActionListener

{
    @Override
    public void actionPerformed(ActionEvent e)
    {
            JOptionPane.showMessageDialog(new JDialog(), "(Uncle word - text editor v.0.21.1)\n"+
                    "email:shekaqwe@gmail.com \n by LinkClink", "About program", JOptionPane.INFORMATION_MESSAGE);
    }
}
