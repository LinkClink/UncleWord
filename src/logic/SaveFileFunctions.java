package logic;

import javax.swing.*;
import java.io.*;

public class SaveFileFunctions extends JPanel
{
    FileSet fileSet = new FileSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    boolean filename_ck = true;
    private int validate_flag;
    private int validate_index;
    private String validate;

    private int result;
    private String code_save;
    private String buffer_file;
    private String save_text;

    private Writer out;
    private JFileChooser fileChooser = new JFileChooser();
    private FileWriter fileWriter = null;

    public void SaveAs(JTextArea jTextArea)
    {
        code_save = fileSet.getFile_code_save();

        result = fileChooser.showSaveDialog(SaveFileFunctions.this);

        if (fileChooser.getSelectedFile() != null)
        {
            validate = String.valueOf(fileChooser.getSelectedFile().getName());

            if(filename_ck == true) // ck file type
                buffer_file = String.valueOf(fileChooser.getSelectedFile()) + fileType_ck(validate);

            save_text = jTextArea.getText();

            try
            {
                fileWriter = new FileWriter(buffer_file);
            } catch (IOException e1)
            { showErrorDialog.show_dialog_0(e1.getMessage()); }
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
                    fileWriter.close();
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
            }
        }
    }

    public void Save(JTextArea jTextArea)
    {
        save_text = jTextArea.getText();
        try
        {
            fileWriter = new FileWriter(buffer_file);
        } catch (IOException e1)
        { showErrorDialog.show_dialog_0(e1.getMessage()); }
        try
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(buffer_file), code_save));
        } catch (UnsupportedEncodingException e1)
        { showErrorDialog.show_dialog_0(e1.getMessage());
        } catch (FileNotFoundException e1)
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
    }

    public String fileType_ck(String name)
    {
        validate_flag=name.lastIndexOf(".txt");
        validate_index=name.length();

        if( validate_index - 5 == validate_flag ) validate_flag = -1; else validate_flag = 0;

        switch (validate_flag)
        {
            case -1 & 0:
            { return ".txt"; }

            default:
            { return ""; }
        }
    }
}
