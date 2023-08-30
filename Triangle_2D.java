package exe.ex4.geo;

import java.util.Arrays;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{

	private Point_2D p1;
	private Point_2D p2;
	private Point_2D p3; 

	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this.p1 = new Point_2D(p1);
		this.p2 = new Point_2D(p2);
		this.p3 = new Point_2D(p3);

	}
	public Triangle_2D(Triangle_2D t1) {
		this.p1 = new Point_2D(t1.get_p1());
		this.p2 = new Point_2D(t1.get_p2());
		this.p3 = new Point_2D(t1.get_p3());
	}

	public Point_2D[] getAllPoints() {
		Point_2D [] points = new Point_2D[3];
		points[0] = new Point_2D(get_p1());
		points[1] = new Point_2D(get_p2());
		points[2] = new Point_2D(get_p3());
		return points;
	}
	@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D triangle = new Triangle_2D(p1, p2, p3);
		
		Triangle_2D triangle1 = new Triangle_2D(p1, p2, ot);	
		Triangle_2D triangle2 = new Triangle_2D(p1, p3, ot);
		Triangle_2D triangle3 = new Triangle_2D(p2, p3, ot);
		double sumOfAreas=triangle1.area()+triangle2.area()+triangle3.area();

		if (Math.abs(triangle.area()-sumOfAreas) <=  Ex4_Const.EPS ){
			return true;
		}
		return false;
	}

	@Override
	public double area() {
		double a= p1.distance(p2);
		double b= p2.distance(p3);
		double c= p1.distance(p3);

		double s= (a+b+c)/2;
		double area= Math.sqrt(s*(s-a)*(s-b)*(s-c));

		return area;
	}

	@Override
	public double perimeter() {
		double a= p1.distance(p2);
		double b= p2.distance(p3);
		double c= p1.distance(p3);

		return a+b+c;
	}

	@Override
	public void translate(Point_2D vec) {
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle_2D(p1,p2,p3);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this.p1.scale(center, ratio);
		this.p2.scale(center, ratio);
		this.p3.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this.p1.rotate(center, angleDegrees);  
		this.p2.rotate(center, angleDegrees);
		this.p3.rotate(center, angleDegrees);
	}

	@Override
	public String toString() {
		return "Triangle_2D " + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 ;
	}

	//getters
	public Point_2D get_p1() {
		return this.p1;
	}
	public Point_2D get_p2() {
		return this.p2;
	}
	public Point_2D get_p3() {
		return this.p3;
	}
}
