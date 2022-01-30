package automation;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.annotations.Test;

public class Log4jTest {
	
//	https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
	@Test
	public void log4jTest() throws Exception {
		
//		get log4j object
		Logger l = Logger.getRootLogger();
		l.setLevel(Level.WARN);//Setting Level of logs
		PatternLayout layout= new PatternLayout("%C %d %m %n");
		FileAppender appender=new FileAppender(layout,"./target/MyReport.log");
		l.addAppender(appender);
		
		l.fatal("Fatal Msg");
		l.error("Error Msg");
		l.warn("Warning Msg");
		l.trace("Trace Msg");
		l.debug("Debug Msg");
		l.info("HI");
		
		
	}

}
