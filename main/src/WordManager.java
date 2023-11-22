import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordManager {
    static final String word = "DUSCHE";
    int wordlength =0;

    public int getWordlength() {
        return wordlength;
    }

    public void setWordlength(int wordlength) {
        this.wordlength = wordlength;
    }

    String[] wordfill = new String[word.length()];
    String SolutionWord = getSolutionWord();

    public String getSolutionWord(){

        Random random = new Random();
        List<String>filteredList = getFilteredList();

        return filteredList.get(random.nextInt(filteredList.size()));

    }
    public List<String> getFilteredList() {

        List<String> filteredList = new LinkedList<>();

        try {
            Path fl = Paths.get("C:/Users/rayen/Downloads/wordlist.txt"); //Pfad bestimmen

            List<String> list = Files.readAllLines(fl); // Das File in eine Liste aus Strings formen

            if (getWordlength() > 1) {

                for (int i = 0; i < list.size() - 1; i++) {

                    if (list.get(i).length() == getWordlength()) {

                        filteredList.add(list.get(i));


                    }
                }
            }

        } catch (IOException e) {

            System.out.println("Dateipfad existiert nicht");

        } catch (IllegalArgumentException e) {

            System.out.println("Ich hab kein Wort mit Länge "+getWordlength());

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

    public boolean wordExist(String word) {

     for (int i=0; i< getFilteredList().size();i++) {

            if (word.equals(getFilteredList().get(i))) {

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

