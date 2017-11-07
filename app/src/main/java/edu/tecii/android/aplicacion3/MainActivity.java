package edu.tecii.android.aplicacion3;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3;
    CheckBox checkBox1, checkBox2, checkBox3;
    ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = (SeekBar)findViewById(R.id.seekBar);
        seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar)findViewById(R.id.seekBar3);

        checkBox1 = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);

        fondo = (ConstraintLayout)findViewById(R.id.layout);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cambiarColor(seekBar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekBar1.setOnSeekBarChangeListener(listener);
        seekBar2.setOnSeekBarChangeListener(listener);
        seekBar3.setOnSeekBarChangeListener(listener);
    }

    public void cambiarColor(View c){
        int rojo = checkBox1.isChecked() ? seekBar1.getProgress():255;
        int verde = checkBox2.isChecked() ? seekBar2.getProgress():255;
        int azul = checkBox3.isChecked() ? seekBar3.getProgress():255;
        fondo.setBackgroundColor(Color.argb(255, rojo, verde, azul));
    }

    public void abrirPagWeb(View v){
        /* Codigo para cuando se requiere un solo
        String uriURL = getResources().getString(R.string.paginaWeb);
        Intent desplegarPag = new Intent(Intent.ACTION_VIEW, Uri.parse(uriURL));
        startActivity(desplegarPag);
        */

        //Codigo para cuando queremos una lista de strings
        String[] lista= getResources().getStringArray(R.array.lista);
        for (String e:lista){
            Toast mensajes = Toast.makeText(getApplicationContext(),e,Toast.LENGTH_SHORT);
            mensajes.show();
        }
    }
}
