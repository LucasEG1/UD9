package MiniTerminal;

import java.io.File;
import java.io.IOException;

public class MiniFileManager{

    private static File archivoActual = new File(".");
    
    public static void printList(boolean info){
        if (archivoActual.isDirectory() == true){
            String[] archivos = archivoActual.list();
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
            }
        }
    }
    
    /*public boolean changeDir(String dir){
    }*/
    public static String getPWD(){
        return archivoActual.getAbsolutePath();
    }
}
