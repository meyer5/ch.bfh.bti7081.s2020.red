package ch.bfh.btx8081.gui.shared;

public interface LogInInterface {
	
	public void addListener(LogInViewListener presenter);
	
	public void showNotification(String message);
	
	interface LogInViewListener {
		
		public void handleLogiInClick(String userName, String password);
		
	}
	
}
