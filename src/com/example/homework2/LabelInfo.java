package com.example.homework2;

public class LabelInfo {
    public int color;
    public String label;
    public LabelInfo(){
        super();
    }
    
    public LabelInfo(int color, String label) { 
        super();
        this.color = color;
        this.label = label;
    }
public LabelInfo insert(int colors,String label){
		
		LabelInfo dummy = new LabelInfo(color,label);
		return  dummy;
		
	}
public String getLabel(){
	return this.label;
}
public int getColor(){
	return this.color;
}



}

