import java.util.Scanner;

public class MahasiswaMain {
    public static void main(String[] args) {
        // Data awal
        Mahasiswa[] mahasiswaList = {
            new Mahasiswa("22001", "Ali Rahman", "Informatika"),
            new Mahasiswa("22002", "Budi Santoso", "Informatika"),
            new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis")
        };

        MataKuliah[] mataKuliahList = {
            new MataKuliah("MK001", "Struktur Data", 3),
            new MataKuliah("MK002", "Basis Data", 3),
            new MataKuliah("MK003", "Desain Web", 3)
        };

        Penilaian[] penilaianList = {
            new Penilaian(mahasiswaList[0], mataKuliahList[0], 80, 85, 90),
            new Penilaian(mahasiswaList[0], mataKuliahList[1], 60, 75, 70),
            new Penilaian(mahasiswaList[1], mataKuliahList[0], 75, 70, 80),
            new Penilaian(mahasiswaList[2], mataKuliahList[1], 85, 90, 95),
            new Penilaian(mahasiswaList[2], mataKuliahList[2], 80, 90, 65)
        };

        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            // Menu utama
            System.out.println("=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    for (Mahasiswa m : mahasiswaList) {
                        m.tampilMahasiswa();
                    }
                    break;
                case 2:
                    for (MataKuliah mk : mataKuliahList) {
                        mk.tampilMatakuliah();
                    }
                    break;
                case 3:
                    for (Penilaian p : penilaianList) {
                        p.tampilPenilaian();
                    }
                    break;
                case 4:
                    bubbleSort(penilaianList);
                    System.out.println("Data Mahasiswa Setelah Diurutkan:");
                    for (Penilaian p : penilaianList) {
                        p.tampilPenilaian();
                    }
                    break;
                case 5:
                    System.out.print("Masukkan NIM mahasiswa yang dicari: ");
                    scanner.nextLine(); // Mengonsumsi newline
                    String targetNIM = scanner.nextLine();
                    Mahasiswa hasil = linearSearch(mahasiswaList, targetNIM);
                    if (hasil != null) {
                        System.out.println("Mahasiswa Ditemukan:");
                        hasil.tampilMahasiswa();
                    } else {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    public static void bubbleSort(Penilaian[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].nilaiAkhir < data[j + 1].nilaiAkhir) {
                    Penilaian temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static Mahasiswa linearSearch(Mahasiswa[] data, String targetNIM) {
        for (Mahasiswa mhs : data) {
            if (mhs.NIM.equals(targetNIM)) {
                return mhs;
            }
        }
        return null;
    }
}