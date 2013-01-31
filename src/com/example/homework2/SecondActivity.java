package com.example.homework2;

//import edu.ucsc.luca.backnforth.MainActivity;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	// view references 
	Button forest;
	Button ocean;
	Button yellow;
	Button orange;
	Button purple;
	Button pink;
	Button red;
	Button blue;
	Button green;
	Button enter;
	EditText edit; 
	static int colordummy; 
	private static final String LOG_TAG = "SecondActivity";
	
	@SuppressLint("NewApi") // used to avoid lint errors 
	
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Intent intent = getIntent();
		
		setContentView(R.layout.activity_second);
	
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
	}
		// finds the views
		forest = (Button) findViewById(R.id.button1);
		forest.setBackgroundResource(R.color.DarkGreen);
		
		ocean = (Button) findViewById(R.id.button2);
		ocean.setBackgroundResource(R.color.Aqua);
		
		yellow = (Button) findViewById(R.id.button3);
		yellow.setBackgroundResource(R.color.Yellow);
		
		orange = (Button) findViewById(R.id.button4);
		orange.setBackgroundResource(R.color.Orange);
		
		purple = (Button) findViewById(R.id.button5);
		purple.setBackgroundResource(R.color.Purple);
		
		pink = (Button) findViewById(R.id.button6);
		pink.setBackgroundResource(R.color.Pink);
		
		enter = (Button) findViewById(R.id.button7);
		
		
		red = (Button) findViewById(R.id.button8);
		red.setBackgroundResource(R.color.Red);
		
		green = (Button) findViewById(R.id.button9);
		green.setBackgroundResource(R.color.Green);
		
		blue = (Button) findViewById(R.id.button10);
		blue.setBackgroundResource(R.color.Blue);
		
		edit = (EditText) findViewById(R.id.editText1);
		
		 
	
	}
	
	// These methods enter the text into the TextView
	public void forestPressed(View v){
		edit.setText(forest.getText().toString());
		colordummy =  ((ColorDrawable) forest.getBackground()).getColor();
	}
	
	public void oceanPressed(View v){
		edit.setText(ocean.getText().toString());
		colordummy =  ((ColorDrawable) ocean.getBackground()).getColor();
	}
	
	public void yellowPressed(View v){
		edit.setText(yellow.getText().toString());
		colordummy =  ((ColorDrawable) yellow.getBackground()).getColor();
	}
	
	public void orangePressed(View v){
		edit.setText(orange.getText().toString());
		colordummy =  ((ColorDrawable) orange.getBackground()).getColor();
	}
	
	public void purplePressed(View v){
		edit.setText(purple.getText().toString());
		colordummy =  ((ColorDrawable) purple.getBackground()).getColor();
	}
	
	public void redPressed(View v){
		edit.setText(red.getText().toString());
		colordummy =  ((ColorDrawable) red.getBackground()).getColor();
	}
	
	public void bluePressed(View v){
		edit.setText(blue.getText().toString());
		colordummy =  ((ColorDrawable) blue.getBackground()).getColor();
	}
	
	public void greenPressed(View v){
		edit.setText(green.getText().toString());
		colordummy =  ((ColorDrawable) green.getBackground()).getColor();
	}
	
	public void pinkPressed(View v){
		edit.setText(pink.getText().toString());
		colordummy =  ((ColorDrawable) pink.getBackground()).getColor();
	}
	
	
	public void enterPressed (View v){
		Log.d(LOG_TAG, "Chosen: " +  edit.getText().toString());
		
		
		Intent back = new Intent();	 // intent constructor 
		back.putExtra(MainActivity.COLOR_TYPE, edit.getText().toString()); // attached the new string with color to the intent
		back.putExtra(MainActivity.COLOR, (int)colordummy);
		setResult(RESULT_OK,back); // if 
		finish();	
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}
