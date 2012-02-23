import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Trigram {
    private static final String NO_ALPHANUM = "[^a-z0-9]";
    
    private List<String> next;
    private String key;
    private Random rand;
    
    public Trigram(String[] words) {
        if (words.length != 3) {
            throw new IllegalArgumentException("Three words exactly for a Trigram.");
        }
        
        this.rand = new Random();
        this.key = this.generateKey(words);
        this.next = new ArrayList<String>();
        this.next.add(words[2]);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public String nextKey(String next) {
        String first = this.key.split(" ")[1];
        String second = next.toLowerCase().replaceAll(NO_ALPHANUM, "");
        
        return first + " " + second;
    }
    
    public String getNext() {
        int randomIndex = this.rand.nextInt(this.next.size());
        
        return this.next.get(randomIndex);
    }

    public void addNext(String word) {
        this.next.add(word);
    }
    
    public List<String> values() {
        return next;
    }
    
    private String generateKey(String[] words) {
        return words[0].toLowerCase().replaceAll(NO_ALPHANUM, "") + " " + words[1].toLowerCase().replaceAll(NO_ALPHANUM, "");
    }
}
