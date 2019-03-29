// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class RealCell implements Cell {

	private String cell;
	
	public RealCell(String input) {
		this.cell = input;
	}
	
	@Override
	public String abbreviatedCellText() {
		String newCellContents = cell;
		if(cell.length() > 10) {
			return(cell.substring(0, 10));
		}
		else {
			newCellContents += "          ";
			return (newCellContents.substring(0, 10));
		}
	}

	public double getDoubleValue() {
		return Double.parseDouble(cell);
	}
	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		String newCellContents = cell;
		return newCellContents;          
	}
	public String getUserInput() {
		return cell;
	}

}