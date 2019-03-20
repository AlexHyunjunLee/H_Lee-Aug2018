package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell() {
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