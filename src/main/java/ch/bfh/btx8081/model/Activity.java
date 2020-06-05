package ch.bfh.btx8081.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue
	private Long id;
	private String activity = "";
	private String iconID = "";
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "DIARY_ID")
	private Diary diary;
	

//	Constructor for JPA
	public Activity() {
		
	}
	
	public Activity(String activity, String iconID) {
		super();
		this.activity = activity;
		this.iconID = iconID;
	}
	
//	getters & setters
	
	public String getActivity() {
		return activity;
	}
	protected void setActivity(String activity) {
		this.activity = activity;
	}
	public String getIconID() {
		return iconID;
	}
	protected void setIconID(String iconID) {
		this.iconID = iconID;
	}

}
