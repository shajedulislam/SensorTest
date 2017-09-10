package com.example.testsensors;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;



public class flipflop extends Service implements SensorEventListener
{
	
	SensorManager sensorManager;
	Sensor sensor;

	
	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent,int  flags,int  startId)
	{
		
		 sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		 sensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);		
		 sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		
		 return START_STICKY;
	}
	
	
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		// TODO Auto-generated method stub
		//accT.setText("\nX : "+event.values[0]+"\nY : "+event.values[1]+"\nZ : "+event.values[2]);
		
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER & event.values[2]<0)
		{
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.setRingerMode(1);
		}
		else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER & event.values[2]>0)
		{
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.setRingerMode(2);
		}
	}
		
	
	

}
