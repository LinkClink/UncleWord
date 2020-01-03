package logic;

public class FileSet
{
    public String getFile_code() {
        return file_code;
    }

    public void setFile_code(String file_code) {
        this.file_code = file_code;
    }

    public String getBuffer_file() {
        return buffer_file;
    }

    public void setBuffer_file(String buffer_file) {
        this.buffer_file = buffer_file;
    }

    public String getFile_code_open() {
        return file_code_open;
    }

    public void setFile_code_open(String file_code_open) {
        this.file_code_open = file_code_open;
    }

    public String getFile_code_save() {
        return file_code_save;
    }

    public void setFile_code_save(String file_code_save) {
        this.file_code_save = file_code_save;
    }

    public int getMark_text_position() {
        return mark_text_position;
    }

    public void setMark_text_position(int mark_text_position) {
        FileSet.mark_text_position = mark_text_position;
    }

    static String file_code;

    static String buffer_file = null;

    static String file_code_open = "AUTO"; // ANSI
    static String file_code_save = "Cp1251"; // ANSI

    static int mark_text_position = 0; // 0
}
