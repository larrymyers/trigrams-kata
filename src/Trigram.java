import java.util.ArrayList;
import java.util.List;


public class Trigram {
    
    private List<String> next;
    private String key;
    
    public Trigram(String[] words) {
        if (words.length != 3) {
            throw new IllegalArgumentException("Three words exactly for a Trigram.");
        }
        
        if (this.next == null) {
            this.next = new ArrayList<String>();
        }
        
        if (this.key == null) {
            this.key = this.generateKey(words);
        }
        
        this.next.add(words[2]);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public String getNext() {
        
        return null;
    }
    
    private String generateKey(String[] words) {
        return null;
    }
}
