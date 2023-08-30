package exe.ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ShapeCollectionTest {
	//to create shapes
	private ArrayList <GUI_Shape> _shapes = new ArrayList<GUI_Shape>();

	//segment
	Point_2D p1= new Point_2D(1,2);
	Point_2D p2= new Point_2D(6,2);

	GeoShape seg= new Segment_2D(p1,p2);

	//rectangle
	Point_2D p3 = new Point_2D(0,10);
	Point_2D p4 = new Point_2D(10,10);
	Point_2D p5 = new Point_2D(0,10);
	Point_2D p6 = new Point_2D(10,0);

	GeoShape rect= new Rect_2D(p3,p4,p5,p6);

	//Triangle
	Point_2D p7 = new Point_2D(1 ,1);
	Point_2D p8 = new Point_2D(1, 3);
	Point_2D p9 = new Point_2D(4, 1);

	GeoShape tri= new Triangle_2D(p7,p8,p9);

	//circle
	Point_2D p10 = new Point_2D(1,2);
	double rad=5;

	GeoShape c= new Circle_2D(p10,5);

	GUI_Shape gs1 = new GUIShape(seg,true,Color.BLUE,0);
	GUI_Shape gs2 = new GUIShape(rect,true,Color.RED,2);
	GUI_Shape gs3 =new GUIShape(tri,false,Color.GREEN,2);
	GUI_Shape gs4 =new GUIShape(c,false,Color.yellow,1);
	
	ShapeCollection collection = new ShapeCollection();

	@Test
	void get() {
		collection.add(gs1);
		collection.add(gs2);
		GUI_Shape a= collection.get(0);
		GUI_Shape a2=collection.get(1);
		assertTrue(a==gs1);
		assertTrue(a2==gs2);
	}
	@Test
	void Size() {
		collection.add(gs1);
		collection.add(gs2);
		assertEquals(collection.size(),2);
	}
	@Test
	void testRemoveElementAt() {
		collection.add(gs1);
		collection.add(gs2);
		assertEquals(collection.size(),2);
		collection.removeElementAt(0);
		assertEquals(collection.size(),1);
	}

	@Test
	void testAddAt() {
		collection.add(gs1);
		collection.add(gs2);
		assertEquals(collection.size(),2);
		collection.addAt(gs3, 0);
		assertEquals(collection.size(),3);
	}


		@Test
		void testCopy() {
			collection.add(gs1);
			ShapeCollection copy = (ShapeCollection)collection.copy();
			assertEquals(collection.size(), copy.size());
	}

	@Test
	// test area sort
	void testSort() {
		_shapes.sort(new ShapeComperator(Ex4_Const.Sort_By_Area));
		for (int i = 0; i<collection.size()-1; i++) {
			boolean b = (_shapes.get(i).getShape().area()) <= (_shapes.get(i+1).getShape().area());
			assertTrue(b);
		}
		//anti area
		_shapes.sort(new ShapeComperator(Ex4_Const.Sort_By_Anti_Area));
		for (int i = 0; i<collection.size()-1; i++) {
			boolean s = (_shapes.get(i).getShape().area()) >= (_shapes.get(i+1).getShape().area());
			assertTrue(s);
		}
	}

	@Test
	void testRemoveAll() {
		collection.add(gs1);
		collection.add(gs2);
		assertEquals(collection.size(),2);
		collection.removeAll();;
		assertEquals(collection.size(),0);
	}

	@Test
    void save() {
        String testFilePath = "test_shapes.ser"; // Test file path
        collection.add(gs1);
        collection.add(gs2);
        collection.add(gs3);

        // Save the ShapeCollection
        collection.save(testFilePath);

        // Verify that the file exists
        File file = new File(testFilePath);
        assertTrue(file.exists());

        // Clean up - delete the test file
        file.delete();
    }

	@Test
	void testLoad() {
		   // data
	    String testFilePath = "test_shapes.txt";
	    File testFile = new File(testFilePath);

	    try {
	        // Write  file
	        FileWriter writer = new FileWriter(testFile);
	        writer.write("GUIShape,-16776961,true,0,Segment_2D,1.0,2.0,6.0,2.0\n");
	        writer.write("GUIShape,-65536,true,2,Rect_2D,0.0,10.0,10.0,10.0,0.0,10.0,10.0,0.0\n");
	        writer.close();

	        collection.load(testFilePath);

	        // Verify the loaded shapes
	        assertEquals(2, collection.size());
	    } catch (IOException e) {
	        fail("An exception occurred while preparing the test file.");
	    } finally {
	        // delete the test file
	        if (testFile.exists()) {
	            testFile.delete();
	        }
	    }
	}
	@Test
	void testToString() {
		collection.add(gs1);
		String result = collection.toString();
		String expcted= "GUIShape,-16776961,true,0,Segment_2D,1.0,2.0 , 6.0,2.0";
		assertEquals(result, expcted);
	}

}
