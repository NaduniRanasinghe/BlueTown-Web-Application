package blueLite.com.model;

public class CRM_register {
	
	private int cid;
	private String nic;
	private String fname;
	private String Lname;
	private String email;
	private String mobile;
	private String address1;
	private String address2;
	private String city;
	private String apartmenttype;
	private String site;
	private String gender;
	private String password;

	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String Lname) {
		this.Lname = Lname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return Lname;
	}
	public String getEmail() {
		return email;
	}
    public String getMobile() {
		return mobile;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getApartmenttype() {
		return apartmenttype;
	}
	public void setApartmenttype(String apartmenttype) {
		this.apartmenttype = apartmenttype;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
