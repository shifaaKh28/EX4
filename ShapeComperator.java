package exe.ex4.geo;

import java.util.Comparator;
/*
 * This class represents a Comparator over GUI_Shape - 
 * as a linear order over GUI_Shapes.
 */

public class ShapeComperator implements Comparator<GUI_Shape>{

	private int f;
	public ShapeComperator(int flag) {
		f = flag;
	}
	@Override
	public int compare(GUI_Shape g1, GUI_Shape g2) {
		int a=0;
		if(f == Ex4_Const.Sort_By_Area) {
			a = Double.compare(g1.getShape().area(), g2.getShape().area());
		}
		
		else if(f == Ex4_Const.Sort_By_Anti_Area) {
			a = Double.compare(g2.getShape().area(), g1.getShape().area());
		}
		
		if(f == Ex4_Const.Sort_By_Perimeter) {
			a = Double.compare(g1.getShape().perimeter(), g2.getShape().perimeter());
		}
		else if(f == Ex4_Const.Sort_By_Anti_Perimeter) {
			a = Double.compare(g2.getShape().perimeter(), g1.getShape().perimeter());
		}
		
		if(f == Ex4_Const.Sort_By_toString) {
			a = g1.toString().compareTo(g2.toString());
		}
		else if(f == Ex4_Const.Sort_By_Anti_toString) {
			a = g2.toString().compareTo(g1.toString());
		}
		
		if(f == Ex4_Const.Sort_By_Perimeter) {
			a = Double.compare(g1.getShape().perimeter(), g2.getShape().perimeter());
		}
		else if(f == Ex4_Const.Sort_By_Anti_Perimeter) {
			a = Double.compare(g2.getShape().perimeter(), g1.getShape().perimeter());
		}
		
		if(f == Ex4_Const.Sort_By_Tag) {
			a = Integer.compare(g1.getTag(), g2.getTag());
		}
		else if(f == Ex4_Const.Sort_By_Anti_Tag) {
			a = Integer.compare(g2.getTag(), g1.getTag());
		}
		return a;
	}

}
