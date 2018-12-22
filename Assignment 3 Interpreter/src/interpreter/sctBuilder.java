package interpreter;
import java.util.ArrayList;

public class sctBuilder {
	
	public SCTNode buildSCT(Node astroot)
	{
		SCTNode sctnode = new SCTNode();
		if (astroot == null)
			return sctnode;
		
		return builder(sctnode, astroot);
	}
	
	//walks the tree to add and create new sctnodes
	public SCTNode builder(SCTNode sctnode, Node astnode)
	{
		if(astnode == null)
			return sctnode;
		
		if(isBLOCK(astnode))
		{
			SCTNode sctkid = new SCTNode(sctnode);
	        astnode.setSctNode(sctkid);

	        ArrayList<Node> children = astnode.getChildren();
	        for (Node child : children) 
	        {
	            builder(sctkid, child);
	        }

		}
		
		if (isUSE(astnode))
		{
	        if (sctnode == null || astnode == null)
	            return sctnode;

	        sctnode.findEntry(astnode);
		}
		
		return sctnode;
	}
	
	
	public boolean isUSE(Node astnode)
	{
		return astnode != null && astnode.getKeyword().equals("id") && !astnode.getParent().getKeyword().equals("equal");
	}
	
	public boolean isBLOCK (Node astnode)
	{
		return astnode != null && astnode.getKeyword().equals("brace1");
	}
}
