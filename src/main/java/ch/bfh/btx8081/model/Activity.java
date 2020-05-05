package ch.bfh.btx8081.model;

public class Activity {
	
	private String activity;
	private String iconID;
	
	public Activity(String activity, String iconID) {
		super();
		this.activity = activity;
		this.iconID = iconID;
	}
	
//	getters & setters
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getIconID() {
		return iconID;
	}
	public void setIconID(String iconID) {
		this.iconID = iconID;
	}

}
