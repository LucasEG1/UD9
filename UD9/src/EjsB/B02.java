package EjsB;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class B02 {

    public static void main(String[] args) {
        File f = new File("JavaFile/alumnos_notas.txt");
        
        
        try {
            //Scanner para leer el archivo
            Scanner leer = new Scanner(f);
            
            while (leer.hasNext()){
                
                //La línea se lee y se suma uno a la cantidad de líneas leídas
                String linea = leer.nextLine();
                System.out.println("Linea leída: " + linea);
                
                //La línea se divide en partes
                String[] linSpl = linea.split(" ");
                
                //Bucle que recorre desde la posición 3 (las dos primeras son el nombre y apellido) y suma el número al total
                int notasLeidas = 0;
                int total = 0;
                for (int i = 2; i < linSpl.length; i++) {
                    total += Integer.parseInt(linSpl[i]);
                    notasLeidas++;
                    
                }
                System.out.println("Notas leídas: " + notasLeidas);
                System.out.println("El total es: " + total);
                System.out.println("La media del alumno es: " + (double)total/notasLeidas);
                System.out.println("");
            }
            leer.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
