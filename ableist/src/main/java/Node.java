import java.util.BitSet;

public class Node {
    private Node left;
    private Node right;
    private int frequency = 0;
    private char character;
    private String compressCode;
    BitSet huffmanCodeBit;

    public void setBitSet() {
        huffmanCodeBit = new BitSet(compressCode.length());
        for (int i = 0; i < compressCode.length(); i++) {
            if (compressCode.charAt(i) == '1') {
                huffmanCodeBit.set(i);
            }
        }
    }

    public BitSet getHuffmanCodeBit() {
        return huffmanCodeBit;
    }

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
        if (left == null){
            return null;
        }
        return left;
    }
    public Node getRight() {
        if (right == null){
            return null;
        }
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
    public void setCompressCode(String compressCode) {
        this.compressCode = compressCode;
    }
    public String getCompressCode() {
        return compressCode;
    }

}
