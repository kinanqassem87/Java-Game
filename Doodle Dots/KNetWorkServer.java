import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KNetWorkServer extends UnicastRemoteObject implements MouseListener, Play{
	
	private JFrame frame = null;  //  @jve:decl-index=0:visual-constraint="36,12"
	private JPanel jContentPane = null;
	
	
	private JButton btend = null;
	int turn = 1;
	private JLabel lblTurn = null;
	String p1Name;
	JLabel[][] map = new JLabel[5][5];
	JLabel[][] cell = new JLabel[4][4];
	JLabel[][] vLabels = new JLabel[5][4];
	JLabel[][] hLabels = new JLabel[5][4];
	int score1 = 0, score2 = 0;
	Play other;
	/**
	 * This method initializes btend	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtend() {
		if (btend == null) {
			btend = new JButton();
			btend.setBounds(new java.awt.Rectangle(297,279,82,28));
			btend.setText("end");
			btend.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btend;
	}

	
	public KNetWorkServer(String p1) throws RemoteException {
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
			//Naming.rebind("server", this);
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
						//other = (Play) Naming.lookup("client");
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
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			for(int i=1; i<5; i++){
				for(int j=1; j<5; j++){
					map[i][j] = new JLabel();
					map[i][j].setName("la"+i+j);
					map[i][j].setIcon(new ImageIcon("F:/Java/workspace/KinanGame/black.jpg"));
					map[i][j].setBounds(new java.awt.Rectangle(108+(i-1)*47, 144+(j-1)*36, 10, 10));
					jContentPane.add(map[i][j]);
				}
			}
			
			for(int i=1; i<5; i++){
				for(int j=1; j<4; j++){
					vLabels[i][j] = new JLabel();
					vLabels[i][j].setName("v"+i+j);
					vLabels[i][j].setBounds(new java.awt.Rectangle(117+(j-1)*47, 144+(i-1)*36, 36, 10));
					//System.out.println(vLabels[i][j].getName() + ":" + vLabels[i][j].getBounds().x + ", " + vLabels[i][j].getBounds().y);
					vLabels[i][j].addMouseListener(this);
					jContentPane.add(vLabels[i][j]);
				}
			}
			
			for(int i=1; i<5; i++){
				for(int j=1; j<4; j++){
					hLabels[i][j] = new JLabel();
					hLabels[i][j].setName("h"+i+j);
					hLabels[i][j].setBounds(new java.awt.Rectangle(108+(i-1)*47, 153+(j-1)*36, 10, 36));
					//System.out.println(hLabels[i][j].getName() + ":" + hLabels[i][j].getBounds().x + ", " + hLabels[i][j].getBounds().y);
					hLabels[i][j].addMouseListener(this);
					jContentPane.add(hLabels[i][j]);
				}
			}
			
			for(int i=1; i<4; i++){
				for(int j=1; j<4; j++){
					cell[i][j] = new JLabel();
					cell[i][j].setName("c"+i+j);
					cell[i][j].setBounds(new java.awt.Rectangle(117+(i-1)*47, 153+(j-1)*36, 36, 28));
					jContentPane.add(cell[i][j]);
				}
			}
			
			
		
			jContentPane.add(getBtend(), null);
			jContentPane.add(lblTurn, null);
			
		}
		return jContentPane;
	}

	public void mouseClicked(MouseEvent e) {
		
		JLabel selected = (JLabel) e.getSource();
		System.out.println(selected.getName());
		if (turn == 1) {
			if (selected.getIcon()==null) {
				ImageIcon img = new ImageIcon("F:/Java/workspace/KinanGame/green.jpg");
				selected.setIcon(img);
				int res = win(" win");
				if (res == 0) {
					// labturn.setText("Turn: Player1");
					turn = 2;
				} else {
					score1 += res;
					// jLabel3.setText(""+score2);
				}
			}
			if (score1 + score2 == 9) {

				String winner = (score1 > score2) ? "You Win" : "You Lose";
				JOptionPane.showMessageDialog(frame, winner);
			}
			// ////////

			try {
				other.play(selected.getName());
			} catch (Exception ex) {
				ex.printStackTrace();
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

	
	public int win(String status){
		int result = 0;
		for(int i=1;i<4;i++){
			for(int j=1;j<4;j++){
				
				if((hLabels[i][j].getIcon()!=null)&&(hLabels[i+1][j].getIcon()!=null)&&(vLabels[j][i].getIcon()!=null)&&(vLabels[j+1][i].getIcon()!=null)&&(cell[i][j].getText().equals(""))){
					cell[i][j].setText(status);
					result++;
				}
			}
		}
		return result;
	}
	
	public void play(String pos) throws RemoteException {
		int num = Integer.parseInt(pos.substring(1, pos.length()));
		int i = num/10;
		int j = num%10;
		char direction = pos.charAt(0);
		System.out.println(i + " ," + j +  "d: " + direction);
		ImageIcon img = new ImageIcon("F:/Java/workspace/KinanGame/red.jpg");
		if(direction == 'v'){
			vLabels[i][j].setIcon(img);	
		}else if(direction == 'h'){
			hLabels[i][j].setIcon(img);
		}
		int res = win(" lose");
		if (res == 0) {
			// labturn.setText("Turn: Player1");
			turn = 1;
		} else {
			score2 += res;
			// jLabel3.setText(""+score2);
		}
		if (score1 + score2 == 9) {

			String winner = (score1 > score2) ? "You Win" : "You Lose";
			JOptionPane.showMessageDialog(frame, winner);
		}

	}
	
	public static void main(String... args) throws RemoteException{
		new KNetWorkServer("A");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
