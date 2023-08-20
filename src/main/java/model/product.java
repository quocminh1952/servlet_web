package model;

import java.util.Objects;

public class product {
	private String product_Id;
	private String product_Name;
	private String product_SL_Id;
	private int product_Year;
	private double product_price_In;
	private double product_price_Initial;
	private double product_price_out;
	private int product_quantity;
	private String product_Story;
	
	public product() {
		//TODO Auto-generated constructor stub
	}

	public product(String product_Id, String product_Name, String product_SL_Id, int product_Year,
			double product_price_In, double product_price_Initial, double product_price_out, int product_quantity,
			String product_Story) {

		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_SL_Id = product_SL_Id;
		this.product_Year = product_Year;
		this.product_price_In = product_price_In;
		this.product_price_Initial = product_price_Initial;
		this.product_price_out = product_price_out;
		this.product_quantity = product_quantity;
		this.product_Story = product_Story;
	}

	public String getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_SL_Id() {
		return product_SL_Id;
	}

	public void setProduct_SL_Id(String product_SL_Id) {
		this.product_SL_Id = product_SL_Id;
	}

	public int getProduct_Year() {
		return product_Year;
	}

	public void setProduct_Year(int product_Year) {
		this.product_Year = product_Year;
	}

	public double getProduct_price_In() {
		return product_price_In;
	}

	public void setProduct_price_In(double product_price_In) {
		this.product_price_In = product_price_In;
	}

	public double getProduct_price_Initial() {
		return product_price_Initial;
	}

	public void setProduct_price_Initial(double product_price_Initial) {
		this.product_price_Initial = product_price_Initial;
	}

	public double getProduct_price_out() {
		return product_price_out;
	}

	public void setProduct_price_out(double product_price_out) {
		this.product_price_out = product_price_out;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_Story() {
		return product_Story;
	}

	public void setProduct_Story(String product_Story) {
		this.product_Story = product_Story;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product_Id, product_Story);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product other = (product) obj;
		return Objects.equals(product_Id, other.product_Id) && Objects.equals(product_Story, other.product_Story);
	}
	
	
}




