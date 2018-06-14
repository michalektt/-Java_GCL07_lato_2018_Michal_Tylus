package springboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static AtomicLong idCounter = new AtomicLong();

	public static String createID()
	{
	    return String.valueOf(idCounter.getAndIncrement());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
