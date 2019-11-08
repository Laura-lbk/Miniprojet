package org.insset.shared;


import static com.google.gwt.thirdparty.guava.common.base.Ascii.toLowerCase;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param nbr the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(Integer nbr) {
        if((nbr == null) || (nbr.toString().isEmpty())) {
            return false;
        }
        return true;
    }

    
    public static boolean isValidRoman(String nbr) {
        //Implement your code
        
        int posi = 0;
        int combo = 0;
        String charActual = "a";
        String charNext = "a";
        int valCharActual = 0;
        int valCharNext = 0;
        
        
        nbr.toLowerCase();
        
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
            if((valCharActual >= valCharNext)  && (combo <= 4) && (posi < nbr.length()-1)){
                posi = posi+1;
                
                if(valCharActual == valCharNext){
                    combo++;
                }
                if(combo == 4){
                    return false;
                }
                
                if(" ".equals(charNext)){
                    
                } else {
                    charActual = String.valueOf(nbr.charAt(posi));
                    charNext = String.valueOf(nbr.charAt(posi+1));
                }
                
                

            }
            else if(valCharActual < valCharNext){
                posi = posi+1;
                
                if(" ".equals(charNext)){
                    
                } else {
                    charActual = String.valueOf(nbr.charAt(posi));
                    charNext = String.valueOf(nbr.charAt(posi+1));
                }
            }
            count++;
        }
     
        return true;
    }

    
    public static boolean isValidDate(String date) {
        //Implement your code
        return true;
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
