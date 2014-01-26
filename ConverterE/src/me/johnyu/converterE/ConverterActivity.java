package me.johnyu.converterE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class ConverterActivity extends Activity {
	// Initialize cTemp to be 0 and fTemp to be 32
	public double cTemp = getCelsius(32);
	public double fTemp = getFahrenheit(0);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.converter_activity_main);
		
		// Initialize celcisus and fahrenheit text box
		EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
		celsiusBox.setText(Double.toString(cTemp));
		EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
		fahrenheitBox.setText(Double.toString(fTemp));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.converter, menu);
		return true;
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
