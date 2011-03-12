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

public class DemoServer {

   public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(9800);
            byte[] receiveData = new byte[1024];
            //byte[] sendData = new byte[1024];
            while(true)
               {
            	
            	System.out.println( "UDP Server Waiting on Packet..." );
            	
            	// gotta read in a variable length packet, we know in adv how big it is?
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData()).trim(); // trim to get sentence length
                  System.out.println("RECEIVED: '" + sentence + "', bytes recieved: " + receivePacket.getData().length + ", length of string: " + receivePacket.getLength() );
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String capitalizedSentence = "return " + sentence; //sentence.toUpperCase();
                  
                  byte[] sendData = capitalizedSentence.getBytes();
                  
                  System.out.println( "New sentence length: " + capitalizedSentence.length() + ", bytes: " + capitalizedSentence.getBytes().length );
                  
                  System.out.println( "Sending Return packet" );
                  System.out.println( "Sending bytes: " + sendData.length );
                
                  
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}