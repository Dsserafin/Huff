class MinHeap {

    int size;
    private Node[] nodeArray;

    MinHeap(Node[] nodes) {
        this.nodeArray = nodes;
        this.size = nodes.length;
        buildHeap(nodeArray);
    }

    private void minHeapify(int i, int size, Node[] array){
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if( l < size && array[l].getFrequency() < array[largest].getFrequency() ){
            largest = l;
        }
        if( r < size && array[r].getFrequency() < array[largest].getFrequency() ){
            largest = r;
        }
        if( largest != i ){
            Node temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            minHeapify(largest, size, array);
        }

    }

    private void buildHeap(Node[] array){
        for (int i = (array.length - 1)/2; i >= 0; i--) {
            minHeapify(i, array.length, array);
        }
    }

    public void insert(Node n){
        size++;
        nodeArray[size-1] = nodeArray[0];
        nodeArray[0] = n;
        minHeapify(0, size, nodeArray);

    }

    public Node getMin(){
        Node temp = nodeArray[0];
        nodeArray[0] = nodeArray[size-1];
        size--;
        minHeapify(0, size, nodeArray);
        return temp;
    }



}