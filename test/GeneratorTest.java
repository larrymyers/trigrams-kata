import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;


public class GeneratorTest {

    @Test
    public void should_throw_error_if_given_null_input() {
        try {
            new Generator(null);
        } catch(IllegalArgumentException e) {
            return;
        }
        
        fail("Expected an illegal arg exception.");
    }
    
    @Test
    public void should_generate_trigrams_from_input() {
        Generator generator = new Generator("I wish I may I wish I might");
        
        Map<String,Trigram> trigrams = generator.getTrigrams();
        
        assertEquals(4, trigrams.keySet().size());
        
        assertTrue(trigrams.containsKey("i wish"));
        assertTrue(trigrams.containsKey("wish i"));
        assertTrue(trigrams.containsKey("i may"));
        assertTrue(trigrams.containsKey("may i"));
        
        assertEquals("I", trigrams.get("i may").getNext());
        assertEquals(2, trigrams.get("wish i").values().size());
        assertEquals("may", trigrams.get("wish i").values().get(0));
        assertEquals("might", trigrams.get("wish i").values().get(1));
    }
    
    @Test
    public void should_generate_text_from_trigrams() {
        Generator generator = new Generator("I wish I may I wish I might");
        
        assertNotNull(generator.generateText());
        
        System.out.println("Generated Texts:");
        System.out.println(generator.generateText());
        System.out.println(generator.generateText());
        System.out.println(generator.generateText());
    }
}
