
import java.util.ArrayList;

public class Node {
    private Node parent;
    private ArrayList<Node> children;
    private String keyword;
    private String value;
    private int hashId;
    
    public Node(String keyword) {
        this(keyword, "");
    }

    public Node(String keyword, String value) {
        this.keyword = keyword;
        this.value = value;
        children = new ArrayList<Node>();
        this.hashId = System.identityHashCode(this);
    }

    public String getKeyword() {
        return keyword;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }

    public void addChildren(ArrayList<Node> childrenToAdd) {
        if (childrenToAdd == null)
            return;

        for (Node child : childrenToAdd)
            addChild(child);
    }

    public void replaceChildren(ArrayList<Node> childrenToAdd) {
        if (childrenToAdd == null)
            return;

        children.clear();
        for (Node child : childrenToAdd)
            addChild(child);
    }

    public boolean isEpsilonRule() {
        return Character.isUpperCase(this.keyword.charAt(0)) && children.isEmpty();
    }

    private boolean isValueOkayToPrint()
    {
        return !value.isEmpty() &&
                keyword.equals("id") || keyword.equals("int") ||
                keyword.equals("float") || keyword.equals("string");
    }

    @Override
    public String toString() {
        String str = "Node: " +
                "id='" + hashId + '\'' +
                ", keyword='" + keyword + '\'';

        if (isValueOkayToPrint()) {
            str = str + ", value='" + value + '\'';
        }

        str = str + "}";
        return str;
    }

}
