package EjsB;

import java.io.*;
import java.util.*;

public class RetoCesar {
    public static int clave = 13;
    
    public static String tradPalabra(String palabra){
        String palDesc = "";
        char lt;
        for (int i = 0; i < palabra.length(); i++) {
            lt = (char) (palabra.charAt(i)+clave);
            palDesc = palDesc + tradLetra(lt);
        }
        System.out.println(palDesc);
        return palDesc;        
    }
    
    public static char tradLetra(char car){
        char carNuevo = car;
        if ((int) car >= 65 && (int) car <= 90){
            carNuevo = (char)((int)car + clave);
        }
        
        if ((int) carNuevo > 90 && (int) carNuevo < 90+clave){
            
           carNuevo = (char)((int)carNuevo-26);
           
        } else if ((int) car < 65 || (int)car > 90+clave){
        }
        return carNuevo;
    }
    
    
    public static void main(String[] args) {
        
        File carta = new File("JavaFile/carta");
        File traducida = new File("JavaFile/descifrada.txt");
        ArrayList<String> palabras = new ArrayList();
        String palabra; // = "NCVÓA N FH FRÑBE L CNQER RCVZNPUBF: ¡FNYHQBF! RA CEVZRE YHTNE RFCREB DHR FR RAPHRAGER OVRA QR FNYHQ L DHR YNF PBFNF INLNA OVRA CNEN IQ., CNEN ZV UREZNAN L FH UVWN, L CNEN ZV UREZNAB. QBL YNF TENPVNF N FRENCVF CBE FNYINEZR YN IVQN PHNAQB, WHFGB NY CEVAPVCVB, CNFÉ GNAGB CRYVTEB RA RY ZNE. PHNAQB YYRTHÉ N ZVFRAHZ, RY CHREGB EBZNAB QR THREEN PREPN QR AÁCBYRF, ERPVOÍ GERF ZBARQNF QR BEB QRY RZCRENQBE GENWNAB CNEN TNFGBF, L GBQB ZR IN CREB ZHL OVRA. CBE SNIBE, FRÑBE CNQER, RFPEVON L PHÉAGRZR FBOER FH FNYHQ, YHRTB FBOER ZVF UREZNABF, L GNZOVÉA CNEN DHR CHRQN ORFNE FH ZNAB CBE UNOREZR RQHPNQB OVRA L RA PBAFRPHRAPVN CHRQN RFCRENE HAN EÁCVQN CEBZBPVÓA, FV YBF QVBFRF DHVRERA. QÉ ERPHREQBF N PNCVGÓA [NYTÚA NZVTB] L N ZV UREZNAB L UREZNAN, L N FRERAVYYN L N ZVF NZVTBF. YRF RAIVB HA CRDHRÑB ERGENGB N GENIÉF QR RHXGRZBA. QRFRRAZR FHREGR, RA FVRGR QVNF NY NYON NGNPNERZBF RA ONEPB CBE YN PBFGN HAN CRDHRÑN CBOYNPVÓA YYNZNQN NHFVNFZNEPURGBEVK. FRTHEB DHR AB FR YB RFCRENA. ZV AHRIB ABZOER EBZNAB RF NAGBAVHF ZNKVZHF.";
        /** PARA LEER */
        
        try {
            Scanner in = new Scanner(carta);
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
        
        /*try {
            FileWriter escribir = new FileWriter(traducida, false);
            escribir.write(tradPalabra(palabra));
            
            for (int i = 0; i < palabras.size(); i++) {
               
                escribir.write("\n");
            }
                        
            escribir.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        
    }
}
