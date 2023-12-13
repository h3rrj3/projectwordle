import java.nio.channels.WritePendingException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WordManager wm;
        BuchstabenManager bm = new BuchstabenManager();

        System.out.println("Willkommen bei Wordle!");
        System.out.print("Geben Sie die Wortlänge ein : ");

        int length = scanner.nextInt();
        wm = bm.getWm();
        wm.generateWordList(length);
        String loesung = wm.getSolutionWord();

        System.out.println(loesung);//Für Debugging

        for (int i=0; i<6;i++) {

            System.out.print("Geben Sie das Eingabewort ein: ");
            String eingabe = scanner.next();
            String ergebnis=bm.comparisonOfLetters(loesung, eingabe);

            if (ergebnis == null) {

                i--;


            } else if (ergebnis.equals("WON")) {

                break;

            }
            else {

                System.out.println(ergebnis);

            }
            
            if (i==5){
                System.out.println();
                System.out.println("Keine Versuche mehr leider Verloren ):");
                System.exit(1);
            }

        }
    }
}
