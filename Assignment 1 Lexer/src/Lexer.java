import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class Lexer {
    private StringBuilder input = new StringBuilder();
    private Token token;
    private String inputstream;
    private boolean complete = false;
    private Set<Character> empty = new HashSet<Character>();

    public Lexer(String filePath) {
        try (Stream<String> st = Files.lines(Paths.get(filePath))) {
            st.forEach(input::append);
        } catch (IOException ex) {
        	complete = true;
            return;
        }
   
        empty.add('\r'); //return
        empty.add('\n'); //enter
        empty.add((char) 8); //backspace
        empty.add((char) 9); //tab
        empty.add((char) 11); //vertical tab
        empty.add((char) 12); //new page
        empty.add((char) 32); //removes start characters
        Advance();
    }

    public void Advance() {
        if (complete) {
            return;
        }
        if (input.length() == 0) {
        	complete = true;
            return;
        }

        ignoreWhiteSpace();
        if (findNextToken()) {
            return;
        }

        complete = true;
    }

    private void ignoreWhiteSpace() {
        int whiteSpace= 0;

        while (empty.contains(input.charAt(whiteSpace))) {
        	whiteSpace++;
        }

        if (whiteSpace > 0) {
            input.delete(0, whiteSpace);
        }
    }

    private boolean findNextToken() {
        for (Token t : Token.values()) {
            int end = t.endOfMatch(input.toString());

            if (end != -1) {
                token = t;
                inputstream = input.substring(0, end);
                input.delete(0, end);
                return true;
            }
        }

        return false;
    }

    public Token currentToken() {
        return token;
    }

    public String Peak() {
        return inputstream;
    }

    public boolean isComplete() {
        return complete;
    }
}
