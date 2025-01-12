public class Huffman {
    DFS dfs = new DFS();
    Node[] nodeArray;
    int size;

    public Huffman(Node[] nodeArray) {
        this.nodeArray = nodeArray;
        size = nodeArray.length;

    }

    public Node HuffmanAlgorithm() {
        Node[] result = nodeArray;
        for (int i = 0; i < size; i++) {
            Node left = extractMin(result);
            Node right = extractMin(result);
            Node tempNode = new Node(left, right, left.getChar());
            insert(tempNode, result);
        }
        return extractMin(result);
    }
    public Node extractMin(Node[] nodes) {
        Node min = nodes[0];
        for (int i = 1; i < size; i++) {
            nodes[i-1] = nodes[i];

        }
        size--;
        return min;
    }
    public void insert(Node newNode, Node[] nodes) {
        size++;
        nodes[size-1] = newNode;
        dfs.heapSort(nodes, size);
    }
}
