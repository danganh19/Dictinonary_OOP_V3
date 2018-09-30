public class DictionaryCommandline {
    //Print out all Dictionary data
    public static void showAllWords(){
        System.out.println("\n\n");
        int count = 0;
        System.out.println("No \t| English \t| Vietnamese");
        for(int i = 0; i < Dictionary.WordL.size(); i++)
        {
            count ++;
            System.out.println("No" + count +"\t|" + Dictionary.WordL.get(i).getWord_target() + "\t|" + Dictionary.WordL.get(i).getWord_explain() );
        }
    }

    //Dictionary Basic: Insert words from Commandline and print them out
    public static void dictionaryBasic()
    {
        DictionaryManagement a = new DictionaryManagement();
        a.insertFromCommandline();
        DictionaryCommandline.showAllWords();
    }

    //Searching for one or several word by head string or all word
    public static boolean dictionarySearcher(String string_head){
        System.out.println("\n\n");
        int count = 0;
        for (int i = 0; i < Dictionary.WordL.size(); i++) {
            if (Dictionary.WordL.get(i).getWord_target().indexOf(string_head) == 0) {
                count ++;
                System.out.println("No" + count + "\t|" + Dictionary.WordL.get(i).getWord_target() + "\t|" + Dictionary.WordL.get(i).getWord_explain());
            }
        }
        if(count == 0) return false;
        else return true;
    }

    // Dictionary version 2, 3 tests
    public static void dictionaryAdvanced(){
        DictionaryManagement.insertFromFile();
        DictionaryCommandline.showAllWords();
        DictionaryManagement.dictionaryLookup("hair");
        DictionaryManagement.insertWord("remote", "dieu khien");
        DictionaryCommandline.showAllWords();
        DictionaryManagement.removeWord("hand");
        DictionaryCommandline.showAllWords();
        DictionaryManagement.updateWord("dog", "chair", "cai ghe");
        DictionaryCommandline.showAllWords();
        DictionaryCommandline.dictionarySearcher("h");
        DictionaryManagement.dictionaryExportToFile();
    }
}
