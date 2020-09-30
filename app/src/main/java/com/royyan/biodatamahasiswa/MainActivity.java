package com.royyan.biodatamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private EditText editTextName, editTextNim, editTextTgl;
    private Button getData;
    private RadioGroup radioSection;
    private Spinner spinner;
    private RadioButton laki, perempuan;

    String nama, jk, jurusan;
    int nim, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTgl = (EditText) findViewById(R.id.tanggal_lahir);
        getData = (Button) findViewById(R.id.button_simpan);
        radioSection = (RadioGroup) findViewById(R.id.radio_grup);
        editTextName = (EditText) findViewById(R.id.nama_mahasiswa);
        editTextNim = (EditText) findViewById(R.id.nim_mahasiswa);
        spinner = (Spinner) findViewById(R.id.spinner);
        laki = (RadioButton) findViewById(R.id.laki_laki);
        perempuan = (RadioButton) findViewById(R.id.perempuan);


        editTextTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editTextTgl.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        radioSection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group1, int checkedId1) {
                switch (checkedId1) {
                    case R.id.laki_laki://radiobuttonID
                        //do what you want
                        break;
                    case R.id.perempuan://radiobuttonID
                        //do what you want
                        break;
                }
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioSection.getCheckedRadioButtonId();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("nim", editTextNim.getText().toString());
                intent.putExtra("tanggal", editTextTgl.getText().toString());
                if(laki.isChecked()){
                    laki = (RadioButton) findViewById(selectedId);
                    intent.putExtra("jenis_kelamin", laki.getText().toString());
                }else{
                    intent.putExtra("jenis_kelamin", perempuan.getText().toString());
                }
                intent.putExtra("jurusan", spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}