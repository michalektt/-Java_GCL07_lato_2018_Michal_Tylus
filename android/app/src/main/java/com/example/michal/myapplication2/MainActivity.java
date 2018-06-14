package com.example.michal.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SensorManager sm;
    private float acelVal, acleLast, shake;

    private Vibrator vibrator;


    private Button mChangeTextButton;
    private Button mAboutButton;
    private Button mVibratorButton;
    private TextView mText;
    String[] textTab={"Zjedzmy ciastko ^^","Nie podglądaj!", "Ciiii...", "Nic tu nie ma ;)","Jak Ci mija dzień? ","Na górze róże...","HALOOO","","Hello World!", "Tak się kicha na kielicha!", "No ale czemu nie?","Ktoś Cię kocha!", "Uśmiechnij się!", "Fasolki","Na dwór, czy na pole?","Carpe diem","Don't worry, be happy!","Jesteś kimś!", "Kto jak nie Ty?", "Zaśpiewaj!","Idziemy na dwór?", "Stawiasz pizze!", "Ciamciaramcia", " Dzieeeeeń dobry!"};
    boolean isON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        isON=true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChangeTextButton=findViewById(R.id.changeText);
        mAboutButton=findViewById(R.id.aboutView);
        mText=findViewById(R.id.napis);
        mVibratorButton = findViewById(R.id.vibButton);

        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal=SensorManager.GRAVITY_EARTH;
        acleLast=SensorManager.GRAVITY_EARTH;
        shake=0.0f;

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        mVibratorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isON==true){
                    isON = false;
                    Snackbar.make(v, "Wyłączono wibracje", Snackbar.LENGTH_LONG).show();
                }
                else {
                    isON = true;
                    Snackbar.make(v, "Włączono wibracje", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        mChangeTextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isON==true)vibrator.vibrate(500);
                Random generator=new Random();

                int los=generator.nextInt(textTab.length-1)+0;
                mText.setText(textTab[los]);
                }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ABOUT.class);
                startActivity(intent);
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private final SensorEventListener sensorListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            acleLast=acelVal;
            acelVal=(float)Math.sqrt((double)(x*x+y*y+z*z));
            float delta = acelVal - acleLast;
            shake= shake * 0.9f + delta;
            if(shake > 3){
                Toast toast = Toast.makeText(getApplicationContext(),"Już tak nie trzęś ;)", Toast.LENGTH_LONG);
                toast.show();
                if(isON==true)vibrator.vibrate(1000);
                Random generator=new Random();
                int los=generator.nextInt(textTab.length-1)+0;
                mText.setText(textTab[los]);
                toast.cancel();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
