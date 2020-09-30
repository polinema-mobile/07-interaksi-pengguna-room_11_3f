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
        TextView tvData1 = (TextView) findViewById(R.id.item_name);
        TextView tvData2 = (TextView) findViewById(R.id.item_nim);
        TextView tvData3 = (TextView) findViewById(R.id.item_tanggal);
        TextView tvData4 = (TextView) findViewById(R.id.item_jenis_kelamin);
        TextView tvData5 = (TextView) findViewById(R.id.item_jurusan);

        if(getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            tvData1.setText(bundle.getString("name"));
            tvData2.setText(bundle.getString("nim"));
            tvData3.setText(bundle.getString("tanggal"));
            tvData4.setText(bundle.getString("jenis_kelamin"));
            tvData5.setText(bundle.getString("jurusan"));

        }else{
            tvData1.setText(getIntent().getStringExtra("name"));
            tvData2.setText(getIntent().getStringExtra("nim"));
            tvData3.setText(getIntent().getStringExtra("tanggal"));
            tvData4.setText(getIntent().getStringExtra("jenis_kelamin"));
            tvData5.setText(getIntent().getStringExtra("jurusan"));
        }
    }

}
