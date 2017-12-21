package com.company;

import java.io.*;

public class FileOperation {
    public void fileMaker(String path, String fileName) {
        /*létrehozom a változót amibe tárolom majd az elérési útvonalat és a file nevet összefûzve.
        * ha nincs a mappanév után / akkor rak bele egyet az összefûzésnél.
        * A FileWriter-tal létrehozom a file-t.*/
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

    public void fileMaker(String path, int number, String fileName) {
        /*A pont mentén szétvágom a filenevet(feltételezve hogy egy db . van benne)
        * egy for ciklusban létrehozom a számozott file-neveket,
        * majd az elõzõ metódust meghívva létrehozom a file-okat.*/
        String[] splittedFileName = fileName.split("\\.");
        if (splittedFileName.length == 2) {
            for (int i = 1; i <= number; i++) {
                String currentFileName = splittedFileName[0] + i + "." + splittedFileName[1];
                fileMaker(path, currentFileName);
            }
        }
    }

    public void fileMakerWithContent(String path, String fileName, String content) {
        /*létrehozom a változót amibe tárolom majd az elérési útvonalat és a file nevet összefûzve.
        ha nincs a mappanév után / akkor rak bele egyet az összefûzésnél.
        A FileWriter-tal létrehozom a file-t,a tartalmat bele írom a file-ba a BufferedWriter segítségével*/

        String fullFilename = null;
        if (path.endsWith(File.separator)) {
            fullFilename = path + fileName;
        } else {
            fullFilename = path + File.separator + fileName;
        }
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(fullFilename);
            bw = new BufferedWriter(fw);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void fileMakerWithContent(String path, int number, String fileName, String content) {
        /*Ahogy a 2.feladatnál szétszedem a file nevet,hogy belekerüljön a szám, majd meghívva a 3.feladat metódusát,
        melyben összefûzöm a file nevet a mappanévvel és beleírom a megadott tartalmat.*/
        String[] splittedFileName = fileName.split("\\.");
        if (splittedFileName.length == 2) {
            for (int i = 1; i <= number; i++) {
                String currentFileName = splittedFileName[0] + i + "." + splittedFileName[1];
                fileMakerWithContent(path, currentFileName, content);

            }
        }
    }

    public void printMatrixIntoFile(int[][] mtx) {
        /*létrehozom a mátrix.txt, forokkal bejárom a kapott mátrixot és a Stringé alakítottam a mátrix adott elemét
        amit beleírtam a fileba (elõször a bufferbe aztán a fileba), soroként írtam egy sortörést.
        * */
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("matrix.txt");
            bw = new BufferedWriter(fw);
            for (int i = 0; i < mtx.length; i++) {
                for (int j = 0; j < mtx[i].length; j++) {

                    bw.write(String.valueOf(mtx[i][j]) + " ");
                }
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
