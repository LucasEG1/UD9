package EjsB;

import java.io.*;
import java.util.*;

public class B04 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        File usaNombres = new File("JavaFile/usa_nombres.txt");
        File usaApellidos = new File("JavaFile/usa_apellidos.txt");
        ArrayList<String> listaNombres = null;
        ArrayList<String> listaApellidos = null;

        /* PRIMER TRY-CATCH PARA LEER EL ARCHIVO */
        try {
            //Crea el scanner y arrayList para el archivo usaPers
            Scanner nom = new Scanner(usaNombres);
            Scanner ape = new Scanner(usaApellidos);
            listaNombres = new ArrayList();
            listaApellidos = new ArrayList();

            //Lee el archivo de nombres, guardando cada nombre en una posición de la lista
            while (nom.hasNext()){
                String linea = nom.nextLine();
                listaNombres.add(linea);
            }
            
            //Lee el archivo de apellidos, guardando cada nombre en una posición de la lista
            while (ape.hasNext()){
                String linea = ape.nextLine();
                listaApellidos.add(linea);
            }

            nom.close();
            ape.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* SEGUNDO TRY-CATCH PARA ESCRIBIR LOS NOMBRES ORDENADOS*/
        //Pide el nombre para el archivo de nombres ordenados y la cantidad de nombres a generar
        System.out.println("Cuántos nombres deseas generar?");
        int cuantosNombres = leer.nextInt();
        leer.nextLine();
        System.out.println("Nombre para tu archivo de nombres generados:");
        String nombre = leer.nextLine();
        File nombresRand = new File("JavaFile/" + nombre);

        int ranNom;
        int ranAp;
        try {
            //Crea el escritor para el archivo usaPers
            FileWriter escribir = new FileWriter(nombresRand, false);
            for (int i = 0; i < cuantosNombres; i++) {
                ranNom = (int) (Math.random()*(listaNombres.size()+1));
                ranAp = (int) (Math.random()*(listaApellidos.size()+1));
                
                escribir.write(listaNombres.get(ranNom) + 
                       " " + listaApellidos.get(ranAp) + "\n");
            }

            escribir.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
