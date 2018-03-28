import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Fidaa extends JFrame {

	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JRadioButton rb1p = null;
	private JRadioButton rbnp = null;
	private JRadioButton rb2p = null;
	private JButton btrun = null;
	private JButton btexit = null;
	private JButton btinst = null;
	ButtonGroup group = new ButtonGroup();
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField txtPlayer1 = null;
	private JTextField txtPlayer2 = null;

	/**
	 * This method initializes rd1p	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRb1p() {
		if (rb1p == null) {
			rb1p = new JRadioButton();
			rb1p.setBounds(new java.awt.Rectangle(9,99,109,28));
			rb1p.setText("1 player");
		}
		return rb1p;
	}

	/**
	 * This method initializes rbnp	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRbnp() {
		if (rbnp == null) {
			rbnp = new JRadioButton();
			rbnp.setBounds(new java.awt.Rectangle(135,99,127,28));
			rbnp.setSelected(false);
			rbnp.setText("network player");
		}
		return rbnp;
	}

	/**
	 * This method initializes rb2p	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRb2p() {
		if (rb2p == null) {
			rb2p = new JRadioButton();
			rb2p.setBounds(new java.awt.Rectangle(279,99,109,28));
			rb2p.setSelected(true);
			rb2p.setText("2 player");
		}
		return rb2p;
	}

	/**
	 * This method initializes btrun	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtrun() {
		if (btrun == null) {
			btrun = new JButton();
			btrun.setBounds(new java.awt.Rectangle(81,243,208,55));
			btrun.setText("run");
			btrun.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new Fidaa2(txtPlayer1.getText(), txtPlayer2.getText()); // TODO Auto-generated Event stub actionPerformed()
					dispose();
				}
			
			});
			
		}
		return btrun;
	}

	/**
	 * This method initializes btexit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtexit() {
		if (btexit == null) {
			btexit = new JButton();
			btexit.setBounds(new java.awt.Rectangle(9,324,91,28));
			btexit.setText("exit");
			btexit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit (0); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btexit;
	}

	/**
	 * This method initializes btinst	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtinst() {
		if (btinst == null) {
			btinst = new JButton();
			btinst.setBounds(new java.awt.Rectangle(261,324,118,28));
			btinst.setText("instruction");
			btinst.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null,"not ready"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btinst;
	}

	/**
	 * This method initializes txtPlayer1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPlayer1() {
		if (txtPlayer1 == null) {
			txtPlayer1 = new JTextField();
			txtPlayer1.setBounds(new java.awt.Rectangle(108,144,145,19));
			txtPlayer1.setText("");
		}
		return txtPlayer1;
	}

	/**
	 * This method initializes txtPlayer2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPlayer2() {
		if (txtPlayer2 == null) {
			txtPlayer2 = new JTextField();
			txtPlayer2.setBounds(new java.awt.Rectangle(108,180,145,19));
			txtPlayer2.setText("");
		}
		return txtPlayer2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fidaa();

	}

	/**
	 * This is the default constructor
	 */
	public Fidaa() {
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
		this.setTitle("XO Game");
		this.setVisible(true);
		group.add(rb1p);
		group.add(rb2p);
		group.add(rbnp);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(27,180,73,19));
			jLabel2.setText("Player2 :");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(27,144,73,19));
			jLabel1.setText("Player1 :");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(45,18,298,64));
			jLabel.setFont(new java.awt.Font("Dotum", java.awt.Font.BOLD | java.awt.Font.ITALIC, 24));
			jLabel.setText("    fidaa's X-O game");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getRb1p(), null);
			jContentPane.add(getRbnp(), null);
			jContentPane.add(getRb2p(), null);
			jContentPane.add(getBtrun(), null);
			jContentPane.add(getBtexit(), null);
			jContentPane.add(getBtinst(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getTxtPlayer1(), null);
			jContentPane.add(getTxtPlayer2(), null);
		}
		return jContentPane;
	}

}
