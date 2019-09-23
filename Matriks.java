package com.ms.matrix;
import java.util.Scanner;

public class Matriks {
    int matrixRow;
    int matrixCol;
    double[][] matrix;

    public void MakeMatriks(int row,int col){
        this.matrixRow=row;
        this.matrixCol=col;
        this.matrix=new float[row+1][col+1];
    }
    public int GetMatrixCol(){
        return this.matrixCol;
    }

    public int GetMatrixRow(){
        return this.matrixRow;
    }

    public double GetElmtDiagonal (int i){
        return this.matrix[i][i];
    }
    public double GetElmtMatriks(int i,int j){
        return this.matrix[i][j];
    }
    
}
                        