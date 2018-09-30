import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    //Initialization
    public DictionaryManagement() {
    }

    //Insert n words form Commandline
    public void insertFromCommandline() {
        System.out.println("\n\n");
        System.out.println("Enter Number Words: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Word " + i + ":");
            System.out.println("Enter Target_Word: ");
            String target = scanner.next();
            System.out.println("Enter Explain_Word: ");
            String explain = scanner.next();
            Dictionary.addWord(target, explain);
        }
    }

    //Insert words from a file
    public static void insertFromFile() {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("dictionaries.txt");
            br = new BufferedReader(fr);
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] curWord = currentLine.split("\t", 2);
                String target = curWord[0];
                String explain = curWord[1];
                Dictionary.addWord(target, explain);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Export Dictionary data to file
    public static void dictionaryExportToFile() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("ExportToFile.txt");
            bw = new BufferedWriter(fw);
            for (int i = 0; i < Dictionary.WordL.size(); i++) {
                bw.write(Dictionary.WordL.get(i).getWord_target() + "\t" + Dictionary.WordL.get(i).getWord_explain());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Look up a word in English
    public static boolean dictionaryLookup(String target) {
        System.out.println("\n\n");
        for (int i = 0; i < Dictionary.WordL.size(); i++) {
            int count = 0;
            if (Dictionary.WordL.get(i).getWord_target().equalsIgnoreCase(target)) {
                count++;
                System.out.println("Found the word you choice:");
                System.out.println("No" + count + "\t|" + Dictionary.WordL.get(i).getWord_target() + "\t|" + Dictionary.WordL.get(i).getWord_explain());
                return true;
            }
        }
        System.out.println("Can't find the word you choice!");
        return false;
    }

    //Insert a word to dictionary
    public static void insertWord(String target, String explain) {
        Dictionary.addWord(target, explain);
    }

    //Update a word, edit target word and explain word
    public static void updateWord(String target, String target_update, String explain_update) {
        for (int i = 0; i < Dictionary.WordL.size(); i++) {
            if (Dictionary.WordL.get(i).getWord_target().equalsIgnoreCase(target)) {
                Dictionary.WordL.get(i).setWord_target(target_update);
                Dictionary.WordL.get(i).setWord_explain(explain_update);
            }
        }
    }

    //remove a word from dictionary
    public static boolean removeWord(String target_remove) {
        for (int i = 0; i < Dictionary.WordL.size(); i++) {
            if (Dictionary.WordL.get(i).getWord_target().equalsIgnoreCase(target_remove)) {
                Dictionary.WordL.remove(i);
                return true;
            }
        }
        System.out.println("Can't find and remove!");
        return false;
    }

    public static void main(String[] args) {
        DictionaryCommandline.dictionaryAdvanced();
    }
}
