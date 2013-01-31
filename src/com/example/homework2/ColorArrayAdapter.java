package com.example.homework2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.LinearLayout;
import android.widget.TextView;
public class ColorArrayAdapter extends ArrayAdapter<LabelInfo> {  
	   Context context; 
	    int layoutResourceId;    
	    LabelInfo data[] = null;
	    
	    public ColorArrayAdapter(Context context, int layoutResourceId, ArrayList<LabelInfo> items) {
	        super(context, layoutResourceId, items);
	        this.layoutResourceId = layoutResourceId;
	        this.context = context;
	      //  this.data = items;
	    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
         ColorHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ColorHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.txtLabel);
           
            
            row.setTag(holder);
        }
        else
        {
            holder = (ColorHolder) row.getTag();
        }
        
       LabelInfo colors= getItem(position);
       holder.txtTitle.setText(colors.label);
       holder.txtTitle.setBackgroundColor(colors.color);
        
        return row;
    }
    
    static class ColorHolder
    {
        TextView txtTitle;
        int color;
    }
}