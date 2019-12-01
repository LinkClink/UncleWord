package LogicJpanel;

import gui.MainJpanel;
import logic.FileSet;

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

    Writer out;
    JFileChooser fileChooser = new JFileChooser();
    FileWriter fileWriter = null;


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
                    buffer_file = String.valueOf(fileChooser.getSelectedFile());
                    save_text = jTextArea.getText();

                    try
                    {
                        fileWriter = new FileWriter(buffer_file);
                    } catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    try {
                        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(buffer_file), code_save));
                    } catch (UnsupportedEncodingException e1)
                    {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1)
                    {
                        e1.printStackTrace();
                    }
                    try {
                        out.write(save_text);
                    } catch (IOException e1)
                    {
                        e1.printStackTrace();
                    } finally {
                        try {
                            out.close();
                        } catch (IOException e1)
                        {
                            e1.printStackTrace();
                        }
                    }

                }
            }
    }
}
