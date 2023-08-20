package model;

public class client {
	private String client_Id;
	private String client_Login;
	private String client_Password;
	private String client_FullName;
	private String client_Gender;
	private String client_Address;
	private String client_PhoneNumber;
	private String client_Email;
	private boolean client_Receive_Email;
	
	public client(String client_Id, String client_Login, String client_Password, String client_FullName,
			String client_Gender,String client_Address, String client_PhoneNumber, String client_Email,
			boolean client_Receive_Email) {
		
		this.client_Id = client_Id;
		this.client_Login = client_Login;
		this.client_Password = client_Password;
		this.client_FullName = client_FullName;
		this.client_Gender = client_Gender;
		this.client_Address = client_Address;
		this.client_PhoneNumber = client_PhoneNumber;
		this.client_Email = client_Email;
		this.client_Receive_Email = client_Receive_Email;
	}

	public client() {
		
	}

	public String getClient_Id() {
		return client_Id;
	}

	public void setClient_Id(String client_Id) {
		this.client_Id = client_Id;
	}

	public String getClient_Login() {
		return client_Login;
	}

	public void setClient_Login(String client_Login) {
		this.client_Login = client_Login;
	}

	public String getClient_Password() {
		return client_Password;
	}

	public void setClient_Password(String client_Password) {
		this.client_Password = client_Password;
	}

	public String getClient_FullName() {
		return client_FullName;
	}

	public void setClient_FullName(String client_FullName) {
		this.client_FullName = client_FullName;
	}

	public String getClient_Address() {
		return client_Address;
	}

	public void setClient_Address(String client_Address) {
		this.client_Address = client_Address;
	}

	public String getClient_PhoneNumber() {
		return client_PhoneNumber;
	}

	public void setClient_PhoneNumber(String client_PhoneNumber) {
		this.client_PhoneNumber = client_PhoneNumber;
	}

	public String getClient_Email() {
		return client_Email;
	}

	public void setClient_Email(String client_Email) {
		this.client_Email = client_Email;
	}

	public boolean getClient_Receive_Email() {
		return client_Receive_Email;
	}

	public void setClient_Receive_Email(boolean client_Receive_Email) {
		this.client_Receive_Email = client_Receive_Email;
	}

	public String getClient_Gender() {
		return client_Gender;
		
	}

	public void setClient_Gender(String client_Gender) {
		this.client_Gender = client_Gender;
		
	}
	
	
	
}	
