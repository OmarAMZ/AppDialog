package com.example.appdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button dialogosimple;
    private Button dialogolistasimple;
    private Button dialogodate;
    private Button dialogotime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mostrar Dialogo Simple Al presionar el boton
        dialogosimple = (Button) findViewById(R.id.btndialogsimple);
        dialogosimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("SimpleDialog");
                alertDialogBuilder
                        .setMessage("Este es un SimpleDialog")
                        .setCancelable(false)
                        .setPositiveButton("ACEPTAR",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("CANCELAR",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                            }
                        }).create().show();
            }
        });

        //Mostrar Dialogo Lista Simple Al presionar el boton
        dialogolistasimple = (Button) findViewById(R.id.btndialoglistasimple);
        dialogolistasimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Este es un DialogListSimple");

                String[] colores = {"Azul", "Rojo", "Verde", "Morado", "Negro"};
                builder.setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                        }
                    }
                })
                        .setCancelable(false)
                        .setNegativeButton("CANCELAR",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        //Mostrar Dialogo DatePicker Al presionar el boton
        dialogodate = (Button) findViewById(R.id.btndialogdatepicker);
        dialogodate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        //Mostrar Dialogo TimePicker Al presionar el boton
        dialogotime = (Button) findViewById(R.id.btndialogtimepicker);
        dialogotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });
    }
}