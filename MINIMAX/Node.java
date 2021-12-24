import java.util.ArrayList;

public class Node {
    Node parent; //ο κόμβος-πατέρας του κόμβου που δημιουργήσατε.
    Node check;
    ArrayList<Node> children = new ArrayList<>(); //ο δυναμικός πίνακας που περιλαμβάνει τα παιδιά του κόμβου που δημιουργήσατε.
    int nodeDepth; //το βάθος του κόμβου στο δέντρο του MinMax Αλγορίθμου.
    int nodeEvaluation;  //την τιμή της συνάρτησης αξιολόγησης της κίνησης που αντιπροσωπεύει ο συγκεκριμένος κόμβος.
    int nodeDice;

    public Node(){
        // empty constructor
    }

    public Node(Node parent, int nodeDepth, int nodeEvaluation, int nodeDice){
        this.parent = parent;
        this.nodeDepth = nodeDepth;
        this.nodeEvaluation = nodeEvaluation;
        this.nodeDice = nodeDice;
    }
    
    //start of setters and getters

    public Node getCheck() {
        return check;
    }

    public void setCheck(Node check) {
        this.check = check;
    }

    public int getNodeDice() {
        return nodeDice;
    }

    public Node getParent() {
        return parent;
    }
    
    public ArrayList<Node> getChildren() {
        return children;
    }

    public int getNodeDepth() {
        return nodeDepth;
    }

    public int getNodeEvaluation() {
        return nodeEvaluation;
    }

    public void setNodeDice(int nodeDice) {
        this.nodeDice = nodeDice;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void setNodeDepth(int nodeDepth) {
        this.nodeDepth = nodeDepth;
    }

    public void setNodeEvaluation(int nodeEvaluation) {
        this.nodeEvaluation = nodeEvaluation;
    }
}