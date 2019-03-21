package textExcel;

public class ValueCell extends RealCell {
	private String value;
	public ValueCell(String valueInput) {
		super(valueInput);
		value = valueInput;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return "          ";
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
	}
}
