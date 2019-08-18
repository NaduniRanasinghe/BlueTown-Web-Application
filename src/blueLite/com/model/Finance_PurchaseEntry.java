package blueLite.com.model;

public class Finance_PurchaseEntry {

	private int invoiceNumber, sellerID, hidden_id;
	private String date, additional;
	private double value;
	
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getHidden_id() {
		return hidden_id;
	}
	public void setHidden_id(int hidden_id) {
		this.hidden_id = hidden_id;
	}
	
	
}
