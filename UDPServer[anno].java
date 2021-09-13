// ASK 2020 York Online Masters
// ---------UDPServer ---------
//  Socket communications UDP
import java.io.*;
import java.net.*;
class UDPServer {
public static void main(String args[]) throws Exception
{
	// Create serverSocket = 9876 for incoming request: 
	DatagramSocket serverSocket = new DatagramSocket(9876);
	byte[] receiveData = new byte[1024];
	byte[] sendData = new byte[1024];
	while(true)
{
	DatagramPacket receivePacket = new DatagramPacket(receiveData,
	receiveData.length);

	// Read request from serverSocket
	serverSocket.receive(receivePacket);
	String sentence = new String(receivePacket.getData());
	InetAddress IPAddress = receivePacket.getAddress();

	// getPort() method of java Socket class returns the remote port number to which the socket is connected.
	int port = receivePacket.getPort();

	//perform capitalization function
	String capitalizedSentence = sentence.toUpperCase();
	sendData = capitalizedSentence.getBytes();

	// write reply to serverSocket specifying client host address and porter number
	DatagramPacket sendPacket = new DatagramPacket(sendData,
	sendData.length, IPAddress, port);
	serverSocket.send(sendPacket);
	}
  }
}