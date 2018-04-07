package br.ufc.quixada.redes.cliente;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient {
	private static Scanner scan;

	public static void main (String args[]) {
		// arguments supply message and hostname of destination
		Socket s = null;
		scan = new Scanner(System.in);
		System.out.println("The request pattern is <method> <op_1> <op_2>. For example, add 2 2");
		try {
			s = new Socket("127.0.0.1", 6789);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			while(true) {
				System.out.println("What is your request?");
				String request = scan.nextLine();
				out.writeUTF(request); // UTF is a string encoding see Sn 4.3
				String data = in.readUTF();
				if(data.equals("exit")) break;
				else if(data.startsWith("c")) {
					String aux[] = data.split(" ");
					System.out.println("Received: " + aux[aux.length - 1]);
				} else System.out.println("Error: " + data.substring(2));
			}
			System.out.println("To the next");
		} catch (UnknownHostException e) { 
			System.out.println("Sock:"+e.getMessage()); 
		} catch (EOFException e) {
			System.out.println("EOF:"+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:"+e.getMessage());
		} finally { 
			if(s!=null) {
				try {
					s.close();
				} catch (IOException e) { 
					System.out.println("close:"+e.getMessage()); 
				} 
			}
		}
	}
}

