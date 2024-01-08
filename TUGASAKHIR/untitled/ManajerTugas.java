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
            System.out.println("4. Tampilkan Tugas Berdasarkan Prioritas");
            System.out.println("5. Hapus TUgas");
            System.out.println("6. Keluar");
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
                case 4 :
                    tampilkanTugasBerdasarkanPrioritas();
                    break;
                case 5:
                    hapusTugas();
                    break;
                case 6:
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

        System.out.print("Masukkan prioritas tugas (1 untuk rendah, 2 untuk sedang, 3 untuk tinggi): ");
        int prioritas = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        System.out.print("Masukkan deadline tugas (format: YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        Tugas tugasBaru = new Tugas(namaTugas, prioritas, deadline);
        daftarTugas.add(tugasBaru);
        System.out.println("Tugas '" + namaTugas + "' dengan prioritas " + prioritas + " dan deadline " + deadline + " telah ditambahkan.");
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

    private void tampilkanTugasBerdasarkanPrioritas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
        } else {
            System.out.println("Daftar Tugas Berdasarkan Prioritas:");

            // Bubble Sort
            for (int i = 0; i < daftarTugas.size() - 1; i++) {
                for (int j = 0; j < daftarTugas.size() - i - 1; j++) {
                    if (daftarTugas.get(j).getPrioritas() > daftarTugas.get(j + 1).getPrioritas()) {
                        // Swap
                        Tugas temp = daftarTugas.get(j);
                        daftarTugas.set(j, daftarTugas.get(j + 1));
                        daftarTugas.set(j + 1, temp);
                    }
                }
            }

            // Menampilkan tugas setelah diurutkan
            for (int i = 0; i < daftarTugas.size(); i++) {
                Tugas tugas = daftarTugas.get(i);
                System.out.println((i + 1) + ". " + tugas.getNama() + " - Prioritas: " + tugas.getPrioritas() + " - Deadline: " + tugas.getDeadline());
            }
        }
    }



    private void hapusTugas() {
        tampilkanTugas();
        if (!daftarTugas.isEmpty()) {
            System.out.print("Pilih nomor tugas yang akan dihapus: ");
            int indeksHapus = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            if (indeksHapus > 0 && indeksHapus <= daftarTugas.size()) {
                Tugas tugas = daftarTugas.remove(indeksHapus - 1);
                System.out.println("Tugas '" + tugas.getNama() + "' telah dihapus.");
            } else {
                System.out.println("Nomor tugas tidak valid.");
            }
        } else {
            System.out.println("Tidak ada tugas yang bisa dihapus.");
        }
    }

}

