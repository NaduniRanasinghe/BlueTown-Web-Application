package blueLite.com.model;

public class ORM_AddServiceModel {
	 private String name,mobile,Email,address_line_1,address_line_2,city;
	    private int id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		
		
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		
		public String getEmail() {
			return Email;
		}
		public void setEmail(String Email) {
			this.Email = Email;
		}
		public String getAddress_line_1() {
			return address_line_1;
		}
		public void setAddress_line_1(String address_line_1) {
			this.address_line_1 = address_line_1;
		}
		public String getAddress_line_2() {
			return address_line_2;
		}
		public void setAddress_line_2(String address_line_2) {
			this.address_line_2 = address_line_2;
		}
		public String getcity() {
			return city;
		}
		public void setcity(String city) {
			this.city = city;
		}
		
}
