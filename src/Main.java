public class Main {
    public static void main(String[] args) {
        int[] arr = {12,13,14,5,15};
        sortArray(arr);
        displayArray(arr);
        int findNumber = binarySearchIterative(arr,14);
        int findNumberRecursive = binarySearchRecursive(arr,0,arr.length-1,3);
        if(findNumber>=0)
        {
            System.out.println("14 found at position: "+(findNumber+1));
        }
        else System.out.println("Number not found");

        if(findNumberRecursive>=0)
        {
            System.out.println("14 found at position: "+(findNumberRecursive+1+" using recursion"));
        }
        else System.out.println("Number not found");
    }
    public static void swapNumbers(int[] a, int largestIndex, int largestUnsortedIndex)
    {
        int temp;
        temp = a[largestIndex];// Temp stores the largest value in the array
        a[largestIndex] = a[largestUnsortedIndex]; // saving the value at largestUnsortedIndex
        a[largestUnsortedIndex] = temp;
    }
    public static void sortArray(int[] a)
    {
        // Selection Sort: for Ascending Order, Find the largest Element from the unsorted list and swap it with the largest unsorted Index
        for(int largestUnsortedIndex = a.length-1;largestUnsortedIndex>=0;largestUnsortedIndex--)
        {
            int largestIndex = 0;
            for(int i =1; i<=largestUnsortedIndex;i++)
            {
                if(a[i]>a[largestIndex])
                    largestIndex=i;
            }
            swapNumbers(a,largestIndex,largestUnsortedIndex);
        }

    }
    public static int binarySearchIterative(int[] arr, int value)
    {
        int start=0,end=arr.length;
        while(start<end)
        {
            int midpoint =(start+end)/2;
            if(value == arr[midpoint])
            {
                return midpoint;
            }
            if(value > arr[midpoint])
            {
                // remove the previous part of the midpoint
                 start = midpoint+1;
            }
            if(value<arr[midpoint])
            {
                end=midpoint;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int firstElement, int lastElement, int key)
    {
        if(lastElement>=firstElement && firstElement<=arr.length-1)
        {
            int midIndex = firstElement +(lastElement-firstElement)/2;
            if(arr[midIndex]==key)
            {
                return midIndex;
            }
            else if (key>arr[midIndex])
            {
                // array to the right is active now
                return (binarySearchRecursive(arr,midIndex+1,lastElement,key));
            }
            else
                return (binarySearchRecursive(arr,firstElement,midIndex,key));
        }
        return -1;

    }
    public static void displayArray(int[] a)
    {
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}