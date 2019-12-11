package LogicJpanel;

import logic.FileSet;
import logic.ShowErrorDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveTxT implements ActionListener
{
    private JTextArea jTextArea;
    private String buffer_file;
    private String code_save;
    private String save_text;
    
    FileWriter fileWriter = null;
    Writer writer = null;
    
    FileSet fileSet = new FileSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    public SaveTxT(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        code_save = fileSet.getFile_code_save();
        buffer_file = fileSet.getBuffer_file();
        
            if (buffer_file != null) 
            {
                save_text = jTextArea.getText();
                try
                {
                    fileWriter = new FileWriter(buffer_file);
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(buffer_file), code_save));
                } catch (UnsupportedEncodingException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage());
                } catch (FileNotFoundException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    writer.write(save_text);
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                finally
                {
                    try
                    {
                        writer.close();
                    } catch (IOException e1)
                    { showErrorDialog.show_dialog_0(e1.getMessage()); }
                }
            }
    }
}
