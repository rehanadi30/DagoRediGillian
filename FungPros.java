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
    public double Determinan(Matriks M){ //ini hrus ganti yakk wkwkwk
        double koef,det;
        double temp[M.GetMatrixRow()+1][M.GetMatrixCol()+1];

        if(M.GetMatrixRow() == 2)
        {
            det =(M.GetElmtMatriks(1,1)*M.GetElmtMatriks(2,2))-(M.GetElmtMatriks(1,2)*M.GetElmtMatriks(2,1));
            return det;
        }
        else 
        {
            for (int i=1; i <= M.GetMatrixRow(); i++)
            {
                for (int j=1; j <= M.GetMatrixCol(); j++)
                {
                    temp[i][j] = M.GetElmtMatriks(i,j);
                }
            }
            for (int i=1; i <= M.GetMatrixRow(); i++)
            {
                for (int j=1; j <= M.GetMatrixCol(); j++)
                {
                    if (j > i)
                    {
                        koef = temp[j][i] / temp[i][i];
                        for (int k=0; k <= M.GetMatrixRow(); k++)
                        {
                            temp[j][k] -= koef * temp[i][k];
                        }
                    }
                }
            }
            det = 1;
            for (int i=1; i <= M.GetMatrixRow(); i++) det *= temp[i][i];

            if (det == 0) return 0;
            else return det;
        }

    }
    public double Cramer(Matriks M,int indeks){
        Matriks A=new Matriks();
        Matriks hasil=new Matriks();
        A.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol()-1);
        hasil.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol()-1);
        A = GetSquare(M);
        for (i=1;i<=M.GetMatrixRow();i++){
            M.matrix[i][indeks]=M.GetElmtMatriks(i,M.GetMatrixCol());
        }
        hasil = GetSquare(M);
        return(Determinan(hasil)/Determinan(A));
    }
    public Matriks Kofaktor(Matriks M){
        Matriks kof = new Matriks();
        kof.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        for(i=1;i<=M.GetMatrixRow();i++){
            for(j=1;j<=M.GetMatrixCol();j++){
                if(j)
            }
        }
    }
}