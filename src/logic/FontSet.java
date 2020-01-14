package logic;

import java.awt.*;

public class FontSet
{
    public String getPrimary_font() {
        return primary_font;
    }

    public void setPrimary_font(String primary_font) {
        FontSet.primary_font = primary_font;
    }

    public int getPrimary_font_size() {
        return primary_font_size;
    }

    public void setPrimary_font_size(int primary_font_size) {
        FontSet.primary_font_size = primary_font_size;
    }

    public int getPrimary_font_style() {
        return primary_font_style;
    }

    public void setPrimary_font_style(int primary_font_style) {
        FontSet.primary_font_style = primary_font_style;
    }

    public String getPrimary_board_color() {
        return primary_board_color;
    }

    public String getPrimary_board_text_color() {
        return primary_board_text_color;
    }

    public String getPrimary_font_menu() {
        return primary_font_menu;
    }

    public String getPrimary_color_menu() {
        return primary_color_menu;
    }

    public String[] getFonts() {
        return fonts;
    }

    static String primary_font = "Consolas";
    static int primary_font_size = 16;
    static int primary_font_style = 0;

    static String primary_font_menu = "arial";

    static String primary_board_color = "white";
    static String primary_board_text_color = "black";
    static String primary_color_menu = "black";

    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

}
