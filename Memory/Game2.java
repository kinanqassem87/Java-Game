import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game2 extends JFrame implements MouseListener {

	private JPanel jContentPane = null;
	private JButton btnew = null;
	private JButton btback = null;
	
	private JLabel l2 = null;
	private JLabel l8 = null;
	private JLabel l5 = null;
	private JLabel l3 = null;
	private JLabel l1 = null;
	private JLabel l9 = null;
	private JLabel l4 = null;
	private JLabel l7 = null;
	private JLabel l10 = null;
	private JLabel l6 = null;
	private JLabel l11 = null;
	private JLabel l12 = null;
	
	int turn =1;
	int score1 = 0, score2 = 0;
	ArrayList<String> values = new ArrayList<String>();
	ArrayList<String> randomValues = new ArrayList<String>();
	ArrayList<JLabel> selectedLabels = new ArrayList<JLabel>();
	private JLabel jLabel = null;
	
	private JLabel lblScore1 = null;
	private JLabel lblScore2 = null;
	/**
	 * This is the default constructor
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game2();

	}
	public Game2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(438, 501);
		this.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setVisible(true);
		l1.addMouseListener(this);
		l2.addMouseListener(this);
		l3.addMouseListener(this);
		l4.addMouseListener(this);
		l5.addMouseListener(this);
		l6.addMouseListener(this);
		l7.addMouseListener(this);
		l8.addMouseListener(this);
		l9.addMouseListener(this);
		l10.addMouseListener(this);
		l11.addMouseListener(this);
		l12.addMouseListener(this);
		values.add("A");values.add("B");values.add("C");values.add("D");values.add("E");values.add("F");
		values.add("A");values.add("B");values.add("C");values.add("D");values.add("E");values.add("F");
		randomValues = random(values);
		for(int i=0;i<12;i++){
			System.out.println(randomValues.get(i));
		}
		
		
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
			l12 = new JLabel();
			l12.setBounds(new java.awt.Rectangle(288,117,95,69));
			l12.setText("???");
			l11 = new JLabel();
			l11.setBounds(new java.awt.Rectangle(189,117,95,69));
			l11.setText("???");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(153,72,87,23));
			jLabel.setText("Player 1");
			l6 = new JLabel();
			l6.setBounds(new java.awt.Rectangle(189,261,95,69));
			//l6.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l6.setName("l6");
			l6.setText("???");
			l10 = new JLabel();
			l10.setBounds(new java.awt.Rectangle(90,333,95,69));
			//l10.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l10.setName("l10");
			l10.setText("???");
			l7 = new JLabel();
			l7.setBounds(new java.awt.Rectangle(189,333,95,69));
			//l7.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l7.setName("l7");
			l7.setText("???");
			l4 = new JLabel();
			l4.setBounds(new java.awt.Rectangle(288,333,95,69));
			l4.setName("l4");
			//l4.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l4.setText("???");
			l9 = new JLabel();
			l9.setBounds(new java.awt.Rectangle(90,261,95,69));
			//l9.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l9.setName("l9");
			l9.setText("???");
			l1 = new JLabel();
			l1.setBounds(new java.awt.Rectangle(90,189,95,69));
			//l1.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l1.setName("l1");
			l1.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
			l1.setText("???");
			l3 = new JLabel();
			l3.setBounds(new java.awt.Rectangle(288,261,95,69));
			//l3.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l3.setName("l3");
			l3.setText("???");
			l5 = new JLabel();
			l5.setBounds(new java.awt.Rectangle(189,189,95,69));
			//l5.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l5.setName("l5");
			l5.setText("???");
			l8 = new JLabel();
			l8.setBounds(new java.awt.Rectangle(90,117,95,69));
			//l8.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l8.setName("l8");
			l8.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
			l8.setText("???");
			l2 = new JLabel();
			l2.setBounds(new java.awt.Rectangle(288,189,95,69));
			//l2.setIcon(new ImageIcon("D:/my pic/i_have_no_idea.jpg"));
			l2.setName("l2");
			l2.setText("???");

			l11.setName("l11");
			l12.setName("l12");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnew(), null);
			jContentPane.add(getBtback(), null);
			jContentPane.add(l2, null);
			jContentPane.add(l8, null);
			jContentPane.add(l5, null);
			jContentPane.add(l3, null);
			jContentPane.add(l1, null);
			jContentPane.add(l9, null);
			jContentPane.add(l4, null);
			jContentPane.add(l7, null);
			jContentPane.add(l10, null);
			jContentPane.add(l6, null);
			jContentPane.add(jLabel, null);
			jContentPane.add(l11, null);
			jContentPane.add(l12, null);
			jContentPane.add(lblScore1, null);
			jContentPane.add(lblScore2, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes btnew	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnew() {
		if (btnew == null) {
			btnew = new JButton();
			btnew.setBounds(new java.awt.Rectangle(9,10,72,40));
			btnew.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 12));
			btnew.setText("New");
			btnew.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Game2();
					dispose();// TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btnew;
	}

	/**
	 * This method initializes btback	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtback() {
		if (btback == null) {
			btback = new JButton();
			btback.setBounds(new java.awt.Rectangle(333,10,72,40));
			btback.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 12));
			btback.setText("Back");
			btback.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Game();
					dispose();// TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btback;
	}
	public void mouseClicked(MouseEvent e) {
		JLabel selected;
		ImageIcon img;
		selected = (JLabel)e.getComponent();
	
		int labelNo = Integer.parseInt(selected.getName().substring(1));
		if(selectedLabels.size()==0){
			if(selected.getText().equals("???")){
				selected.setText(randomValues.get(labelNo-1));
				selectedLabels.add(selected);
			 }
		}else if(selectedLabels.size()==1){
			if(selected.getText().equals("???")){
				selected.setText(randomValues.get(labelNo-1));
				selectedLabels.add(selected);
			 }
		}else{
			if(selectedLabels.get(0).getText().equals(selectedLabels.get(1).getText())){
				if(turn==1){
					score1++;
					lblScore1.setText("p1: "+score1);
				}else{
					score2++;
					lblScore2.setText("p2: "+score2);
				}
			}else{
				for(int i=0; i<selectedLabels.size(); i++){
					
					selectedLabels.get(i).setText("???");
				}
			}
			selectedLabels = new ArrayList<JLabel>();
			if(turn == 1){
				turn = 2;
				jLabel.setText("Player 2");
			}else{
				turn = 1;
				jLabel.setText("Player 1");
			}
			
			isFinish();
			
		}
		 
		// TODO Auto-generated method stub
		
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
			dispose();
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
			//System.out.println(values.size());
			int randPos = (int) (Math.random()*(values.size()-1));
			//System.out.println(randPos);
			returnValues.add(values.get(randPos));
			values.remove(randPos);
		}
		return returnValues;
	}

}  //  @jve:decl-index=0:visual-constraint="10,-8"
