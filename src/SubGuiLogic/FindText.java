package SubGuiLogic;

import SubGui.FindTextJframe;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class FindText
{
    FindTextJframe findTextJframe = new FindTextJframe();
    String pattern = "";

    JTextArea jTextArea;

    Highlighter.HighlightPainter ColorSet = new TextPaint(Color.GRAY);
    JTextComponent textComp;

    Highlighter hilite;
    Document doc;
    String text;

    public void findtext(JTextField jTextField)
    {
        jTextArea = findTextJframe.getjTextArea();
        textComp = jTextArea;
        pattern = jTextField.getText();

        try
        {
            hilite = textComp.getHighlighter();
            doc = textComp.getDocument();
            text = doc.getText(0, doc.getLength());
            int pos = 0;
            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0)
            {
                hilite.addHighlight(pos, pos + pattern.length(), ColorSet);
                pos += pattern.length();
            }

        } catch (Exception ae)
        {

        }
    }

    class TextPaint extends DefaultHighlighter.DefaultHighlightPainter
    {
        public TextPaint(Color color)
        {
            super(color);
        }
    }
}
