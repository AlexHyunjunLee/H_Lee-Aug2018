package textExcel;

public class ValueCell extends RealCell {
	private double value;
	public ValueCell(double valueInput) {
		super("" + valueInput);
		value = valueInput;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String doubleValue = value+"          ";
		doubleValue.substring(0, 9);
		return doubleValue;
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
	}
}
