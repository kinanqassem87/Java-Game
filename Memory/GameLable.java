import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameLable extends JLabel{
	private String value;
	private String currState;

	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value = value;
	}

	public String getCurrState() {
		return currState;
	}
	public void setCurrState(String currState) {
		this.currState = currState;
		String imagePath = "img/";
		if(currState.equals("closed")) {
			imagePath += "X.jpg";
		} else {
			imagePath += getValue() + ".jpg";
		}
		this.setIcon(new ImageIcon(imagePath));
	}
}
