package lib.FileSystem;

public class File extends MemoryObject
{
    private String extentention;
    private String content;

    public File(String name, String content)
    {
        super(name);
        this.extentention = getExtentionFromFileName(name);
        this.content = content;
    }

    public String getExtentention() { return extentention; }
    public String getContent() { return content; }

    @Override
    public void rename(String newFileName)
    {
        this.extentention = getExtentionFromFileName(newFileName);
        super.rename(newFileName);
    }

    public void rewriteContent(String newContent) 
    {
        this.content = newContent;
    }

    // static methods
    // ---------

    private static String getExtentionFromFileName(String fileName)
    {
        /* Extention is the part of name separeted with dot */
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(dotIndex + 1);
    }
}