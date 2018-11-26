
import java.util.ArrayList;

public class ASTConverter {
    public static Node convert(Node root) {
    	
        if (root != null) {
            ArrayList<Node> children = root.getChildren();
            
            for (int i = 0; i < children.size(); i++) {
                Node fixedChild = convert(children.get(i));
                fixedChild.getChildren().removeIf(Node::isEpsilonRule);
                fixedChild = fixExtra(fixedChild);
                children.set(i, fixedChild);
            }
        }
        
        return fix(root);
    }
    
    private static Node fix(Node pstNode) {
        Node hoisted = pstNode;

        if (pstNode != null) {
            String nodeType = pstNode.getKeyword();
            ArrayList<Node> children = pstNode.getChildren();
            boolean add = true;

            if (!children.isEmpty()) {
                switch (nodeType) {
                    case "Pgm":
                        hoisted = fix1(children);
                        break;
                    case "BBlock":
                        hoisted = fix2(children);
                        break;
                    case "Vargroup":
                        hoisted = fix1(children);
                        break;
                    case "PPvarlist":
                        hoisted = fix3(children);
                        break;
                    case "Varlist":
                        hoisted = fix4(children);
                        break;
                    case "Vardecl":
                        hoisted = fix1(children);
                        break;
                    case "Basekind":
                        hoisted = fix0(children);
                        break;
                    case "Varid":
                        hoisted = fix0(children);
                        break;
                    case "Stmts":
                        hoisted = fix1(children);
                        break;
                    case "Stmt":
                        hoisted = fix0(children);
                        break;
                    case "Stasgn":
                        hoisted = fix1(children);
                        break;
                    case "Stprint":
                        hoisted = fix1(children);
                        break;
                    case "Stwhile":
                        hoisted = fix4(children);
                        break;
                    case "PPexprs":
                        hoisted = fix4(children);
                        break;
                    case "PPexpr1":
                        hoisted = fix4(children);
                        break;
                    case "Exprlist":
                        hoisted = fix1(children);
                        break;
                    case "Moreexprs":
                        hoisted = fix1(children);
                        break;
                    case "S":
                        hoisted = fix4(children);
                        break;
                    case "Expr":
                        hoisted = fix1(children);
                        break;
                    case "R":
                        hoisted = fix4(children);
                        break;
                    case "Rterm":
                        hoisted = fix0(children);
                        break;
                    case "Q":
                        hoisted = fix4(children);
                        break;
                    case "Term":
                        hoisted = fix0(children);
                        add = true;
                        break;
                    default: 
                        hoisted = fix0(children);
                } 
            }

            if (add)
                hoisted.addChildren(children);
            else
                hoisted.replaceChildren(children);

            hoisted.setParent(pstNode.getParent());
        }
        return hoisted;
    }

    private static Node fix1(ArrayList<Node> children) {
        return children.remove(1);
    }

    private static Node fix2(ArrayList<Node> children) {
        children.remove(0);
        return children.remove(2);
    }

    private static Node fix3(ArrayList<Node> children) {
        children.remove(0);
        return children.remove(1);
    }

    private static Node fix4(ArrayList<Node> children) {
        return children.remove(2);
    }

    private static Node fix0(ArrayList<Node> children) {
        return children.remove(0);
    }

    private static Node fixExtra(Node node) {
        Node hoisted = node;

        if (hoisted.getKeyword().equals("Q")) {
            ArrayList<Node> children = hoisted.getChildren();

            if (children.size() >= 1) {
                hoisted = fix0(children);
                hoisted.replaceChildren(children);
            }
        }

        if (hoisted.getKeyword().equals("R")) {
            ArrayList<Node> children = hoisted.getChildren();

            if (children.size() == 1) {
                Node nodeToTest = children.get(0);

                if (nodeToTest.getKeyword().equals("caret") ||
                        nodeToTest.getKeyword().equals("aster") ||
                        nodeToTest.getKeyword().equals("slash")) {
                    hoisted = nodeToTest;
                } else {
                    hoisted = fix0(children);
                    hoisted.replaceChildren(children);
                }
            }
        }

        hoisted.setParent(node.getParent());
        return hoisted;
    }
}
