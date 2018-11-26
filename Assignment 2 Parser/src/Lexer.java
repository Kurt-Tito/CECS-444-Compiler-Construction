import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
* This Lexer class works on creating tokens from words on the given text file.
*
*
*/
public class Lexer {
    private StringBuilder input = new StringBuilder();
    private Token token;
    private String inputstream;
    private boolean complete = false;
    private Set<Character> empty = new HashSet<Character>();
    private String filePath;
    private ArrayList<Token> tokens;
    
    //Reads the text file line by line
    public Lexer(String file) {
    	filePath = file;
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
    /**
    *This advance function moves onto the next character.
    *
    *
    */
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
        tokens.add(token);
    }
    /**
    *This ignoreWhiteSpace function ignores any blank spaces in the text.
    *
    *
    */
    private void ignoreWhiteSpace() {
        int whiteSpace= 0;

        while (empty.contains(input.charAt(whiteSpace))) {
        	whiteSpace++;
        }

        if (whiteSpace > 0) {
            input.delete(0, whiteSpace);
        }
    }
    /**
    *This findNextToken function gets the next token once it reaches 
    *the end of one token.
    *
    */
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
    //returns the current Token word
    public Token currentToken() {
        return token;
    }

    //returns the Token's number, used for format printing
    public String printToken() {
    	String token = currentToken().toString();
    	token = token.replaceAll("TOKEN", "");
    	return token;
    }
    
    //returns the line number where the token is located
    public int lineNumber() {
    	return 1;
    }
    
    //checks if the number is an integer
    public boolean inputIntCheck(String inputstream) {
    	if(inputstream.matches("-?\\d+")) {
    		return true;
    	}
    	return false;
    }
    
    //checks if the number is a float
    public boolean inputFloatCheck(String inputstream) {
    	try {
    		float temp = Float.parseFloat(inputstream);
    	}
    	catch (NumberFormatException ex) {
    		return false;
    	}
    	return true;
    }
    
  //returns the line number where the token is located
    public int lineNumber(String inputstream) throws FileNotFoundException {
    	Scanner in = new Scanner(new File(filePath));
    	int line = 1;
    	while(in.hasNext()) {
    		String str = in.nextLine();
    		if(str.contains(inputstream)) {
    			return line;
    		}
    		line++;
    		str = "";
    		in.reset();
    	}
    	return line;

}
    //returns a copy of the next character in the input stream
    public String Peak() {
        return inputstream;
    }
    //returns the boolean value of complete
    public boolean isComplete() {
        return complete;
    }
    
    public ArrayList<Token> getTokens()
    {
    	return tokens;
    }
}
