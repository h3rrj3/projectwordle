import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordManager {
    private int wordLength;
    String SolutionWord;
    List<String>filteredList;

    public void setFilteredList(List<String> filteredList) {
        this.filteredList = filteredList;
    }

    public List<String> getFilteredList() {
        return filteredList;
    }


    public int getWordLength() {
        return wordLength;
    }

    public  void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }


    public String getSolutionWord(){

        Random random = new Random();

        return filteredList.get(random.nextInt(filteredList.size()));

    }
    public List<String> generateWordList(int wordLength) { // getWordlistbylenght || filterwordsbylength

        List<String> filteredList = new LinkedList<>();

        try {
            Path fl = Paths.get("C:/Users/rayen/IdeaProjects/projectwordle2.0/main/src/wordlistG.txt"); //Pfad bestimmen

            List<String> list = Files.readAllLines(fl); // Das File in eine Liste aus Strings formen

            if (wordLength > 1) {

                for (int i = 0; i < list.size() - 1; i++) {

                    if (list.get(i).length() == wordLength) {

                        filteredList.add(list.get(i));


                    }
                }
                setFilteredList(filteredList);
                return filteredList;
            }

        } catch (IOException e) {

            System.out.println("Dateipfad existiert nicht");

        } catch (IllegalArgumentException e) {

            System.out.println("Ich hab kein Wort mit Länge "+ getWordLength());

            return null;
        }
        return filteredList;
    }

    public boolean checkSolutionWord(String loesung, String word) {

        if (loesung.equals(word)) {

            return true;

        }

        return false;
    }

    public  boolean wordExist(String word) {
        return filteredList.contains(word);
    }

    /*
    public String tostring() {
        String string = Arrays.toString(wordfill);
        string = string.replace("[", "");
        string = string.replace("]", "");
        string = string.replace(",", "");
        string = string.replace(" ", "");


        System.out.println(string);
        return string;
    }

     */

}

