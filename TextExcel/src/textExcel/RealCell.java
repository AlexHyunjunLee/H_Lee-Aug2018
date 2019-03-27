package textExcel;

public class RealCell implements Cell {

	private String cell;
	
	public RealCell(String input) {
		this.cell = input;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String newCellContents = cell;
		if(cell.length() > 10) {
			return(cell.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - cell.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
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
