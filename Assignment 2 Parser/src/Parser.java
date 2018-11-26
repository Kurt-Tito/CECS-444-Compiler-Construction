
import java.util.ArrayList;
import java.util.Stack;

public class Parser {

    private static Stack<Node> inputStack;
    private static ArrayList<Token> tokens;
    private static Node root;

    public static void main(String args[]) {
        Node astRoot = getASTRoot(true);
        printTree(astRoot, 0);
    }

    public static Node getASTRoot(boolean printPST) {
        ParseTable table = init();
        if (table == null) {
            System.out.println("Tokenizer Failed.");
            System.exit(1);
        }

        while(!inputStack.empty()) {
			
            String stackTop = inputStack.peek().getKeyword();
            String inputFront = tokens.get(0).getGrammar().getKeyword();
			
			// LL Mechanism 

            if (stackTop.equals(inputFront) || stackTop.equals("$")) {
                m1();
            } else if (m2(stackTop)) {
                errorFunc("M2");
            } else {
				
                Rule rule = table.get(stackTop, inputFront);
            
                if (m3(rule)) {
                    errorFunc("M3");
                } else {
                    m4(rule);
                } 
            } 
        } 

        if (printPST)
            printTree(root, 0);

        return ASTConverter.convert(root);
    } 

    private static ParseTable init() {
        Tokenizer tokenizer = new Tokenizer("program.txt");

        if (tokenizer.isReady())
            tokens = tokenizer.tokenize();

        if (tokens == null || tokens.isEmpty())
            return null;

        // SETUP : start the parser
        inputStack = new Stack<Node>();
        root = new Node("Pgm");
        inputStack.push(root);

        return new ParseTable();
    }
	
	/** LL MECH Methods **/
	
    private static void m1() {
        Node poppedNode = inputStack.pop();
        Token poppedToken = tokens.remove(0);

        poppedNode.setValue(poppedToken.getValue());
    }

    private static boolean m2(String top) {
        return !top.isEmpty() && Character.isLowerCase(top.charAt(0));
    }

    private static boolean m3(Rule rule) {
        return rule == null;
    }

    private static void m4(Rule rule) {
        
        if (rule.isEpsilonRule()) {
            inputStack.pop();
        } else {
           
            Node parent = inputStack.pop();

            String[] reversed = rule.getReversedRhsArray();
            for (String keyword : reversed) {
                Node child = new Node(keyword);
                parent.addChild(child);
                inputStack.push(child);
            }
        }
    }

    private static void errorFunc(String errorFuncLoc) {
        System.out.println(errorFuncLoc + " errorFunc.");
        System.exit(1);
    }

	//Print Tree Recursively
    public static void printTree(Node root, int level) {
        if (root == null)
            return;

        String str = "";
		
        for (int i = 0; i < level; i++)
            str = str + "  ";
		
        String tabbing = str;
        
        System.out.println(tabbing + "(" + root + ")");

        level++;
        ArrayList<Node> children = root.getChildren();
        for (Node child : children) {
            printTree(child, level);
        }
    }
    
    
} 
