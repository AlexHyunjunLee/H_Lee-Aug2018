// @author Alex Lee
// @version March 19, 2019
//This class contain methods for the real cell

package textExcel;

public class RealCell implements Cell, Comparable<Object> {
	private String cell;
	//constructor
	public RealCell(String input) {
		this.cell = input;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String cellContents = cell+= "          ";//adds 10 spaces in order to fill up the needed part;
		return (cellContents.substring(0, 10));
	}
	//Returns the double value of a real cell
	public double getDoubleValue() {
		return Double.parseDouble(cell);
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return cell;          
	}
	@Override
	public int compareTo(Object str) {
		RealCell you = (RealCell) str;
		double comparison = this.getDoubleValue()-you.getDoubleValue();
		System.out.println(comparison);
		return (int) comparison;
	}

}