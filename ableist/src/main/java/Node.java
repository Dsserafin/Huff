public class Node {
    private Node left;
    private Node right;
    private int frequency = 0;
    private char character;

    public Node(Node left, Node right, char character) {
        this.left = left;
        this.right = right;
        this.character = character;
    }
    public char getChar() {
        return character;
    }
    public void setCharacter(char character) {
        this.character = character;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int getFrequency() {
        return frequency;
    }
    public char getCharacter() {
        return character;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public void calculateFrequency() {
        this.frequency = left.getFrequency() + right.getFrequency();
    }
    public void copyNode(Node node){
        this.setCharacter(node.getCharacter());
        this.setFrequency(node.getFrequency());
        this.setLeft(node.getLeft());
        this.setRight(node.getRight());
    }

}
