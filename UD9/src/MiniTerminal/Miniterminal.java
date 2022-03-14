package MiniTerminal;

import java.io.File;
import java.util.Scanner;

public class Miniterminal {
    private static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.print("user@machine:");
            //String[] comando = leerComando();
            String comando = leer.nextLine();
            switch (comando){
                
                case "pwd":
                    System.out.println("comando pwd");
                    MiniFileManager.getPWD();
                    break;
                    
                case "cd":
                    System.out.println("comando cd");
                    break;
                    
                case "ls":
                    System.out.println("comando ls");
                    MiniFileManager.printList(false);
                    break;
                
                case "ll":
                    System.out.println("comando ll");
                    break;
                    
                case "mkdir":
                    System.out.println("comando mkdir");
                    break;
                    
                case "rm":
                    System.out.println("comando rm");
                    break;
                    
                case "mv":
                    System.out.println("comando mv");
                    break;
                    
                case "help":
                    help();
                    break;
                    
                case "exit":
                    System.out.println("Saliendo");
                    salir = true;
                    break;
                    
                default:
                    System.err.println("Comando no reconocido");
                    break;
                
            }
            
            
        } while (!salir);        
        
    }
    
    private static void help(){
        System.out.println("pwd​ : Muestra cual es la carpeta actual.");
        System.out.println("cd <DIR>​: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.");
        System.out.println("ls​: Muestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego\n"
                            + "archivos, ambos ordenados alfabéticamente).");
        System.out.println("ll​: Como ls pero muestra también el tamaño y la fecha de última modificación.");
        System.out.println("mkdir <DIR>​: Crea el directorio ‘DIR’ en la carpeta actual.");
        System.out.println("rm <FILE>​ : Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si\n"
                            + "tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.");
        System.out.println("mv <FILE1> <FILE2>​ : Mueve o renombra ‘FILE1’ a ‘FILE2’.");
        System.out.println("help​ : Muestra una breve ayuda con los comandos disponibles.");
        System.out.println("exit​ : Termina el programa.");
    }
    
    public static String[] leerComando(){
        String comando = leer.nextLine();
        
        String[] args = comando.split(" ");
        return args;
    }
}
