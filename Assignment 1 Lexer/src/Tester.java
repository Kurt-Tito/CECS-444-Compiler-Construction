import java.io.FileNotFoundException;

/**        
 * Tester.java
 * 
 *  This is the main runnable class that displays all the tokens that are processed from the given text file. 
 */
public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        Lexer input = new Lexer("test.txt");
        
        while (!input.isComplete()) {
        	if(input.inputIntCheck(input.Peak())) {
        		int numInt = Integer.parseInt(input.Peak());
        		System.out.printf("(Tok: %2s %s\n", input.printToken(), ("line= " + input.lineNumber(input.Peak())) + (" str= \"" + input.Peak() + "\"") + (" int= " + numInt + ")"));
        	}
        	else if(input.inputFloatCheck(input.Peak())) {
        		float numFloat = Float.parseFloat(input.Peak());
        		System.out.printf("(Tok: %2s %s\n", input.printToken(), ("line= " + input.lineNumber(input.Peak())) + (" str= \"" + input.Peak() + "\"") + (" float= " + numFloat + ")"));
        	}
        	else {
        		System.out.printf("(Tok: %2s %s\n", input.printToken(), ("line= " + input.lineNumber(input.Peak())) + (" str= \"" + input.Peak() + "\")"));
        	}
            input.Advance();
       }
       if(input.isComplete()) {
    	   System.out.printf("%-5s %s\n",  "(Tok:  0 line=", input.lineNumber(input.Peak()) + " str= \"\")");
       }	
    }
}
