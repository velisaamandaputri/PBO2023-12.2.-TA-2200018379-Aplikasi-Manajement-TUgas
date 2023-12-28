import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManajerTugas {
    private List<Tugas> daftarTugas;
    private Scanner scanner;

    public ManajerTugas() {
        daftarTugas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("=== Aplikasi Manajemen Tugas ===");
            System.out.println("1. Tampilkan Daftar Tugas");
            System.out.println("2. Tambah Tugas Baru");
            System.out.println("3. Tandai Tugas Selesai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (pilihan) {
                case 1:
                    tampilkanTugas();
                    break;
                case 2:
                    tambahTugas();
                    break;
                case 3:
                    tandaiSelesai();
                    break;
                case 4:
                    berjalan = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private void tampilkanTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
        } else {
            System.out.println("Daftar Tugas:");
            for (int i = 0; i < daftarTugas.size(); i++) {
                Tugas tugas = daftarTugas.get(i);
                System.out.println((i + 1) + ". " + tugas.getNama() + " - Selesai: " + tugas.isSelesai());
            }
        }
    }

    private void tambahTugas() {
        System.out.print("Masukkan nama tugas baru: ");
        String namaTugas = scanner.nextLine();
        Tugas tugasBaru = new Tugas(namaTugas);
        daftarTugas.add(tugasBaru);
        System.out.println("Tugas '" + namaTugas + "' telah ditambahkan.");
    }

    private void tandaiSelesai() {
        tampilkanTugas();
        System.out.print("Pilih nomor tugas yang telah selesai: ");
        int indeksTugas = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        if (indeksTugas > 0 && indeksTugas <= daftarTugas.size()) {
            Tugas tugas = daftarTugas.get(indeksTugas - 1);
            tugas.tandaiSelesai();
            System.out.println("Tugas '" + tugas.getNama() + "' telah ditandai sebagai selesai.");
        } else {
            System.out.println("Nomor tugas tidak valid.");
        }
    }
}
