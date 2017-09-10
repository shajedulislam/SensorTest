package com.example.testsensors;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
	
	Button vibration,startflip,stopflip,proximity,acc;
	Vibrator vib;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnCast();
		 
		 vibration.setOnClickListener(this);
		 startflip.setOnClickListener(this);
		 stopflip.setOnClickListener(this);
		 acc.setOnClickListener(this);
		 proximity.setOnClickListener(this);
		 
		 vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		 	 
		 
	}
	
	
	public void btnCast()
	{
	
		vibration=(Button) findViewById(R.id.button1);
		startflip=(Button) findViewById(R.id.flip);
		stopflip=(Button)findViewById(R.id.stopflip);
		acc=(Button) findViewById(R.id.btnacc);
		proximity=(Button) findViewById(R.id.btnPS);
		
		
	}
	@Override
	public void onClick(View v) 
	{
		if(v.getId()==R.id.button1)
		{			       
			vib.vibrate(300);
		}
		
		else if(v.getId()==R.id.flip)
		{			
			startService(new Intent(this,flipflop.class));
		}
		else if(v.getId()==R.id.stopflip)
		{		
			stopService(new Intent(this,flipflop.class));
		}
		else if(v.getId()==R.id.btnacc)
		{
			
			Intent intent = new Intent(MainActivity.this, Accelerometer.class);		
			startActivity(intent);
		}
		else if(v.getId()==R.id.btnacc)
		{
			
			Intent intent = new Intent(MainActivity.this, Accelerometer.class);		
			startActivity(intent);
		}
	}
	
	
	
	


}
