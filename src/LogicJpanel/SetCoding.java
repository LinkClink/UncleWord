package LogicJpanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetCoding implements ActionListener
{
    private Object e_get;

    private JCheckBoxMenuItem open_ansi;
    private JCheckBoxMenuItem save_ansi;

    private JCheckBoxMenuItem open_utf;
    private JCheckBoxMenuItem save_utf;

    private JCheckBoxMenuItem open_auto;
    private JCheckBoxMenuItem save_auto;


    public SetCoding(JCheckBoxMenuItem open_ansi, JCheckBoxMenuItem save_ansi, JCheckBoxMenuItem open_utf,
                     JCheckBoxMenuItem save_utf, JCheckBoxMenuItem open_auto, JCheckBoxMenuItem save_auto)
    {
        this.open_ansi = open_ansi;
        this.save_ansi = save_ansi;

        this.open_utf = open_utf;
        this.save_utf = save_utf;

        this.open_auto = open_auto;
        this.save_auto = save_auto;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        e_get = e.getSource();




    }
}
