package blueLite.com.model;

public class Finance_AssetEntry {

	private String name, type, additional, otherIDs;
	private double value;
	private int hidden_id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	public String getOtherIDs() {
		return otherIDs;
	}
	public void setOtherIDs(String otherIDs) {
		this.otherIDs = otherIDs;
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
