package EjsB;

import java.io.*;
import java.util.*;

public class B03 {
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        File usaPers = new File("JavaFile/usa_personas.txt");
        ArrayList<String> listaNombres = null;
        /* PRIMER TRY-CATCH PARA LEER EL ARCHIVO */
        try {
            //Crea el scanner y arrayList para el archivo usaPers
            Scanner in = new Scanner(usaPers);
            listaNombres = new ArrayList();
                        
            //Lee el archivo, guardando cada nombre en una posición de la lista
            while (in.hasNext()){
                String linea = in.nextLine();
                listaNombres.add(linea);
            }
            
            
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Ordeno el arrayList
        Collections.sort(listaNombres);
        
        
        /* SEGUNDO TRY-CATCH PARA ESCRIBIR LOS NOMBRES ORDENADOS*/
        
        //Pide el nombre para el archivo de nombres ordenados
        System.out.println("Nombre para tu archivo ordenado:");
        String nombre = leer.nextLine();
        File usaPerSorted = new File("JavaFile/" + nombre);
        
        try {
            //Crea el escritor para el archivo usaPers
            FileWriter escribir = new FileWriter(usaPerSorted, false);
            for (int i = 0; i < listaNombres.size(); i++) {
                escribir.write(listaNombres.get(i) + "\n");
            }
            
            
            escribir.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
