import java.util.ArrayList;
import java.util.List;

public class WordHandler {

    static List<String> words;
    static FileHandler fh;

    public WordHandler(){
        words = new ArrayList<String>();
    }

    public void addWord(String word){
        words.add(word);
    }

    public void sendWordsToFile(){
        for(String s : words){
            fh.writeToFile(s);
        }
    }
}
