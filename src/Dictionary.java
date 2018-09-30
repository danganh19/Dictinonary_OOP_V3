import java.util.ArrayList;

public class Dictionary {
    //WordList Initialization
    public static ArrayList<Word> WordL = new ArrayList();

    //add word with target word and explain word
    public static void addWord(String word_target,String word_explain){
        Word newWord = new Word(word_target,word_explain);
        WordL.add(newWord);
    }
}