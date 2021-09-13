// AKS 2020 York Online Masters
// --------UDPClient-----------
// Socket Communications - UDP
import java.io.*;
import java.net.*;
class UDPClient {
public static void main(String args[]) throws Exception
{
// Client inputs value
BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
// ClientSocket created
DatagramSocket clientSocket = new DatagramSocket();

// getByName() method of InetAddres class determines the IP address of a host from a given host's name 
InetAddress IPAddress = InetAddress.getByName("localhost");
byte[] sendData = new byte[1024];
byte[] receiveData = new byte[1024];

// .readLine() used to read a single line of text from the console
String sentence = inFromUser.readLine();

// getBytes() method encodes a given String into a sequence of bytes
sendData = sentence.getBytes();

//Send message packet to destination IPAddress 9876
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
clientSocket.send(sendPacket);

//Receive back the reply from the server 
DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
clientSocket.receive(receivePacket);
String modifiedSentence = new String(receivePacket.getData());

//print message into console
System.out.println("FROM SERVER:  " + modifiedSentence);
clientSocket.close();
	}
}



