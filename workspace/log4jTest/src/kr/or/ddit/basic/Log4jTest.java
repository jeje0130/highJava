package kr.or.ddit.basic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4jTest {
	// Logger 클래스의 인스턴스를 받아온다
	private static Logger logger = Logger.getLogger(Log4jTest.class) ;

	public static void main(String[] args) {
		// 로그 기록을 남기는 메서드는 로그 레벨과 1대 1로 대응이 되는 메서드를 제공한다.
		// 형식 1) logger객체변수.로그레벨메서드("출력할 메시지");
		// 로그레벨 : trace < debug < info < warn < error < fatal
		/*
		 * logger.trace("이것은 log4j의 Trace 레벨의 메시지입니다.");
		 * logger.debug("이것은 log4j의 debug 레벨의 메시지입니다.");
		 * logger.info("이것은 log4j의 info 레벨의 메시지입니다.");
		 * logger.warn("이것은 log4j의 warn 레벨의 메시지입니다.");
		 * logger.error("이것은 log4j의 error 레벨의 메시지입니다.");
		 * logger.fatal("이것은 log4j의 fatal 레벨의 메시지입니다.");
		 */	
		
		//-----------------------------------------------------------
		//형식 2) logger객체변수.log(Level.로그레벨, "출력할메세지")
		 logger.log(Level.TRACE, "이것은 log4j의 Trace 레벨의 메시지입니다.");
		 logger.log(Level.DEBUG, "이것은 log4j의 debug 레벨의 메시지입니다.");
		 logger.log(Level.INFO, "이것은 log4j의 info 레벨의 메시지입니다.");
		 logger.log(Level.WARN, "이것은 log4j의 warn 레벨의 메시지입니다.");
		 logger.log(Level.ERROR, "이것은 log4j의 error 레벨의 메시지입니다.");
		 logger.log(Level.FATAL, "이것은 log4j의 fatal 레벨의 메시지입니다.");
		
		
		
	}

}
