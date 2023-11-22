import java.util.Scanner;

public class BuchstabenManager {

    public char buchstabenVergleich() {
    String loesung = "Bauer";
    String eingabe = "Alter";
    if (eingabe.equals(loesung)) {
        System.out.println("You won!");
    }


    //char[] eingabeFolge = eingabe.toCharArray();
    //char[] loesungFolge = loesung.toCharArray();

    if (eingabe.equals(loesung)) {
        System.out.println("You Won!");
    } else
        for (int i = 0; i <= loesung.length(); i++) {
            if (eingabe.charAt(i) == (loesung.charAt(i))) {
                return;                                         // Zeichen ist gleich
            }
        }
    }





}
