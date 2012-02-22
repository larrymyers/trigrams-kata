import static org.junit.Assert.*;

import org.junit.Test;


public class GeneratorTest {

    @Test
    public void should_take_a_string_as_the_source_input() {
        try {
            new Generator(null);
        } catch(IllegalArgumentException e) {
            return;
        }
        
        fail("Expected an illegal arg exception.");
    }
}
