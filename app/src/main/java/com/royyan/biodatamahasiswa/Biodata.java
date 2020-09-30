package com.royyan.biodatamahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

class Biodata implements Parcelable {

    String nama, nim, tanggal, jk, jurusan;


    protected Biodata(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        tanggal = in.readString();
        jk = in.readString();
        jurusan = in.readString();
    }

    public Biodata(String nama, String nim, String tanggal, String jk, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.tanggal = tanggal;
        this.jk = jk;
        this.jurusan = jurusan;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public static Creator<Biodata> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(tanggal);
        dest.writeString(jk);
        dest.writeString(jurusan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Biodata> CREATOR = new Creator<Biodata>() {
        @Override
        public Biodata createFromParcel(Parcel in) {
            return new Biodata(in);
        }

        @Override
        public Biodata[] newArray(int size) {
            return new Biodata[size];
        }
    };
}
