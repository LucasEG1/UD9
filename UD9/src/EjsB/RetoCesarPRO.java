package EjsB;

import java.io.*;
import java.util.*;

public class RetoCesarPRO {
    public static int clave;
        
    /**
     * MAIN del programa :)
     * @param args 
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList();
        String palabra;
        String textoCompleto = "";
        
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
            Scanner in = new Scanner(cifrado);
            while (in.hasNext()){
                palabra = in.next();
                textoCompleto = textoCompleto + palabra + " ";
                palabras.add(palabra);
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
        
        //Vemos qué letra es la más repetida. Restamos el valor de dicha letra
        //al de la primera letra del abecedario (A) y así averiguamos la clave.
        clave = ((int)letraMasFrecuente(textoCompleto) - (int)'A');
        //Creamos el archivo
        File descifrado = new File(nombre);
        try {
            FileWriter escribir = new FileWriter(descifrado, true);
            for (int i = 0; i < palabras.size(); i++) {
                escribir.write(tradPalabra(palabras.get(i)) + " ");
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
    
    public static char letraMasFrecuente(String texto) {
        char[] vchars = texto.toUpperCase().toCharArray();
        char[] letrasAbeced = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int[] repetCadaLetra = new int[letrasAbeced.length]; //La posición del array corresponde a la posicion de la letra en letrasAbeced
        int mayorRepeticiones = repetCadaLetra[0];
        int cualLetra = 0;
        //Recorre cada letra del texto
        for (int i = 0; i < vchars.length; i++) {
            
            /*Recorre el vector letrasAbeced, si la letra del texto coincide con alguna
            letra del vector, se suma 1 en repetCadaLetra (en la posición de la letra correspondiente).*/
            for (int j = 0; j < letrasAbeced.length; j++) {
                
                if( vchars[i] == letrasAbeced[j] ){
                    repetCadaLetra[j]++;
                }
            }
        }
        
        for (int i = 1; i < repetCadaLetra.length; i++) {
            if (repetCadaLetra[i] > mayorRepeticiones) {
                mayorRepeticiones = repetCadaLetra[i];
                cualLetra = i;
            }
        }        
        return letrasAbeced[cualLetra];
    }
}
