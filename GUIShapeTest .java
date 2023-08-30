package exe.ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GUIShapeTest {
	//segment
	Point_2D p1= new Point_2D(1,2);
	Point_2D p2= new Point_2D(6,2);

	GeoShape seg= new Segment_2D(p1,p2);

	//circle
	Point_2D p3 = new Point_2D(1,2);
	double rad=5;

	GeoShape c= new Circle_2D(p3,5);
	//polygon 
	Point_2D p4 = new Point_2D(1,3);
	Point_2D p5 = new Point_2D(3,8);
	Point_2D p6 = new Point_2D(8,8);
	Point_2D p7 = new Point_2D(5,5);
	Point_2D p8 = new Point_2D(8,5);


	GUI_Shape gs1 = new GUIShape(seg,true,Color.BLUE,0);
	GUI_Shape gs2 =new GUIShape(c,false,Color.yellow,1);
	GUI_Shape gs3 =new GUIShape(c,false,Color.BLACK,1);

	ShapeCollection collection = new ShapeCollection();
	ShapeCollection collection1 = new ShapeCollection();

	@Test
	public void testShapes() {
		// Test segment
		collection.add(gs1);

		System.out.println(collection.toString());
		String s = "GUIShape,-16776961,true,0,Segment_2D,1.0,2.0 , 6.0,2.0"; // A segment data 
		String [] arr = s.split(",");

		assertEquals(arr[2], "true");

		//toString
		String s2 = "GUIShape,-16776961,true,0,Segment_2D,1.0,2.0 , 6.0,2.0";
		assertEquals(s2, collection.toString());

		//test circle
		String s3="GUIShape,-256,false,1,exe.ex4.geo.Circle_2D: 1.0,2.0,5.0";
		String [] arr2 = s3.split(",");
		assertEquals(arr2[2], "false");


		// Polygon test
		ArrayList<Point_2D> Points = new ArrayList<Point_2D>();
		String str = "GUIShape,-16777216,true,2,Polygon2D,1,3,3.0,8.0,8.0,8.0,5.0,5.0,8.0,5.0"; // A polygon data 
		String [] arr3 = str.split(",");
		assertEquals(arr3[3], "2");
		collection1.add(gs3);
		//test color
		assertEquals(gs3.getColor().getRGB(),Color.BLACK.getRGB());	

	}
}
