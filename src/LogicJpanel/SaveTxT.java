package LogicJpanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveTxT implements ActionListener
{
    private JTextArea jTextArea;
    private String buffer_text;
    private String code_save;
    
    FileWriter fileWriter = null;
    Writer writer = null;
    
    
    
    public SaveTxT(JTextArea jTextArea, String buffer_text,String code_save)
    {
        this.jTextArea = jTextArea;
        this.buffer_text = buffer_text;
        this.code_save = code_save;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
            if (buffer_text != null) 
            {
                String s = jTextArea.getText();
                try {
                    fileWriter = new FileWriter(buffer_text);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(buffer_text), code_save));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    writer.write(s);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
    }
}
