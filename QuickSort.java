public class QuickSort{

    static void quickSort(int a[], int start, int end) {
        int partition = partition(a, start, end);
        if (partition - 1 > start)
            quickSort(a, start, partition - 1);
        if (partition + 1 < end)
            quickSort(a, partition + 1, end);
    }
    static int partition(int a[], int start, int end) {
        // choose pivot
        int pivot = a[end];
        // loop through the array
        for (int i = start; i < end; i++) {
            // check for elements that are less than pivot
            // swap accordingly
            if (a[i] < pivot) {
                swap(a, start, i);
                start++;
            }
        }
        swap(a, start, end);
        return start;
    }
    static void swap(int a[], int index1, int index2) {
        String tmp = Task33.data1[index1];
        Task33.data1[index1] = Task33.data1[index2];
        Task33.data1[index2] = tmp;
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }



    static void quickSort1(float a[], int start, int end) {
        int partition = partition1(a, start, end);
        if (partition - 1 > start)
            quickSort1(a, start, partition - 1);
        if (partition + 1 < end)
            quickSort1(a, partition + 1, end);
    }
    static int partition1(float a[], int start, int end) {
        // choose pivot
        float pivot = a[end];
        // loop through the array
        for (int i = start; i < end; i++) {
            // check for elements that are less than pivot
            // swap accordingly
            if (a[i] > pivot) {
                swap1(a, start, i);
                start++;
            }
        }
        swap1(a, start, end);
        return start;
    }
    static void swap1(float a[], int index1, int index2) {
        String tmp = Task33.data1[index1];
        Task33.data1[index1] = Task33.data1[index2];
        Task33.data1[index2] = tmp;
        float temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}