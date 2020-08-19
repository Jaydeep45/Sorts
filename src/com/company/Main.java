package com.company;
/*
 By: Jaydeep Ravat
 Sorts:Bubble Sort,Insertion Sort,Selection Sort, Heap Sort, Shell Sort, Merge Sort and Quick Sort
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int ch, n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        do {
            System.out.println("1:Bubble Sort");
            System.out.println("2:Selection Sort");
            System.out.println("3:Insertion Sort");
            System.out.println("4:Heap Sort");
            System.out.println("5:Shell Sort");
            System.out.println("6: Merge Sort");
            System.out.println("7: Quick Sort");
            System.out.println("8: Print Sorted Array");
            System.out.println("9: Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    BubbleSort(a, n);
                    break;
                case 2:
                    SelectionSort(a, n);
                    break;
                case 3:
                    InsertionSort(a, n);
                    break;
                case 4:
                    HeapSort(a, n);
                    break;
                case 5:
                    ShellSort(a,n);
                    break;
                case 6:
                    MergeSort(a,0,n-1);
                    break;
                case 7:
                    QuickSort(a,0,n-1);
                    break;
                case 8:
                    print_array(a);
                    break;

            }
        } while (ch < 9);
    }

    public static void BubbleSort(int[] A, int x){
        for(int i=0;i<x;i++){
            for(int j = i+1;j<x;j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }
    public static void SelectionSort(int[] A, int x){
        for (int i=0;i<x;i++){
            int mj = i;
            int mx = A[i];
            for (int j =i+1;j<x;j++){
                if (A[j] < mx) {
                    mj = j;
                    mx = A[j];
                }
            }
            A[mj] = A[i];
            A[i] = mx;
        }
    }
    public static void InsertionSort(int[] A, int x){
            for(int i = 1;i<x;i++){
                int s = A[i];
                int j = i - 1;
                while(j >= 0 && A[j] > s){
                    A[j+1] = A[j];
                    j--;
                }
                A[j+1] = s;
            }
    }
    public static void HeapSort(int[] A, int x){
        for(int i = x/2 - 1;i>=0;i--){
            Heapify(A,x,i);
        }
        for(int i=x-1;i>0;i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            Heapify(A,i,0);
        }
    }
    public static void Heapify(int[] A, int x, int j){
        int largest = j;
        int l = j*2 + 1;
        int r = j*2 + 2;
        if (l < x && A[l] > A[largest])
            largest = 1;
        if (r < x && A[r] >A[largest])
            largest = r;
        if (largest != j){
            int swap = A[j];
            A[j] = A[largest];
            A[largest] = swap;
            Heapify(A,x,largest);
        }
    }
    private static void ShellSort(int[] A, int x) {
        for(int gap = x / 2;gap >0;gap /= 2){
            for(int i = gap;i<x;i++){
                int temp = A[i];
                int j =i;
                while(j >= gap && A[j-gap] > temp){
                    A[j] = A[j-gap];
                    j = j - gap;
                }
                A[j] = temp;
            }
        }
    }
    public static void MergeSort(int[] a,int l,int r) {
        if(l<r){
            int m = (l+r)/2;
            MergeSort(a,l,m);
            MergeSort(a,m+1,r);

            merge(a,l,m,r);
        }
    }
    public static void merge(int[] a,int l,int m,int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
    public static void QuickSort(int[] arr,int low, int high){
        if (low < high)
        {
            int pi = partition(arr, low, high);

            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }
    public static int  partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void print_array(int[] a){
        for (int j : a)
            System.out.println(j);
    }

}
