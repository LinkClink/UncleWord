package LogicJpanel;

import logic.FileSet;
import logic.GetEncode;
import logic.ShowErrorDialog;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class OpenTxT extends Component implements ActionListener

{
    private int save_dialog;
    private int result;

    private String buffer_file;
    private JTextArea jTextArea;

    FileSet fileSet = new FileSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();
    GetEncode charsetDetector = new GetEncode();

    private String save_text;
    private String textLine;

    private JFileChooser fileChooser_open = new JFileChooser();
    private FileNameExtensionFilter filter_1 = new FileNameExtensionFilter("*.txt", "txt");
    
    private FileInputStream fileInputStream_1 = null;
    private BufferedReader buffer_reader= null;

    private FileReader fileReader = null;
    private FileWriter fileWriter = null;
    private Writer out = null;

    //Ansi+UTF-8+UTF-16
    private String code_open;
    private String code_save;

    public OpenTxT(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;

        fileChooser_open.addChoosableFileFilter(filter_1);
        fileChooser_open.setFileFilter(filter_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        code_open = fileSet.getFile_code_open();
        code_save = fileSet.getFile_code_save();

        buffer_file = fileSet.getBuffer_file(); //must get

        // Save block --1--
            if (buffer_file != null) // ++ file open check
            {
                save_dialog = JOptionPane.showConfirmDialog(new JPanel(),
                        "Save changes " + buffer_file,
                        "UncleWord",
                        JOptionPane.YES_NO_OPTION);
                //save
                if (save_dialog == 0)
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
                fileChooser_open.setCurrentDirectory(new File(buffer_file)); //set file directory
            }
            // --1--
            result = fileChooser_open.showOpenDialog(OpenTxT.this);

            if (result == JFileChooser.APPROVE_OPTION) //open file
            {
                jTextArea.setText(null);

                try
                {
                    fileReader = new FileReader(fileChooser_open.getSelectedFile());
                } catch (FileNotFoundException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    fileInputStream_1 = new FileInputStream(fileChooser_open.getSelectedFile());
                    buffer_file = String.valueOf(fileChooser_open.getSelectedFile());
                    fileSet.setBuffer_file(buffer_file);
                } catch (FileNotFoundException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    if(code_open.equals("AUTO"))
                    { code_open = charsetDetector.GetFileDecode(buffer_file); }

                    buffer_reader= new BufferedReader(new InputStreamReader(fileInputStream_1,code_open));

                } catch (UnsupportedEncodingException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    while ((textLine = buffer_reader.readLine()) != null) //read line-by-line
                    {
                        jTextArea.append(textLine + "\n");
                    }

                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    buffer_reader.close();
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    fileReader.close();
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }
                try
                {
                    fileInputStream_1.close();
                } catch (IOException e1)
                { showErrorDialog.show_dialog_0(e1.getMessage()); }

            }
    }
}
