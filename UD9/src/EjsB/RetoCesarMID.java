package EjsB;

import java.io.*;
import java.util.*;

public class RetoCesarMID {
    public static int clave = 13;
    public static int claveReal = clave%26;    
    
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
        ArrayList<String> palabras = new ArrayList();
        String palabra;
        
        //Preguntamos por la clave a utilizar
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuál clave será utilizada?");
        clave = leer.nextInt();
        leer.nextLine(); //para atrapar el enter de la anterior lectura.
        
        /**
         * PARA LEER
         */
        
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
        System.out.println("Qué nombre tendrá el archivo con la carta descifrada?");
        String nombre = leer.nextLine();
        //Creamos el archivo
        File traducida = new File("JavaFile/" + nombre);
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
