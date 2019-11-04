package LogicJpanel;

import gui.MainJpanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class OpenTxT extends Component implements ActionListener

{
    private String bufer_file;
    private JTextArea jTextArea;

    JFileChooser fileChooser_open = new JFileChooser();
    JFileChooser fileChooser_save = new JFileChooser();

    FileNameExtensionFilter filter_1 = new FileNameExtensionFilter("TxT", "txt");

    FileReader fileReader = null;
    FileWriter fileWriter = null;
    Writer out = null;

    //Ansi    UTF-8
    String[] codding = new String[]{"Cp1251","UTF-8"};
    String code_open = "Cp1251";
    String code_save = "Cp1251";

    String textLine;

    //
    int result;
    
    
    public OpenTxT(String bufer_file)
    {


    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
            if (bufer_file != null) 
            {
                int n = JOptionPane.showConfirmDialog(
                        new JPanel(),
                        "Save changes " + bufer_file,
                        "Lightweight text editor",
                        JOptionPane.YES_NO_OPTION);
                //save
                if (n == 1) {
                    String s = jTextArea.getText();
                    try {
                        fileWriter = new FileWriter(bufer_file);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        out = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(bufer_file), code_save));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        out.write(s);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            out.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            }

            jTextArea.setText(null);

            result = fileChooser_open.showOpenDialog(OpenTxT.this);

            if (result == JFileChooser.APPROVE_OPTION) {

                fileReader = null;
                FileInputStream fileInputStream_1 = null;
                BufferedReader bufer_reader = null;

                try {
                    fileReader = new FileReader(fileChooser_open.getSelectedFile());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    fileInputStream_1 = new FileInputStream(fileChooser_open.getSelectedFile());
                    bufer_file = String.valueOf(fileChooser_open.getSelectedFile());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    System.out.print(code_open);
                    bufer_reader = new BufferedReader(new InputStreamReader(fileInputStream_1, code_open));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }

                try {
                    while ((textLine = bufer_reader.readLine()) != null) {
                        jTextArea.append(textLine + "\n");

                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    bufer_reader.close();
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
