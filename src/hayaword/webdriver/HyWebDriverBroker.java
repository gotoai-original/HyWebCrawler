package hayaword.webdriver;

public class HyWebDriverBroker extends WebDriverBroker {

	
	private static String s_HY_WEBDRIVER_BINARY = "";
	private static String s_LD_LIBRARY_PATH = "";
	
	
	public static HyWebDriverBroker factoryCreate() {
		HyWebDriverBroker driver_broker = new HyWebDriverBroker();
		return driver_broker;
	}
	
	
	//////////////////////////////////////////////////////////////////////
	
	// Prevent direct construction
	private HyWebDriverBroker() {
		
	}
	
	private void launchDriver() throws Exception {
		
	}
	
	private void closeDriver() {
		
	}
	

	public void get(String url) throws Exception {
		
	}
	
	public String getSource() throws Exception {
		return null;
	}
	
	public String getTitle() throws Exception {
		return null;
	}
	
	public void close() {
		
	}
	
	///////////////////////////////////////////////////////////////////////////
	// For unit test
	public static void main(String []args) {
		try {
			HyWebDriverBroker driver_broker = HyWebDriverBroker.factoryCreate();
			
			driver_broker.launchDriver();
			
			driver_broker.get("http://www.deeplearning.net/");
			
			String page_title = driver_broker.getTitle();
			
			String page_source = driver_broker.getSource();
			
			driver_broker.closeDriver();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
	}
}
