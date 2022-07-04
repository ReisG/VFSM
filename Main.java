import lib.FileSystem.File;
import lib.FileSystem.Folder;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        File a = new File("bob.txt", "My bad");
        Folder fold = new Folder("root");

        fold.addObject(a);
        System.out.println(Arrays.toString(fold.getNamesOfObjects()));
    }
}