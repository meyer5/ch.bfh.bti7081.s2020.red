package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "activity")
public class Activity {
	@Id
	private String activity = "";
	private String iconID = "";
	
	@ManyToOne
	@JoinColumn(name = "diary_id")
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
