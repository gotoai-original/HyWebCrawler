package hayaword.queues;

import java.util.concurrent.*;


public class ToFetchQueue extends ConcurrentLinkedQueue <Object> {


	private static final long serialVersionUID = 1L;
	

	public static final ToFetchQueue s_INSTANCE = new ToFetchQueue();
	
	public class ToFetch {
		public String url;
	}
	
	
	public static void loadSeedsFromTextFile(String file_name) {
		
	}

}
