import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordManager {
    static final String word = "DUSCHE";
    String[] wordfill = new String[word.length()];
    String SolutionWord = getSolutionWord(6);

    public String getSolutionWord(int wordlength){

        Random random = new Random();
        List<String>filteredList = getFilteredList(wordlength);

        return filteredList.get(random.nextInt(filteredList.size()));

    }
    public List<String> getFilteredList(int wordLength) {

        List<String> filteredList = new LinkedList<>();

        try {
            Path fl = Paths.get("C:/Users/rayen/Downloads/wordlist.txt"); //Pfad bestimmen

            List<String> list = Files.readAllLines(fl); // Das File in eine Liste aus Strings formen

            if (wordLength > 1) {

                for (int i = 0; i < list.size() - 1; i++) {

                    if (list.get(i).length() == wordLength) {

                        filteredList.add(list.get(i));


                    } else {
                        continue;
                    }
                }
            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (IllegalArgumentException e) {

            //System.out.println("Ich hab kein Wort mit Länge "+wordLength);

            return null;
        }
        return filteredList;
    }

    public boolean checkSolutionWord(String word) {

        if (SolutionWord.equals(word)) {

            System.out.println("Du hast gewonnen");

            return true;

        }

        return false;
    }

    public boolean wordExist(String word, int wordlength) {

     for (int i=0; i< getFilteredList(wordlength).size();i++) {

            if (word.equals(getFilteredList(wordlength).get(i))) {

                return true;

            }

        }
     return false;
    }


    public String tostring() {
        String string = Arrays.toString(wordfill);
        string = string.replace("[", "");
        string = string.replace("]", "");
        string = string.replace(",", "");
        string = string.replace(" ", "");


        System.out.println(string);
        return string;
    }

}

