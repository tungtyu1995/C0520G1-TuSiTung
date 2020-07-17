package thuat_toan_tim_kiem.thuchanh;

import java.util.Scanner;

public class BinarySearchNontRecursive {
    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else if (key > mid){
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap vao so can tim kiem: ");
        int number = scanner.nextInt();
        int result = binarySearch(list,number);
        if (result == -1){
            System.out.println("khong tim thay");
        }
        else {
            System.out.println(number+ " nam o vi tri thu: " + (result+1));
        }
    }
}
