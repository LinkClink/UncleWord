package LogicJpanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutProgram implements ActionListener

{


    @Override
    public void actionPerformed(ActionEvent e)
    {
            JOptionPane.showMessageDialog(new JDialog(), "(Lightweight text editor ver_0.1)\n" +
                    "Jest stworzony dla redaktowania teksu\n" +
                    "email:shekaqwe@gmail.com \n by LinkClink", "About program", JOptionPane.INFORMATION_MESSAGE);
    }
}
