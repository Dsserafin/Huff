class MinHeap {
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

    public void buildHeap(Node[] array){
        for (int i = (array.length - 1)/2; i >= 0; i--) {
            minHeapify(i, array.length, array);
        }
    }

    public void heapSort(Node[] array, int heap_size) {
        buildHeap(array);
        for (int i = heap_size - 1; i >= 0; i--) {
            Node temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            minHeapify(0, i, array);
        }

    }

}