package model;

import java.sql.Date;
import java.util.Objects;

public class order {
	private String order_Id;
	private client order_Client;
	private String order_Client_Address;
	private String order_Status;
	private String order_COD;
	private Date order_Date;
	private Date order_Ship;
	
	public order() {
		
	}

	public order(String order_Id, client Order_client, String order_Client_Address, String order_status,
			String order_COD, Date order_Date, Date order_Ship) {
		this.order_Id = order_Id;
		this.order_Client = Order_client;
		this.order_Client_Address = order_Client_Address;
		this.order_Status = order_status;
		this.order_COD = order_COD;
		this.order_Date = order_Date;
		this.order_Ship = order_Ship;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public client getOrder_Client() {
		return order_Client;
	}

	public void setOrder_Client(client order_Client) {
		this.order_Client = order_Client;
	}

	public String getOrder_Client_Address() {
		return order_Client_Address;
	}

	public void setOrder_Client_Address(String order_Client_Address) {
		this.order_Client_Address = order_Client_Address;
	}

	public String getOrder_Status() {
		return order_Status;
	}

	public void setOrder_Status(String order_Status) {
		this.order_Status = order_Status;
	}

	public String getOrder_COD() {
		return order_COD;
	}

	public void setOrder_COD(String order_COD) {
		this.order_COD = order_COD;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	public Date getOrder_Ship() {
		return order_Ship;
	}

	public void setOrder_Ship(Date order_Ship) {
		this.order_Ship = order_Ship;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		order other = (order) obj;
		return Objects.equals(order_Id, other.order_Id);
	}
	
	
	
}
