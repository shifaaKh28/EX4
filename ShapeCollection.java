package exe.ex4.geo;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection{
	private ArrayList<GUI_Shape> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i) ;
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i,s);
	}
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public GUI_Shape_Collection copy() {
				ShapeCollection copy = new ShapeCollection();
				for (int i = 0; i<_shapes.size(); i++) {
					GeoShape g = _shapes.get(i).getShape().copy(); // Copying the shapes 
					GUIShape gs = new GUIShape(g,_shapes.get(i).isFilled(),_shapes.get(i).getColor(), _shapes.get(i).getTag());
					copy.add(gs);
				}
				return copy;
			}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.removeAll(_shapes);
	}
	/**
	 * Saves the collection of GUI shapes to a file.
	 *
	 * @param file The name of the file to save the shapes to.
	 */
	@Override
	public void save(String file) {
		try {
			// Creates a FileWriter object to write to the specified file.
			FileWriter f = new FileWriter(file);
			for(int i = 0; i<_shapes.size(); i++) {

				// Writes the string representation of each shape to the file, followed by a newline character.
				f.write((_shapes.get(i).toString() + "\n"));
			}
			// Closes the FileWriter to ensure all buffered data is written to the file.
			f.close();
		}
		catch(IOException e) {
			// Prints the stack trace of the exception if an I/O error occurs.
			e.printStackTrace();
		}
	}

	@Override
	public void load(String file) {
		// loading the file to a new and clear gui  
		_shapes.clear();
		try {
			// Open the file
			FileReader r= new FileReader(file);// getting the file path
			BufferedReader b = new BufferedReader(r);

			// Read the file
			String line;
			while ((line = b.readLine()) != null) {
				_shapes.add(new GUIShape(line));
			}
			// Close the file
			b.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}


}
