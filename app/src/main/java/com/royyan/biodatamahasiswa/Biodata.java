package com.royyan.biodatamahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

class Biodata implements Parcelable {

    String nama, jk, jurusan;
    int nim;
    int tanggal;

    protected Biodata(Parcel in) {
        nama = in.readString();
        jk = in.readString();
        jurusan = in.readString();
        nim = in.readInt();
        tanggal = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(jk);
        parcel.writeString(jurusan);
        parcel.writeInt(nim);
        parcel.writeInt(tanggal);
    }
}
