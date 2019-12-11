package LogicJpanel;

import logic.FileSet;
import logic.ShowErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class SaveAsTxT extends Component implements ActionListener
{
    private JTextArea jTextArea;
    private int result;
    private String code_save;
    private String buffer_file;
    private String save_text;

    FileSet fileSet = new FileSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    private Writer out;
    private JFileChooser fileChooser = new JFileChooser();
    private FileWriter fileWriter = null;

    boolean filename_ck = true;
    private int validate_flag;
    String validate;

    public SaveAsTxT(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       code_save = fileSet.getFile_code_save();

            if(jTextArea.getText()!=null)
            {
                result = fileChooser.showSaveDialog(SaveAsTxT.this);

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
                    { showErrorDialog.show_dialog_0(e1.getMessage()); } catch (FileNotFoundException e1)
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
            }
    }

    public String fileType_ck(String name)
    {
        validate_flag=name.lastIndexOf(".txt");
        switch (validate_flag)
        {
            case -1:
            { return ".txt"; }

            default:
            { return ""; }
        }
    }
}
