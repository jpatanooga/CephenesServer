/**
    Copyright [2011] [Josh Patterson]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
 */

package tv.floe.cephenes.tests.udp.server;

import java.io.*;
import java.net.*;

public class DemoClient {
	public static void main(String args[]) throws Exception
	   {
//	      BufferedReader inFromUser =
//	         new BufferedReader(new InputStreamReader(System.in));
	      DatagramSocket clientSocket = new DatagramSocket();
	      InetAddress IPAddress = InetAddress.getByName("localhost");
	      //byte[] sendData = new byte[1024];
	      byte[] receiveData = new byte[1024];
	      String sentence = "alpha, beta, gamma"; //inFromUser.readLine();
	      byte[] sendData = sentence.getBytes();
	      
	      System.out.println( "Sending bytes: " + sendData.length );
	      
	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9800);
	      clientSocket.send(sendPacket);
	      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	      clientSocket.receive(receivePacket);
	      String modifiedSentence = new String(receivePacket.getData()).trim();
	      
	      System.out.println( "Rcvd Bytes: " + receivePacket.getData().length );
	      
	      System.out.println("FROM SERVER:" + modifiedSentence);
	      clientSocket.close();
	   }
}
