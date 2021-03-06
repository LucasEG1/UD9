package EjsB;

import java.io.*;
import java.util.*;

public class RetoCesarMID {
    public static int clave;
        
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList();
        String palabra;
        
        //Preguntamos por el texto a encriptar y creamos un File para dicho archivo
        System.out.println("¿Cómo se llama el archivo a desencriptar?");
        System.out.println("NOTA: La ruta por defecto es la carpeta del proyecto.");
        System.out.print("Nombre / ruta del archivo:");
        String nombreArchivo = leer.nextLine();
        
        File cifrado = new File(nombreArchivo);
        
        //Pregunta por el nombre del archivo hasta que se introduce uno existente
        while (!cifrado.exists()){
            System.out.println("El archivo no existe. Indique un archivo que sí exista para continuar");
            nombreArchivo = leer.nextLine();
            cifrado = new File(nombreArchivo);
        }
        
        /**
         * PARA LEER
         */
        
        try {
            
            //Preguntamos por la clave a utilizar. Está dentro del try-catch para evitar el inputMismatchException.
            System.out.println("Cuál clave será utilizada?");
            clave = leer.nextInt();
            leer.nextLine(); //para atrapar el enter de la anterior lectura.
            
            
            Scanner in = new Scanner(cifrado);
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
        File descifrado = new File(nombre);
        try {
            FileWriter escribir = new FileWriter(descifrado, true);
            for (int i = 0; i < palabras.size(); i++) {
                escribir.write(palabras.get(i) + " ");
            }      
            escribir.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Función tradPalabra para traducir la palabra leída
     * @param palabra
     * @return 
     */
    public static String tradPalabra(String palabra){
        String palDesc = "";
        char lt;
        for (int i = 0; i < palabra.length(); i++) {
            lt = palabra.toUpperCase().charAt(i);
            palDesc += tradLetra(lt);
        }
        return palDesc;        
    }
    
    /**
     * Función utilizada por tradPalabra para traducir letra por letra.
     * @param car
     * @return 
     */
    public static char tradLetra(char car){
        int claveReal = clave%26;
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
}
