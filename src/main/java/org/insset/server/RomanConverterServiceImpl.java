/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import static com.google.gwt.thirdparty.guava.common.base.Ascii.toLowerCase;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String("xxxvi");
    }
    
    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        
       
        int i = 1;
        int v = 5;
        int x = 10;
        int l = 50;
        int c = 100;
        int d = 500;
        int m = 1000;
        int rom = 0;
        int posi = 0;
        int combo = 0;
        String charActual = "a";
        String charNext = "a";
        String charPrev = "a";
        int valCharActual = 0;
        int valCharNext = 0;
        int valCharPrev = 0;
        //toLowerCase(nbr);
        
        int count =0;
        
        //neccessaire pour donner la sortie du while
        nbr = nbr +" ";
        
        while(count < nbr.length()){
            
            
            
            //on recupere les charactere dans un string (3 a chaque fois)
            charActual = String.valueOf(nbr.charAt(posi));
            if(posi < nbr.length()-1){
                charNext = String.valueOf(nbr.charAt(posi+1));
            }
            posi++;
            charPrev = String.valueOf(nbr.charAt(posi-1));
            posi = posi-1;
            
            
            //boucle qui verifie la regle des 3 chiffre d'affile
            while((charActual.equals(charNext) || charPrev.equals(charActual)) && (combo < 3) && (posi < nbr.length()-1)){
                posi = posi+1;
                combo++;
                switch (charActual) {

                    case "i":
                        rom = rom +1;
                        valCharActual = 1;
                        valCharNext = 1;
                    break;
                    case "v":
                        rom = rom +5;
                        valCharActual = 5;
                        valCharNext = 5;
                    break;
                    case "x":
                        rom = rom +10;
                        valCharActual = 10;
                        valCharNext = 10;
                    break;
                    case "l":
                        rom = rom +50;
                        valCharActual = 50;
                        valCharNext = 50;
                    break;
                    case "c":
                        rom = rom +100;
                        valCharActual = 100;
                        valCharNext = 100;
                    break;
                    case "d":
                        rom = rom +500;
                        valCharActual = 500;
                        valCharNext = 500;
                    break;
                    case "m":
                        rom = rom +1000;
                        valCharActual = 1000;
                        valCharNext = 1000;
                    break;
                   
                }

                if(" ".equals(charNext)){
                    
                } else {
                    charActual = String.valueOf(nbr.charAt(posi));
                    charNext = String.valueOf(nbr.charAt(posi+1));
                    charPrev = String.valueOf(nbr.charAt(posi-1));  
                }
                

            }
            //reset du combo
            combo = 0;
            count++;
            /*
            //on donner les valeurs des chiffre actuel, precedent et suivant en int
            switch (charActual) {

                    case "i":
                        rom = rom +1;
                        break;
                    case "v":
                        rom = rom +5;
                        break;
                    case "x":
                        rom = rom +10;
                        break;
                    case "l":
                        rom = rom +50;
                        break;
                    case "c":
                        rom = rom +100;
                        break;
                    case "d":
                        rom = rom +500;
                        break;
                    case "m":
                        rom = rom +1000;
                        break;
                }
            
            if(charActual < charPrev && charActual < charNext){
                
                
            }
           
           */
        }
        
       
        return rom;
    }

}
