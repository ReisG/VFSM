package lib.FileSystem;

import lib.FileSystem.MemoryObject;

public final class Folder extends MemoryObject
{
    static final int MaxFilesContain = 600;

    private MemoryObject[] fileTree;
    private int numberOfFilesContain;
    
    public Folder(String name)
    {
        super(name);
        fileTree = new MemoryObject[MaxFilesContain];
        numberOfFilesContain = 0;
    }

    public int getNumberOfFilesContain() { return numberOfFilesContain; }

    public void addObject(MemoryObject object)
    {
        fileTree[numberOfFilesContain++] = object;
    }

    public void createFile(String name, String fileContent)
    {
        addObject(new File(name, fileContent));
    }

    public void createFolder(String folderName)
    {
        addObject(new Folder(name));
    }

    public void deleteObject(String objectName)
    {
        for (int object = 0; object < numberOfFilesContain; object++)
        {
            if ( objectName.equals(fileTree[object].getName()) )
            {
                /* For now it's unsorted array,
                 * and we (right now) don't look at indexes.
                 * This was we can just move last element on deleted element position
                 */
                fileTree[object] = fileTree[numberOfFilesContain];
                break;
            }
        }

        throw new RuntimeException("There is no element in folder named <" + objectName + ">");
    }

    public MemoryObject goToObject(String objectName)
    {
        for (MemoryObject object : fileTree)
        {
            if ( objectName.equals(object.getName()) ) return object;
        }

        throw new RuntimeException("There is no object named <" + objectName + ">");
    }

    public String[] getNamesOfObjects()
    {
        String[] namesOfObjectsInside = new String[numberOfFilesContain];
        for (int object = 0; object < numberOfFilesContain; object++)
        {
            namesOfObjectsInside[object] = fileTree[object].getName();
        }
        return namesOfObjectsInside;
    }
}