import java.util.Scanner;

public class BuchstabenManager {

    public char buchstabenVergleich() {
    String loesung = "Bauer";
    String eingabe = "Alter";
    int[] anzeigeArray = {0, 0, 0, 0, 0};                   // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

    if (eingabe.equals(loesung)) {
        System.out.println("You Won!");
    } else
        for (int i = 0; i <= loesung.length(); i++) {
            if (eingabe.charAt(i) == loesung.charAt(i)) {       // Zeichen ist korrekt => anzeigeArray = 2
                anzeigeArray[i] = 2;
            }
            else if (eingabe.charAt(i) == loesung.charAt()) {   // Zeichen ist vorhanden aber falsche Stelle => anzeigeArray = 1
                anzeigeArray[i] = 1;
            }
            else {                                              // Zeichen falsch => anzeigeArray
                anzeigeArray[i] = 0;
            }
        }
    }
}
