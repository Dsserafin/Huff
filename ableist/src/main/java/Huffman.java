import java.util.ArrayList;

public class Huffman {
    private MinHeap dfs = new MinHeap();
    private Node[] nodeArray;
    private int size;
    private Node root;
    private ArrayList<Node> compressed = new ArrayList<>();


    public Huffman(Node[] nodeArray) {
        this.nodeArray = nodeArray;
        size = nodeArray.length;

    }

    public ArrayList<Node> getCompressed() {
        return compressed;
    }

    private void findRoot(){
        root = HuffmanAlgorithm();
    }

    private Node HuffmanAlgorithm() {
        Node[] result = nodeArray;
        dfs.heapSort(result, result.length);
        for (int i = size - 1; i > 0; i--) {
            Node left = extractMin(result);
            Node right = extractMin(result);
            Node tempNode = new Node(left, right, left.getChar());
            tempNode.setFrequency(right.getFrequency() + left.getFrequency());
            insert(tempNode, result);

        }
        return extractMin(result);
    }
    private Node extractMin(Node[] nodes) {
        Node min = nodes[size-1];
        size--;

        return min;
    }
    private void insert(Node newNode, Node[] nodes) {
        size++;
        nodes[size-1] = newNode;

    }

    public void setCompressing(){
        findRoot();
        if (root.getRight() == null) {
            root.setCompressCode("1");
            Compress(root.getLeft());
        }else if (root.getLeft() == null) {
            root.setCompressCode("0");
            Compress(root.getRight());
        }else{
            root.getRight().setCompressCode("1");
            Compress(root.getRight());
            root.getLeft().setCompressCode("0");
            Compress(root.getLeft());
        }
    }

    private void Compress(Node node){
        if(node.getRight() != null){
            node.getRight().setCompressCode(node.getCompressCode() + "1");
            Compress(node.getRight());
        }
        if(node.getLeft() != null){
            node.getLeft().setCompressCode(node.getCompressCode() + "0");
            Compress(node.getLeft());
        }
        if (node.getRight() == null && node.getLeft() == null){
            node.setBitSet();
            compressed.add(node);
        }
    }



}
