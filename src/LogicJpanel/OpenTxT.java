package LogicJpanel;

import gui.MainJpanel;
import logic.FileSet;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class OpenTxT extends Component implements ActionListener

{
    int save_dialog;
    int result;

    private String buffer_file;
    private JTextArea jTextArea;

    FileSet fileSet = new FileSet();

    String save_text;
    String textLine;

    JFileChooser fileChooser_open = new JFileChooser();
    
    FileInputStream fileInputStream_1 = null;
    BufferedReader buffer_reader= null;


    FileNameExtensionFilter filter_1 = new FileNameExtensionFilter("*.txt", "txt");

    FileReader fileReader = null;
    FileWriter fileWriter = null;
    Writer out = null;

    //Ansi    UTF-8
    String code_open;
    String code_save;
    
    public OpenTxT(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;


        fileChooser_open.addChoosableFileFilter(filter_1);
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
                if (save_dialog == 1)
                {
                    save_text = jTextArea.getText();
                    try
                    {
                        fileWriter = new FileWriter(buffer_file);
                    } catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    try {
                        out = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(buffer_file), code_save));
                    } catch (UnsupportedEncodingException e1)
                    {
                        e1.printStackTrace(); //add show dialog
                    } catch (FileNotFoundException e1)
                    {
                        e1.printStackTrace();
                    }
                    try {
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
                }
            }
            // --1--

            result = fileChooser_open.showOpenDialog(OpenTxT.this);

            if (result == JFileChooser.APPROVE_OPTION) //positive result
            {
                jTextArea.setText(null);

                try {
                    fileReader = new FileReader(fileChooser_open.getSelectedFile());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    fileInputStream_1 = new FileInputStream(fileChooser_open.getSelectedFile());
                    buffer_file = String.valueOf(fileChooser_open.getSelectedFile());

                    fileSet.setBuffer_file(buffer_file);
                } catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                try {
                    System.out.print(code_open);
                    buffer_reader= new BufferedReader(new InputStreamReader(fileInputStream_1, code_open));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }

                try {
                    while ((textLine = buffer_reader.readLine()) != null)
                    {
                        jTextArea.append(textLine + "\n");

                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    buffer_reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    fileReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    fileInputStream_1.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
    }
}
