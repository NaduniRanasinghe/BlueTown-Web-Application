package blueLite.com.model;

public class HR_Salary {
	
	String nic;
	
	double basicSal, decrement, otHrs, otRate, bonus, commission;
	int id;
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public double getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}
	public double getDecrement() {
		return decrement;
	}
	public void setDecrement(double decrement) {
		this.decrement = decrement;
	}
	public double getOtHrs() {
		return otHrs;
	}
	public void setOtHrs(double otHrs) {
		this.otHrs = otHrs;
	}
	public double getOtRate() {
		return otRate;
	}
	public void setOtRate(double otRate) {
		this.otRate = otRate;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double calculateTotalSal(double b, double otr, double oth, double bonus, double c, double d) {
		
		/*this.basicSal = b;
		this.otRate = otr;
		this.bonus = bonus;
		this.otHrs = oth;
		this.commission = c; */
		
		return b + c + bonus  + otr * oth - d;
	}
	
}
