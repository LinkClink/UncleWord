package SubGuiLogic;

import SubGui.FindTextJframe;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindText implements ActionListener
{
    private JTextArea jTextArea;

    public FindText(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        new FindTextJframe();

        Highlighter.HighlightPainter red = new TextPaint(Color.GRAY);
        JTextComponent textComp;
        textComp = jTextArea;
        String pattern = "";

        pattern = JOptionPane.showInputDialog(null, "Text please");

        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;
            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
                hilite.addHighlight(pos, pos + pattern.length(), red);
                pos += pattern.length();
                //  textArea_redactor_1.replaceRange(pattern1,pos,pos+pattern.length());

            }


        } catch (Exception ae)
        {

        }
    }







    class TextPaint extends DefaultHighlighter.DefaultHighlightPainter
    {
        public TextPaint(Color color) {
            super(color);
        }
    }
}
