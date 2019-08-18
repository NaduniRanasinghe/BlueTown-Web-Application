package blueLite.com.model;

public class ORM_AddMetModel {
	
	private String company_name,mobile,Email,city,Item_name,address_line_1,address_line_2;
	private double unit_Price;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	
	public String getAddress_line_1() {
		return address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	
    
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
		
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
		
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
		
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public double getUnit_Price() {
		return unit_Price;
	}
	public void setUnit_Price(double unit_Price) {
		this.unit_Price = unit_Price;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String Item_name) {
		this.Item_name = Item_name;
	}
		
	}
	




