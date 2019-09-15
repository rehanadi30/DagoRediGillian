// Nama Pembuat: Rehan Adi Satrya
// NIM Pembuat : 13518061
// Tanggal SubProgram dibuat : Minggu, 15 September 2019
// Nama File : DagoRediGill.java
// Program mainnya

package com.ms.matrix;
import java.util.Scanner;

public class DagoRediGill {
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Masukkan jumlah persamaan");
         
        int matrixRow = scan.nextInt();
         
        System.out.println("Masukkan jumlah peubah");
         
        int matrixCol = scan.nextInt();

        //defining 2D array to hold matrix data
        int[][] matrix = new int[matrixRow][matrixCol];

        //Main Menu
        System.out.println(" ");
        System.out.println("SELAMAT DATANG DI PROGRAM MATRIKS DAGOREDIGILL");
        System.out.println("Berikut layanan yang kami sediakan untuk anda");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("MAIN MENU:");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");
        System.out.println("");
        System.out.println("");
        System.out.println("Masukkan menu yang ingin kalian akses:");

        int b = scan.nextInt();
        if (b == 1)
            {
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode Matriks Balikan");
                System.out.println("4. Kaidah Cramer");
                bacaMatriks(scan, matrix, matrixRow, matrixCol);
                
            }
        else if (b == 2)
            {
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode Matriks Balikan");
                System.out.println("4. Kaidah Cramer");
            }
        else if (b == 3)
        {
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode Matriks Balikan");
                System.out.println("4. Kaidah Cramer");
        }
  }
  public static void bacaMatriks(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
      
     System.out.println("Masukkan elemen matriks");
         
          for (int i = 0; i < (matrixRow); i++)
          {
              for (int j = 0; j < (matrixCol); j++)
              {
                  matrix[i][j] = scan.nextInt();
              }
          }
  }
  
  public static void printMatriks(int[][] matrix, int matrixRow, int matrixCol){
    System.out.println("Matriks yang kamu inginkan adalah : ");
        
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
             
            System.out.println();
        }
  }
}
                        