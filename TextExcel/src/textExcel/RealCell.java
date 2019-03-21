package textExcel;

public class RealCell implements Cell {

	private String cell;
	
	public RealCell(String input) {
		this.cell = input;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String stringcell = cell;
		stringcell += "          ";
		return stringcell;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;           
	}

}
