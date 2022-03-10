package MiniTerminal;

import java.io.File;

public class MiniFileManager {
    String comando;
    String argumentos[];
    
    public String getPWD(File archivo){
        return archivo.getAbsolutePath();
    }
    
}
