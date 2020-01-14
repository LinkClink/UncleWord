package LogicJpanel;

import logic.FileSet;
import logic.SaveFileFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveTxT implements ActionListener
{
    private JTextArea jTextArea;
    private String buffer_file;

    FileSet fileSet = new FileSet();
    SaveFileFunctions SaveFileFunctions = new SaveFileFunctions();

    public SaveTxT(JTextArea jTextArea)
    { this.jTextArea = jTextArea; }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        buffer_file = fileSet.getBuffer_file();
        
            if (buffer_file != null) 
            { SaveFileFunctions.Save(jTextArea); }
            else
            { SaveFileFunctions.SaveAs(jTextArea); }
    }
}
