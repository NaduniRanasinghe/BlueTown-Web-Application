package blueLite.com.model;

public class IL_Equipment {

	private int id;
	private String name;
	private int quantity;
	private double unitCost;
	private double maintenanceCost;
	private double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unitCost=" + unitCost
				+ ", maintenanceCost=" + maintenanceCost + ", total=" + total + "]";
	}
	
	
	
}
