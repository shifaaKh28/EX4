
package exe.ex4.geo;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */

import exe.ex4.geo.GeoShape;

import java.awt.*;
import java.util.ArrayList;



public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;

	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}

	public GUIShape(String 	l) {
		init(l.split(","));
	} 

	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;

	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		return "GUIShape," + _color.getRGB() + "," + _fill + "," + _tag + "," +_g;
	}

	/**
	 * Initializes the GUIShape object based on the provided array of string values.
	 * This method is used for loading and setting the properties of the shape.
	 *
	 * @param ww The array of string values containing shape information.
	 */
	private void init(String[] ww) {
		// Extract color, fill, and tag values from the array
		_color = new Color(Integer.parseInt(ww[1]));
		_fill = Boolean.parseBoolean(ww[2]);
		_tag = Integer.parseInt(ww[3]);
		String information = ww[4];
		Point_2D zero = new Point_2D(0,0);

		// Determine the type of shape based on the information string
		// Initialize the shape based on the type
		if(information.compareTo("Point_2D") == 0) {
			zero = new Point_2D(Double.parseDouble(ww[5]),Double.parseDouble(ww[6]));
		}

		else if (information.compareTo("Rect_2D") == 0) {

			double x1 = 0;
			double x2 = 0;
			double x3 = 0;
			double x4 = 0;
			double y1 = 0;
			double y2 = 0;
			double y3 = 0;
			double y4 = 0;
			
			x1 = Double.parseDouble(ww[5]);
			y1 = Double.parseDouble(ww[6]);
			x2 = Double.parseDouble(ww[7]);
			y2 = Double.parseDouble(ww[8]);
			x3 = Double.parseDouble(ww[9]);
			y3 = Double.parseDouble(ww[10]);
			x4 = Double.parseDouble(ww[11]);
			y4 = Double.parseDouble(ww[12]);

			Point_2D _p1;
			Point_2D _p2;
			Point_2D _p3;
			Point_2D _p4;
			
			_p1 = new Point_2D(x1,y1);
			_p2 = new Point_2D(x2,y2);
			_p3 = new Point_2D(x3,y3);
			_p4 = new Point_2D(x4,y4);

			ArrayList<Point_2D> PointsfromRect = new ArrayList<>();
			PointsfromRect.add(_p1);
			PointsfromRect.add(_p2);
			PointsfromRect.add(_p3);
			PointsfromRect.add(_p4);

			_g = new Polygon_2D(PointsfromRect);
		}
		else if (information.compareTo("Circle_2D") == 0) {
			double xx = 0;
			double yy = 0;
			
			xx = Double.parseDouble(ww[5]);
			yy = Double.parseDouble(ww[6]);
			Point_2D cen = new Point_2D(xx,yy);
			double rad = Double.parseDouble(ww[7]);
			_g = new Circle_2D(cen,rad);
		}

		else if (information.compareTo("Polygon_2D") == 0) {
			ArrayList<Point_2D> PointsFromPoly = new ArrayList<>();
			for (int i = 5; i<ww.length; i = i+2) {
				Point_2D pol = new Point_2D(Double.parseDouble(ww[i]),Double.parseDouble(ww[i+1]));
				PointsFromPoly.add(pol);
			}
			_g = new Polygon_2D(PointsFromPoly);
		}

		else if (information.compareTo("Triangle_2D") == 0) {
			double x1 = 0;
			double x2 = 0;
			double x3 = 0;
			double y1 = 0;
			double y2 = 0;
			double y3 = 0;
			
			x1 = Double.parseDouble(ww[5]);
			y1 = Double.parseDouble(ww[6]);
			x2 = Double.parseDouble(ww[7]);
			y2 = Double.parseDouble(ww[8]);
			x3 = Double.parseDouble(ww[9]);
			y3 = Double.parseDouble(ww[10]);

			Point_2D p_1;
			Point_2D p_2;
			Point_2D p_3;
			
			p_1 = new Point_2D(x1,y1);
			p_2 = new Point_2D(x2,y2);
			p_3 = new Point_2D(x3,y3);
			_g = new Triangle_2D(p_1, p_2, p_3);
		}
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	@Override
	public void setShape(GeoShape g) {
		if(g instanceof Rect_2D) {
			this._g=(Rect_2D)g;
		}
		if (g instanceof Triangle_2D) {
			this._g=(Triangle_2D)g;
		}
		if(g instanceof Segment_2D) {
			this._g=(Segment_2D)g;
		}
		if(g instanceof Polygon_2D) {
			this._g = (Polygon_2D)g;
		}
	}
}
