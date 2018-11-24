package hayaword.util;

import java.util.*;


public class Common {

	static public String utcToLocalTimeA14(long lUtc) {
		Calendar then = Calendar.getInstance();
		then.setTime(new Date(lUtc));
		
		String s1 = String.format("%04d%02d%02d%02d%02d%02d",
				then.get(Calendar.YEAR), then.get(Calendar.MONTH)+1,
				then.get(Calendar.DAY_OF_MONTH), then.get(Calendar.HOUR_OF_DAY),
				then.get(Calendar.MINUTE), then.get(Calendar.SECOND)
				);
				
		return s1;			
	}
	
	static public String utcToLocalTimeA14(String strZoneID, long lUtc) {
		Calendar then = Calendar.getInstance(TimeZone.getTimeZone(strZoneID));
		then.setTime(new Date(lUtc));
		
		String s1 = String.format("%04d%02d%02d%02d%02d%02d",
				then.get(Calendar.YEAR), then.get(Calendar.MONTH)+1,
				then.get(Calendar.DAY_OF_MONTH), then.get(Calendar.HOUR_OF_DAY),
				then.get(Calendar.MINUTE), then.get(Calendar.SECOND)
				);
				
		return s1;			
	}
	
	static public String utcToLocalTimeA17(long lUtc) {
		Calendar then = Calendar.getInstance();
		then.setTime(new Date(lUtc));
		
		String s1 = String.format("%04d%02d%02d%02d%02d%02d%03d",
				then.get(Calendar.YEAR), then.get(Calendar.MONTH)+1,
				then.get(Calendar.DAY_OF_MONTH), then.get(Calendar.HOUR_OF_DAY),
				then.get(Calendar.MINUTE), then.get(Calendar.SECOND),
				then.get(Calendar.MILLISECOND)
				);
				
		return s1;			
	}
	
	static public String utcToLocalTimeStandard(long lUtc) {
		Calendar then = Calendar.getInstance();
		then.setTimeInMillis(lUtc);
		
		String s1 = String.format("%04d-%02d-%02d %02d:%02d:%02d",
				then.get(Calendar.YEAR), then.get(Calendar.MONTH)+1,
				then.get(Calendar.DAY_OF_MONTH), then.get(Calendar.HOUR_OF_DAY),
				then.get(Calendar.MINUTE), then.get(Calendar.SECOND)
				);
				
		return s1;			
	}
	
	static public String utcToTimeStandard(String strZoneID, long lUtc) {
		Calendar then = Calendar.getInstance(TimeZone.getTimeZone(strZoneID));
		then.setTimeInMillis(lUtc);
		
		String s1 = String.format("%04d-%02d-%02d %02d:%02d:%02d",
				then.get(Calendar.YEAR), then.get(Calendar.MONTH)+1,
				then.get(Calendar.DAY_OF_MONTH), then.get(Calendar.HOUR_OF_DAY),
				then.get(Calendar.MINUTE), then.get(Calendar.SECOND)
				);
				
		return s1;			
	}
	
	//
	static public long localTimeA14ToUtc(String lta14) {
		Calendar then = Calendar.getInstance();
		
		then.set(Calendar.YEAR, Integer.valueOf(lta14.substring(0, 4)).intValue());
		then.set(Calendar.MONTH, Integer.valueOf(lta14.substring(4, 6)).intValue()-1);
		then.set(Calendar.DAY_OF_MONTH, Integer.valueOf(lta14.substring(6, 8)).intValue());
		then.set(Calendar.HOUR_OF_DAY, Integer.valueOf(lta14.substring(8, 10)).intValue());
		then.set(Calendar.MINUTE, Integer.valueOf(lta14.substring(10, 12)).intValue());
		then.set(Calendar.SECOND, Integer.valueOf(lta14.substring(12, 14)).intValue());
		then.set(Calendar.MILLISECOND, 0);

		return then.getTimeInMillis();			
	}
	
	static public long localTimeA14ToUtc(String strZoneID, String lta14) {
		Calendar then = Calendar.getInstance(TimeZone.getTimeZone(strZoneID));
		
		then.set(Calendar.YEAR, Integer.valueOf(lta14.substring(0, 4)).intValue());
		then.set(Calendar.MONTH, Integer.valueOf(lta14.substring(4, 6)).intValue()-1);
		then.set(Calendar.DAY_OF_MONTH, Integer.valueOf(lta14.substring(6, 8)).intValue());
		then.set(Calendar.HOUR_OF_DAY, Integer.valueOf(lta14.substring(8, 10)).intValue());
		then.set(Calendar.MINUTE, Integer.valueOf(lta14.substring(10, 12)).intValue());
		then.set(Calendar.SECOND, Integer.valueOf(lta14.substring(12, 14)).intValue());
		then.set(Calendar.MILLISECOND, 0);

		return then.getTimeInMillis();			
	}
	
	static public long localStandardTimeToUtc(String stdTime) {
		Calendar then = Calendar.getInstance();
		
		then.set(Calendar.YEAR, Integer.valueOf(stdTime.substring(0, 4)).intValue());
		then.set(Calendar.MONTH, Integer.valueOf(stdTime.substring(5, 7)).intValue()-1);
		then.set(Calendar.DAY_OF_MONTH, Integer.valueOf(stdTime.substring(8, 10)).intValue());
		then.set(Calendar.HOUR_OF_DAY, Integer.valueOf(stdTime.substring(11, 13)).intValue());
		then.set(Calendar.MINUTE, Integer.valueOf(stdTime.substring(14, 16)).intValue());
		then.set(Calendar.SECOND, Integer.valueOf(stdTime.substring(17, 19)).intValue());
		then.set(Calendar.MILLISECOND, 0);

		return then.getTimeInMillis();			
	}
	
	//
	static public String getThrowableStackTrace(Throwable one) {
		
		String str1 = "";
		
		try {
			str1 += one.getMessage() + "\r\n";
			StackTraceElement [] sts = one.getStackTrace();
			for(int i=0; i<sts.length; ++i) {
					str1 += "  at " + sts[i].toString() + "\r\n";
			}
		} catch(Exception ex) {
		} 
		
		return str1;
	}
	
	
	/**
	 * Returns a copy of the string, with leading and trailing specified characters
	 * omitted. 
	 */
	static public String trimString(String target, String to_trim) {
		int i=0, j=target.length()-1;
		
		for(;i<=j;) {
			if(to_trim.contains(target.subSequence(i,i+1))) {
				++i;
			} else {
				break;
			}
		}
		
		for(;j>=i;) {
			if(to_trim.contains(target.subSequence(j,j+1))) {
				--j;
			} else {
				break;
			}
		}
		
		return target.substring(i, j+1);
	}
	
	/**
	 * 
	 */
    public static Object[] reverseArray(Object[] arr) {
        List < Object > list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }
	
}
