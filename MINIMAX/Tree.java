public class Tree {

    static int treeDepth = 3;

    static int eval = 1;

    Tree(){}

    public static void createMySubtree(Node root, int depth){
        if(depth == treeDepth) return;
        for(int i = 0; i < 4; i++){
            int dice = 2*i + 1;
            Node child = new Node(root, depth+1, ++eval, dice);
            root.children.add(child);
            System.out.println("NODE: " + eval);
            createOpponentSubtree(child, depth+1);
        }
    }

    public static void createOpponentSubtree(Node parent, int depth){
        if(depth == treeDepth) return;
        for(int i = 0; i < 4; i++){
            int dice = 2*i + 1;
            Node child = new Node(parent, depth+1, ++eval, dice);
            parent.children.add(child);
            System.out.println("NODE: " + eval);
            createMySubtree(child, depth+1);
        }
    }

    public static Node maximum(Node maxEval, Node eval){
        if(maxEval.getCheck().getNodeEvaluation() > eval.getCheck().getNodeEvaluation()) return maxEval;
        return eval;
    }

    public static Node minimum(Node minEval, Node eval){
        if(minEval.getCheck().getNodeEvaluation() < eval.getCheck().getNodeEvaluation()) return minEval;
        return eval;
    }

    public static Node minimax(Node root, boolean maximizer) {
        if (root.getNodeDepth() == treeDepth) {
            return root;
        }
        if (maximizer) {
            Node maxEval = new Node();
            maxEval.setCheck(maxEval);
            maxEval.getCheck().setNodeEvaluation(-100);
            for (int i = 0; i < root.children.size(); i++) {
                root.children.get(i).setCheck(minimax(root.children.get(i), false));
                maxEval = maximum(maxEval, root.children.get(i));
            }
            return maxEval;
        } else {
            Node minEval = new Node();
            minEval.setCheck(minEval);
            minEval.getCheck().setNodeEvaluation(100);
            for (int i = 0; i < root.children.size(); i++) {
                root.children.get(i).setCheck(minimax(root.children.get(i), true));
                minEval = minimum(minEval, root.children.get(i));
            }
            return minEval;
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.setNodeDepth(1);
        root.setNodeEvaluation(1);
        System.out.println("NODE: " + root.getNodeEvaluation());
        Tree.createMySubtree(root, 1);

        Node minMax = Tree.minimax(root, true);
        System.out.println("RESULT OF MINMAX: " + minMax.getNodeDice());
        System.out.println("VALUE: " + minMax.getNodeEvaluation());
    }

}
