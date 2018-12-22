package interpreter;

import java.util.*;

public class SCTNode {

	//SCT Parent Node
	private SCTNode parent;
	
	//Children of current node
	private ArrayList<SCTNode> children;
	
	//Symbol Table of current SCT node
	private HashSet<SymbolTable> symtab;
	
	public SCTNode()
	{
		this.children = new ArrayList<>();
		this.symtab = new HashSet<>();
	}
	
	public SCTNode(SCTNode sctnode)
	{
		this();
		setParent(sctnode);
		sctnode.addChild(this);
	}
	
	public SCTNode getParent()
	{
		return parent;
	}
	
	public ArrayList<SCTNode> getChildren()
	{
		return children;
	}
	
	public HashSet<SymbolTable> getSymbolTable()
	{
		return symtab;
	}
	
	public void setParent(SCTNode parent)
	{
		this.parent = parent;
	}
	
	public void addChild(SCTNode node)
	{
		this.children.add(node);
	}
	
	public void setSymbolTable(HashSet<SymbolTable> symtab)
	{
		this.symtab = symtab;
	}
	
	public void addSymbol(SymbolTable table)
	{
		if(table == null)
		{
			return;
		}
		
		//declarations
		
	}

	public String findEntry(Node astnode) 
	{
		// TODO Auto-generated method stub
		if (astnode == null)
			return "";
		
		if (astnode.getKeyword().equals("int") || astnode.getKeyword().equals("float"))
		{
			return astnode.getValue();
		}
		
		for (SymbolTable entry : symtab)
		{
			if(entry.getID().equals(astnode.getValue()))
			{
				return entry.getValue();
			}
		}
		
		if (parent != null)
			return this.parent.findEntry(astnode);
		else
			return "";
	}

}
