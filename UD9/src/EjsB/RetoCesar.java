package EjsB;

import java.io.*;
import java.util.*;

public class RetoCesar {
    public static int claveReal = 13;
    
    
    public static String tradPalabra(String palabra){
        String palDesc = "";
        char lt;
        for (int i = 0; i < palabra.length(); i++) {
            lt = palabra.charAt(i);
            palDesc = palDesc + tradLetra(lt);
        }
        return palDesc;        
    }
    
    public static char tradLetra(char car){
        char carNuevo = car;
        if ((int) car >= 65 && (int) car <= 90){
            carNuevo = (char)((int)car + claveReal);
        }
        
        if ((int) carNuevo > 90 && (int) carNuevo <= 90+claveReal){
           carNuevo = (char)((int)carNuevo-26);
        } else if ((int) car < 65 || (int)car > 90+claveReal){
        }
        return carNuevo;
    }
    
    
    public static void main(String[] args) {
        
        File carta = new File("JavaFile/carta");
        File traducida = new File("JavaFile/descifrada.txt");
        ArrayList<String> palabras = new ArrayList();
        String palabra;
        /** PARA LEER */
        
        try {
            Scanner in = new Scanner(carta);
            while (in.hasNext()){
                palabra = in.next();
                palabras.add(tradPalabra(palabra));
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        /**
         * PARA ESCRIBIR
         */
        
        try {
            FileWriter escribir = new FileWriter(traducida, false);
            for (int i = 0; i < palabras.size(); i++) {
                escribir.write(palabras.get(i) + " ");
            }      
            escribir.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
