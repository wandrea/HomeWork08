package com.company;

import java.io.*;

public class FileOperation {
    public void fileMaker(String path, String fileName) {
        /*l�trehozom a v�ltoz�t amibe t�rolom majd az el�r�si �tvonalat �s a file nevet �sszef�zve.
        * ha nincs a mappan�v ut�n / akkor rak bele egyet az �sszef�z�sn�l.
        * A FileWriter-tal l�trehozom a file-t.*/
        String fullFilename = null;
        if (path.endsWith(File.separator)) {
            fullFilename = path + fileName;
        } else {
            fullFilename = path + File.separator + fileName;
        }
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
