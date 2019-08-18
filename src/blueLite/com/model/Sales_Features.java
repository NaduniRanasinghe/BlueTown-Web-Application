package blueLite.com.model;

public class Sales_Features {
	
	private int apartmentId,id;
	private String room,bathroom,sRoom,CCTV;
	
	
	public String getCCTV() {
		return CCTV;
	}
	public void setCCTV(String cCTV) {
		CCTV = cCTV;
	}
	public int getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBathroom() {
		return bathroom;
	}
	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}
	public String getsRoom() {
		return sRoom;
	}
	public void setsRoom(String sRoom) {
		this.sRoom = sRoom;
	}
	
	

}
