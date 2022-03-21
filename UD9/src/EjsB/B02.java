package EjsB;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class B02 {

    public static void main(String[] args) {
        File f = new File("JavaFile/alumnos_notas.txt");
        try {
            Scanner leer = new Scanner(f);
            String linea = leer.nextLine();
            String[] linSpl = linea.split(" ");
            int total;
            for (int i = 0; i < linSpl.length; i++) {
                total+=
                
            }
            
            
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
