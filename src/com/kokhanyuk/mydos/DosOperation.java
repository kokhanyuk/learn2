package com.kokhanyuk.mydos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.Date;

/**
 * Created by Alex on 08.03.2016.
 */
public class DosOperation {


    void readDataFile(String fileName) {

        File fp = new File(fileName);
        if (fp.exists()) {
            if (fp.isFile()) {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(fileName));
                    String tmp = "";
                    while ((tmp = br.readLine()) != null) {
                        System.out.println(tmp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("File " + fp.getName() + " not found.");
        }
    }

    public void makeFile(String fileName) {
        File fp = new File(fileName);
        try {
            if (!fp.exists()) {
                fp.createNewFile();
                System.out.println("Created " + fileName);
            } else System.out.println("File " + fileName + " is exist");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void remFile(String fileName) {
        File fp = new File(fileName);
        if (fp.exists()) {
            fp.delete();

            System.out.println("Removed " + fileName);
        } else System.out.println("File " + fileName + " not found");
    }

    public void writeDataFile(String fileName, String text) {
        File f = new File(fileName);
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.printf(text + "\n");
        } catch (IOException e) {
            System.err.println("Error open stream " + e);
        } finally {
            if (pw != null) {

                //try {
                pw.close();
                /**} catch (IOException e) {
                 e.printStackTrace();
                 }*/
            }
        }
    }

    public String cd(String dirName) {

        File currentDir = new File(dirName);
        JFileChooser chooser = new JFileChooser();
        if (currentDir.exists() && currentDir.isDirectory()) {
            chooser.setCurrentDirectory(new File(dirName));
            return chooser.getCurrentDirectory().toString();
        }
        System.out.println("Directory "+dirName+" not found");
        return chooser.getCurrentDirectory().toString();
    }

    public void dir(String dirName) {

        try {
            File dir = new File(dirName);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    Date date = new Date(files[i].lastModified());
                    System.out.print("\n" + files[i].getPath() + " \t| " + files[i].length() + "\t|" + date);
                }
            } else {
                System.out.println("Directory not found");
            }
        } catch (NullPointerException id1) {
            System.out.print("Empty directory name");
        }
    }
}



