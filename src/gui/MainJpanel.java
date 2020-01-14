/* Rebuild 08.06.2019 */

package gui;
import LogicJpanel.*;
import logic.FontSet;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJpanel extends JPanel
{
    FontSet fontSet = new FontSet();

    String data_string_date_format = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(data_string_date_format);

    String date_y_m_d = simpleDateFormat.format(new Date());

    Font font_menu_1 = new Font("Arial", Font.PLAIN, 11);
    Font font_menuitem_1 = new Font("Arial", Font.PLAIN, 10);
    Font font_textArea_redactor_1 = new Font(fontSet.getPrimary_font(), fontSet.getPrimary_font_style(), fontSet.getPrimary_font_size());
    Font font_label_1 = new Font("Arial", Font.PLAIN, 14);

    JMenuBar menubar_1 = new JMenuBar();
    JMenu menu_1 = new JMenu(" File ");
    JMenu menu_2 = new JMenu(" Editing ");
    JMenu menu_3 = new JMenu(" Settings ");
    JMenu menu_5 = new JMenu(" Codding ");

    JMenu menu_5_sub_1 = new JMenu("  Codding Open  ");
    JMenu menu_5_sub_2 = new JMenu("  Codding Save  ");

    JMenuItem menu_1_item_1 = new JMenuItem("New: ");
    JMenuItem menu_1_item_2 = new JMenuItem("Open: ");
    JMenuItem menu_1_item_3 = new JMenuItem("Save: ");
    JMenuItem menu_1_item_4 = new JMenuItem("Save As: ");
    JMenuItem menu_1_item_5 = new JMenuItem("Exit ");

    JMenuItem menu_2_item_1 = new JMenuItem(" Find  ");
    JMenuItem menu_2_item_2 = new JMenuItem(" Replace ");
    JMenuItem menu_2_item_3 = new JMenuItem(" Paste  ");
    JMenuItem menu_2_item_4 = new JMenuItem(" Copy ");

    JMenuItem menu_3_item_1 = new JMenuItem(" About ");
    JMenuItem menu_3_item_2 = new JMenuItem(" Font text ");
    JMenuItem menu_3_item_3 = new JMenuItem(" Program style ");

    JCheckBoxMenuItem menu_5_sub_1_check_1 = new JCheckBoxMenuItem("ANSI");
    JCheckBoxMenuItem menu_5_sub_1_check_2 = new JCheckBoxMenuItem("UTF-8");
    JCheckBoxMenuItem menu_5_sub_1_check_3 = new JCheckBoxMenuItem("AUTO");
    JCheckBoxMenuItem menu_5_sub_1_check_4 = new JCheckBoxMenuItem("UTF-16");

    JCheckBoxMenuItem menu_5_sub_2_check_1 = new JCheckBoxMenuItem("ANSI");
    JCheckBoxMenuItem menu_5_sub_2_check_2 = new JCheckBoxMenuItem("UTF-8");
    JCheckBoxMenuItem menu_5_sub_2_check_3 = new JCheckBoxMenuItem("UTF-16");

    JTextArea textArea_redactor_1 = new JTextArea();
    JScrollPane scroll_textArea_redactor_1 = new JScrollPane(textArea_redactor_1);

    JLabel label_1 = new JLabel(date_y_m_d);

    ActionListener CopyTxT = new CopyText(textArea_redactor_1);
    ActionListener FindTextJpanel = new FindTextJpanel(textArea_redactor_1);
    ActionListener PasteText = new PasteText(textArea_redactor_1);
    ActionListener ReplaceTextJpanel = new ReplaceTextJpanel(textArea_redactor_1);
    ActionListener SaveTxT = new SaveTxT(textArea_redactor_1);
    ActionListener AboutProgram = new AboutProgram();
    ActionListener OpenTxT = new OpenTxT(textArea_redactor_1);
    ActionListener NewFile = new NewFile(textArea_redactor_1);
    ActionListener SaveAsTxT = new SaveAsTxT(textArea_redactor_1);
    ActionListener CloseProgram = new CloseProgram(textArea_redactor_1);
    ActionListener FontTextJpanel = new FontTextJpanel(textArea_redactor_1);
    ActionListener ProgramStyleJpanel = new ProgramStyleJpanel(textArea_redactor_1,menu_1,menu_2,menu_3,menu_5);
    ActionListener SetCoding = new SetCoding(menu_5_sub_1_check_1,menu_5_sub_2_check_1,menu_5_sub_1_check_2,
                                             menu_5_sub_2_check_2,menu_5_sub_1_check_3,menu_5_sub_2_check_3,menu_5_sub_1_check_4);

    public MainJpanel()
    {
        //Set Colors
        textArea_redactor_1.setBackground(Color.WHITE);
        textArea_redactor_1.setForeground(Color.BLACK);

        setLayout(new BorderLayout());

        menu_1_item_1.setForeground(Color.GRAY);
        menu_1_item_5.setForeground(Color.GRAY);
        ////// Fonts All
        textArea_redactor_1.setFont(font_textArea_redactor_1);

        menu_1.setFont(font_menu_1);
        menu_2.setFont(font_menu_1);
        menu_3.setFont(font_menu_1);
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
        menu_3_item_3.setFont(font_menuitem_1);

        label_1.setFont(font_label_1);
        /// Controls Alt
        menu_1_item_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
        menu_1_item_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menu_1_item_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        // 2
        menu_2_item_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        menu_2_item_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
        menu_2_item_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        menu_2_item_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        // 3
        menu_3_item_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
        menu_3_item_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));

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
        menu_3.add(menu_3_item_3);

        menu_5_sub_1.add(menu_5_sub_1_check_1);
        menu_5_sub_1.add(menu_5_sub_1_check_2);
        menu_5_sub_1.add(menu_5_sub_1_check_4);
        menu_5_sub_1.add(menu_5_sub_1_check_3);

        menu_5_sub_2.add(menu_5_sub_2_check_1);
        menu_5_sub_2.add(menu_5_sub_2_check_2);
        menu_5_sub_2.add(menu_5_sub_2_check_3);

        menu_5.add(menu_5_sub_1);
        menu_5.add(menu_5_sub_2);
        /// Add menu to menubar
        menubar_1.add(menu_1);
        menubar_1.add(menu_2);
        menubar_1.add(menu_3);
        menubar_1.add(menu_5);

        menubar_1.setBackground(Color.WHITE);

        add(menubar_1, BorderLayout.NORTH);
        add(label_1, BorderLayout.SOUTH);
        add(scroll_textArea_redactor_1, BorderLayout.CENTER);
        //actions
        menu_1_item_1.addActionListener(NewFile);
        menu_1_item_2.addActionListener(OpenTxT);
        menu_1_item_3.addActionListener(SaveTxT);
        menu_1_item_4.addActionListener(SaveAsTxT);
        menu_1_item_5.addActionListener(CloseProgram);

        menu_2_item_1.addActionListener(FindTextJpanel);
        menu_2_item_2.addActionListener(ReplaceTextJpanel);
        menu_2_item_3.addActionListener(PasteText);
        menu_2_item_4.addActionListener(CopyTxT);

        menu_3_item_1.addActionListener(AboutProgram);
        menu_3_item_2.addActionListener(FontTextJpanel);
        menu_3_item_3.addActionListener(ProgramStyleJpanel);

        menu_5_sub_1_check_1.addActionListener(SetCoding);
        menu_5_sub_1_check_2.addActionListener(SetCoding);

        menu_5_sub_2_check_1.addActionListener(SetCoding);
        menu_5_sub_2_check_2.addActionListener(SetCoding);

        menu_5_sub_1_check_3.addActionListener(SetCoding);
        menu_5_sub_2_check_3.addActionListener(SetCoding);

        menu_5_sub_1_check_4.addActionListener(SetCoding);
        /// Coding sets  primary AUTO
        menu_5_sub_1_check_3.setState(true);
        menu_5_sub_2_check_1.setState(true);

        menu_5_sub_1_check_3.setEnabled(false);
        menu_5_sub_2_check_1.setEnabled(false);
    }
}


