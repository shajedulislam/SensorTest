package com.example.testsensors;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProximitySensor extends Activity implements SensorEventListener {
	TextView proText,statusTxt,accT;
	SensorManager sm;
	Sensor proxSensor,accelerometer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proximity_sensor);
		
		proText=(TextView)findViewById(R.id.proximityTextView);
		sm=(SensorManager)getSystemService(SENSOR_SERVICE);
		proxSensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		
		sm.registerListener(this,proxSensor , SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub		
		
		proText.setText(String.valueOf(event.values[0]));
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
