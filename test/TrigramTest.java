import static org.junit.Assert.*;

import org.junit.Test;



public class TrigramTest {
    
    @Test
    public void should_throw_exception_if_less_than_three_words_are_used() {
        try {
            new Trigram(new String[] { "a", "test" });
        } catch (IllegalArgumentException e) {
            return;
        }
        
        fail("Expected only two words to be invalid.");
    }
    
    @Test
    public void should_throw_exception_if_more_than_three_words_are_used() {
        try {
            new Trigram(new String[] { "a", "test", "with", "more"});
        } catch (IllegalArgumentException e) {
            return;
        }
        
        fail("Expected more than three words to be invalid.");
    }
    
    @Test
    public void should_use_first_two_words_as_the_key() {
        Trigram trigram = new Trigram(new String[] {"foo", "bar", "baz"});
        
        assertEquals("foo bar", trigram.getKey());
    }
    
    @Test
    public void should_lower_case_and_only_use_alpha_numeric_chars_for_key() {
        Trigram trigram = new Trigram(new String[] {"foo,", " .bar!", "baz"});
        
        assertEquals("foo bar", trigram.getKey());
    }
}
