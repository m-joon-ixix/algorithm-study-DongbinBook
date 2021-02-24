public class SortingAlgorithms {
    public static void main(String[] args){
        int[] array = initializeArray();
        System.out.println("Before Sorting: ");
        printArray(array);
        System.out.println();

        selectionSort(array);
        printArray(array); // sorted result

        array = initializeArray();
        insertionSort(array);
        printArray(array); // sorted result

        array = initializeArray();
        quickSort(array, 0, array.length - 1);
        printArray(array); // sorted result

        array = initializeArray();
        countSort(array);
        printArray(array); // sorted result
    }

    static void selectionSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int minIdx = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[minIdx] > array[j]) minIdx = j;
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j - 1] <= array[j]){
                    break;
                } else {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    static void quickSort(int[] array, int start, int end){
        if(start >= end) return;

        int pivotIdx = start, largerIdx = start + 1, smallerIdx = end;

        while(true){
            while(largerIdx <= end && array[pivotIdx] >= array[largerIdx]) largerIdx++;
            while(smallerIdx > start && array[pivotIdx] <= array[smallerIdx]) smallerIdx--;

            if(largerIdx < smallerIdx){
                int temp = array[largerIdx];
                array[largerIdx] = array[smallerIdx];
                array[smallerIdx] = temp;
                largerIdx++;
                smallerIdx--;
            } else {
                int temp = array[pivotIdx];
                array[pivotIdx] = array[smallerIdx];
                array[smallerIdx] = temp;
                break;
            }
        }

        quickSort(array, start, smallerIdx - 1);
        quickSort(array, smallerIdx + 1, end);
    }

    static void countSort(int[] array){
        int min = array[0], max = array[0];
        for(int i : array){
            if(min > i) min = i;
            if(max < i) max = i;
        }

        int[] counts = new int[max - min + 1];
        // counts[i - min]: count of number i
        for(int i : array) counts[i - min]++;

        int idx = 0;
        for(int i = 0; i < counts.length; i++){
            for(int j = 0; j < counts[i]; j++){
                array[idx] = min + i;
                idx++;
            }
        }
    }

    static void printArray(int[] array){
        System.out.print("Printing Array: ");
        for(int i : array) System.out.print(i + " ");
        System.out.println();
    }

    static int[] initializeArray(){
        return new int[]{7, 3, 8, 8, 1, 0, 2, 7, 4, 4, 4, 5, 2, 6, 5};
    }
}
