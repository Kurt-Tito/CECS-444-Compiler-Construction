public class Tester {
    public static void main(String[] args) {
        Lexer input = new Lexer("test.txt");

        while (!input.isComplete()) {
            System.out.printf("%-10s %s\n", input.currentToken(), ("'" +input.Peak() + "'"));
            input.Advance();
        }
       if(input.isComplete()) {
    	   System.out.printf("%-10s %s\n", "TOK0", "'\"\"'");
       }
    }
}

