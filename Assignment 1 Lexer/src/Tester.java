/**        
 * Tester.java
 * 
 *  This is the main runnable class that displays all the tokens that are processed from the given text file. 
 */
public class Tester {
    public static void main(String[] args) {
        Lexer input = new Lexer("test.txt");
        
        while (!input.isComplete()) {
            System.out.printf("(Tok: %2s %s\n", input.printToken(), ("line= " + input.lineNumber()) + (" str= \"" + input.Peak() + "\")"));
            input.Advance();
       }
       if(input.isComplete()) {
    	   System.out.printf("%-5s %s\n",  "(Tok:  0 line=", input.lineNumber() + " str= \"\")");
       }	
    }
}
