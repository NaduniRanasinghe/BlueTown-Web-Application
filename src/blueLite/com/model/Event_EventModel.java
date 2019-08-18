package blueLite.com.model;

public class Event_EventModel {
	private int id;
	private String eventName;
	private String description;
    private String date;  
    private String eventType;  
    private double estimateBudget; 
    private String location ;
   
  
    
    public String getName() {
    	return eventName;
    }
    
    public void setName(String name) {
    	this.eventName=name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description=description;
    }
   
     public String getDate() {  
          return date;  
     }  
     public void setDate(String date) {  
          this.date =date;  
     }  
     public String getEventType() {  
          return eventType;  
     }  
     public void setEventType(String eventType) {  
          this.eventType = eventType;  
     }  
    
    
     public String getLocation() {  
         return location;  
    }  
    public void setLocation(String location) {  
         this.location = location;  
    }



public String getEventName() {
	return eventName;
}

public void setEventName(String eventName) {
	this.eventName = eventName;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getEstimateBudget() {
	return estimateBudget;
}

public void setEstimateBudget(double estimateBudget) {
	this.estimateBudget = estimateBudget;
}
 }  
