package hayaword.webdriver;

public abstract class WebDriverBroker {

	public static WebDriverBroker factoryCreate() {return null;}
	
	abstract public void get(String url) throws Exception;
	
	abstract public String getTitle() throws Exception;
	
	abstract public String getSource() throws Exception;
	
	abstract public void close();
	
}
