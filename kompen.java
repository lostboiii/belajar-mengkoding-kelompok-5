import java.util.Scanner;

public class kompen{
    static Scanner sc = new Scanner(System.in);

    static String nim;
    static String password;
    static String nama,kelas;
    static double poin_akhir = 0;
    static int  kerja = 0;
    static double[] totalKompenMhs;
    static String kompenMhs[][] = new String[20][10];
    static int semester = 1;


    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
     public static void admin(){
        boolean hitungKompen = true;
        do {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║          Selamat Datang Admin              ║");
        System.out.println("║        Silahkan pilih menu dibawah ini:    ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("");
        System.out.println("1. List Kompen Pada Kelas ");
        System.out.println("2. Perhitungan Kompen ");
        System.out.println("3. Input Mahasiswa");
        System.out.println("4. Pembayaran Kompen");
        System.out.println("5. Pergantian Semester Baru");
        System.out.println("6. Cari Kelas");
        System.out.println("7. Logout");
        System.out.println("0. Keluar Program Sistem Kompen");
        System.out.println("");
        System.out.println("Masukkan Menu Yang Ingin Dituju : ");
        int menu = sc.nextInt();
        
        
         switch (menu) {
            case 0:
            hitungKompen = false;
            System.out.println("Terima kasih. Program Sistem Kompen keluar.");
            break;
            case 1:
            viewKompen();
            break;
            case 2:
            TambahKompen();
            break;
            case 3:
            tambahNama();
            break;
            case 4:
            bayarKompen();
            break;
            case 5:
            tambahSemester();
            break;
            case 6:
            cariKelas();
            break;
            case 7:
            logout();
            break;
            default:
            hitungKompen = false;
            System.out.println("Pilihan Tidak Valid");
            break;
    }
     } while (hitungKompen);
        }
         public static void user(){
        boolean hitungKompen = true;
        do{
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║          Selamat Datang User               ║");
        System.out.println("║        Silahkan pilih menu dibawah ini:    ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("");
        System.out.println("1. List Kompen Pada Kelas ");
        System.out.println("0. Keluar Program Sistem Kompen");
        System.out.println("");
        System.out.println("Masukkan Menu Yang Ingin Dituju : ");
        int menu = sc.nextInt();
    
          switch (menu) {
            case 0:
            hitungKompen = false;
            System.out.println("Terima kasih. Program Sistem Kompen keluar.");
            break;
            case 1:
            viewKompen();
            break;
            default:
            break;
          }
           } while (hitungKompen);
        }
        static void tambahSemester() {
            semester++;
        
            for (int i = 0; i < kompenMhs.length; i++) {
                if (kompenMhs[i][0] != null && isNumeric(kompenMhs[i][semester - 1])) {
                    kompenMhs[i][semester] = Integer.toString(Integer.parseInt(kompenMhs[i][semester - 1]) * 2);
                    kompenMhs[i][semester - 1] = "0";
                    System.out.println("Sukses");
                    System.out.println("Sekarang Adalah Semester :"+semester);
                }
            }
        }
        static boolean isNumeric(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        static void simpanNamaBaru(String nama, String kelas) {
            int indeksKosong = -1;
            for (int i = 0; i < kompenMhs.length; i++) {
                if (kompenMhs[i][0] == null) {
                    indeksKosong = i;

                    break;
                }
            }
            if (indeksKosong != -1) {
                kompenMhs[indeksKosong][0] = nama;
                kompenMhs[indeksKosong][9] = kelas;
                System.out.println("Nama berhasil disimpan di indeks " + indeksKosong);
                for (int i = 1; i < kompenMhs[indeksKosong].length; i++) {
                    kompenMhs[indeksKosong][i] = "0";
                     kompenMhs[indeksKosong][9] = kelas;
                }
            } else {
                System.out.println("error,array penuh.");
            }
        }
    
        static void tambahNama(){
            sc.nextLine();
            System.out.println("Masukkan Nama :");
            String namaBaru = sc.nextLine();
            System.out.println("Masukkan Kelas :");
            String kelasBaru = sc.nextLine();
            simpanNamaBaru(namaBaru,kelasBaru);
        }
        static void viewKompen() {
        System.out.println("===========================================================================================================================================================");
            for (int i = 0; i < kompenMhs.length; i++) {
                if (kompenMhs[i][0] != null) {
                    for (int j = 0; j < kompenMhs[i].length; j++) {
                        System.out.print(kompenMhs[i][j] + "\t|\t");
                    }
                    System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        System.out.println("===========================================================================================================================================================");
        }
    static void bayarKompen(){
        int jamKompen,bayar,id;
        do {
        viewKompen();
        System.out.println("Masukkan id Yang Ingin Membayar Kompen :");
        id = sc.nextInt();
        System.out.println("Masukkan Jumlah Jam Yan Ingin Dibayar :");
        bayar = sc.nextInt();
        System.out.println("Jam Kompen Tidak Boleh Lebih Dari Jam Alpa!");
        jamKompen = Integer.parseInt(kompenMhs[id][semester]);
        } while (bayar>jamKompen);

        kompenMhs[id][semester] = Integer.toString(Integer.parseInt(kompenMhs[id][semester]) - bayar);    

        System.out.println("Jam Kompen Sukses Dibayar");
    }
    static void cariKelas() {
        sc.nextLine();
        boolean found = false;
        System.out.println("Masukkan Kelas Yang Ingin Dicari : ");
        String cari = sc.nextLine();

        System.out.println("===========================================================================================================================================================");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "Nama", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "Kelas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < kompenMhs.length; i++) {
            if (kompenMhs[i][0] != null && cari.equalsIgnoreCase(kompenMhs[i][9])) {
                found = true;
                System.out.printf("%-10s|", kompenMhs[i][0]);
                for (int j = 1; j < kompenMhs[i].length; j++) {
                    System.out.printf("%-15s|", kompenMhs[i][j]);
                }
                System.out.println();
                found = true;
            }
        }

        System.out.println("===========================================================================================================================================================");
    
        if (!found) {
            System.out.println("Data tidak ditemukan untuk kelas " + cari);
        }
    }
    
    
     static void TambahKompen(){
        viewKompen();
        System.out.println("Masukkan id Yang Ingin Ditambah Jam Kompen :");
        int id = sc.nextInt();
        System.out.println("Masukkan Jumlah Jam Alpa :");
        int alpa = sc.nextInt();
        kompenMhs[id][semester] = Integer.toString(Integer.parseInt(kompenMhs[id][semester]) + alpa);

        System.out.println("success");
    }
    static void logout(){
        clear();
        login();
    }
    static void login(){
        String[] loginAdmin ={
                "admin","passadmin","123","123"
            };
            String[] loginUser = {
                "321", "1"
            };
        System.out.println("===== Sistem Kompen Mahasiswa =====\n");
            int angka = 0;
            boolean sukses = false;
            while(!sukses){
                System.out.println("masukkan pilihan angka untuk login(1.Admin,2.User)");
                angka = sc.nextInt();
                sc.nextLine();

                System.out.println("masukkan NIM");
                nim = sc.nextLine();
                System.out.println("masukkan password");
                password = sc.nextLine();
                switch (angka) {
                case 1:
                    for (int i = 0; i < loginAdmin.length; i += 2) {
                        if (nim.equals(loginAdmin[i]) && password.equals(loginAdmin[i + 1])) {
                            sukses = true;
                            nama = "Admin";
                            break;
                        }
                        else{
                            System.out.println("Login salah, coba lagi");
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < loginUser.length; i += 2) {
                        if (nim.equals(loginUser[i]) && password.equals(loginUser[i + 1])) {
                            sukses = true;
                            break;
                        }
                         else{
                            System.out.println("Login salah, coba lagi");
                        }
                    }
                    break;

                default:
                    System.out.println("Pilihan anda salah");
                    break;
            }
            }
            

            if (!sukses) {
                System.out.println("Username atau Password salah. Coba lagi.");
            }
            clear();

  
            if (angka==1) {
                admin();
            } else {
                user();
            }

    }

        public static void main(String[] args) {
           kompenMhs[0][0] = "Nama";
           kompenMhs[0][1] = "S1";
           kompenMhs[0][2] = "S2";
           kompenMhs[0][3] = "S3";
           kompenMhs[0][4] = "S4";
           kompenMhs[0][5] = "S5";
           kompenMhs[0][6] = "S6";
           kompenMhs[0][7] = "S7";
           kompenMhs[0][8] = "S8";
           kompenMhs[0][9] = "Kelas";
    
           kompenMhs[1][0] = "hekal";
           kompenMhs[1][1] = "3";
           kompenMhs[1][2] = "0";
           kompenMhs[1][3] = "0";
           kompenMhs[1][4] = "0";
           kompenMhs[1][5] = "0";
           kompenMhs[1][6] = "0";
           kompenMhs[1][7] = "0";
           kompenMhs[1][8] = "0";
           kompenMhs[1][9] = "1Z";
            

            login();
        }
        }
