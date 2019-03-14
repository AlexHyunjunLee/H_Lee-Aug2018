// @author Alex Lee
// @version March 12, 2019

package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String value = text.substring(0, text.length()-1);
		value += "          ";
		String abbrevText = value.substring(0, 9);
		return abbrevText;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}

}
