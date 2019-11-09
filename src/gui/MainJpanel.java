/* Rebuild 08.06.2019 */

package gui;
import LogicJpanel.*;

import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJpanel extends JPanel
{
    //Ansi    UTF-8
    String[] codding = new String[]{"Cp1251","UTF-8"};
    String code_open = "Cp1251";
    String code_save = "Cp1251";

    //
    int result;
    int flag_check_box_dark_mode = 0;
    //
    String textLine = "";
    String bufer_file = null;

    //
    JFileChooser fileChooser_open = new JFileChooser();
    JFileChooser fileChooser_save = new JFileChooser();

    FileNameExtensionFilter filter_1 = new FileNameExtensionFilter("TxT", "txt");

    FileReader fileReader = null;
    FileWriter fileWriter = null;

    BufferedWriter bufferedWriter = null;

    Writer out = null;

    String data_string_date_format = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_string_date_format);

    String date_y_m_d = simpleDateFormat.format(new Date());

    Font font_menu_1 = new Font("Arial", Font.PLAIN, 11);

    Font font_menuitem_1 = new Font("Arial", Font.PLAIN, 10);
    Font font_menuitem_2 = new Font("Arial", Font.BOLD, 10);

    /////
    Font font_textArea_redactor_1 = new Font("Consolas", Font.PLAIN, 16);

    Font test_1 = new Font("Arial", Font.PLAIN, 7);

    Font font_label_1 = new Font("Arial", Font.PLAIN, 14);

    JMenuBar menubar_1 = new JMenuBar();
    JMenu menu_1 = new JMenu(" File ");
    JMenu menu_2 = new JMenu(" Editing ");
    JMenu menu_3 = new JMenu(" Settings ");
    JMenu menu_4 = new JMenu(" Appearance ");
    JMenu menu_5 = new JMenu(" Codding ");

    JMenu menu_5_sub_1 = new JMenu("  Codding Open  ");
    JMenu menu_5_sub_2 = new JMenu("  Codding Save  ");

    JMenuItem menu_1_item_1 = new JMenuItem("New ");
    JMenuItem menu_1_item_2 = new JMenuItem("Open ");
    JMenuItem menu_1_item_3 = new JMenuItem("Save ");
    JMenuItem menu_1_item_4 = new JMenuItem("Save As: ");
    JMenuItem menu_1_item_5 = new JMenuItem("Exit ");

    JMenuItem menu_2_item_1 = new JMenuItem(" Find  ");
    JMenuItem menu_2_item_2 = new JMenuItem(" Replace ");
    JMenuItem menu_2_item_3 = new JMenuItem(" Paste  ");
    JMenuItem menu_2_item_4 = new JMenuItem(" Copy ");

    JMenuItem menu_3_item_1 = new JMenuItem(" About ");
    JMenuItem menu_3_item_2 = new JMenuItem(" Font size ");

    JCheckBoxMenuItem menu_4_item_1_check = new JCheckBoxMenuItem(" Dark Mode ");

    JCheckBoxMenuItem menu_5_sub_1_check_1 = new JCheckBoxMenuItem(" ANSI ");
    JCheckBoxMenuItem menu_5_sub_1_check_2 = new JCheckBoxMenuItem(" UTF-8 ");

    JCheckBoxMenuItem menu_5_sub_2_check_1 = new JCheckBoxMenuItem(" ANSI ");
    JCheckBoxMenuItem menu_5_sub_2_check_2 = new JCheckBoxMenuItem(" UTF-8 ");

    public JTextArea getTextArea_redactor_1() {
        return textArea_redactor_1;
    }


    public void setTextArea_redactor_1(String text) {
        textArea_redactor_1.setText(text);
    }

     JTextArea textArea_redactor_1 = new JTextArea();
    JScrollPane scroll_textArea_redactor_1 = new JScrollPane(textArea_redactor_1);

    JLabel label_1 = new JLabel(date_y_m_d);

    Highlighter h = null;
    Highlighter.HighlightPainter h1 = null;

    ActionListener CopyTxT = new CopyText(textArea_redactor_1);
    ActionListener FindText = new FindText(textArea_redactor_1);
    ActionListener PasteText = new PasteText(textArea_redactor_1);
    ActionListener ReplaceTextJpanel = new ReplaceTextJpanel(textArea_redactor_1);
    ActionListener SaveTxT = new SaveTxT(textArea_redactor_1,bufer_file,code_save);
    ActionListener AboutProgram = new AboutProgram();

    public MainJpanel() {
        /////
        menubar_1.setBackground(Color.WHITE);

        menu_1.setForeground(Color.BLACK);

        menu_1_item_1.setBackground(Color.WHITE);
        menu_1_item_2.setBackground(Color.WHITE);
        menu_1_item_3.setBackground(Color.WHITE);
        menu_1_item_4.setBackground(Color.WHITE);
        menu_1_item_5.setBackground(Color.WHITE);

        menu_1_item_1.setForeground(Color.BLACK);
        menu_1_item_2.setForeground(Color.BLACK);
        menu_1_item_3.setForeground(Color.BLACK);
        menu_1_item_4.setForeground(Color.BLACK);
        menu_1_item_5.setForeground(Color.BLACK);

        menu_2.setForeground(Color.BLACK);
        menu_2_item_1.setBackground(Color.WHITE);
        menu_2_item_2.setBackground(Color.WHITE);
        menu_2_item_3.setBackground(Color.WHITE);
        menu_2_item_4.setBackground(Color.WHITE);

        menu_2_item_1.setForeground(Color.BLACK);
        menu_2_item_2.setForeground(Color.BLACK);
        menu_2_item_3.setForeground(Color.BLACK);
        menu_2_item_4.setForeground(Color.black);

        menu_3.setForeground(Color.BLACK);

        menu_3_item_1.setBackground(Color.WHITE);
        menu_3_item_2.setBackground(Color.WHITE);

        menu_3_item_1.setForeground(Color.BLACK);
        menu_3_item_2.setForeground(Color.BLACK);

        menu_4.setForeground(Color.BLACK);

        label_1.setForeground(Color.BLACK);

        menu_4_item_1_check.setBackground(Color.WHITE);
        menu_4_item_1_check.setForeground(Color.BLACK);

        textArea_redactor_1.setBackground(Color.WHITE);
        textArea_redactor_1.setForeground(Color.BLACK);

        setBackground(Color.WHITE);
        ///////

        setLayout(new BorderLayout());

        menu_1_item_1.setForeground(Color.GRAY);
        menu_1_item_5.setForeground(Color.GRAY);
        menu_4_item_1_check.setForeground(Color.BLACK);

        ////// Fonts All
        textArea_redactor_1.setFont(font_textArea_redactor_1);

        menu_1.setFont(font_menu_1);
        menu_2.setFont(font_menu_1);
        menu_3.setFont(font_menu_1);
        menu_4.setFont(font_menu_1);
        menu_5.setFont(font_menu_1);

        menu_5_sub_1.setFont(font_menuitem_1);
        menu_5_sub_2.setFont(font_menuitem_1);

        menu_1_item_1.setFont(font_menuitem_1);
        menu_1_item_2.setFont(font_menuitem_1);
        menu_1_item_3.setFont(font_menuitem_1);
        menu_1_item_4.setFont(font_menuitem_1);
        menu_1_item_5.setFont(font_menuitem_1);

        menu_2_item_1.setFont(font_menuitem_1);
        menu_2_item_2.setFont(font_menuitem_1);
        menu_2_item_3.setFont(font_menuitem_1);
        menu_2_item_4.setFont(font_menuitem_1);

        menu_3_item_1.setFont(font_menuitem_1);
        menu_3_item_2.setFont(font_menuitem_1);

        menu_4_item_1_check.setFont(font_menuitem_2);


        label_1.setFont(font_label_1);

        /// Controls Alt
        menu_1_item_1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.ALT_MASK));
        menu_1_item_2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menu_1_item_3.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_T, ActionEvent.ALT_MASK));
        // 2
        menu_2_item_1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        menu_2_item_2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.ALT_MASK));
        menu_2_item_3.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        menu_2_item_4.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        // 3
        menu_3_item_2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_B, ActionEvent.ALT_MASK));


        //// Add items to menu

        menu_1.add(menu_1_item_1);
        menu_1.add(menu_1_item_2);
        menu_1.add(menu_1_item_3);
        menu_1.add(menu_1_item_4);
        menu_1.add(menu_1_item_5);

        menu_2.add(menu_2_item_1);
        menu_2.add(menu_2_item_2);
        menu_2.add(menu_2_item_3);
        menu_2.add(menu_2_item_4);

        menu_3.add(menu_3_item_1);
        menu_3.add(menu_3_item_2);

        menu_4.add(menu_4_item_1_check);

        menu_5_sub_1.add(menu_5_sub_1_check_1);
        menu_5_sub_1.add(menu_5_sub_1_check_2);

        menu_5_sub_2.add(menu_5_sub_2_check_1);
        menu_5_sub_2.add(menu_5_sub_2_check_2);

        menu_5.add(menu_5_sub_1);
        menu_5.add(menu_5_sub_2);

        /// Add menu to menubar
        menubar_1.add(menu_1);
        menubar_1.add(menu_2);
        menubar_1.add(menu_3);
        menubar_1.add(menu_4);
        menubar_1.add(menu_5);


        menubar_1.setBackground(Color.WHITE);

        add(menubar_1, BorderLayout.NORTH);
        add(label_1, BorderLayout.SOUTH);
        add(scroll_textArea_redactor_1, BorderLayout.CENTER);

        //Set icons
        menu_1_item_1.setIcon(new ImageIcon("src/png/png_1.png"));
        menu_1_item_2.setIcon(new ImageIcon("src/png/png_2.png"));
        menu_1_item_3.setIcon(new ImageIcon("src/png/png_3.png"));
        menu_1_item_4.setIcon(new ImageIcon("src/png/png_4.png"));
        menu_1_item_5.setIcon(new ImageIcon("src/png/png_5.png"));

        //2
        menu_2_item_1.setIcon(new ImageIcon("src/png/png_6.png"));
        menu_2_item_2.setIcon(new ImageIcon("src/png/png_8.png"));
        menu_2_item_3.setIcon(new ImageIcon("src/png/png_7.png"));
        menu_2_item_4.setIcon(new ImageIcon("src/png/png_9.png"));

        //3
        menu_3_item_1.setIcon(new ImageIcon("src/png/png_10.png"));
        menu_3_item_2.setIcon(new ImageIcon("src/png/png_11.png"));


        //actions
        menu_1_item_1.addActionListener(new actions());
        menu_1_item_2.addActionListener(new actions());
        menu_1_item_3.addActionListener(SaveTxT);
        menu_1_item_4.addActionListener(new actions());
        menu_1_item_5.addActionListener(new actions());

        menu_2_item_1.addActionListener(FindText);
        menu_2_item_2.addActionListener(ReplaceTextJpanel);
        menu_2_item_3.addActionListener(PasteText);
        menu_2_item_4.addActionListener(CopyTxT);


        menu_3_item_1.addActionListener(AboutProgram);
        menu_3_item_2.addActionListener(new actions());

        menu_4_item_1_check.addActionListener(new actions());

        menu_5_sub_1_check_1.addActionListener(new actions());
        menu_5_sub_1_check_2.addActionListener(new actions());

        menu_5_sub_2_check_1.addActionListener(new actions());
        menu_5_sub_2_check_2.addActionListener(new actions());

        //FileCoser Setting
        fileChooser_open.setDialogTitle("Open File");
        fileChooser_open.setAcceptAllFileFilterUsed(false);
        fileChooser_open.addChoosableFileFilter(filter_1);

        /// Coding sets
        menu_5_sub_1_check_1.setState(true);
        menu_5_sub_2_check_1.setState(true);

        menu_5_sub_1_check_1.setEnabled(false);
        menu_5_sub_2_check_1.setEnabled(false);

    }

    class actions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Object e_get = e.getSource();
            //1
            /** NEW  */
            if (e_get == menu_1_item_1) {
                if (bufer_file != null) {
                    int n = JOptionPane.showConfirmDialog(
                            new JPanel(),
                            "Save changes " + bufer_file,
                            "Lightweight text editor",
                            JOptionPane.YES_NO_OPTION);
                    //save
                    if (n == 0) {
                        String s = textArea_redactor_1.getText();
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
                    //not save
                    if (n == 1)
                    {
                        textArea_redactor_1.setText(null);
                    }
                } else textArea_redactor_1.setText(null);

            }
            ///////////////////////////////////////////////////////////
            /** Open  */
            if (e_get == menu_1_item_2) {
                if (bufer_file != null) {
                    int n = JOptionPane.showConfirmDialog(
                            new JPanel(),
                            "Save changes " + bufer_file,
                            "Lightweight text editor",
                            JOptionPane.YES_NO_OPTION);
                    //save
                    if (n == 1) {
                        String s = textArea_redactor_1.getText();
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

                textArea_redactor_1.setText(null);

                result = fileChooser_open.showOpenDialog(MainJpanel.this);

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
                            textArea_redactor_1.append(textLine + "\n");

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
            ////////////////////////////////////////////////////////////////////////////////////
            /** Save */
            if (e_get == menu_1_item_3) {
                if (bufer_file != null) {
                    String s = textArea_redactor_1.getText();
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
            ////////////////////////////////////////////////////////////////////////////////
            /** Save As */
            if (e_get == menu_1_item_4)
            {
                if(textArea_redactor_1.getText()!=null) {
                    result = fileChooser_save.showSaveDialog(MainJpanel.this);

                    if (fileChooser_save.getSelectedFile() != null) {
                        bufer_file = String.valueOf(fileChooser_save.getSelectedFile());
                        System.out.print(bufer_file);
                        String s = textArea_redactor_1.getText();
                        FileWriter fileWriter = null;
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
            }
            //////////////////////////////////////////////////////////////////////////////////
            /** Exit */
            if (e_get == menu_1_item_5)
            {

            }
            //3

            /** Font size  */
            if (e_get == menu_3_item_2)
            {
                Object size = 0;
                Object[] possibilities = {11,14,16,18,20,22,26,28};
                size = JOptionPane.showInputDialog(
                        MainJpanel.this,
                        "Please selected to size:\n",
                        "Font size",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        16);
                if(size.hashCode() !=0)
                {
                    textArea_redactor_1.setFont(new Font("Arial", Font.PLAIN, size.hashCode()));
                }
            }
            //4
            /** Dark Mode */
            if(e_get==menu_4_item_1_check)
            {
                if(flag_check_box_dark_mode==0)
                {
                    menubar_1.setBackground(Color.BLACK);

                    menu_1.setForeground(Color.WHITE);
                    menu_1_item_1.setBackground(Color.BLACK);
                    menu_1_item_2.setBackground(Color.BLACK);
                    menu_1_item_3.setBackground(Color.BLACK);
                    menu_1_item_4.setBackground(Color.BLACK);
                    menu_1_item_5.setBackground(Color.BLACK);

                    menu_1_item_1.setForeground(Color.WHITE);
                    menu_1_item_2.setForeground(Color.WHITE);
                    menu_1_item_3.setForeground(Color.WHITE);
                    menu_1_item_4.setForeground(Color.WHITE);
                    menu_1_item_5.setForeground(Color.WHITE);

                    menu_2.setForeground(Color.WHITE);
                    menu_2_item_1.setBackground(Color.BLACK);
                    menu_2_item_2.setBackground(Color.BLACK);
                    menu_2_item_3.setBackground(Color.BLACK);
                    menu_2_item_4.setBackground(Color.BLACK);

                    menu_2_item_1.setForeground(Color.WHITE);
                    menu_2_item_2.setForeground(Color.WHITE);
                    menu_2_item_3.setForeground(Color.WHITE);
                    menu_2_item_4.setForeground(Color.WHITE);

                    menu_3.setForeground(Color.WHITE);

                    menu_3_item_1.setBackground(Color.BLACK);
                    menu_3_item_2.setBackground(Color.BLACK);

                    menu_3_item_1.setForeground(Color.WHITE);
                    menu_3_item_2.setForeground(Color.WHITE);

                    menu_4.setForeground(Color.WHITE);

                    label_1.setForeground(Color.WHITE);

                    menu_4_item_1_check.setBackground(Color.BLACK);
                    menu_4_item_1_check.setForeground(Color.WHITE);

                    menu_5.setForeground(Color.WHITE);

                    menu_5_sub_1_check_1.setForeground(Color.WHITE);
                    menu_5_sub_1_check_2.setForeground(Color.WHITE);

                    menu_5_sub_2_check_1.setForeground(Color.WHITE);
                    menu_5_sub_2_check_2.setForeground(Color.WHITE);

                    menu_5_sub_1_check_1.setBackground(Color.BLACK);
                    menu_5_sub_1_check_2.setBackground(Color.BLACK);

                    menu_5_sub_2_check_1.setBackground(Color.BLACK);
                    menu_5_sub_2_check_2.setBackground(Color.BLACK);

                    textArea_redactor_1.setBackground(Color.BLACK);
                    textArea_redactor_1.setForeground(Color.WHITE);


                    setBackground(Color.BLACK);
                    flag_check_box_dark_mode=1;

                }else
                {
                    menubar_1.setBackground(Color.WHITE);

                    menu_1.setForeground(Color.BLACK);
                    menu_1_item_1.setBackground(Color.WHITE);
                    menu_1_item_2.setBackground(Color.WHITE);
                    menu_1_item_3.setBackground(Color.WHITE);
                    menu_1_item_4.setBackground(Color.WHITE);
                    menu_1_item_5.setBackground(Color.WHITE);

                    menu_1_item_1.setForeground(Color.BLACK);
                    menu_1_item_2.setForeground(Color.BLACK);
                    menu_1_item_3.setForeground(Color.BLACK);
                    menu_1_item_4.setForeground(Color.BLACK);
                    menu_1_item_5.setForeground(Color.BLACK);

                    menu_2.setForeground(Color.BLACK);
                    menu_2_item_1.setBackground(Color.WHITE);
                    menu_2_item_2.setBackground(Color.WHITE);
                    menu_2_item_3.setBackground(Color.WHITE);
                    menu_2_item_4.setBackground(Color.WHITE);

                    menu_2_item_1.setForeground(Color.BLACK);
                    menu_2_item_2.setForeground(Color.BLACK);
                    menu_2_item_3.setForeground(Color.BLACK);
                    menu_2_item_4.setForeground(Color.black);

                    menu_3.setForeground(Color.BLACK);

                    menu_3_item_1.setBackground(Color.WHITE);
                    menu_3_item_2.setBackground(Color.WHITE);

                    menu_3_item_1.setForeground(Color.BLACK);
                    menu_3_item_2.setForeground(Color.BLACK);

                    menu_4.setForeground(Color.BLACK);

                    label_1.setForeground(Color.BLACK);

                    menu_5.setForeground(Color.BLACK);

                    menu_4_item_1_check.setBackground(Color.WHITE);
                    menu_4_item_1_check.setForeground(Color.BLACK);

                    menu_5_sub_1_check_1.setForeground(Color.BLACK);
                    menu_5_sub_1_check_2.setForeground(Color.BLACK);

                    menu_5_sub_2_check_1.setForeground(Color.BLACK);
                    menu_5_sub_2_check_2.setForeground(Color.BLACK);

                    menu_5_sub_1_check_1.setBackground(Color.WHITE);
                    menu_5_sub_1_check_2.setBackground(Color.WHITE);

                    menu_5_sub_2_check_1.setBackground(Color.WHITE);
                    menu_5_sub_2_check_2.setBackground(Color.WHITE);

                    textArea_redactor_1.setBackground(Color.WHITE);
                    textArea_redactor_1.setForeground(Color.BLACK);


                    setBackground(Color.WHITE);

                    flag_check_box_dark_mode=0;

                }
            }
            //5
            /** Open ANSI  */
            if(e_get==menu_5_sub_1_check_1)
            {
                code_open=codding[0];

                menu_5_sub_1_check_1.setEnabled(false);
                menu_5_sub_1_check_2.setEnabled(true);
                menu_5_sub_1_check_2.setState(false);

            }
            /** Open UTF-8  */
            if(e_get==menu_5_sub_1_check_2)
            {
                code_open=codding[1];

                menu_5_sub_1_check_2.setEnabled(false);
                menu_5_sub_1_check_1.setEnabled(true);
                menu_5_sub_1_check_1.setState(false);

            }
            /** Save ANSI  */
            if(e_get==menu_5_sub_2_check_1)
            {
                code_save=codding[0];

                menu_5_sub_2_check_1.setEnabled(false);
                menu_5_sub_2_check_2.setEnabled(true);
                menu_5_sub_2_check_2.setState(false);

            }
            /** Save UTF-8  */
            if(e_get==menu_5_sub_2_check_2)
            {
                code_save=codding[1];

                menu_5_sub_2_check_2.setEnabled(false);
                menu_5_sub_2_check_1.setEnabled(true);
                menu_5_sub_2_check_1.setState(false);

            }
        }
    }




}


