public class Tugas {
    private String nama;
    private boolean selesai;

    public Tugas(String nama) {
        this.nama = nama;
        this.selesai = false;
    }

    public String getNama() {
        return nama;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void tandaiSelesai() {
        this.selesai = true;
    }
}
