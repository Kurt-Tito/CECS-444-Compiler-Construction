package interpreter;

import java.util.ArrayList;

public class SymbolTable {
	
	private SCTNode sctnode;
	private Node astnode;
	private String id;
	private String type;
	private String value;
	
	public SymbolTable(SCTNode sctnode, Node astnode)
	{
		this.sctnode = sctnode;
		this.astnode = astnode;
		
		ArrayList<Node> children = astnode.getChildren();
		this.type = children.get(0).getKeyword();
		
		if (this.type.equals("id"))
		{
			this.value = sctnode.findEntry(astnode);
		}
	}
	
	//Getters
	public void setSCTNode(Node astnode)
	{
		this.astnode = astnode;
	}
	
	public void setASTNode(Node astnode)
	{
		this.astnode = astnode;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	//Getters
	public SCTNode getSCTNode()
	{
		return sctnode;
	}
	
	public Node getASTNode()
	{
		return astnode;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getValue()
	{
		return value;
	}

}
