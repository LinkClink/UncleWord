package LogicJpanel;

import logic.FileSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetCoding implements ActionListener
{
    private Object e_get;

    private String[] codding = new String[]{"Cp1251","UTF-8","Auto"};

    private JCheckBoxMenuItem open_ansi;
    private JCheckBoxMenuItem save_ansi;

    private JCheckBoxMenuItem open_utf;
    private JCheckBoxMenuItem save_utf;

    private JCheckBoxMenuItem open_auto;
    private JCheckBoxMenuItem save_auto;

    FileSet fileSet = new FileSet();

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


        /** Open ANSI  */
        if(e_get==open_ansi)
        {
            fileSet.setFile_code_open(codding[0]);
            open_ansi.setEnabled(false);
            open_utf.setEnabled(true);
            open_auto.setEnabled(true);
            open_utf.setState(false);
            open_auto.setState(false);
        }
        /** Open UTF-8  */
        if(e_get==open_utf)
        {
            fileSet.setFile_code_open(codding[1]);
            open_utf.setEnabled(false);
            open_ansi.setEnabled(true);
            open_auto.setEnabled(true);
            open_auto.setState(false);
            open_ansi.setState(false);
        }
        /** Open AUTO */
        if(e_get == open_auto)
        {
            fileSet.setFile_code_open(codding[2]);
            open_auto.setEnabled(false);
            open_ansi.setEnabled(true);
            open_utf.setEnabled(true);
            open_ansi.setState(false);
            open_utf.setState(false);
        }
        /** Save ANSI  */
        if(e_get==save_ansi)
        {
            fileSet.setFile_code_save(codding[0]);
            save_ansi.setEnabled(false);
            save_utf.setEnabled(true);
            save_auto.setEnabled(true);
            save_utf.setState(false);
            save_auto.setState(false);
        }
        /** Save UTF-8  */
        if(e_get==save_utf)
        {
            fileSet.setFile_code_save(codding[1]);
            save_utf.setEnabled(false);
            save_ansi.setEnabled(true);
            save_auto.setEnabled(true);
            save_auto.setState(false);
            save_ansi.setState(false);
        }
        /** Save AUTO */
        if(e_get==save_auto)
        {
            fileSet.setFile_code_save(codding[2]);
            save_auto.setEnabled(false);
            save_utf.setEnabled(true);
            save_ansi.setEnabled(true);
            save_utf.setState(false);
            save_ansi.setState(false);
        }
    }
}
