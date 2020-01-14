package LogicJpanel;

import logic.FileSet;
import logic.ShowErrorDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NewFile implements ActionListener 
{
    private JTextArea jTextArea;
    private String buffer_file;
    private String code_save;
    private String save_text;

    private int switch1;

    FileSet fileSet = new FileSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    private FileWriter fileWriter;
    private Writer out;

    public NewFile(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        buffer_file = fileSet.getBuffer_file();
        code_save = fileSet.getFile_code_save();

            if (buffer_file != null) // check file is open
            {
                switch1 = JOptionPane.showConfirmDialog(
                        new JPanel(),
                        "Save changes " + buffer_file,
                        "UncleWord",
                        JOptionPane.YES_NO_OPTION);

                switch (switch1)
                {
                    case 0: // save chL::
                    {
                        save_text = jTextArea.getText();
                        try
                        {
                            fileWriter = new FileWriter(buffer_file);
                        } catch (IOException e1) { showErrorDialog.show_dialog_0(e1.getMessage()); }
                        try
                        {
                            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(buffer_file), code_save));
                        } catch (UnsupportedEncodingException e1)
                        { showErrorDialog.show_dialog_0(e1.getMessage()); }
                        catch (FileNotFoundException e1)
                        { showErrorDialog.show_dialog_0(e1.getMessage()); }
                        try
                        {
                            out.write(save_text);
                        } catch (IOException e1)
                        { showErrorDialog.show_dialog_0(e1.getMessage()); }
                        finally
                        {
                            try
                            {
                                out.close();
                            } catch (IOException e1)
                            { showErrorDialog.show_dialog_0(e1.getMessage()); }
                        }
                        jTextArea.setText(null);
                        fileSet.setBuffer_file(null);
                        break;
                    }
                    case 1: // don't save ::
                    {
                        jTextArea.setText(null);
                        fileSet.setBuffer_file(null);
                        break;
                    }
                }
            }
    }
}
