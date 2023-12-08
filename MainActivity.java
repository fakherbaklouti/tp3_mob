package com.example.fakher_baklouti_lsi3_tp3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private TextView Age ,tvresultat ;
    private SeekBar id;
    private EditText ed;
    private Button bt;

    private RadioButton boui , bnon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }

        });
    }
    public void calculer (View view)
    {
        Log.i("Information", "button cliqué");
        int age;
        float valeurMesuree;
        boolean verifAge = false, verifValeur = false;
        if(id.getProgress()!=0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",
                    Toast.LENGTH_SHORT).show();
        if(ed.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur !",
                    Toast.LENGTH_LONG).show();
        if(verifAge && verifValeur)
        {
            age = id.getProgress();
            valeurMesuree = Float.valueOf(ed.getText().toString());
            boolean bouiChecked = boui.isChecked();
            if (bouiChecked) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        tvresultat.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        tvresultat.setText("Niveau de glycémie est normale");
                    else
                        tvresultat.setText("Niveau de glycémie est trop élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        tvresultat.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)1
                    tvresultat.setText("Niveau de glycémie est normale");
                        else
                    tvresultat.setText("Niveau de glycémie est trop élevé");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvresultat.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvresultat.setText("Niveau de glycémie est normale");
                    else
                        tvresultat.setText("Niveau de glycémie est trop élevé");
                }
            } else {
                if (valeurMesuree > 10.5)
                    tvresultat.setText("Niveau de glycémie est trop élevé");
                else
                    tvresultat.setText("Niveau de glycémie est normale");
            }
        }

        id.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information " ,"OnProgressChanged"+progress);
                Age.setText("Votre àge "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void init() {
        Age =findViewById(R.id.Age);
        id = findViewById(R.id.SbAge);
        boui = findViewById(R.id.rbtOui);
        bnon =findViewById(R.id.rbtnon);
        bt =findViewById(R.id.btnconsulter);
        ed =findViewById(R.id.rbtvaleur);
        tvresultat=findViewById(R.id.tvresultat);

    }

}