package me.sera.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import me.sera.app.MainActivity;

public class FileHandler {

    private static FileHandler instance;
    private MainActivity core;
    private static File file;

    public static FileHandler getInstance() {
        return instance;
    }

    public String onRead(String fname) {

        File path = core.getApplication().getFilesDir();
        File read = new File(path, fname);
        byte[] cont = new byte[(int) read.length()];
        try {
            FileInputStream input = new FileInputStream(read);
            input.read(cont);
            return new String(cont);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }

    public void onWrite(String fname, String context, String filetype) {

        file = core.getApplication().getFilesDir();
        try {
            FileOutputStream output = new FileOutputStream(new File(fname + filetype, context));
            output.write(context.getBytes());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
