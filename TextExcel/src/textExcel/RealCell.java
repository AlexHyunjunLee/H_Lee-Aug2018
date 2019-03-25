package textExcel;

public class RealCell implements Cell {

	private String cell;
	
	public RealCell(String input) {
		this.cell = input;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String stringcell = getDoubleValue()+"";
		stringcell += "          ";
		return stringcell.substring(0, 9);
	}

	private double getDoubleValue() {
		return Double.parseDouble(cell);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return cell;           
	}

}
