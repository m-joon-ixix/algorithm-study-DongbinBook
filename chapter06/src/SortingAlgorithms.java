public class SortingAlgorithms {
    public static void main(String[] args){
        int[] numbers1 = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        selectionSort(numbers1);
        int[] numbers2 = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        insertionSort(numbers2);
        int[] numbers3 = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        System.out.print("Result of Quick Sort: ");
        printArray(quickSort(numbers3));
        int[] numbers4 = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        countSort(numbers4);
    }

    static void printArray(int[] array){
        for(int i : array) System.out.print(i + " ");
        System.out.println();
    }

    // each sort method sorts the given array, and prints the sorted result
    static void selectionSort(int[] array){
        int minIdx, temp;
        for(int i = 0; i < array.length - 1; i++){
            // put the smallest element of (array[i] ~ endOfArray) into array[i]
            minIdx = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[minIdx] > array[j]) minIdx = j;
            }
            temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }

        System.out.print("Result of Selection Sort: ");
        printArray(array);
    }

    static void insertionSort(int[] array){
        int currentIdx, temp;
        for(int i = 1; i < array.length; i++){
            // insert array[i] into proper location, sending it leftward step by step
            currentIdx = i;
            while(currentIdx > 0 && array[currentIdx - 1] > array[currentIdx]){
                temp = array[currentIdx];
                array[currentIdx] = array[currentIdx - 1];
                array[currentIdx - 1] = temp;
                currentIdx--;
            }
        }

        System.out.print("Result of Insertion Sort: ");
        printArray(array);
    }

    static int[] quickSort(int[] array){
        if(array.length <= 1) return array;

        int pivotIdx = 0, leftIdx = 1, rightIdx = array.length - 1, temp;
        while(true){
            while(leftIdx < array.length && array[pivotIdx] >= array[leftIdx]) leftIdx++;
            while(rightIdx > 0 && array[pivotIdx] <= array[rightIdx]) rightIdx--;
            if(leftIdx < rightIdx){
                temp = array[leftIdx];
                array[leftIdx] = array[rightIdx];
                array[rightIdx] = temp;
            } else {
                break;
            }
        }

        temp = array[rightIdx];
        array[rightIdx] = array[pivotIdx];
        array[pivotIdx] = temp;

        pivotIdx = rightIdx; // pivotIdx changed to proper position

        int[] frontArray = new int[pivotIdx];
        int[] backArray = new int[array.length - pivotIdx - 1];
        for(int i = 0; i < pivotIdx; i++){
            frontArray[i] = array[i];
        }
        for(int i = pivotIdx + 1; i < array.length; i++){
            backArray[i - pivotIdx - 1] = array[i];
        }
        frontArray = quickSort(frontArray);
        backArray = quickSort(backArray);

        int[] resultArray = new int[array.length];
        for(int i = 0; i < frontArray.length; i++){
            resultArray[i] = frontArray[i];
        }
        resultArray[pivotIdx] = array[pivotIdx];
        for(int i = 0; i < backArray.length; i++){
            resultArray[pivotIdx + 1 + i] = backArray[i];
        }

        return resultArray;
    }

    // used in restricted situations: range of elements is restricted (diff of max & min < 1M)
    static void countSort(int[] array){
        int max = array[0], min = array[0];
        for(int i : array){
            if(max < i) max = i;
            if(min > i) min = i;
        }
        // actual number = idxOfArray + min
        int[] count = new int[max - min + 1];
        for(int number : array){
            count[number - min]++;
        }

        int currentIdx = 0;
        for(int i = 0; i < count.length; i++){
            for(int j = 0; j < count[i]; j++){
                array[currentIdx] = i + min;
                currentIdx++;
            }
        }

        System.out.print("Result of Count Sort: ");
        printArray(array);
    }
}
