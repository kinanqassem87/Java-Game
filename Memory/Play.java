import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Play extends Remote{
	public void play(String pos) throws RemoteException;
	public String getRandomValues() throws RemoteException;
}
