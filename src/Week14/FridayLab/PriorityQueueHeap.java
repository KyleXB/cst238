package Week14.FridayLab;

public class PriorityQueueHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueueHeap(int[] data){
        capacity = data.length  * 3 + 1;
        heap = new int[capacity];
        size = 1;
        for(int i = 0; i < data.length; i++){
            insert(data[i]);
        }
    }

    public int[] heapSort(){
        int [] sortedData = new int[size - 1];
        int itemCount = size - 1;
        //Your code to generate the sorted data from heap and store into the sortedData array
        //Unfinished
        return sortedData;
    }

    public int getSize(){
        return size - 1;
    }

    //Update logic of the following three methods using the formula from the heap slides
    private int getParentIndex(int i){
        return i/2;
    }

    private int getLeftChildIndex(int i){
        return (2*i);
    }

    private int getRightChildIndex(int i){
        return (2*i)+1;
    }

    private boolean hasParent(int i){
        return getParentIndex(i) > 0;
    }

    private boolean hasLeftChild(int i){
        return getLeftChildIndex(i) < size;
    }

    private boolean hasRightChild(int i){
        return getRightChildIndex(i) < size;
    }

    private int parent(int i){
        return heap[getParentIndex(i)];
    }

    private int leftChild(int i){
        return heap[getLeftChildIndex(i)];
    }

    private int rightChild(int i){
        return heap[getRightChildIndex(i)];
    }

    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(int value){
        if(size == capacity){
            System.out.println("Heap full, cannot insert.");
        } else{
            heap[size++] = value;
            heapifyUp();
        }
    }

    //Implement the following method
    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) > heap[index]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public Integer removeMin(){
        if (size == 1){
            System.out.println("Heap Empty, Cannot Remove");
            return null;
        } else{
            int min = heap[1]; //minheap should have the smallest value at top
            //Add your code here to update the heap and call heapifyDown
            heap[1] = heap[size-1]; //To remove min, replace the "smallest" value with the last value
            size--; //update size
            heapifyDown(); //put current root to its correct position
            return (Integer) min;
        }
    }

    //Implement the following method
    public void heapifyDown(){
        int index = 1;
        while(hasLeftChild(index)) {
            //Add your code here to find the smaller child index
            int smallerChildIndex = leftChild(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = rightChild(index);
            } //Smaller child found

            //Add your code here to break if parent is smaller, otherwise swap and update the index
            if (heap[getParentIndex(index)] < heap[leftChild(index)] && heap[getParentIndex(index)] < heap[rightChild(index)]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < size; i++){
            sb.append(heap[i] + " ");
        }
        return sb.toString();
    }
}
