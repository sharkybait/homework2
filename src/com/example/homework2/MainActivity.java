package com.example.homework2;

import java.util.ArrayList;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;


public class MainActivity extends Activity {
	private static final int COLOR_CHOOSER = 1;
	public static final String COLOR_TYPE = "color_type";
	public static final String COLOR = "color";
	int i=0;
	ListView colors; 
	 Button other;
	 Button button3;
	 Button button2;
	 Button button1;
	// creating list of strings 
	 ArrayList<LabelInfo> items = new ArrayList<LabelInfo>();
	 ColorArrayAdapter values;
	// Resources res = getResources();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// refernces to listview and buttons
		colors = (ListView) findViewById(R.id.listView1);
	    
		button1 = (Button) findViewById(R.id.button1);
		button1.setBackgroundResource(R.color.Red);
		
	   
		button2 = (Button) findViewById(R.id.button2);
	    button2.setBackgroundResource(R.color.Green);
	    
	    button3 = (Button) findViewById(R.id.button3);
	    button3.setBackgroundResource(R.color.Blue);
	    
	    other = (Button) findViewById(R.id.button4);
		
		 
		// Create the array adapter
		
		// values = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
		
		 //  connect the array adapter to the actual ListView
		 //colors.setAdapter(values);
		// LabelInfo label_data[] = new LabelInfo[]{
			//	 new LabelInfo(Color.RED,"TEST"),
				// new LabelInfo(Color.GREEN,"TEST"),
				 //new LabelInfo(Color.BLUE,"TEST"),
				 //new LabelInfo(Color.YELLOW,"TEST"),
		
	//	 };
		
		
		
		
			
				 values = new ColorArrayAdapter(this, 
		                R.layout.listview_item_row,items);
				colors.setAdapter(values);
	}
	// get the return values --- code skeleton used from BacknForth, adapted/changed core of method
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    	super.onActivityResult(requestCode, resultCode, data);
	    	switch (requestCode) {
	    		case (COLOR_CHOOSER ):
	    			if (resultCode == Activity.RESULT_OK) {
	    				
	    				int colordummy1 = data.getIntExtra(COLOR, SecondActivity.colordummy);
	    				int colordummy2 = ((ColorDrawable) button1.getBackground()).getColor();
	    				int colordummy3 = ((ColorDrawable) button2.getBackground()).getColor(); 
	    				
	    				LabelInfo labeldummy= new LabelInfo(colordummy1,data.getCharSequenceExtra(COLOR_TYPE).toString());
	    				
	    				// Do something
	    				String colorType = data.getCharSequenceExtra(COLOR_TYPE).toString();
	    				
	    				// updates the list view adding the color from Second Activity
	    				items.add(0,labeldummy);
	    				
	    				
	    				values.notifyDataSetChanged();
	    				
	    				
	    				//Change the Button Labels to add the new values 
	    				
	    				
	    				
	    				button3.setText(button2.getText().toString());
	    				button3.setBackgroundColor(colordummy3);
	    				
	    				button2.setText(button1.getText().toString());
	    				button2.setBackgroundColor(colordummy2);
	    				
	    				button1.setText(colorType);
	    				button1.setBackgroundColor(colordummy1);
	    				
	    				
	    			}
	    		break;
	    	}
	    }
	
	
	//Resources res = context.getResources();
	// three methods for each button to enter button text in listview
	
	public void button1Pressed (View v){
		//label_data[i].insert(Color.RED,button1.getText().toString());
		int colordummy = ((ColorDrawable) button1.getBackground()).getColor();
		LabelInfo labeldummy= new LabelInfo(colordummy,button1.getText().toString());
		
		items.add(0,labeldummy);
		values.notifyDataSetChanged();
		i++;
		}
	
	
	public void button2Pressed (View v){
	//	items.add(button2.getText().toString());
		
	int colordummy = ((ColorDrawable) button1.getBackground()).getColor();
	int colordummy2 = ((ColorDrawable) button2.getBackground()).getColor(); 
	
	LabelInfo labeldummy= new LabelInfo(colordummy2,button2.getText().toString());
	 
	 
	
	   String dummy = button2.getText().toString();// holds button2 text
		
		button2.setBackgroundColor(colordummy); // sets button 2 color to button 1 color
		button2.setText(button1.getText().toString()); // sets button 2 to buttons 1's text
		
		button1.setBackgroundColor(colordummy2);  // button1 color to button 2's previous color
		button1.setText(dummy);                        // sets button1 text to buttons 2's previous text
		
		items.add(0,labeldummy);
		values.notifyDataSetChanged();
		i++;
	}
	
	
	public void button3Pressed (View v){
	
		
		
		int colordummy = ((ColorDrawable) button1.getBackground()).getColor();
		int colordummy2 = ((ColorDrawable) button2.getBackground()).getColor(); 
		int colordummy3 = ((ColorDrawable) button3.getBackground()).getColor(); 
		
		LabelInfo labeldummy= new LabelInfo(colordummy3,button3.getText().toString());
		
		String dummy= button3.getText().toString(); // holds buttons 3 text
		String dummy1= button1.getText().toString(); // holds button 1 text
		
		button1.setText(dummy);                                 // button1 text now equal to button 3 text
		button1.setBackgroundColor(colordummy3);               // button 1 color to button 3 color
		
		button3.setText(button2.getText().toString());          // button3 text now equal to button 2 text
		button3.setBackgroundColor(colordummy2); 
		
		button2.setText(dummy1);                                   // button2 text now equal to button 1 original text
		button2.setBackgroundColor(colordummy); 
		
		
		items.add(0,labeldummy);
		values.notifyDataSetChanged();
		i++;
		
	
	}
	
	// Once other is pressed, changed to next activity. 
	public void otherPressed (View v){
			
		Intent intent = new Intent(this, SecondActivity.class); // points to secondactivity
    	startActivityForResult(intent, COLOR_CHOOSER); // intent:intent to start, COLOR_CHOOSER: returned when onActivityResult is called above
	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
