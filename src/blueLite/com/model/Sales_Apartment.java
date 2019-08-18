package blueLite.com.model;

public class Sales_Apartment {


    private String apartmentname,site,type;
    private int number,id,apartmentId;
    private double squreft;
    
	/*public Apartment(String apartmentname, String site, String type, int number, int id, double squreft) {
		super();
		this.apartmentname = apartmentname;
		this.site = site;
		this.type = type;
		this.number = number;
		this.id = id;
		this.squreft = squreft;}*/
	
	public String getApartmentname() {
		return apartmentname;
	}
	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getSqureft() {
		return squreft;
	}
	public void setSqureft(double squreft) {
		this.squreft = squreft;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	
	
    
    
   
	
}