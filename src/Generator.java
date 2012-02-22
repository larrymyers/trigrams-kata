
public class Generator {
    
    private String input;

    public Generator(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Generator input cannot be null!");
        }
        
        this.input = input;
    }
}
