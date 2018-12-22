package interpreter;
package parser;

public class main {
	public static void main(String args[])
	{
		Node astroot = Parser.getASTRoot(true);
		Interpreter intpr = new Interpreter(astroot);
		intpr.printSCT();
	}
}
