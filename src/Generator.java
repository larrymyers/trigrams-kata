import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Generator {
    
    private Map<String,Trigram> trigrams;
    private Random rand;

    public Generator(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Generator input cannot be null!");
        }
        
        this.trigrams = generateTrigrams(input);
        this.rand = new Random();
    }

    public String generateText() {
        StringBuilder s = new StringBuilder();
        
        String key = getStartKey();
        
        while(this.trigrams.containsKey(key)) {
            Trigram trigram = this.trigrams.get(key);
            String word = trigram.getNext();
            
            s.append(word).append(" ");
            
            key = trigram.nextKey(word);
        }
        
        return s.toString();
    }
    
    public Map<String, Trigram> getTrigrams() {
        return this.trigrams;
    }
    
    private String getStartKey() {
        Set<String> keys = this.trigrams.keySet();
        
        int randIndex = this.rand.nextInt(keys.size());
        int i = 0;
        
        for (String key: keys) {
            if (i == randIndex) {
                return key;
            }
            
            i++;
        }
        
        return null;
    }
    
    private Map<String, Trigram> generateTrigrams(String input) {
        Map<String,Trigram> trigrams = new HashMap<String,Trigram>();
        
        String[] words = input.split(" ");
        
        int last = words.length - 3;
        
        for (int i = 0; i <= last; i++) {
            String[] subset = new String[3];
            subset[0] = words[i];
            subset[1] = words[i+1];
            subset[2] = words[i+2];
            
            Trigram trigram = new Trigram(subset);
            
            String key = trigram.getKey();
            
            if (trigrams.containsKey(key)) {
                trigrams.get(key).addNext(trigram.getNext());
            } else {
                trigrams.put(key, trigram);
            }
        }
        
        return trigrams;
    }

}
