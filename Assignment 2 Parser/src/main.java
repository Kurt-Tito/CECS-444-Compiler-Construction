

import static java.lang.Thread.sleep;

public class main {

    public static void main(String args[]) {
        Node astRoot = Parser.getASTRoot(true);
        System.out.println("\n\n");
        Parser.printTree(astRoot, 0);
    }
}
