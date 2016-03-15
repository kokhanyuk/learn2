package com.kokhanyuk.mydos;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyDos {

    public static void main(String[] args) {


        String st = "";
        String fileName;
        System.out.println("\nMyDos v 1.0\n");
        Scanner in = new Scanner(System.in);
        DosOperation dos = new DosOperation();
        JFileChooser chooser = new JFileChooser();
        String dirName = chooser.getCurrentDirectory().toString();
        while (st != "exit") {
            System.out.println("\ncd -change the current working directory.;\ndir -displays the contents of a directory;" +
                    "\nmake -make file in current working directory;" + "\nrem -remove file;" + "\nread -read data from file;" +
                    "\nwrite - write data to file;\nexit -exit (or any key to exit).\n");

            System.out.println("Current dir: " + dirName);
            st = in.nextLine();

            switch (st) {
                case "cd":
                    System.out.println("New current directory:");
                    String newDirName = in.nextLine();
                    dirName = dos.cd(newDirName);
                    System.out.println(dirName);
                    break;
                case "dir":
                    dos.dir(dirName);
                    break;
                case "read":
                    System.out.println("Enter file name:");
                    fileName = in.nextLine();
                    dos.readDataFile(dirName+File.separator + fileName);
                    break;
                case "write":
                    System.out.println("Enter file name:");
                    fileName = in.nextLine();
                    System.out.println("Type the text and press Enter:");
                    String text = in.nextLine();
                    dos.writeDataFile(dirName+File.separator+fileName, text);
                    System.out.println(st);
                    break;
                case "make":
                    System.out.println("Enter file name:");
                    fileName = in.nextLine();
                    dos.makeFile(dirName+File.separator + fileName);
                    break;
                case "rem":
                    System.out.println("Enter file name:");
                    fileName = in.nextLine();
                    dos.remFile(dirName +File.separator+ fileName);
                    break;
                case "exit":
                    st = "exit";
                    break;
                default:
                    st = "exit";
            }

        }
    }
}
