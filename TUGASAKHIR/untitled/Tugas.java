	public class Tugas {
        private String nama;
        private boolean selesai;

        private int prioritas; //Prioritas tugas (misalnya: 1 untuk rendah, 2 untuk sedang, 3 untuk tinggi)
        private String deadline; //deadline pengumpulan tugas

        public Tugas(String nama, int prioritas, String deadline) {
            this.nama = nama;
            this.selesai = false;
            this.prioritas = prioritas;
            this.deadline = deadline;
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

        public int getPrioritas() {
            return prioritas;
        }

        public void setPrioritas(int prioritas) {
            this.prioritas = prioritas;
        }

        public String getDeadline() {
            return deadline;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;

        }
    }