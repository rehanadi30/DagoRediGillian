import java.util.Scanner;

public class Interpolasi
{
    public double duarX[];
    public double duarY[];
    public double titikInterpolasi;
    public double hasilInterpolasi;
    public void interpolasi()
    {
        titikInterpolasi = 0; //ini bakal jadi semacam x
        hasilInterpolasi = 0; //yang ini nanti jadi  y
    }
    public void bacaTitik()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan titik yang ingin kamu interpolasi: ");
        double titikInterpolasi = sc.nextDouble();
    }
    public void duarTitik(int n) //ini tarray titik yang DUARRRR
    {
        duarX = new double[n];
        duarY = new double[n];
    }
    public void isiTitik(double X, double Y, int i)
    {
        duarX[i] = X;
        duarY[i] = Y;
    }
    public void tulisIsiInterpolasi()
    {
        //nunggu prosesInterpolasiDuar
    }
    public void prosesInterpolasiDuar(double isiX[][], double isiY, boolean GaussJordan)
    {
        //nunggu GaussJordan
    }
    public static double pow(double x, int p) // x pangkat n
    {
        double hasil;
		hasil = x;
		if(p == 0)
		{
			return 1.0;
		}
		else if(p == 1)
		{
			return x;
		} 
		else
		{
			for(int i = 1;i<p;i++)
			{
				hasil = hasil*hasil;
			}
		}
		
		return hasil;
    }
}