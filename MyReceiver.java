import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyReceiver
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(1234);
			byte b[]=new byte[10];
			String msg="";
			DatagramPacket pack=null;
			
			pack=new DatagramPacket(b,b.length);
			ds.receive(pack);
			b=pack.getData();
			msg=new String(b);
			
			StringBuffer sb=new StringBuffer(msg);
			String rev=""+sb.reverse();
			
			b=rev.getBytes();
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,4321);
			ds.send(pack);
			
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Receiver error : "+e.getMessage());
		}
	}
}