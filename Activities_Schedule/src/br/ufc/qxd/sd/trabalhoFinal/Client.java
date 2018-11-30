package br.ufc.qxd.sd.trabalhoFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
	private Socket socket;
	private OutputStream output;
	private Writer writer; 
	private BufferedWriter buffer;
	//private boolean teste = true;
	private static final Client instance = new Client();
	
	private Client() {}

	public static void main(String[] args) {
		Client.getInstance().connect();
		Scanner scan = new Scanner(System.in);
		/*while(Client.getInstance().teste) {
			System.out.println("Digite uma mensagem: ");
			String message = scan.nextLine();
			Client.getInstance().sendMessage(message);
			Client.getInstance().to_listen();
		}*/
		InvokeOperations invoke = new InvokeOperations();
		boolean teste = true;
		
		while(teste) {
			System.out.println("----- TO_DO -----");
			System.out.println("1 - Listar");
			System.out.println("2 - Adicionar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Finalizar");
			System.out.println("5 - Sair");
			int option = Integer.parseInt(scan.nextLine());
			
			switch (option) {
			case 1:
				Client.getInstance().sendMessage(invoke.listActivity());
				Client.getInstance().to_listen();
				break;
			case 2:
				Client.getInstance().sendMessage(invoke.addActivity());
				Client.getInstance().to_listen();
				break;
			case 3:
				Client.getInstance().sendMessage(invoke.upActivity());
				Client.getInstance().to_listen();
				break;
			case 4:
				Client.getInstance().sendMessage(invoke.finishActivity());
				Client.getInstance().to_listen();
				break;
			case 5:
				Client.getInstance().sendMessage("exit");
				teste = false;
				System.out.println("Conexão encerrada");
				break;
			default:
				System.out.println("Operação não existe. Digite novamente.");
			}
		}
		
		scan.close();
	}
	
	public void connect() {
		try {
			this.socket = new Socket("127.0.0.1", 9876);
			this.output = this.socket.getOutputStream();
			this.writer = new OutputStreamWriter(this.output);
			this.buffer = new BufferedWriter(this.writer);
			this.buffer.flush();
			System.out.println("Conectado.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.socket.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String text) {
		try {	
			//Message message = new Message(text);
	        //RequestMessage message = new RequestMessage("add", "title", "description", text);
			//String request = new GsonBuilder().create().toJson(message);
			this.buffer.write(text);
			this.buffer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void to_listen() {		
	    try {
		    InputStream input = this.socket.getInputStream();
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));

			String response = buffer.readLine();
			Gson gson = new Gson();
		    Type type = new TypeToken<List<Activity>>(){}.getType();
		    List<Activity> activities = gson.fromJson(response, type);
		    System.out.println("----- Atividades cadastradas -----");
		    for(Activity activity : activities) {
		    	System.out.println(activity.toString());
		    }
//			System.out.println(response);
//			Message message = new Gson().fromJson(response, Message.class);
//		    if(!"exit".equalsIgnoreCase(message.getText())) {
//				System.out.println("Servidor mandou: " + message.getText());
//			} else {
//				Client.getInstance().teste = false;
//			}
	    } catch(IOException e) {
		    e.printStackTrace();
	    }
	}
	
	public static Client getInstance() {
		return Client.instance;
	}

}
