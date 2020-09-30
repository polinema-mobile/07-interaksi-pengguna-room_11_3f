package com.royyan.biodatamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.royyan.biodatamahasiswa.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView nama = (TextView) findViewById(R.id.item_name);
        TextView nim = (TextView) findViewById(R.id.item_nim);
        TextView tanggal = (TextView) findViewById(R.id.item_tanggal);
        TextView jk = (TextView) findViewById(R.id.item_jenis_kelamin);
        TextView jurusan = (TextView) findViewById(R.id.item_jurusan);

        if(getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            nama.setText(bundle.getString("name"));
            nim.setText(bundle.getString("nim"));
            tanggal.setText(bundle.getString("tanggal"));
            jk.setText(bundle.getString("jenis_kelamin"));
            jurusan.setText(bundle.getString("jurusan"));

        }else{
            nama.setText(getIntent().getStringExtra("name"));
            nim.setText(getIntent().getStringExtra("nim"));
            tanggal.setText(getIntent().getStringExtra("tanggal"));
            jk.setText(getIntent().getStringExtra("jenis_kelamin"));
            jurusan.setText(getIntent().getStringExtra("jurusan"));
        }

        Biodata biodata = getIntent().getParcelableExtra("BIODATA");

        nama.setText( biodata.getNama());
        nim.setText(biodata.getNim());
        tanggal.setText(biodata.getTanggal());
        jk.setText (biodata.getJk());
        jurusan.setText(biodata.getJurusan());
    }

}
