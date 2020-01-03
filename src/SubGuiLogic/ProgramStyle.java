package SubGuiLogic;

import logic.FontSet;
import logic.ShowErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class ProgramStyle
{
    FontSet fontSet = new FontSet();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    Font font_menu;

    private Field field = null;

    public void ResetStyle(JTextArea jTextArea, JMenu jMenu1, JMenu jMenu2, JMenu jMenu3, JMenu jMenu4)
    {
        jTextArea.setForeground(CheckColor(fontSet.getPrimary_board_text_color()));
        jTextArea.setBackground(CheckColor(fontSet.getPrimary_board_color()));

        jMenu1.setForeground(CheckColor(fontSet.getPrimary_color_menu()));
        jMenu2.setForeground(CheckColor(fontSet.getPrimary_color_menu()));
        jMenu3.setForeground(CheckColor(fontSet.getPrimary_color_menu()));
        jMenu4.setForeground(CheckColor(fontSet.getPrimary_color_menu()));

        font_menu = new Font(fontSet.getPrimary_font_menu(),0,11);
        jMenu1.setFont(font_menu);
        jMenu2.setFont(font_menu);
        jMenu3.setFont(font_menu);
        jMenu4.setFont(font_menu);
    }

    public void SetStyle(JTextArea jTextArea, JMenu jMenu1, JMenu jMenu2, JMenu jMenu3, JMenu jMenu4, String board_color,
                                                       String board_text_color, String menu_text_color, String font_name)
    {
       jTextArea.setForeground(CheckColor(board_text_color));
       jTextArea.setBackground(CheckColor(board_color));

       jMenu1.setForeground(CheckColor(menu_text_color));
       jMenu2.setForeground(CheckColor(menu_text_color));
       jMenu3.setForeground(CheckColor(menu_text_color));
       jMenu4.setForeground(CheckColor(menu_text_color));

        font_menu = new Font(font_name,0,11);
        jMenu1.setFont(font_menu);
        jMenu2.setFont(font_menu);
        jMenu3.setFont(font_menu);
        jMenu4.setFont(font_menu);
    }

    protected Color CheckColor(String color)
    {
        try
        {
            field = Class.forName("java.awt.Color").getField(color);
        } catch (NoSuchFieldException e)
        { showErrorDialog.show_dialog_0(e.getMessage()); }
        catch (ClassNotFoundException e)
        { showErrorDialog.show_dialog_0(e.getMessage()); }
        try
        { return (Color)field.get(null);
        } catch (IllegalAccessException e)
        { showErrorDialog.show_dialog_0(e.getMessage()); }
        return null;
    }
}
