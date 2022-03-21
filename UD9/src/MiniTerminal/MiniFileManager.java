package MiniTerminal;

import java.io.File;
import java.io.IOException;

/**
 * Clase MiniFileManager para gestionar las operaciones de la mini terminal.
 * @author Lucas Gyori
 */     
public class MiniFileManager{

    private static File archivoActual = new File("JavaFile");
    
    /**Si es un directorio imprime los archivos que contiene
     * @param info indica si mostrar más información o no (nº de Bytes, fecha de modificación)
     * 
     */
    public static void printList(boolean info){
        if (info == true){
            if (archivoActual.isDirectory() == true) {
                String[] archivos = archivoActual.list();
                for (int i = 0; i < archivos.length; i++) {
                    System.out.println(archivos[i]);
                }
            } else {
                System.out.println(archivoActual.getName());
            }
        } else {
            
        }
    }
    
    public static String getPWD(){
        return archivoActual.getAbsolutePath();
    }
    
    public static String[] leerComando(String comando){
        String[] argumentos = comando.split(" ");
        return argumentos;
    }
    
    public static void changeDir(String direccion){
        File fDir = new File(direccion);
        if ("..".equals(direccion)){
            archivoActual = archivoActual.getParentFile();
        } else if (".".equals(direccion)) {
        } else {
            archivoActual = fDir;
        }
    }
    
    public static void makeDir(String nombre) throws Exception{
        File n = new File(archivoActual, nombre);
        if (n.exists() == false){
            if (n.mkdirs() == true){
                System.out.println("Directorio creado exitosamente.");
            } else{
                throw new Exception("No se ha podido crear el directorio");
            }
        } else {
            throw new Exception("El directorio ya existe");    
        }
    }
}
