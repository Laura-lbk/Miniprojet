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
        
        int rom = 0;
        int posi = 0;
        int combo = 0;
        String charActual = "a";
        String charNext = "a";
        int valCharActual = 0;
        int valCharNext = 0;
        
        
        toLowerCase(nbr);
        
        int count =0;
        
        //neccessaire pour donner la sortie du while
        nbr = nbr +" ";
        
        while(count < nbr.length()){
            
            //on recupere les charactere dans un string (3 a chaque fois)
            charActual = String.valueOf(nbr.charAt(posi));
            if(posi < nbr.length()-1){
                charNext = String.valueOf(nbr.charAt(posi+1));
            }
            
            //le chiffre romain traduit en valeur
            valCharActual = giveValChar(charActual);
            //idem pour le caractere suivant
            valCharNext = giveValChar(charNext);
            
            //if qui verifie la regle des 3 chiffre d'affile
            if((valCharActual >= valCharNext)  && (combo < 3) && (posi < nbr.length()-1)){
                posi = posi+1;
                
                if(valCharActual == valCharNext){
                    combo++;
                }
                else{
                    combo =0;
                }
                rom = rom + valCharActual;
                
                if(" ".equals(charNext)){
                    
                } else {
                    charActual = String.valueOf(nbr.charAt(posi));
                    charNext = String.valueOf(nbr.charAt(posi+1));
                }
                
                

            }
            else if(valCharActual < valCharNext){
                posi = posi+1;
                rom = rom - valCharActual;
                
                if(" ".equals(charNext)){
                    
                } else {
                    charActual = String.valueOf(nbr.charAt(posi));
                    charNext = String.valueOf(nbr.charAt(posi+1));
                }
            }
            count++;
        }
       
       return rom;
    }
    
    
      public static int giveValChar(String lettre){
        //Fonction qui retourne la valeur de du charactere qu'on lui donne
        int val =0;
        switch (lettre) {

                    case "i":
                        val = 1;
                    break;
                    case "v":
                        val = 5;
                    break;
                    case "x":
                        val = 10;
                    break;
                    case "l":
                        val = 50;
                    break;
                    case "c":
                        val= 100;
                    break;
                    case "d":
                        val = 500;
                    break;
                    case "m":
                        val = 1000;
                    break;
                }
        return val;
        
    }
    
      

}
