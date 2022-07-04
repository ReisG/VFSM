package lib.FileSystem;

/* This class is created to let compiler store
 * File and Folder in one array
*/
public abstract class MemoryObject
{
    protected String name;

    public MemoryObject(String name)
    {
        this.name = name;
    }

    public final String getName() { return this.name; }

    public void rename(String newObjectName)
    {
        this.name = newObjectName;
    }
}