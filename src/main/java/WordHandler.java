import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordHandler {

    static List<String> words;
    static FileHandler fh;

    public WordHandler(){
        words = new ArrayList<>();
        try {
            fh = new FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        words.add("Something");
        getWords();

    }

    public void addWord(String word){
        words.add(word);
    }

    public void sendWordsToFile(){
        for(String s : words){
            System.out.println("Hallo");
            fh.writeToFile(s);
        }
    }

    public void getWords(){
        for(String s : words){
            System.out.println(s);
        }
    }
}
