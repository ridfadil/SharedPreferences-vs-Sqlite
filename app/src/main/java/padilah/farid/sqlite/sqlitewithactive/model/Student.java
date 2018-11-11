package padilah.farid.sqlite.sqlitewithactive.model;

public class Student {
    private String id;
    private String nama;
    private String nim;
    private String alamat;
    private String jurusan;

    public Student(String id, String nama, String nim, String alamat, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
