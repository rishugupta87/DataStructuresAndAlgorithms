package binaryheap;

/**
 * Created by rg029761 on 8/16/15.
 */
public class MinHeap {

    private int[] minHeap;
    private int position;

    public MinHeap(final int size) {
        setMinHeap(new int[size + 1]); //size including 0. we fill from index 1
        setPosition(1);
    }

    public void createHeap(int[] arrA) {
        if (arrA.length > 0) {
            for (int i = 0; i < arrA.length; i++) {
                insert(arrA[i]);
            }
        }
    }

    public void display() {
        for (int i = 1; i < getMinHeap().length; i++) {
            System.out.print(" " + getMinHeap()[i]);
        }
        System.out.println("");
    }

    /**
     * O(logn) comoplexity
     * place x at the free position in the array.
     * if x < x's parent -> swap. Repeat.
     *
     * @param x which is to be inserted.
     */
    public void insert(final int x) {
        getMinHeap()[getPosition()] = x;
        bubbleUp();
        setPosition(getPosition() + 1);
    }

    public int[] getMinHeap() {
        return minHeap;
    }

    public int removeMin() {
        int min = minHeap[1]; // this has the minimum element
        minHeap[1] = minHeap[position - 1]; //replace last element with first
        //make last element as 0
        minHeap[position - 1] = Integer.MAX_VALUE;

        bubbleDown(); //call to fix heap property if applicable
        return min;
    }

    public void bubbleDown() {
        int pos = 1;
        while((position > 2 * pos && minHeap[pos] > minHeap[2*pos]) || (position > 2 * pos+ 1 && minHeap[pos] > minHeap[2*pos + 1])) {
            int min = 0;
            if(minHeap[2* pos] < minHeap[2* pos + 1]) {
                min = 2* pos;
                swap(pos, min);
            } else {
                min = 2* pos + 1;
                swap(pos, min);
            }
            pos = min;
        }
        return;
    }

    public void bubbleUp() {
        int pos = getPosition();
        while(getMinHeap()[pos] < getMinHeap()[pos/2]) {
            swap(pos, pos/2);
            pos = pos/2; //update position for the next swap.
        }
        return;
    }

    private void swap(final int x, final int y) {
        int temp = getMinHeap()[x];
        getMinHeap()[x] = getMinHeap()[y];
        getMinHeap()[y] = temp;
    }

    public void setMinHeap(int[] minHeap) {
        this.minHeap = minHeap;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
