package com.example.testsensors;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.EventLog.Event;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
	//TextView proText,statusTxt,accT;
	SensorManager sm;
	Sensor proxSensor,accelerometer;
	Vibrator vib;
	Button btn,btnPro,btnAcc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		btn=(Button)findViewById(R.id.button1);
		btnPro=(Button)findViewById(R.id.btnPS);
		btnAcc=(Button)findViewById(R.id.btnacc);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				vib.vibrate(200);
				
			}
		});
		btnPro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ProximitySensor.class);
				
				startActivity(intent);
				
			}
		});
		btnAcc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Accelerometer.class);
				
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		
		
		
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		//statusTxt.setText("Working");
		
		
	}
	
}
