package com.tc.poc.networkdb.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sport_Events")
public class SportEvents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, updatable=true, nullable=false)
	private Long Id;

	@Column(name="eventname", unique=false, updatable=true, nullable=false)
	private String eventname;
	//private String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ").toString();
	@Column(name="dateofevent", unique=false, updatable=true, nullable=false)
	private String dateofevent;  
	@Column(name="description", unique=false, updatable=true, nullable=true)
	private String description;
	@Column(name="eventtype", unique=false, updatable=true, nullable=false)
	private String eventtype;
	@Column(name="venue", unique=false, updatable=true, nullable=false)
	private String venue;
	@Column(name="importantinfo", unique=false, updatable=true, nullable=true)
	private String importantinfo;
	@Column(name="roomtypes", unique=false, updatable=true, nullable=true)
	private String roomtypes;
	@Column(name="eventimage", unique=false, updatable=true, nullable=true)
	private String eventimage;
		
public SportEvents() {}

public SportEvents(String eventName,String dateOfEvent,  String description,String eventType,String venue,String importantInfo,String roomTypes,String eventImage) {
	this.eventname=eventName;
	this.dateofevent=dateOfEvent;
	this.description=description;
	this.eventtype=eventType;
	this.venue=venue;
	this.importantinfo=importantInfo;
	this.roomtypes=roomTypes;
	this.eventimage=eventImage;
}


public String getEventname() {
	return eventname;
}

public void setEventname(String eventname) {
	this.eventname = eventname;
}

public String getDateofevent() {
	return dateofevent;
}

public void setDateofevent(String dateofevent) {
	this.dateofevent = dateofevent;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getEventtype() {
	return eventtype;
}

public void setEventtype(String eventtype) {
	this.eventtype = eventtype;
}

public String getVenue() {
	return venue;
}

public void setVenue(String venue) {
	this.venue = venue;
}

public String getImportantinfo() {
	return importantinfo;
}

public void setImportantinfo(String importantinfo) {
	this.importantinfo = importantinfo;
}

public String getRoomtypes() {
	return roomtypes;
}

public void setRoomtypes(String roomtypes) {
	this.roomtypes = roomtypes;
}

public String getEventimage() {
	return eventimage;
}

public void setEventimage(String eventimage) {
	this.eventimage = eventimage;
}

@Override
public String toString() {
	return "SportEvents [eventName=" + eventname + ", dateOfEvent=" + dateofevent + ", description=" + description
			+ ", eventType=" + eventtype + ", venue=" + venue + ", importantInfo=" + importantinfo + ", roomTypes="
			+ roomtypes + ", eventImage=" + eventimage + "]";
}


}
