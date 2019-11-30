package LogicJpanel;

import logic.FileSet;

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

    int switch1;

    FileSet fileSet = new FileSet();

    FileWriter fileWriter;
    Writer out;

    public NewFile(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        buffer_file = fileSet.getBuffer_file();
        code_save = fileSet.getFile_code_save();

            if (buffer_file != null)
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
                        try {
                            fileWriter = new FileWriter(buffer_file);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            out = new BufferedWriter(new OutputStreamWriter(
                                    new FileOutputStream(buffer_file), code_save));
                        } catch (UnsupportedEncodingException e1)
                        {
                            e1.printStackTrace();
                        } catch (FileNotFoundException e1)
                        {
                            e1.printStackTrace();
                        }
                        try
                        {
                            out.write(save_text);
                        } catch (IOException e1)
                        {
                            e1.printStackTrace();
                        } finally
                        {
                            try
                            {
                                out.close();
                            } catch (IOException e1)
                            {
                                e1.printStackTrace();
                            }
                        }
                        break;
                    }
                    case 1: // dont save ::
                    {
                        jTextArea.setText(null);
                        break;
                    }
                }///
            }
    }
}
