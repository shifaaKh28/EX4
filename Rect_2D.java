package exe.ex4.geo;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {

	private Point_2D p1;
	private Point_2D p2;
	private Point_2D p3;
	private Point_2D p4;

	//Constructor 1
	public Rect_2D(Point_2D p1, Point_2D p2) {
		this.p1 = new Point_2D(p1);
		this.p2 = new Point_2D(p2);
		this.p3 = new Point_2D(p1.x(),p2.y());
		this.p4 = new Point_2D(p2.x(),p1.y());
	}
	//Constructor 2
	public Rect_2D(Point_2D p1, Point_2D p2,Point_2D p3, Point_2D p4) {
		this.p1 = new Point_2D(p1);
		this.p2 = new Point_2D(p2);
		this.p3 = new Point_2D(p3);
		this.p4 = new Point_2D(p4);
	}
	//copy constructor
	public Rect_2D(Rect_2D t1) {
		this.p1 = new Point_2D(t1.get_p1());
		this.p2 = new Point_2D(t1.get_p2());
		this.p3 = new Point_2D(t1.get_p3());
		this.p4 = new Point_2D(t1.get_p4());
	}
	//Height of the rect
	public double getHeight() {
		return p1.distance(p2);
	}

	//Width of the rect
	public double getWidth() {
		return p2.distance(p3);
	}

	@Override
	public boolean contains(Point_2D ot) {
		//Create four triangles using the rectangle's corner points and the given point
		Triangle_2D tri1 = new Triangle_2D(p1,p2,ot);
		Triangle_2D tri2 = new Triangle_2D(p2,p3,ot);
		Triangle_2D tri3 = new Triangle_2D(p3,p4,ot);
		Triangle_2D tri4 = new Triangle_2D(p4,p1,ot);
		
		 //Calculate the area of the rectangle
		double area = this.area();
		 // Calculate the total area of the triangles
		double Total = tri1.area() + tri2.area() + tri3.area() + tri4.area();
		
		// Check if the difference between the rectangle area and the total area of the triangles equals to 0
		if(Math.abs(area- Total) <= Ex4_Const.EPS) {
			return true;
		}
		return false;
	}
	
	@Override
	public double area() {
		double width = getWidth();
		double height = getHeight();

		return height*width ;
	}

	@Override
	public double perimeter() {
		double width = getWidth();
		double height = getHeight();

		return (2*width)+(height*2);
	}

	@Override
	public void translate(Point_2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
		this.p4.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Rect_2D(p1,p2,p3,p4);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this.p1.scale(center, ratio);
		this.p2.scale(center, ratio);
		this.p3.scale(center, ratio);
		this.p4.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.p1.rotate(center, angleDegrees);  
		this.p2.rotate(center, angleDegrees);
		this.p3.rotate(center, angleDegrees);
		this.p4.rotate(center, angleDegrees);
	}

	public Point_2D get_p1() {
		return this.p1;
	}

	public Point_2D get_p2() {
		return this.p2;
	}
	public Point_2D get_p3() {
		return this.p3;
	}
	public Point_2D get_p4() {
		return this.p4;
	}

	@Override
	public String toString() {
		return "Rect_2D " + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 ;
	}
/*
 * in this method we take all the points of the rect
 */
	public Point_2D[] getAllPoints() {
		Point_2D[] points = {new Point_2D(this.p1), new Point_2D(this.p2),new Point_2D(this.p3),new Point_2D(this.p4) };
		return points;
	}


}
