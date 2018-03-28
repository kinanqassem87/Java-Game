import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClientGame extends UnicastRemoteObject implements MouseListener, Play {

	private JFrame frame = null;
	private JPanel jContentPane = null;
	

	private GameLable[][] labels = new GameLable[4][5];
	
	int turn =1;
	int score1 = 0, score2 = 0;
	ArrayList<String> values = new ArrayList<String>();
	ArrayList<String> randomValues = new ArrayList<String>();
	ArrayList<GameLable> selectedLabels = new ArrayList<GameLable>();
	private JLabel jLabel = null;
	
	private JLabel lblScore1 = null;
	private JLabel lblScore2 = null;
	
	Play other;
	/**
	 * This is the default constructor
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		new ClientGame();

	}
	public ClientGame() throws RemoteException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		try {
			
			Naming.rebind("client", this);
			JOptionPane.showMessageDialog(null, "Client is ready");
			other = (Play) Naming.lookup("server");
			JOptionPane.showMessageDialog(null, "Connection ok...");
			randomValues = getRandoms(other.getRandomValues());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setSize(438, 501);
		frame.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		frame.setContentPane(getJContentPane());
		frame.setTitle("JFrame");
		frame.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblScore2 = new JLabel();
			lblScore2.setBounds(new java.awt.Rectangle(360,432,46,19));
			lblScore2.setText("0");
			lblScore1 = new JLabel();
			lblScore1.setBounds(new java.awt.Rectangle(18,432,46,19));
			lblScore1.setText("0");
			int k = 0;
			for(int j=1;j<5;j++){
				for(int i=1;i<4;i++){
					labels[i][j] = new GameLable();
					labels[i][j].setValue(randomValues.get(k));
					labels[i][j].setName("l" + i + j);
					labels[i][j].setCurrState("closed");
					labels[i][j].setBounds(new Rectangle(90 + 99*(i-1), 117 + 72*(j-1), 95, 69));
					labels[i][j].addMouseListener(this);
					k++;
				}
			}
			
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(153,72,87,23));
			jLabel.setText("Player 1");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(lblScore1, null);
			jContentPane.add(lblScore2, null);
			for(int j=1;j<5;j++){
				for(int i=1;i<4;i++){
					jContentPane.add(labels[i][j], null);
				}
			}
		}
		return jContentPane;
	}

	public void mouseClicked(MouseEvent e) {
		GameLable selected;
		selected = (GameLable)e.getComponent();

		if (turn == 2) {
			if (selectedLabels.size() == 0) {
				if (selected.getCurrState().equals("closed")) {
					selected.setCurrState("opened");
					selectedLabels.add(selected);
				}
			} else if (selectedLabels.size() == 1) {
				if (selected.getCurrState().equals("closed")) {
					selected.setCurrState("opened");
					selectedLabels.add(selected);
				}
			} else {
				if (selectedLabels.get(0).getValue().equals(selectedLabels.get(1).getValue())) {
					selectedLabels.get(0).setCurrState("finished");
					selectedLabels.get(1).setCurrState("finished");
					score2++;
					lblScore2.setText("p2: " + score2);
				} else {
					for (int i = 0; i < selectedLabels.size(); i++) {
						selectedLabels.get(i).setCurrState("closed");
					}
				}
				selectedLabels = new ArrayList<GameLable>();
				turn = 1;
				jLabel.setText("Player 1");
				isFinish();
			}
			try{
				other.play(selected.getName());
			} catch(Exception ex){
				
			}
		}
		
	}
	private void isFinish() {
		// if the score of the two players is 6 then end the game
		if(score1+score2==6){
			if(score1>score2){
				JOptionPane.showMessageDialog(null, "Player 1 won");
			}else if(score1<score2){
				JOptionPane.showMessageDialog(null, "Player 2 won");
			}else{
				JOptionPane.showMessageDialog(null, "Draw");
			}
			frame.dispose();
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<String> random(ArrayList<String> values){
		ArrayList<String> returnValues = new ArrayList<String>();
		while(values.size()>0){
			int randPos = (int) (Math.random()*(values.size()-1));
			returnValues.add(values.get(randPos));
			values.remove(randPos);
		}
		return returnValues;
	}
	public void play(String pos) throws RemoteException {
		int num = Integer.parseInt(pos.substring(1, pos.length()));
		int i = num/10;
		int j = num%10;
		if (selectedLabels.size() == 0) {
			if (labels[i][j].getCurrState().equals("closed")) {
				labels[i][j].setCurrState("opened");
				selectedLabels.add(labels[i][j]);
			}
		} else if (selectedLabels.size() == 1) {
			if (labels[i][j].getCurrState().equals("closed")) {
				labels[i][j].setCurrState("opened");
				selectedLabels.add(labels[i][j]);
			}
		} else {
			if (selectedLabels.get(0).getValue().equals(selectedLabels.get(1).getValue())) {
				selectedLabels.get(0).setCurrState("finished");
				selectedLabels.get(1).setCurrState("finished");
				score1++;
				lblScore1.setText("p1: " + score1);
			} else {
				for (int k = 0; k < selectedLabels.size(); k++) {
					selectedLabels.get(k).setCurrState("closed");
				}
			}
			selectedLabels = new ArrayList<GameLable>();
			turn = 2;
			jLabel.setText("Player 2");
			isFinish();
		}
		
	}
	public String getRandomValues() throws RemoteException {
		return null;	
	}
	public ArrayList<String> getRandoms(String string){
		randomValues = new ArrayList<String>();
		for(int i=0; i<string.length(); i++){
			String s = String.valueOf(string.charAt(i));
			randomValues.add(s);
		}
		return randomValues;
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,-8"
