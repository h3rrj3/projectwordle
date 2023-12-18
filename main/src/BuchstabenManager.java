import java.util.Arrays;

public class BuchstabenManager {
    public WordManager getWm() {
        return wm;
    }
    WordManager wm = new WordManager();
    StringBuilder let =new StringBuilder();




    public String anzeigeFarbausgabeneu (int[]anzeigeArray,String eingabe) {
        let.delete(0,100);
        //System.out.println(Arrays.toString(anzeigeArray));
        for (int i = 0; i < eingabe.length(); i++) {

            if (anzeigeArray[i] == 0) {

                let.append(eingabe.charAt(i));

            } else {

                if (anzeigeArray[i] == 1) {

                    let.append(ColorChange.ANSI_YELLOW + eingabe.charAt(i) + ColorChange.ANSI_RESET);

                } else {

                    let.append(ColorChange.ANSI_GREEN + eingabe.charAt(i) + ColorChange.ANSI_RESET);

                }
            }
        }
        return let.toString();

        // System.out.println(let);
    }



    public  String comparisonOfLetters (String loesung, String eingabe) {

        let = new StringBuilder();
        int[] anzeigeArray = new int[loesung.length()];                 // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

        int count = 0;

        if (!(wm.wordExist(eingabe))) {
            System.out.println("Dieses Wort existiert nicht oder entspricht nicht der Länge " + loesung.length());
            return null;
        }

        if (wm.checkSolutionWord(loesung, eingabe)) {

            System.out.println("You won!");
            return "WON";

        }

        if (eingabe.equalsIgnoreCase(loesung)) {

            anzeigeArray = new int[]{2, 2, 2, 2, 2};


        } else {

            for (int i = 0; i < loesung.length(); i++) {

                if (eingabe.charAt(i) == loesung.charAt(i)) {// Zeichen ist richtig => anzeigeArray[i] = 2

                    anzeigeArray[i] = 2;

                } else {

                    for (int j = 0; j < loesung.length(); j++) {

                        if (eingabe.charAt(i) == loesung.charAt(j)) {// Zeichen ist vorhanden aber falsche Stelle => anzeigeArray[i] = 1

                            anzeigeArray[i] = 1;

                        }
                    }
                }
            }
        }

        for (int m = 0; m < loesung.length(); m++) {

            int countletter = countLetter(String.valueOf(eingabe.charAt(m)), loesung);  //Anzahl eines Buchstaben in dem Lösungswort

            if (countletter >= 1) {                                                       //Falls der Buchstabe min 1 Mal vorkommt

                for (int n = 0; n < loesung.length(); n++) {

                    if (n == m) {                                                         //n==m msteht für den Buchstabe der abgefragt wird und n stht für alle anderen Buchstaben die im Lösungswort vorkommen wäre die selbe Stelle und das wollen wir ja gar nicht abfragen

                        continue;

                    }
                    if (eingabe.charAt(m) == eingabe.charAt(n) && anzeigeArray[m] > 0 && anzeigeArray[n] > 0) { // Beide Stellen des Lösungswort müssen gleich sein, beide Stellen dürfen den Wert 0 nicht haben [0 != 0]

                        if (anzeigeArray[m] == 2 || anzeigeArray[m] == 1) {                //Falls das Lösungswort einmal vorkommt oder das

                            if ((anzeigeArray[n] == 2)) {

                                anzeigeArray[m] = 0;

                            } else {

                                anzeigeArray[n] = 0;

                            }

                        } else {

                            anzeigeArray[m] = 0;                // sonst bleibt anzeigeArray[i] = 0;

                        }
                    }
                }
            }
        }




        return anzeigeFarbausgabeneu(anzeigeArray,eingabe);



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
        //System.out.println(letter+" "+count);
        return count;
    }
}
