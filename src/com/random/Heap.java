import java.util.*;

class HeapUtil {

    public static void maxHeapify(int[] arr, int len, int index) {
        int largest;
        int left = 2*index+1; 
        int right = 2*index+2;

        if(left < len && arr[left] > arr[index] ) {
            largest = left;
        } else {
            largest = index;
        }

        if(right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != index) {
            swap(arr, largest, index);
            maxHeapify(arr, len, largest);
        }
    }

    public static void minHeapify(int[] arr,int len, int index) {
        int smallest;
        int left = 2*index+1;
        int right = 2*index+2;
        if(left < len && arr[index] > arr[left]) {
            smallest = left;
        } else {
            smallest = index;
        }

        if(right < len && arr[smallest] > arr[right]) {
            smallest = right;
        }

        if(smallest != index) {
            swap(arr, smallest, index);
            minHeapify(arr, len, smallest);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void buildMinHeap(int[] arr) {
        int len = arr.length;
        for(int i=(len/2)-1; i>=0; i--) {
            minHeapify(arr, len, i);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for(int i = (len/2)-1; i>=0; i--) {
            maxHeapify(arr, len, i);
        }
    }

    public static void printHeap(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;
        int heap_size = len;
        buildMaxHeap(arr);
        for(int i=len-1; i>=1; i--) {
            swap(arr, 0, i);
            heap_size = heap_size - 1;
            maxHeapify(arr, heap_size, 0);
        }
    }

    public static int extractMaximum(int[] arr) {
        int len = arr.length;
        if(len == 0) {
            return -1;
        }

        int maxValue = arr[0];
        swap(arr, 0, len-1);
        maxHeapify(arr,len-1,0);
        return maxValue;
    }

}

class Heap {
    public static void main(String args[]) {
        int[] arr = {4,3,7,1,8,5};
        //HeapUtil.buildMinHeap(arr);
        //HeapUtil.printHeap(arr);
        HeapUtil.buildMaxHeap(arr);
        //HeapUtil.printHeap(arr);
        //HeapUtil.heapSort(arr);
        HeapUtil.printHeap(arr);
        int maxValue = HeapUtil.extractMaximum(arr);
        System.out.println("Current maximum from Heap = " + maxValue);
    }
}