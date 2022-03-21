package EjsB;

import java.io.File;
import java.util.Scanner;

public class B01 {
    
    public static void main(String[] args) {
        File f = new File("JavaFile/numeros.txt");
        
        try {
            Scanner leer = new Scanner(f);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (leer.hasNext()) {
                int actual = leer.nextInt();
                if (actual < min)
                    min = actual;
                
                if (actual > max)
                    max = actual;
            }
            System.out.println("El mínimo es: " + min);
            System.out.println("El máximo es: " + max);
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
