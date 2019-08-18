package blueLite.com.model;

public class HR_Employee {




    private String fname,lname,nic,appDate,gender,contact,position,email,address1,address2,department,city,password,password1;
    private int id;
    
    
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname1() {
		return lname;
	}
	public void setLname1(String lname) {
		this.lname = lname;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 public String passwordValidation(String password1, String password)
     {
             
             if (password.length() > 15 || password.length() < 5)
             {
                   return "Password should be less than 15 and more than 5 characters in length."
                		   ;
                     
                     
             }
             if (password.indexOf(password1) > -1)
             {
                     return "Password  be same " ;
                     
             }
             String upperCaseChars = "(.*[A-Z].*)";
             if (!password.matches(upperCaseChars ))
             {
                     return "Password should contain atleast one upper case alphabet";
                     
             }
             String lowerCaseChars = "(.*[a-z].*)";
             if (!password.matches(lowerCaseChars ))
             {
                     return "Password should contain atleast one lower case alphabet";
                     
             }
             String numbers = "(.*[0-9].*)";
             if (!password.matches(numbers ))
             {
                     return "Password should contain atleast one number.";
                     
             }
             String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
             if (!password.matches(specialChars ))
             {
                     return "Password should contain atleast one special character";
                    
             }
             else
             {
                     return "valid.";
             }
     }
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

}