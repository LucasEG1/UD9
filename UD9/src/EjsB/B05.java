package EjsB;

import java.io.*;
import java.util.*;

public class B05 {

    public static void main(String[] args) {
        //Si no existe, creo la carpeta "Diccionario"
        File dicc = new File("JavaFile/Diccionario");        
        if (!dicc.exists()){
            dicc.mkdir();
        }
        
        try {
            Scanner in = new Scanner (dicc);
            String linea = in.nextLine();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}