package mang_trong_java.baitap;


import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử màng 1:");
        int size1 = scanner.nextInt();
        System.out.print("Nhập số lượng phần tử mảng 2:");
        int size2 = scanner.nextInt();

        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        int[] array3 = new int[size1 + size2];
        System.out.println("Nhập mảng 1");
        for (int i = 0; i < size1; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ":");
            array1[i] = scanner.nextInt();
        }
        System.out.println("Nhập mảng 2");
        for (int i = 0; i < size2; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ":");
            array2[i] = scanner.nextInt();
        }
        for(int i = 0; i<size1; i++){
            array3[i] = array1[i];
        }
        int count = 0;
        for (int i = size1; i < size1+size2; i++){
            array3[i] = array2[count++];
        }
//        System.arraycopy(array1, 0, array3, 0, size1);
//        System.arraycopy(array2, 0, array3, size1, size2);
        System.out.println("Mảng sau khi gộp");

        for (int i = 0; i < (size1+size2); i++){
            System.out.print(array3[i]+" ");
        }

    }
}
