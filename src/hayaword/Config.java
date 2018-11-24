package hayaword;

import java.io.FileInputStream;
import java.util.Properties;

public class Config extends Properties {
		
	private static final long serialVersionUID = 1L;
	
	public static final Config s_INSTANCE = new Config();
		
	public static String HOME_DIR;
		
	public void load_files(String [] prop_files) throws Exception {
		for (String f: prop_files) {
			Properties prop = new Properties();
			prop.load(new FileInputStream(f));
			
			this.putAll(prop);
		}
	}
}

