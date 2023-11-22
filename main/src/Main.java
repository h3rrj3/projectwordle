import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Willkommen bei Wordle!");

        // provisorische Worteingabe
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie das Lösungswort ein: ");
        String loesung = scanner.nextLine();
        System.out.print("Geben Sie das Eingabewort ein): ");
        String eingabe = scanner.nextLine();


        //
        BuchstabenManager.buchstabenVergleich(loesung, eingabe);
    }
}