// Nama Pembuat: Rehan Adi Satrya
// NIM Pembuat : 13518061
// Tanggal SubProgram dibuat : Minggu, 15 September 2019
// Nama File : DagoRediGill.java
// Program mainnya

package com.ms.matrix;
import java.util.Scanner;

public class Matriks {
    int matrixRow;
    int matrixCol;
    float matrix[][];
    Scanner scan = new Scanner(System.in);

    public static void bacaMatriks(Scanner scan, int matrix[][], int matrixRow, int matrixCol){
    
        System.out.println("Masukkan elemen matriks");
         
            for (int i = 0; i < (matrixRow); i++)
            {
                for (int j = 0; j < (matrixCol); j++)
                {
                    matrix[i][j] = scan.nextInt();
                }
            }
    }
  
    public static void printMatriks(int matrix[][], int matrixRow, int matrixCol){
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
    public int GetMatrixCol(){
        return this.matrixCol;
    }

    public int GetMatrixRow(){
        return this.matrixRow;
    }

    public float GetElmtDiagonal (int i){
        return this.matrix[i][i];
    }

    public boolean isSquare (){
        return (GetMatrixCol()==GetMatrixRow());
    }

    public Matriks GetSquare(){
        Matriks MSquare;
        MSquare.matrixRow=this.matrixRow;
        MSquare.matrixCol=this.matrixCol-1;
        for(int i=0;i<GetMatrixRow();i++){
            for(int j=0;j<GetMatrixCol()-1;j++){
                MSquare.matrix[i][j]=this.matrix[i][j];
            }
        }
        return(MSquare);
    }
    public void Transpose(){
        float Temp;
        MTrans.matrixRow = this.matrixRow;
        MTrans.matrixCol = this.matrixCol;
        for(int i=0;i<GetMatrixRow();i++){
            for(int j=0;j<=i;j++){
                Temp=this.matrix[i][j];
                this.matrix[i][j]=this.matrix[j][i];
                this.matrix[j][i]=Temp;
            }
        }
    }
}
                        