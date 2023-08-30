package exe.ex4.geo;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */

public class Segment_2D implements GeoShape{
	private Point_2D  a;
	private Point_2D  b;
	private double m; //slope
	private double n; //y = mx + n line equation

	//Setters & Getters  
	public Point_2D get_a() {
		return a;
	}

	public void set_a(Point_2D a) {
		this.a = new Point_2D(a);
	}

	public Point_2D get_b() {
		return b;
	}
	public void set_b(Point_2D b) {
		this.b=new Point_2D(b);
	}


	public Segment_2D(Point_2D a, Point_2D b) {
		////// add your code here //////
		this.a = new Point_2D(a);
		this.b = new Point_2D(b);
		this.m = (b.y() - a.y()) / (b.x() - a.x());
		this.n = b.y() - m*b.x();
	}
	public Segment_2D(double x0,double y0,double x1,double y1) {
		this.a = new Point_2D(x0,y0);
		this.b = new Point_2D(x1,y1);
		
		this.m = (b.y()-a.y())/(b.x()-a.x()); 
		this.n =b.y() - m*b.x();
		
	}
	
	public Segment_2D(Segment_2D t1) {
		Point_2D p1 = new Point_2D(t1.get_a());
		Point_2D p2 = new Point_2D(t1.get_b());

		this.a = a;
		this.b = b;

	}
	
	@Override
	public boolean contains(Point_2D ot) {
		Segment_2D seg= new Segment_2D(a,b);
		double length= a.distance(b);
		if ((Math.abs(a.distance(ot))+(b.distance(ot))-length<Ex4_Const.EPS)){
			return true;
		}
		return false;
	}

	@Override
	// the lines dont have area
	public double area() {
		return 0;
	}

	
	@Override
	public double perimeter() {
		return a.distance(b)*2;
	}

	@Override
	public void translate(Point_2D vec) {
		a.move(vec);
		b.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment_2D(a, b);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
    this.a.scale(center, ratio);
    this.b.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
     this.a.rotate(center, angleDegrees);
     this.b.rotate(center, angleDegrees);
	}
	@Override
	public String toString() {
		return "Segment_2D," + this.a + " , " + this.b;
	}
	
	public Point_2D [] getPoints() {
		Point_2D [] arr = new Point_2D[2];
		arr[0] = new Point_2D(this.a);
		arr[1] = new Point_2D(this.b);
		return arr;
	}
	public static void main(String[] args) {
		Point_2D a= new Point_2D(1,2);
		Point_2D b= new Point_2D(8,2);
		
		Point_2D aa= new Point_2D(4,2);
		Point_2D bb= new Point_2D(5,5);
		Segment_2D seg= new Segment_2D(a,b);
		
		boolean is = seg.contains(bb);
		System.out.println(is);
	}
}
