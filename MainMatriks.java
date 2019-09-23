
public class MainMatriks{
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Masukkan jumlah persamaan");
         
        int matrixRow = scan.nextInt();
         
        System.out.println("Masukkan jumlah peubah");
         
        int matrixCol = scan.nextInt();

        //defining 2D array to hold matrix data
        float[][] matrix = new float[matrixRow][matrixCol];

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
}