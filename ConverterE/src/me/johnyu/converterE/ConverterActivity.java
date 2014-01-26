package me.johnyu.converterE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ConverterActivity extends Activity implements OnSeekBarChangeListener, OnClickListener{
	// Initialize cTemp to be 0 and fTemp to be 32
	public double cTemp = getCelsius(32);
	public double fTemp = getFahrenheit(0);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.converter_activity_main);
		
		SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setOnSeekBarChangeListener(this);
		
		Button plusButton = (Button) findViewById(R.id.plus);
		plusButton.setOnClickListener(this);
		Button minButton = (Button) findViewById(R.id.minus);
		minButton.setOnClickListener(this);
		
		// Initialize celcisus and fahrenheit text box
		EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
		celsiusBox.setText(String.format("%.2f", cTemp));
		EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
		fahrenheitBox.setText(String.format("%.2f", fTemp));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.converter, menu);
		return true;
	}
	
	// Calculating the conversion and updating text while seekbar is being moved
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if(fromUser == true)
		{
			fTemp = progress / 10.0;
			cTemp = getCelsius(fTemp);
			
			EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
			celsiusBox.setText(String.format("%.2f", cTemp));
			
			EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
			fahrenheitBox.setText(String.format("%.2f", fTemp));
		}
			
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
//		fTemp = seekBar.getProgress() / 10.0;
//		cTemp = getCelsius(fTemp);
//		
//		EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
//		celsiusBox.setText(String.format("%.2f", cTemp));
//		
//		EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
//		fahrenheitBox.setText(String.format("%.2f", fTemp));
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.plus:
			buttonPressed(R.id.plus);
			break;
		case R.id.minus:
			buttonPressed(R.id.minus);
			break;
		default:
			System.out.println("This is broke.");
			break;
		}
	}
	
	// Calculating the conversion and updating text while buttons are being pressed
	public void buttonPressed(int id)
	{
		// if plus button is pressed
		if( id == R.id.plus)
		{
			System.out.println("this is the ctemp = " + cTemp);
			cTemp = cTemp + 1;
			System.out.println("this is the ctemp = " + cTemp);
			fTemp = getFahrenheit(cTemp);
			
			EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
			celsiusBox.setText(String.format("%.2f", cTemp));
			
			EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
			fahrenheitBox.setText(String.format("%.2f", fTemp));
			
			SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
			seekBar.setProgress((int)fTemp * 10);
		}
		
		// if minus button is pressed
		else
		{
			cTemp--;
			fTemp = getFahrenheit(cTemp);
			
			EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
			celsiusBox.setText(String.format("%.2f", cTemp));
			
			EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
			fahrenheitBox.setText(String.format("%.2f", fTemp));
			
			SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
			seekBar.setProgress((int)fTemp * 10);
		}
	}
	
	
	
	
	
	
	
	// Calculate corresponding Celsius value with given Fahrenheit value
	public double getCelsius(double fahrenheit)
	{
		return (fahrenheit - 32) * 5.0 / 9.0;
	}
	
	public double getFahrenheit(double celsius)
	{
		return celsius * 9.0 / 5.0 + 32;
	}
}
