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
		String newCellContents = text;
		if (text.contains("\"")){
			newCellContents = text.substring(1, text.length()-1);
		}
		int count = newCellContents.length();
		if(count> 10) {
			return(newCellContents.substring(0, 10));
		} else {
			for(int i = 0; i < 10 - count; i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	}

	public void s(){
		String value = text.substring(0, text.length()-1);
		value += "          ";
		String abbrevText = value.substring(0, 9);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}
	public void setContents(String newContents){
		text = newContents;
	}

}
