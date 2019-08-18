package blueLite.com.model;

public class Finance_RevenueEntry {

	private int id;
	private int year;
	private String month;
	private String review;
	private double revenue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "RevenueEntry [year=" + year + ", month=" + month + ", review=" + review + ", revenue=" + revenue + "]";
	}
	
	
}
