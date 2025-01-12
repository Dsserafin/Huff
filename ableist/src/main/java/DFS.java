import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class DFS {




    private void maxHeapify(int i, int size, Node[] array){
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if( l < size && array[l].getFrequency() > array[largest].getFrequency() ){
            largest = l;
        }
        if( r < size && array[r].getFrequency() > array[largest].getFrequency() ){
            largest = r;
        }
        if( largest != i ){
            int temp = array[i].getFrequency();
            array[i] = array[largest];
            array[largest].setFrequency(temp);
            maxHeapify(largest, size, array);
        }

    }

    private void buildHeap(Node[] array){
        for (int i = (array.length - 1)/2; i >= 0; i--) {
            maxHeapify(i, array.length, array);
        }
    }

    public void heapSort(Node[] array, int heap_size) {
        buildHeap(array);
        for (int i = heap_size - 1; i >= 0; i--) {
            int temp = array[i].getFrequency();
            array[i] = array[0];
            array[0].setFrequency(temp);
            maxHeapify(0, i, array);
        }

    }

}