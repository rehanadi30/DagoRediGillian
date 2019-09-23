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
        A = this.GetSquare(M);
        for (int i=1;i<=M.GetMatrixRow();i++){
            M.matrix[i][indeks]=M.GetElmtMatriks(i,M.GetMatrixCol());
        }
        hasil = this.GetSquare(M);
        return(this.Determinan(hasil)/this.Determinan(A));
    }
    public Matriks GetSubMatriks(Matriks M,int row,int col){
        int a=1;
        int b=1;
        Matriks sub = new Matriks();
        sub.MakeMatriks(M.GetMatrixRow()-1,M.GetMatrixCol()-1);
        for(int i=1;i<=M.GetMatrixRow();i++){
            if (i!=row){
                for(int j=1;j<=M.GetMatrixCol();j++){
                    if (j!=col){
                        sub.matrix[a][b]=M.GetElmtMatriks(i,j);
                        b++;
                    }
                }
                a++;
                b=1;
            }
        }
        return (sub);
    } 
    public Matriks Kofaktor(Matriks M){
        Matriks kof = new Matriks();
        Matriks subs= new Matriks();
        subs.MakeMatriks(M.GetMatrixRow()-1,M.GetMatrixCol()-1)
        kof.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        for(int i=1;i<=M.GetMatrixRow();i++){
            for(int j=1;j<=M.GetMatrixCol();j++){
                subs = GetSubMatriks(M,i,j);
                if((i+j)%2==0){
                    kof.matrix[i][j]=this.Determinan(subs);
                }else{
                    kof.matrix[i][j]=(-1)*(this.Determinan(subs));
                }
            }
        }
        return(kof);
    }
    public Matriks Adjoin(Matriks M){
        Matriks koft = new Matriks();
        koft.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        koft = this.Kofaktor(M);
        return(this.Transpose(koft));
    }
    public Matriks KaliKons(Matriks M,float X){
        Matriks MHasil = new Matriks();
        MHasil.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        for(int i=1;i<=M.GetMatrixRow();i++){
            for(int j=1;j<M.GetMatrixCol();j++){
                MHasil.matrix[i][j]=X*M.GetElmtMatriks(i,j);
            }
        }
        return(MHasil);
    }
    public Matriks InversKofaktor(Matriks M){
        Matriks adj = new Matriks();
        adj.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        adj = this.Adjoin(M);
        float x = 1/(this.determinan(M));
        return(this.KaliKons(adj,x));

    }
    public double DetBalikan (Matriks M){
        Matriks inv = new Matriks ();
        inv.MakeMatriks(M.GetMatrixRow(),M.GetMatrixCol());
        inv=this.InversKofaktor(M);
        return(1/this.Determinan(inv));
    }
    
}