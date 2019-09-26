import java.lang.Math; //buat pangkat di determinan

public class FungPros{
    Scanner scan = new Scanner(System.in);

    public void bacaMatriks(Scanner scan, int matrix[][], int matrixRowCol){
        Matriks M = new Matriks();
        M.MakeMatriks(matrixRowCol,matrixRowCol);
        System.out.println("Masukkan elemen matriks");
         
            for (int i = 1; i <= (matrixRowCol); i++)
            {
                for (int j = 1; j <= (matrixRowCol); j++)
                {
                    M.matrix[i][j] = scan.nextInt();
                }
            }
    }
  
    public void printMatriks(Matriks M, int matrixRow, int matrixCol){
        System.out.println("Matriks yang kamu inginkan adalah : ");
            
            for (int i = 1; i <= matrixRow; i++)
            {
                for (int j = 1; j <= matrixCol; j++)
                {
                    System.out.print(M.matrix[i][j]+"\t");
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
    public void BacaSPL (int jmlPers, int jmlVar){
        Matriks SPL = new Matriks();
        SPL.MakeMatriks(jmlPers,(jmlVar+1));
        System.out.println("Masukkan SPL: \n");
        for (int i = 1; i<=jmlPers; i++)
        {
            for (int j =1; j<=(jmlVar+1);j++)
                {
                    SPL.matrix[i][j] = scan.nextInt();
                }
        }
    }

    double determinanCram(Matriks M) //Metode Cramer
    {
        Matriks MP = new Matriks;
        MP.MakeMatriks(matrixRowCol,matrixRowCol);
        double hasil;
        int i, j, currentKol,currentBrs, BrsLevel, KolLevel, chosenCol;
        boolean berubah;
        hasil = 0;
        BrsLevel = GetMatrixRow(M);
        KolLevel = GetMatrixCol(M);
        if (MP.GetMatrixRow() == 2) 
        {
            hasil = (M.GetElmtMatriks(1,1) * M.GetElmtMatriks(2,2) - M.GetElmtMatriks(1,2) * M.GetElmtMatriks(2,1));
            return hasil; 
        }
        else {
            BrsLevel -= 1;
            KolLevel -= 1;
            chosenCol = 1;
            for (currentKol = 1; currentKol <= GetMatrixCol(M); currentKol++) {
                MakeMATRIKS(BrsLevel, KolLevel, &MP);
                for (i = 2; i <= MP.GetMatrixRow(); i++) 
                {
                    berubah = false;
                    for (j = 1; j <= GetMatrixCol(M); j++) 
                    {
                        if (berubah)
                        {
                            MP.GetElmtMatriks(i-1,j-1) = M.GetElmtMatriks(i,j);
                        }

                        else if (j == currentKol) 
                         {
                            berubah = true;
                        }
                        else 
                        {
                            M.GetElmtMatriks(i-1,j) = M.GetElmtMatriks(i,j);
                        }
                    
                }
            } 
                         
            hasil += (M.GetElmtMatriks(1,chosenCol) * determinanCram(MP)) * pow(-1,1+chosenCol);
            chosenCol += 1;
        }
        return hasil;
    }
    public interpolasi()
    {
        double titikInterpolasi = 0; //ini bakal jadi semacam x
        double hasilInterpolasi = 0; //yang ini nanti jadi  y
    }
    public void bacaTitik()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan titik yang ingin kamu interpolasi: ")
        titikInterpolasi = sc.nextDouble();
    }
    public void duarTitik(int n) //ini tarray titik yang DUARRRR
    {
        double duarX = new double[n];
        double duarY = new double[n];
    }
    public void isiTitik(double X, double Y, int i)
    {
        duarX[i] = X;
        duarY[i] = Y;
    }
    public void tulisIsiInterpolasi
    {
        //nunggu prosesInterpolasiDuar
    }
    public void prosesInterpolasiDuar(double isiX, double isiY, boolean GJ)
    {
        //nunggu GaussJordan
    }
      
    public void Gauss(Matriks M){
	for(int i=1;i<=M.GetMatrixRow();i++){
		for(int j=i+1;j<=M.GetMatrixCol();j++){
			double koef;
			koef = M.GetElmtMatriks(j,i)/M.GetElmtMatriks(i,i);
			for(int k=i;k<=M.GetMatrixCol();k++){
				if (k==i){
					// 0-in kolom dibawahnya
					M.matrix[j][k]=0;
				}
				else{
					//kaliin koefisien
					M.matrix[j][k]=M.matrix[j][k]-(koef*(M.matriks[i][k]));
				}
			}
		}
	}	
    }
    public void GaussJordan(Matriks M){
	this.Gauss(M);
	for(int i=M.GetMatrixRow();i>=1;i--){
	     for(int j=iM.GetMatrixCol()+1;j>=1;j--){
			double koef;
			koef = M.GetElmtMatriks(j,i)/M.GetElmtMatriks(i,i);
			for(int k=M.GetMatrixCol();k>=1;k--){
				if (k==i){
					// 0-in kolom diatasnya
					M.matrix[j][k]=0;
				}
				else{
					//kaliin koefisien
					M.matrix[j][k]=M.matrix[j][k]-(koef*(M.matriks[i][k]));
				}
			}
		}
	}
        for(int l=1;l<=M.GetMatrixRow();l++){
             for(int m=1;m<=M.GetMatrixCol();m++){
	          M.Matrix[l][m]=(M.Matrix[l][m])/GetElmtDiagonal(l);
             } 
        } 
    }
    public double DeterminanGauss(Matriks M){
	double detgauss=1;
	for (int i=1;i<=M.GetMatrixRow();i++){
		detgauss = detgauss * GetElmtDiagonal(i);
	}
	return detgauss;
    }
}
