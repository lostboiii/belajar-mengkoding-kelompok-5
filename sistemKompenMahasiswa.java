import java.util.Scanner;
public class sistemKompenMahasiswa {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alpa, kompensasi;
        boolean kondisi;

        System.out.print("Masukkan jumlah alpa: ");
        alpa = sc.nextInt();
        
        System.out.print("Apakah semester ini mengerjakan?(true/false): ");
        kompensasi = alpa*2;
        kondisi = sc.nextBoolean();

        if (kondisi == true ) {
           System.out.println("Jumlah kompen anda: " + alpa + " jam");
        }
        else{
           System.out.println("Jumlah kompen anda: " + kompensasi + " jam");
        }

        sc.close();
    }
}