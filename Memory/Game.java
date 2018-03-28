import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Game extends JFrame {

	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JRadioButton rds = null;
	private JRadioButton rdt = null;
	private JButton btstart = null;
	private JButton btexit = null;
	private JButton bthelp = null;
	ButtonGroup rdGroup=new ButtonGroup();

	/**
	 * This is the default constructor
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Game();
	}
	public Game() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setVisible(true);
		rdGroup.add(rds);
		rdGroup.add(rdt);
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(63,39,271,34));
			jLabel.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD | java.awt.Font.ITALIC, 18));
			jLabel.setForeground(new java.awt.Color(137,220,51));
			jLabel.setText("       Memory Game");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getRds(), null);
			jContentPane.add(getRdt(), null);
			jContentPane.add(getBtstart(), null);
			jContentPane.add(getBtexit(), null);
			jContentPane.add(getBthelp(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes rds	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRds() {
		if (rds == null) {
			rds = new JRadioButton();
			rds.setBounds(new java.awt.Rectangle(45,117,101,21));
			rds.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 12));
			rds.setSelected(true);
			rds.setText("One Player");
		}
		return rds;
	}

	/**
	 * This method initializes rdt	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRdt() {
		if (rdt == null) {
			rdt = new JRadioButton();
			rdt.setBounds(new java.awt.Rectangle(225,117,109,21));
			rdt.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 12));
			rdt.setText("Tow Player");
		}
		return rdt;
	}

	/**
	 * This method initializes btstart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtstart() {
		if (btstart == null) {
			btstart = new JButton();
			btstart.setBounds(new java.awt.Rectangle(54,215,73,65));
			btstart.setText("Start");
			btstart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Game2();
					dispose();// TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btstart;
	}

	/**
	 * This method initializes btexit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtexit() {
		if (btexit == null) {
			btexit = new JButton();
			btexit.setBounds(new java.awt.Rectangle(261,216,69,65));
			btexit.setText("Exit");
			btexit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btexit;
	}

	/**
	 * This method initializes bthelp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBthelp() {
		if (bthelp == null) {
			bthelp = new JButton();
			bthelp.setBounds(new java.awt.Rectangle(153,279,73,55));
			bthelp.setText("Help");
			bthelp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null,"not ready yet"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return bthelp;
	}

}
