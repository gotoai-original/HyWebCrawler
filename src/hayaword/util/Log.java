package hayaword.util;


/**
*
*/

import java.io.*;
import java.util.Calendar;


/**
* 
*/
public class Log {

	/**
	 * L_NOLOG indicates that all messages should not be logged.
	 */
	public static final int L_NOLOG 	= 0;
	
	/**
	 * L_FATAL is a message level indicating a fatal failure, 
	 * which usually causes the program to be terminated abnormally.
	 */	
	public static final int L_FATAL 	= 1;
	
	/**
	 * L_ERROR is a message level indicating a problem, which usually 
	 * causes a processing to be terminated abnormally.
	 */
	public static final int L_ERROR 	= 2;
	
	/**
	 * L_WARNING is a message level indicating a potential problem, in which
	 * usually no processing is terminated abnormally but some unexpected
	 * situations occurred.
	 */
	public static final int L_WARNING 	= 3;
	
	/**
	 * L_INFO is a message level for informational messages, which are
	 * formally displayed to users.
	 */
	public static final int L_INFO 		= 4;


	/**
	 * L_CONFIG is a message level for configuration messages.
	 */
	public static final int L_CONFIG	= 5;
	
	/**
	 * L_FINE is a message level providing tracing information.
	 */
	public static final int L_FINE		= 6;
	
	/**
	 * L_FINER indicates a fairly detailed tracing message.
	 */
	public static final int L_FINER		= 7;
	
	/**
	 * L_FINEST indicates a highly detailed tracing message.
	 */
	public static final int L_FINEST	= 8;
	
	/**
	 * L_ALL indicates that all messages should be logged.
	 */
	public static final int L_ALL		= 9;
	

	/////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	private static LogOption s_LogOption = new LogOption();
	
	
	/**
	 * 
	 * 
	 *
	 */
	private static String getLogFilePathName(Calendar cal) {
		Calendar today = cal;
		
		String strPathName = String.format("%s/%s%04d%02d%02d.log",
				s_LogOption.m_strLogDir, s_LogOption.m_strFilePrefix, 
				today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1,
				today.get(Calendar.DAY_OF_MONTH));
			
		return strPathName; 
	}
	
	/**
	 * 
	 * 
	 */
	private static String getDatetime(Calendar cal) {
		Calendar today = cal;
		
		String strDatetime = String.format("[%04d-%02d-%02d %02d:%02d:%02d.%03d]",
				today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1,
				today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.HOUR_OF_DAY),
				today.get(Calendar.MINUTE), today.get(Calendar.SECOND),
				today.get(Calendar.MILLISECOND));
				
		return strDatetime;
	}

	/**
	 * 
	 * 
	 * 
	 */
	private static String getLevel(int iLevel) {
		switch(iLevel) {
			case L_FATAL:
				return "FATAL";
 			case L_ERROR:
				return "ERROR";
			case L_WARNING:
				return "WARNING";
 			case L_INFO:
				return "INFO";
			case L_CONFIG:
				return "CONFIG";
			case L_FINE:
				return "FINE";
			case L_FINER:
				return "FINER";
			case L_FINEST:
				return "FINEST";
			default:
				return "UNKNOWN";
			}
	}
				
	/**
	 * 
	 * 
	 * 
	 */
	synchronized public static void writeLog(int iLevel, String strMsg) {
		
		try {
			
			if(iLevel > s_LogOption.m_iLevel) {
				return ;
			}
			
			Calendar today = Calendar.getInstance();
			String strDatetime = getDatetime(today);
			
			String strLogMsg = "";
			strLogMsg += strDatetime;
			strLogMsg += (" <" + getLevel(iLevel) + "> ");
			strLogMsg += strMsg;
			strLogMsg += "\r\n";
			
			if(s_LogOption.m_bFileOut) {
				String strFName = getLogFilePathName(today);
				FileOutputStream fos = new FileOutputStream(strFName, true);
				fos.write(strLogMsg.getBytes());
				fos.close();
			}
			
			// Check if need to trace the message on stdout.
			if(s_LogOption.m_bStdOut) {
				System.out.print(strLogMsg);
				System.out.flush();
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
	}

	/**
	 *
	 */
	static public void writeLogF(int iLevel, String strFormat, Object ... args) {
		String strMsg = String.format(strFormat, args);
		
		writeLog(iLevel, strMsg);
	}
	

	/**
	 * 
	 */
	static public void writeLogEx(Exception ex) {
		writeLogF(L_ERROR, "Exception occurred:\r\n" 
				+ Common.getThrowableStackTrace(ex));
	}
	/**
	 * 
	 *
	 */
	synchronized static public void setDir(String strDir) {
		s_LogOption.m_strLogDir = new String(strDir);
	}
	
	/**
	 * 
	 *
	 */
	synchronized static public void setStdOut(boolean bOut) {
		s_LogOption.m_bStdOut = bOut;
	}
	
	/**
	 * 
	 * @param bOut
	 */
	synchronized static public void setFileOut(boolean bOut) {
		s_LogOption.m_bFileOut = bOut;
	}
	
	/**
	 * 
	 * 
	 */
	synchronized static public boolean getStdOutFlag() {
		return s_LogOption.m_bStdOut;
	}

	/**
	 * 
	 * 
	 */
	synchronized static public void setLevel(int iLevel) {
		s_LogOption.m_iLevel = iLevel;
	}	
	
	synchronized static public void setLevel(String strLevel) {
		if(strLevel.equals("NOLOG"))
			s_LogOption.m_iLevel = L_NOLOG;
		else if(strLevel.equals("FATAL"))
			s_LogOption.m_iLevel = L_FATAL;
		else if(strLevel.equals("ERROR"))
			s_LogOption.m_iLevel = L_ERROR;
		else if(strLevel.equals("WARNING"))
			s_LogOption.m_iLevel = L_WARNING;
		else if(strLevel.equals("INFO"))
			s_LogOption.m_iLevel = L_INFO;
		else if(strLevel.equals("CONFIG"))
			s_LogOption.m_iLevel = L_CONFIG;
		else if(strLevel.equals("FINE"))
			s_LogOption.m_iLevel = L_FINE;
		else if(strLevel.equals("FINER"))
			s_LogOption.m_iLevel = L_FINER;
		else if(strLevel.equals("FINEST"))
			s_LogOption.m_iLevel = L_FINEST;
		else if(strLevel.equals("ALL"))
			s_LogOption.m_iLevel = L_ALL;
		else
			s_LogOption.m_iLevel = L_CONFIG;
	}
	/**
	 * 
	 * 
	 */
	synchronized static public void setFilePrefix(String strFilePrefix) {
		s_LogOption.m_strFilePrefix = strFilePrefix;
	}
}

/**
* 
*/
class LogOption {

	/**
	 * 
	 */	
	String 	m_strLogDir 	= "./";
	/**
	 * 
	 */	
	String 	m_strFilePrefix	= "";

	/**
	 * 
	 */
	boolean	m_bStdOut 		= true;
	boolean m_bFileOut		= true;
	int 	m_iLevel 		= Log.L_CONFIG;
}
