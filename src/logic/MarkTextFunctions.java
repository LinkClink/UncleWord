package logic;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.lang.reflect.Field;

public class MarkTextFunctions
{
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();
    FileSet fileSet = new FileSet();

    private String pattern = null;

    private Highlighter.HighlightPainter ColorSet = new MarkTextFunctions.TextPaint(Color.GRAY);
    private JTextComponent textComp;

    private Highlighter hilite;
    private Document doc;
    private String text;
    private String aktStr;

    private Field field = null;

    private int Index;
    private int pos = 0;

    public void MarkSelectText(JTextField jTextField , String color , int select, JTextArea jTextArea)
    {
        pattern = jTextField.getText();

        if(!jTextArea.getText().equals("") && !pattern.equals(""))
        {
            switch (select)
            {
                case 0:
                {
                    PaintText(color,jTextArea,pattern);
                    break;
                }
                case 1:
                {
                    try
                    {
                        SelectText(pattern,jTextArea);
                    } catch (BadLocationException e)
                    { showErrorDialog.show_dialog_0(e.getMessage()); }
                    break;
                }
            }
        }
    }

    public void Reset(JTextArea jTextArea)
    {
        textComp = jTextArea;
        hilite = textComp.getHighlighter();
        hilite.removeAllHighlights();
    }

    class TextPaint extends DefaultHighlighter.DefaultHighlightPainter
    { public TextPaint(Color color)
    {
        super(color);
    }}


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

    public void PaintText(String color, JTextArea jTextArea, String pattern)
    {
        textComp = jTextArea;
        ColorSet = new TextPaint(CheckColor(color));

        try
        {
            hilite = textComp.getHighlighter();
            doc = textComp.getDocument();
            text = doc.getText(0, doc.getLength());
            pos = 0;
            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0)
            {
                hilite.addHighlight(pos, pos + pattern.length(), ColorSet);
                pos += pattern.length();
            }

        } catch (Exception ae)
        { showErrorDialog.show_dialog_0(ae.getMessage()); }
    }

    protected void SelectText(String pattern, JTextArea jTextArea) throws BadLocationException
    {
        aktStr = jTextArea.getText();
        Index = aktStr.indexOf(pattern);

        jTextArea.select(Index, Index + pattern.length());
    }

    public  void PaintTextFirst(String color, JTextArea jTextArea, String pattern, int select)
    {
        if(select == 0)
        {
            textComp = jTextArea;
            ColorSet = new TextPaint(CheckColor(color));
            pos = fileSet.getMark_text_position();

            try
            {
                hilite = textComp.getHighlighter();
                doc = textComp.getDocument();

                text = doc.getText(0, doc.getLength());
                hilite.addHighlight(pos, pos + pattern.length(), ColorSet);

            } catch (Exception ae)
            { showErrorDialog.show_dialog_0(ae.getMessage()); }
            pos += 1;
            fileSet.setMark_text_position(pos);
        } else
          {
            try
            {
                SelectText(pattern,jTextArea);
            } catch (BadLocationException e)
            { showErrorDialog.show_dialog_0(e.getMessage()); }
          }
    }

    public void SelectTextFirst(String pattern, JTextArea jTextArea)
    {
        pos = fileSet.getMark_text_position();
        aktStr = jTextArea.getText();
        Index = aktStr.indexOf(pattern) + pos;
        jTextArea.select(Index, Index + pattern.length());
        pos += 1;
        fileSet.setMark_text_position(pos);
    }
}
