package interpreter;
import java.util.*;

public class Interpreter extends sctBuilder{
	
	private Node astroot;
	private SCTNode sctroot;
	
	public Interpreter(Node astroot)
	{
		this.astroot = astroot;
		sctroot = buildSCT(astroot);
	}
	
	public void runAST(SCTNode sctroot, Node astroot)
	{
		if(isBLOCK(astroot))
			sctroot = astroot.getSctNode();
		else if (isUSE(astroot))
		{
			String val = sctroot.findEntry(astroot);
			sctroot.findEntry(astroot);
		}
		
		//run through children
		ArrayList<Node> children = astroot.getChildren();
		for(int i = 0; i <= children.size()-1; i++)
		{
			runAST(sctroot, children.get(i));
		}
	}
	
	public void printTree(SCTNode root, int level)
	{
		if (root == null)
			return;
		
		String tab = "";
		for (int i  = 0; i < level; i++)
			tab = tab +" ";
		
		System.out.println(tab +" [ " +root +" ] ");
	}
	
	public void printSCT()
	{
		printTree(sctroot, 0);
	}
}
