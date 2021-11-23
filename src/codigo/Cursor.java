package codigo;

import java.awt.Color;

import acm.graphics.GRect;

public class Cursor extends GRect {

	public Cursor(double x, double y, double width, double height, Color c) {
		super(x, y, width, height);
		this.setColor(Color.BLUE);
		this.setFillColor(c);
		this.setFilled(true);
	}
	
	public void movimiento(int anchoPantalla, int posX){
		if(posX+this.getWidth()/2<anchoPantalla && posX-(this.getWidth()/2)>0){
			this.setLocation(posX-this.getWidth()/2, this.getY());
		}

	}

}
