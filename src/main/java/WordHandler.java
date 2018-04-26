import java.util.ArrayList;
import java.util.List;

public class WordHandler {

    List<String> words;

    public WordHandler(){
        words = new ArrayList<String>();
    }

    public void addWord(String word){
        words.add(word);
    }

    public void getWords(){
        for(String s : words){
            System.out.print(s + ", ");
        }
    }
}
