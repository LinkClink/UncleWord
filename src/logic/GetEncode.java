package logic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class GetEncode
{
    private File file;
    private InputStreamReader reader;
    private BufferedInputStream input;
    private CharsetDecoder decoder;

    private String[] ch_toTest = {"UTF-8","Cp1253","UTF-16","windows-1253", "ISO-8859-7","Cp1251","US-ASCII"};
    private String ch_validate;
    private String ch_decode;

    private int c;
    private byte[] buffer = new byte[512];
    private boolean identified = false;

    Charset charset;

    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    protected Charset detectCharset(File f, String[] charsets)
    {
        Charset charset = null;
        for (String charsetName : charsets)
        {
            charset = detectCharset(f, Charset.forName(charsetName));
            if (charset != null)
            { break; }
        }
        return charset;
    }

    protected Charset detectCharset(File f, Charset charset)
    {
        try
        {
            input = new BufferedInputStream(new FileInputStream(f));

            decoder = charset.newDecoder();
            decoder.reset();
            identified = false;

            while ((input.read(buffer) != -1) && (!identified))
            {
                identified = identify(buffer, decoder);
            }
            input.close();

            if (identified)
            { return charset; }
            else
            { return null; }

        } catch (Exception e)
        { return null; }
    }

    protected boolean identify(byte[] bytes, CharsetDecoder decoder)
    {
        try
        { decoder.decode(ByteBuffer.wrap(bytes)); }
        catch (CharacterCodingException e)
        { return false; }
        return true;
    }

    public String GetFileDecode(String filename)
    {
        file = new File(filename);
        charset = detectCharset(file, ch_toTest);

        if (charset != null)
        {
            try
            {
                reader = new InputStreamReader(new FileInputStream(file), charset);
                c=0;
                while ((c = reader.read()) != -1)
                { ch_decode = reader.getEncoding(); }
                reader.close();
            } catch (FileNotFoundException fileEx)
            { showErrorDialog.show_dialog_0(fileEx.getMessage()); }
            catch(IOException ie)
            { showErrorDialog.show_dialog_0(ie.getMessage()); }
        }else
        { showErrorDialog.show_dialog_0("Unrecognized charset"); }

        validate(ch_decode);

        return ch_validate;
    }

    public String validate(String filedecode)
    {
        switch (filedecode)
        {
            case "UTF8":
            { ch_validate = "UTF-8"; break; }
            case "Cp1253":
            { ch_validate = "Cp1251"; break; }
            case "UTF-16":
            { ch_validate = "UTF-16"; break; }
        }
        return ch_validate;
    }
}