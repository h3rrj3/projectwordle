import java.util.Arrays;

public class BuchstabenManager {

    public static int[] buchstabenVergleich(String loesung, String eingabe) {
        int[] anzeigeArray = {0, 0, 0, 0, 0};                           // 0 = Zeichen falsch; 1 = Zeichen rot (vorhanden aber falsche Stelle), 2 = Zeichen richtig

        if (eingabe.equalsIgnoreCase(loesung)) {
            anzeigeArray = new int[]{2, 2, 2, 2, 2};                    // z.Z. nur für Debugging notwendig
            System.out.println("You won!");                             // wird später anders gelöst?
        } else {
            for (int i = 0; i < loesung.length(); i++) {
                if (eingabe.charAt(i) == loesung.charAt(i)) {           // Zeichen ist richtig => anzeigeArray[i] = 2
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
        System.out.println(Arrays.toString(anzeigeArray));              // SOUT für Debugging, kann später gelöscht werden
        return anzeigeArray;
    }

    //provisorische Ausgabe in der entsprechenden Farbe
    public static String anzeigeFarbausgabe (int[] anzeigeArray, String eingabe) {
        for (int i = 0; i < eingabe.length(); i++) {
            switch (anzeigeArray[i]) {
                case 0:
                    System.out.print(eingabe.charAt(i));
                case 1:
                    System.out.print(ColorChange.ANSI_RED + eingabe.charAt(i) + ColorChange.ANSI_RESET);
                case 2:
                    System.out.print(ColorChange.ANSI_GREEN + eingabe.charAt(i) + ColorChange.ANSI_RESET);
            }
        }
        return eingabe;
    }

}
