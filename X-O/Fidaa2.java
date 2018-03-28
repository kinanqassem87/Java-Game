import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fidaa2 extends JFrame implements MouseListener{

	private JPanel jContentPane = null;
	private JLabel la11 = null;
	private JLabel la12 = null;
	private JLabel la13 = null;
	private JLabel la21 = null;
	private JLabel la22 = null;
	private JLabel la23 = null;
	private JLabel la31 = null;
	private JLabel la32 = null;
	private JLabel la33 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JButton btend = null;
	int turn = 1;
	private JLabel lblTurn = null;
	String p1Name, p2Name;
	Map<String, JLabel> map = new HashMap<String, JLabel>();
	/**
	 * This method initializes btend	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtend() {
		if (btend == null) {
			btend = new JButton();
			btend.setBounds(new java.awt.Rectangle(262,239,82,37));
			btend.setText("end");
			btend.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btend;
	}

	
	public Fidaa2(String p1, String p2) {
		super();
		initialize();
		p1Name = p1;
		p2Name = p2;
		lblTurn.setText(p1Name);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 359);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setVisible(true);
		la11.addMouseListener(this);
		la12.addMouseListener(this);
		la13.addMouseListener(this);
		la21.addMouseListener(this);
		la22.addMouseListener(this);
		la23.addMouseListener(this);
		la31.addMouseListener(this);
		la32.addMouseListener(this);
		la33.addMouseListener(this);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblTurn = new JLabel();
			lblTurn.setBounds(new java.awt.Rectangle(123,15,160,28));
			lblTurn.setFont(new java.awt.Font("Dotum", java.awt.Font.BOLD, 18));
			jLabel8 = new JLabel();
			jLabel8.setBounds(new java.awt.Rectangle(72,54,10,145));
			jLabel8.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel8.setText("-");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new java.awt.Rectangle(81,189,235,10));
			jLabel7.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel7.setText("---------------------------------------------------------");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new java.awt.Rectangle(315,54,10,145));
			jLabel6.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel6.setText("-");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new java.awt.Rectangle(81,54,235,10));
			jLabel5.setBackground(java.awt.Color.black);
			jLabel5.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel5.setText("--------------------------------------------------------");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(81,144,235,10));
			jLabel4.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel4.setText("---------------------------------------------------------");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(81,99,235,10));
			jLabel3.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel3.setText("--------------------------------------------------------");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(234,63,10,127));
			jLabel2.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel2.setText("-");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(153,63,10,127));
			jLabel1.setIcon(new ImageIcon("F:/Untitled.jpg"));
			jLabel1.setText("-");
			la33 = new JLabel();
			la33.setBounds(new java.awt.Rectangle(243,153,73,37));
			la33.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la33.setForeground(new java.awt.Color(255,51,51));
			la33.setName("la33");
			la33.setText("");
			la32 = new JLabel();
			la32.setBounds(new java.awt.Rectangle(162,153,73,37));
			la32.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 48));
			la32.setForeground(new java.awt.Color(255,51,51));
			la32.setName("la32");
			la32.setText("");
			la31 = new JLabel();
			la31.setBounds(new java.awt.Rectangle(81,153,73,37));
			la31.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la31.setForeground(new java.awt.Color(255,51,51));
			la31.setName("la31");
			la31.setText("");
			la23 = new JLabel();
			la23.setBounds(new java.awt.Rectangle(243,108,73,37));
			la23.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la23.setForeground(new java.awt.Color(255,51,51));
			la23.setName("la23");
			la23.setText("");
			la22 = new JLabel();
			la22.setBounds(new java.awt.Rectangle(162,108,73,37));
			la22.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la22.setForeground(new java.awt.Color(255,51,51));
			la22.setName("la22");
			la22.setText("");
			la21 = new JLabel();
			la21.setBounds(new java.awt.Rectangle(81,108,73,37));
			la21.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la21.setForeground(new java.awt.Color(255,51,51));
			la21.setName("la21");
			la21.setText("");
			la13 = new JLabel();
			la13.setBounds(new java.awt.Rectangle(243,63,73,37));
			la13.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la13.setForeground(new java.awt.Color(255,51,51));
			la13.setName("la13");
			la13.setText("");
			la12 = new JLabel();
			la12.setBounds(new java.awt.Rectangle(162,63,73,37));
			la12.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la12.setForeground(new java.awt.Color(255,51,51));
			la12.setName("la12");
			la12.setText("");
			la11 = new JLabel();
			la11.setBounds(new java.awt.Rectangle(81,63,73,37));
			la11.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
			la11.setForeground(new java.awt.Color(255,51,51));
			la11.setName("la11");
			la11.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(la11, null);
			jContentPane.add(la12, null);
			jContentPane.add(la13, null);
			jContentPane.add(la21, null);
			jContentPane.add(la22, null);
			jContentPane.add(la23, null);
			jContentPane.add(la31, null);
			jContentPane.add(la32, null);
			jContentPane.add(la33, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(getBtend(), null);
			jContentPane.add(lblTurn, null);
			map.put("11", la11);map.put("12", la11);map.put("13", la11);
			map.put("21", la11);map.put("22", la21);map.put("23", la23);
			map.put("31", la31);map.put("32", la32);map.put("33", la33);
		}
		return jContentPane;
	}

	public void mouseClicked(MouseEvent e) {

		JLabel selected = (JLabel)e.getComponent();
		if (selected.getText().equals("")){
			if(turn == 1){
				selected.setText(" X");
				if(isFinish(" X")){
					JOptionPane.showMessageDialog(null, p1Name + " Win");
					System.exit(0);
				}
				else{
					turn = 2;
					lblTurn.setText(p2Name);
				}
				
			}else{
				selected.setText(" O");
				if(isFinish(" O")){
					JOptionPane.showMessageDialog(null, p2Name + " Win");
					System.exit(0);
				}
				else{
					turn = 1;
					lblTurn.setText(p1Name);
				}
				
			}
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
	
	public boolean isFinish(String sign){
		boolean line1 = la11.getText().equals(sign) && la12.getText().equals(sign) && la13.getText().equals(sign); 
		boolean line2 = la21.getText().equals(sign) && la22.getText().equals(sign) && la23.getText().equals(sign);
		boolean line3 = la31.getText().equals(sign) && la32.getText().equals(sign) && la33.getText().equals(sign);
		boolean col1 = la11.getText().equals(sign) && la21.getText().equals(sign) && la31.getText().equals(sign);
		boolean col2 = la12.getText().equals(sign) && la22.getText().equals(sign) && la32.getText().equals(sign);
		boolean col3 = la13.getText().equals(sign) && la23.getText().equals(sign) && la33.getText().equals(sign);
		boolean basic = la11.getText().equals(sign) && la22.getText().equals(sign) && la33.getText().equals(sign);
		boolean minor = la13.getText().equals(sign) && la22.getText().equals(sign) && la31.getText().equals(sign);
		return line1 || line2 || line3 || col1 || col2 || col3 || basic || minor;
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
