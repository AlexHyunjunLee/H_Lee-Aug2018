package textExcel;

public class PercentCell extends RealCell {
	private String percent;
	public PercentCell(String percentString) {
		super(percentString);
		percent = percentString;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String abbrevPercent = percent;
		int count = abbrevPercent.length();
		if(count> 10) {
			abbrevPercent = percent.substring(0,8);
			abbrevPercent += "%";
		}
		return abbrevPercent;
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		double cellContents = Double.parseDouble(percent.substring(0, percent.length()-2));
		cellContents /= 100;
		return cellContents + "";
	}
}
