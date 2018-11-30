package br.ufc.qxd.sd.trabalhoFinal;

import java.util.Scanner;

import com.google.gson.GsonBuilder;

public class InvokeOperations {
	
	private Scanner scan = new Scanner(System.in);
	
	public String addActivity() {
		System.out.println("Digite o título: ");
		String title = scan.nextLine();
		System.out.println("Digite a descrição: ");
		String description = scan.nextLine();
		System.out.println("Digite a data de encerramento: ");
		String closingDate = scan.nextLine();	
		RequestMessage request = new RequestMessage("add", title, description, closingDate);
		return new GsonBuilder().create().toJson(request);
	}
	
	public String upActivity() {
		System.out.println("Digite a id da atividade: ");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Digite o título: ");
		String title = scan.nextLine();
		System.out.println("Digite a descrição: ");
		String description = scan.nextLine();
		System.out.println("Digite a data de encerramento: ");
		String closingDate = scan.nextLine();	
		RequestMessage request = new RequestMessage("up", title, description, closingDate);
		request.setId(id);
		return new GsonBuilder().create().toJson(request);
	}
	
	public String finishActivity() {
		System.out.println("Digite o id da atividade: ");
		int id = Integer.parseInt(scan.nextLine());
		RequestMessage request = new RequestMessage();
		request.setOp("end");
		request.setId(id);
		return new GsonBuilder().create().toJson(request);
	}
	
	public String listActivity() {
		RequestMessage request = new RequestMessage();
		request.setOp("list");
		return new GsonBuilder().create().toJson(request);
	}

}
