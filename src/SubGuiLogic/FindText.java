package SubGuiLogic;

import SubGui.FindTextJframe;
import logic.ShowErrorDialog;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.lang.reflect.Field;

public class FindText
{
    FindTextJframe findTextJframe = new FindTextJframe();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    private String pattern = null;

    private JTextArea jTextArea;

    private Highlighter.HighlightPainter ColorSet = new TextPaint(Color.GRAY);
    private JTextComponent textComp;

    private Highlighter hilite;
    private Document doc;
    private String text;
    private String fl_text;
    private String aktStr;

    private Field field = null;

    private int Index;
    private int pos = 0;


    public void findtext(JTextField jTextField , String color , int select)
    {
            jTextArea = findTextJframe.getjTextArea();
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
                        try {
                            SelectText(pattern,jTextArea);
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }

        }
    }

    public void Reset()
    {
        jTextArea = findTextJframe.getjTextArea();
        textComp = jTextArea;
        hilite = textComp.getHighlighter();
        hilite.removeAllHighlights();
    }

    class TextPaint extends DefaultHighlighter.DefaultHighlightPainter
    { public TextPaint(Color color)
        {
            super(color);
        }}


        public Color CheckColor(String color)
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

            try {
                hilite = textComp.getHighlighter();
                doc = textComp.getDocument();
                text = doc.getText(0, doc.getLength());
                int pos = 0;
                while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0)
                {
                    hilite.addHighlight(pos, pos + pattern.length(), ColorSet);
                    pos += pattern.length();
                }

            } catch (Exception ae) {
                showErrorDialog.show_dialog_0(ae.getMessage());
            }
        }


        public void SelectText(String pattern, JTextArea jTextArea) throws BadLocationException
        {
            aktStr = jTextArea.getText();
            Index = aktStr.indexOf(pattern);

             jTextArea.requestFocus();
             jTextArea.select(Index, Index + pattern.length());

        }
}
