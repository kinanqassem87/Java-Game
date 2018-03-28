import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.net.NetworkServer;

public class NetWorkServer extends UnicastRemoteObject implements MouseListener, Play{
	
	private JFrame frame = null;
	private JPanel jContentPane = null;
	
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
	String p1Name;
	JLabel[][] map = new JLabel[4][4];
	Play other;
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

	
	public NetWorkServer(String p1) throws RemoteException {
		super();
		initialize();
		p1Name = p1;
		lblTurn.setText(p1Name);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(400, 359);
		frame.setContentPane(getJContentPane());
		frame.setTitle("JFrame");
		frame.setVisible(true);
		
		try {
			if(System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			Naming.rebind("//192.168.0.2/server", this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Server is ready");
		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){

			
			public void run(){
				if(other==null){
					try{
						other = (Play) Naming.lookup("//192.168.0.1/client");
						JOptionPane.showMessageDialog(null, "Connection ok...");
						timer.cancel();
					}catch(Exception ex){
						
					}
					
				}
				
			}
			
		}, 20000, 20000);
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
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//—’› «·⁄‰«’— ⁄·Ï «·Ê«ÃÂ…
			for(int i=1; i<4; i++){
				for(int j=1; j<4; j++){
					map[i][j] = new JLabel();
					map[i][j].setName("la"+i+j);
					map[i][j].setText("");
					map[i][j].setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48));
					map[i][j].setForeground(new java.awt.Color(255,51,51));
					map[i][j].addMouseListener(this);
					map[i][j].setBounds(new java.awt.Rectangle(81*i, 63+(j-1)*45, 73, 37));
					jContentPane.add(map[i][j]);
				}
			}
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
			
		}
		return jContentPane;
	}

	public void mouseClicked(MouseEvent e) {
		//⁄‰œ «·‰ﬁ— ⁄·Ï √Õœ «·⁄‰«’—
		JLabel selected = (JLabel)e.getSource();
		System.out.println(selected.getName());
		if (turn == 1){
			if(selected.getText().equals("")){
				selected.setText(" X");
				if(isFinish(" X")){
					JOptionPane.showMessageDialog(null, p1Name + " Win");
				}
				turn = 2;
				try {
					other.play(selected.getName());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		boolean line1 = map[1][1].getText().equals(sign) && map[1][2].getText().equals(sign) && map[1][3].getText().equals(sign); 
		boolean line2 = map[2][1].getText().equals(sign) && map[2][2].getText().equals(sign) && map[2][3].getText().equals(sign);
		boolean line3 = map[3][1].getText().equals(sign) && map[3][2].getText().equals(sign) && map[3][3].getText().equals(sign);
		boolean col1 = map[1][1].getText().equals(sign) && map[2][1].getText().equals(sign) && map[3][1].getText().equals(sign);
		boolean col2 = map[1][2].getText().equals(sign) && map[2][2].getText().equals(sign) && map[3][2].getText().equals(sign);
		boolean col3 = map[1][3].getText().equals(sign) && map[2][3].getText().equals(sign) && map[3][3].getText().equals(sign);
		boolean basic = map[1][1].getText().equals(sign) && map[2][2].getText().equals(sign) && map[3][3].getText().equals(sign);
		boolean minor = map[1][3].getText().equals(sign) && map[2][2].getText().equals(sign) && map[3][1].getText().equals(sign);
		return line1 || line2 || line3 || col1 || col2 || col3 || basic || minor;	
	}


	public void play(String pos) throws RemoteException {
		int num = Integer.parseInt(pos.substring(2, pos.length()));
		int i = num/10;
		int j = num%10;
		turn = 1;
		map[i][j].setText(" O");
		if(isFinish(" O")){
			JOptionPane.showMessageDialog(null, p1Name + " Lose");
			System.exit(0);
		}
	}
	
	public static void main(String... args) throws RemoteException{
		new NetWorkServer("A");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
