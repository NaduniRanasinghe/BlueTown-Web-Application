package blueLite.com.model;

public class IL_Logistics {
	
	private int id;
	private String name;
	private double cost;
	private double maintenanceCost;
	private double fuelCost;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	public double getFuelCost() {
		return fuelCost;
	}
	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Logistics [id=" + id + ", name=" + name + ", cost=" + cost + ", maintenanceCost=" + maintenanceCost
				+ ", fuelCost=" + fuelCost + ", total=" + total + "]";
	}

}
