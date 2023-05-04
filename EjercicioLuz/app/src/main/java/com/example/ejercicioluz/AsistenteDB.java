package com.example.ejercicioluz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AsistenteDB extends SQLiteOpenHelper {

    public static final String NAME_DB = "tarifa.db";
    public static final int VERSION_DB = 1;

    public AsistenteDB(Context context) {
        super(context, NAME_DB, null, VERSION_DB);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table TARIFAS(tarifa integer primary key Autoincrement, nomTarifa text, codImage integer);");

        db.execSQL("Create table HORAS(codHora integer primary key autoincrement, hora integer , voltaje text,  codTarifa integer);");

        ContentValues cv = new ContentValues();
        cv.put("nomTarifa","Cara"); cv.put("codImage",R.drawable.trafficlight_red_40428); db.insert("TARIFAS",null,cv);
        cv.put("nomTarifa","Media"); cv.put("codImage",R.drawable.stop1normal_yellow_26945); db.insert("TARIFAS",null,cv);
        cv.put("nomTarifa","Barata"); cv.put("codImage",R.drawable.trafficlight_green_40427); db.insert("TARIFAS",null,cv);

        ContentValues cv2 = new ContentValues();
        cv2.put("hora",0);cv2.put("codTarifa",2);cv2.put("voltaje","0.16642€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",1);cv2.put("codTarifa",2);cv2.put("voltaje","0.15576€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",2);cv2.put("codTarifa",2);cv2.put("voltaje","0.16293€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",3);cv2.put("codTarifa",2);cv2.put("voltaje","0.16675€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",4);cv2.put("codTarifa",2);cv2.put("voltaje","0.16098€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",5);cv2.put("codTarifa",2);cv2.put("voltaje","0.16065€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",6);cv2.put("codTarifa",2);cv2.put("voltaje","0.17317€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",7);cv2.put("codTarifa",2);cv2.put("voltaje","0.18769€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",8);cv2.put("codTarifa",1);cv2.put("voltaje","0.22055€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",9);cv2.put("codTarifa",2);cv2.put("voltaje","0.18429€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",10);cv2.put("codTarifa",1);cv2.put("voltaje","0.2397€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",11);cv2.put("codTarifa",1);cv2.put("voltaje","0.21902€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",12);cv2.put("codTarifa",1);cv2.put("voltaje","0.20611€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",13);cv2.put("codTarifa",2);cv2.put("voltaje","0.15959€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",14);cv2.put("codTarifa",3);cv2.put("voltaje","0.0969€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",15);cv2.put("codTarifa",3);cv2.put("voltaje","0.08405€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",16);cv2.put("codTarifa",3);cv2.put("voltaje","0.08008€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",17);cv2.put("codTarifa",3);cv2.put("voltaje","0.08679€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",18);cv2.put("codTarifa",2);cv2.put("voltaje","0.15489€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",19);cv2.put("codTarifa",1);cv2.put("voltaje","0.20841€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",20);cv2.put("codTarifa",1);cv2.put("voltaje","0.25052€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",21);cv2.put("codTarifa",1);cv2.put("voltaje","0.25092€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",22);cv2.put("codTarifa",1);cv2.put("voltaje","0.20787€/kWh");db.insert("HORAS",null,cv2);
        cv2.put("hora",23);cv2.put("codTarifa",1);cv2.put("voltaje","0.19633€/kWh");db.insert("HORAS",null,cv2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
