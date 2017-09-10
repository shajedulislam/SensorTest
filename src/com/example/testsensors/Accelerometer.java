package com.example.testsensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Accelerometer extends Activity implements SensorEventListener {
	
	TextView accT;
	SensorManager sm;
	Sensor accelerometer;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accelerometer);
		
		accT=(TextView)findViewById(R.id.accTxt);
		
		sm=(SensorManager)getSystemService(SENSOR_SERVICE);
		accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		sm.registerListener(this,accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		accT.setText("\nX : "+event.values[0]+"\nY : "+event.values[1]+"\nZ : "+event.values[2]);
		
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER && event.values[2]<0)
		{
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.setRingerMode(1);
		}
		else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER && event.values[2]>0)
		{
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.setRingerMode(2);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
