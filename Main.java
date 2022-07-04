import lib.FileSystem.File;
import lib.FileSystem.Folder;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Folder root = new Folder("root");

        root.createFolder("users");
        root.goToFolder("users").createFile("player.txt", "I always win");

        System.out.println(root.goToFolder("users").getFile("player.txt").getContent());
    }
}