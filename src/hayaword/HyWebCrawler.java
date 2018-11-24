package hayaword;

public class HyWebCrawler {

	public static final HyWebCrawler s_CRAWLER = new HyWebCrawler();
	
	
	///////////////////////////////////////////////////////////////////////////
	public void initailize() {
		
		try {
			// Set home dir
			Config.s_INSTANCE.HOME_DIR = System.getProperty("user.dir");
			
			// Load config
			String config_file = Config.s_INSTANCE.HOME_DIR + "/config/HyWebCrawler.conf";
			Config.s_INSTANCE.load_files(new String [] {config_file});
			
			// Load crawling rules
			
			// Load seeds
			
			// Initialize data objects
			
			// Initialize thread objects
			
			
		} catch (Exception ex) {
			
		}
	}
	
	
	public void start() {
		// Start thread objects
	}
	
	///////////////////////////////////////////////////////////////////////////	
	public static void main(String []args) {
		
		try {
			
			s_CRAWLER.initailize();
			
			
			s_CRAWLER.start();
			
		} catch (Exception ex) {
			
		}
	}
}
