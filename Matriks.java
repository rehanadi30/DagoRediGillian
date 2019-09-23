<<<<<<< HEAD
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
=======
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
>>>>>>> 2ab29896619d40b29e28a1be54f0701932776303
                        