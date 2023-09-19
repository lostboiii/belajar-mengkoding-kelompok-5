import java.util.Scanner;
public class kompen {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alpa, kompensasi;
        boolean kondisi;

        System.out.print("masukkan jumlah alpa : ");
        alpa = sc.nextInt();
        
        System.out.println("apakah mengerjakan semester ini?");
        kompensasi = alpa*2;
        kondisi = sc.nextBoolean();

        if (kondisi == true ) {
           System.out.println("jumlah kompen anda :" + alpa + " jam");
        }
        else{
           System.out.println("jumlah kompen anda :" + kompensasi + " jam");
        }

        sc.close();
    }
}

