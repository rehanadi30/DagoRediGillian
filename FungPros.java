public class FungPros{
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

    public boolean isSquare (Matriks M){
        return (M.GetMatrixCol()==M.GetMatrixRow());
    }


    public Matriks GetSquare(Matriks M){
        Matriks MSquare=new Matriks();
        MSquare.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol()-1);
        for(int i=1;i<=M.GetMatrixRow();i++){
            for(int j=1;j<=M.GetMatrixCol()-1;j++){
                MSquare.matrix[i][j]=M.GetElmtMatriks(i,j);
            }
        }
        return(MSquare);
    }
    public void Transpose(Matriks M){
        double Temp;
        for(int i=1;i<=M.GetMatrixRow();i++){
            for(int j=1;j<=i;j++){
                Temp=M.GetElmtMatriks(i,j);
                M.matrix[i][j]=M.GetElmtMatriks(j,i);
                M.matrix[j][i]=Temp;
            }
        }
    }
    public double Determinan(Matriks M){
        double koef,det;
        double temp[M.GetMatrixRow()+1][M.GetMatrixCol()+1]; // Matriks sementara yang berelemen real

        /* ALGORITMA */
        if(M.GetMatrixRow() == 2)
        {
            det =(M.GetElmtMatriks(1,1)*M.GetElmtMatriks(2,2))-(this.matrix[0][1]*this.matrix[1][0]);
            return det;
        }
        else // lebih dari matriks 2 x 2
        {
            //Mengisi matriks temp bertipe real
            for (int i=1; i <= GetMatrixRow(); i++)
            {
                for (int j=1; j <= GetMatrixCol(); j++)
                {
                    temp[i][j] = this.matrix[i][j];
                }
            }

            // Membentuk matriks segitiga atas
            for (int i=1; i <= GetMatrixRow(); i++)
            {
                for (int j=1; j <= GetMatrixCol(); j++)
                {
                    if (j > i)
                    {
                        koef = temp[j][i] / temp[i][i];
                        for (int k=0; k <= GetMatrixRow(); k++)
                        {
                            temp[j][k] -= koef * temp[i][k];
                        }
                    }
                }
            }
            // Determinan didapatkan dari perkalian diagonalnya
            det = 1;
            for (int i=1; i <= GetMatrixRow(); i++) det *= temp[i][i];

            if (det == 0) return 0;
            else return det;
        }

    }
    public double Cramer(int indeks){
        Matriks A;
        Matriks square;
        
        for (i=1;i<=GetMatrixRow();i++){
            this.matrix[i][indeks]=this.matrix[i][GetMatrixCol()];
        }
        
    }
}