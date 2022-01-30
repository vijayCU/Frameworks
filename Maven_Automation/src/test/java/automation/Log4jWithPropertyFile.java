package automation;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jWithPropertyFile {
	
/*
 * pattern layouts
 * https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
 */
/*
 * 	log4j property file details
 * 
 */
	@Test
	public void log4jTest() throws Exception {
		
//		get log4j object
		Logger l = Logger.getRootLogger();
		
		l.fatal("Fatal Msg");
		l.error("Error Msg");
		l.warn("Warning Msg");
		l.trace("Trace Msg");
		l.debug("Debug Msg");
		l.info("HI");
		
		
	}

}
