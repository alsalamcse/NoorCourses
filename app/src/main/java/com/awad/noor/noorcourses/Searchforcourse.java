package com.awad.noor.noorcourses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Searchforcourse extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private Button btnArabic;
    private Button btnEnglish;
    private Button btnMath;
    private Button btnMusic;
    private Button btnPhysics;
    private Button btnArt;
    private Button btnSport;
    private Button btnChemistry;
    private Button btnBiologically;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchforcourse);
        btnArabic= (Button) findViewById(R.id.btnArabic);
        btnEnglish= (Button) findViewById(R.id.btnEnglish);
        btnMath= (Button) findViewById(R.id.btnMath);
        btnMusic= (Button) findViewById(R.id.btnMusic);
        btnPhysics= (Button) findViewById(R.id.btnPhysics);
        btnArt= (Button) findViewById(R.id.btnArt);
        btnSport= (Button) findViewById(R.id.btnSport);
        btnChemistry= (Button) findViewById(R.id.btnChemistry);
        btnBiologically= (Button) findViewById(R.id.btnBiologically);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
