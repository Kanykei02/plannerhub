package kg.ItAcademy.plannerhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlannerhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerhubApplication.class, args);
	}

}
