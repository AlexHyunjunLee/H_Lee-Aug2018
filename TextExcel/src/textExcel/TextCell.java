// @author Alex Lee
// @version March 12, 2019

package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	public String abbreviatedCellText() {
		String newCellContents = text;
		if (text.contains("\"")){
			newCellContents = text.substring(1, text.length()-1);
		}
		int count = newCellContents.length();
		if(count> 10) {
			return(newCellContents.substring(0, 10));
		} else {
				newCellContents += "          ";
			return (newCellContents.substring(0, 10));
		}
	}
	public String fullCellText() {
		return text;
	}
	public void setContents(String newContents){
		text = newContents;
	}

}