package test;

import java.util.ArrayList;

import DAO.DAO_client;
import model.client;

public class test {

	public static void main(String[] args) {
		
		//Test_DAO_Client:
		//addItem:
		client newClient = new client("client_02","ClientA2","123323678","TRAN NGUYEN H","NU","Cau Giay,Ha Noi","0938313123","client02@gmail.com",true);
		DAO_client.getInstance().addItem(newClient);
//		client removeClient = new client();
//		removeClient.setClient_Id("client_02");
//		DAO_client.getInstance().deleteItem(removeClient);
		
//		client updateClient = new client("client_01",null,"01233434",null,"Đống Đa,Hà Nội","0987654321","client1.2@gmail.com",true);
//		DAO_client.getInstance().updateItem(updateClient);
	}

}
