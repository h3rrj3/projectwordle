import java.nio.channels.WritePendingException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordManager wm;
        System.out.println("Willkommen bei Wordle!");
        /*
        // provisorische Worteingabe
        System.out.print("Geben Sie das Lösungswort ein: ");
        String loesung = scanner.nextLine().toUpperCase();
        System.out.print("Geben Sie das Eingabewort ein: ");
        String eingabe = scanner.nextLine().toUpperCase();


        int[] anzeigeArray;  // Zugriff auf Buchstaben-Vergleich
        anzeigeArray = BuchstabenManager.buchstabenVergleichalt(loesung, eingabe);
        BuchstabenManager.anzeigeFarbausgabe(anzeigeArray, eingabe);



         */

        //---------------------------------------------------------------------
        System.out.print("Geben Sie die Wortlänge ein : ");

        int length = scanner.nextInt();
        BuchstabenManager bm = new BuchstabenManager();
        wm = bm.getWm();
        wm.generateWordList(length);
        String loesung = wm.getSolutionWord();
        System.out.println(loesung);
        for (int i=0; i<6;i++) {

            System.out.print("Geben Sie das Eingabewort ein: ");
            String eingabe = scanner.next();
            String array=bm.comparisonOfLetters(loesung, eingabe);

            if (array == null) {

                i--;

                continue;

            } else if (array.equals("WON")) {

                break;

            }
            else {

                System.out.println(array);

            }

        }
    }
}
