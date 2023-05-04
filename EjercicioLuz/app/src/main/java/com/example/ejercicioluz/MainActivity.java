package com.example.ejercicioluz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText etTiempo;
    Button btnVer;
    ImageView imageView;
    TextView voltaje;
    TextView tvNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTiempo = findViewById(R.id.etTime);
        btnVer = findViewById(R.id.button);
        imageView = findViewById(R.id.ivSemaforo);
        voltaje = findViewById(R.id.tvVoltaje);
        tvNext = findViewById(R.id.tvNext);
        db= new AsistenteDB(this).getReadableDatabase();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hora = sdf.format(new Date().getTime());

        etTiempo.setText(hora);
        getTarifa(etTiempo.getText().toString());

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTarifa(etTiempo.getText().toString());
            }
        });

    }


    public void getTarifa(String texto){

        Pattern p = Pattern.compile("([01]\\d?|2[0-3]):([0-5]\\d?)");
        Matcher m = p.matcher(texto);
        int hora=-1;
        if(m.find()){
            hora = Integer.parseInt(m.group(1));
        }else {
            Toast.makeText(this, "Formato No Valido", Toast.LENGTH_SHORT).show();;
        }

        getHora(hora);

        getNext(hora+1);



        
        
        /*
        int[][] tarifa={{0,1,2,3,4,5,6,7,21,22,23},{8,9,10,11,12,17,18,19,20},{13,14,15,16}};

        for(int i = 0; i< tarifa.length;i++){
            for(int j = 0; j<tarifa[i].length;j++){
                if(hora == tarifa[i][j]){
                    switch (i){
                        case 0:

                            imageView.setImageResource(R.drawable.trafficlight_green_40427);
                            break;
                        case 1:
                            imageView.setImageResource(R.drawable.stop1normal_yellow_26945);
                            break;
                        case 2:
                            imageView.setImageResource(R.drawable.trafficlight_red_40428);
                            break;
                    }
                }
            }*/
        }


        public void getHora(int hora){
            Cursor c = db.rawQuery("Select hora, codImage, voltaje, tarifa from HORAS inner join TARIFAS on codTarifa = tarifa where hora=?",new String[]{String.valueOf(hora)});
            int codHora = c.getColumnIndex("hora");
            int codImage = c.getColumnIndex("codImage");
            int codVoltaje = c.getColumnIndex("voltaje");
            int codTarifa = c.getColumnIndex("tarifa");
            while(c.moveToNext()) {
                int refHora = c.getInt(codHora);
                int refImage = c.getInt(codImage);
                String vol = c.getString(codVoltaje);
                int tarifa = c.getInt(codTarifa);

                    imageView.setImageResource(refImage);
                    voltaje.setText(vol);
                    switch (tarifa){
                        case 1:
                            voltaje.setTextColor(Color.RED);
                            break;
                        case 2:
                            voltaje.setTextColor(Color.argb(255,140,140,0));
                            break;
                        case 3:
                            voltaje.setTextColor(Color.GREEN);
                            break;
                    }


                c.close();
            }
        }

        public void getNext(int hora){
        int num = hora == 24 ?0:hora;
        String next = "Siguiente Hora: ";
        int color = 0;
        //---------------------------------------------
        Cursor c = db.rawQuery("select hora, voltaje, codTarifa from HORAS where hora = ?",new String[]{String.valueOf(num)});
        int codVol = c.getColumnIndex("voltaje");
        int codTar = c.getColumnIndex("codTarifa");

        while(c.moveToNext()){
            next += c.getString(codVol);
            switch (c.getInt(codTar)){
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.argb(255,140,140,0);
                    break;
                case 3:
                    color = Color.GREEN;
                    break;
            }
        }
        //------------------------------------------------
        tvNext.setText(next);
        tvNext.setTextColor(color);

        c.close();
        }

    }
