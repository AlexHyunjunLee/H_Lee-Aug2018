package textExcel;

public class PercentCell extends RealCell {
	private String percent;
	public PercentCell(String percentString) {
		super(percentString);
		percent = percentString;
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
