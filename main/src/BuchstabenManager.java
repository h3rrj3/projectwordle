import java.util.Arrays;

public class BuchstabenManager {
    public WordManager getWm() {
        return wm;
    }
    WordManager wm = new WordManager();
    StringBuilder let =new StringBuilder();

    public static int[] buchstabenVergleichalt(String loesung, String eingabe) {
        int[] anzeigeArray = {0, 0, 0, 0, 0};                           // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

        if (eingabe.equalsIgnoreCase(loesung)) {
            anzeigeArray = new int[]{2, 2, 2, 2, 2};                   // z.Z. nur für Debugging notwendig
            System.out.println("You won!");                             // wird später anders gelöst?
        } else {
            for (int i = 0; i < loesung.length(); i++) {
                if (eingabe.charAt(i) == loesung.charAt(i)) {           // Zeichen ist richtig => anzeigeArray[i] = 2
                    anzeigeArray[i] = 2;
                } else {
                    for (int j = 0; j < loesung.length(); j++) {
                        if (eingabe.charAt(i) == loesung.charAt(j)) {   // Zeichen ist vorhanden aber falsche Stelle => anzeigeArray[i] = 1
                            anzeigeArray[i] = 1;
                        }
                    }
                }                                                       // sonst bleibt anzeigeArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(anzeigeArray));              // SOUT für Debugging, kann später gelöscht werden
        return anzeigeArray;
    }

    //provisorische Ausgabe in der entsprechenden Farbe
    public static void anzeigeFarbausgabe(int[] anzeigeArray, String eingabe) {
        for (int i = 0; i < eingabe.length(); i++) {
            if (anzeigeArray[i] == 0) {
                System.out.print(eingabe.charAt(i));
            } else {
                if (anzeigeArray[i] == 1) {
                    System.out.print(ColorChange.ANSI_YELLOW + eingabe.charAt(i) + ColorChange.ANSI_RESET);
                } else {
                    System.out.print(ColorChange.ANSI_GREEN + eingabe.charAt(i) + ColorChange.ANSI_RESET);
                }
            }
        }
    }

    /*-------------------------------------------------------------------------- */
    /*public static void anzeigeFarbausgabeneu (String eingabe) {

        for (int i = 0; i < eingabe.length(); i++) {
            if (anzeigeArray[i] == 0) {
                System.out.print(eingabe.charAt(i));
            } else {
                if (anzeigeArray[i] == 1) {
                    System.out.print(ColorChange.ANSI_YELLOW + eingabe.charAt(i) + ColorChange.ANSI_RESET);
                } else {
                    System.out.print(ColorChange.ANSI_GREEN + eingabe.charAt(i) + ColorChange.ANSI_RESET);

                }
            }
        }




    }


     */
    public  String comparisonOfLetters (String loesung, String eingabe) {
        /*
        int[] anzeigeArray = new int[loesung.length()];                           // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

        if (eingabe.equalsIgnoreCase(loesung)) {
            anzeigeArray = new int[]{2, 2, 2, 2, 2};                   // z.Z. nur für Debugging notwendig
            System.out.println("You won!");                             // wird später anders gelöst?
        } else {
            for (int i = 0; i < loesung.length(); i++) {
                if (eingabe.charAt(i) == loesung.charAt(i)) {           // Zeichen ist richtig => anzeigeArray[i] = 2
                    anzeigeArray[i] = 2;
                } else {
                    for (int j = 0; j < loesung.length(); j++) {
                        if (eingabe.charAt(i) == loesung.charAt(j)) {   // Zeichen ist vorhanden aber falsche Stelle => anzeigeArray[i] = 1
                            anzeigeArray[i] = 1;
                        }
                    }
                }
            }

            for (int m = 0; m < loesung.length(); m++) {
                    for (int n = 0; n < loesung.length(); n++) {
                        if (n==m){
                            continue;
                        }
                        if (anzeigeArray[m] == anzeigeArray[n] && anzeigeArray[m]>0 && anzeigeArray[n]>0) {
                            int countletter = countLetter(String.valueOf(eingabe.charAt(m)),loesung);
                            if (countletter==1){
                                if (anzeigeArray[m] == 2 || anzeigeArray[m] == 1){

                                }else{
                                    anzeigeArray[m]=0;
                                }
                            }
                        }
                    }
                    // sonst bleibt anzeigeArray[i] = 0;
            }
        }


        System.out.println(Arrays.toString(anzeigeArray));              // SOUT für Debugging, kann später gelöscht werden
        return Arrays.toString(anzeigeArray);

         */


        StringBuilder word = new StringBuilder();
        int count = 0;
        boolean stop = true;

        if (!(wm.wordExist(eingabe))) {
            System.out.println("Dieses Wort existiert nicht oder entspricht nicht der Länge " + loesung.length());
            return null;
        }

        eingabe = eingabe.toUpperCase();

        if (wm.checkSolutionWord(loesung, eingabe)) {

            System.out.println("You won!");
            return "WON";

        }

        for (int i = 0; i < loesung.length(); i++) {

            if (eingabe.charAt(i) == loesung.charAt(i)) {

                word.append(ColorChange.ANSI_GREEN + eingabe.charAt(i) + ColorChange.ANSI_RESET);

            } else {

                for (int j = 0; j < loesung.length() && stop; j++) {

                    if (eingabe.charAt(i) == loesung.charAt(j)) {   // Zeichen ist vorhanden aber falsche Stelle => anzeigeArray[i] = 1

                            word.append(ColorChange.ANSI_YELLOW + eingabe.charAt(i) + ColorChange.ANSI_RESET);

                        count=0;

                        stop = false;

                    } else {

                        count++;

                    }

                }


                stop = true;
                if (count == loesung.length()) {
                    word.append(eingabe.charAt(i));
                    count = 0;
                }
            }

            /*
            if (eingabe.charAt(marked) == eingabe.charAt(i)){
                marked=-1;
                word.append(ColorChange.ANSI_BLUE + eingabe.charAt(i) + ColorChange.ANSI_RESET);

            }

             */


        }
        /*
        for (int e=0;e<word.length();e++){
            System.out.println(word.toString().charAt(e));
        }

         */

        return word.toString();


    }







    public int countLetter(String letter, String loesung){
        int count=0;

        if (let.toString().contains(letter)){
            return 0;
        }


        for(int i=0; i< loesung.length();i++){
            if (String.valueOf(loesung.charAt(i)).equals(letter)) {   // Zeichen ist vorhanden aber falsche Stelle => anzeigeArray[i] = 1
                    count++;
            }
        }
        if (count>0){
            let.append(letter);

        }
        System.out.println(letter+" "+count);
        return count;
    }
}
