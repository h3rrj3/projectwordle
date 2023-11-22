import java.util.Arrays;

public class BuchstabenManager {

    public static int[] buchstabenVergleich(String loesung, String eingabe) {
        int[] anzeigeArray = {0, 0, 0, 0, 0};                           // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

        if (eingabe.equals(loesung)) {
            System.out.println("You Won!");
        } else {
            for (int i = 0; i < loesung.length(); i++) {
                if (eingabe.charAt(i) == loesung.charAt(i)) {           // Zeichen ist korrekt => anzeigeArray[i] = 2
                    anzeigeArray[i] = 2;
                } else {
                    for (int j = 0; j < loesung.length(); j++) {
                        if (eingabe.charAt(i) == loesung.charAt(j)) {   // Zeichen ist vorhanden aber falschen Stelle => anzeigeArray[i] = 1
                            anzeigeArray[i] = 1;
                        }
                    }
                }                                                       // sonst bleibt anzeigeArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(anzeigeArray));
        return anzeigeArray;
    }

}
