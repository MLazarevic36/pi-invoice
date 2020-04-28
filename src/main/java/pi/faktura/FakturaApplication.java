package pi.faktura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Lazy
@EnableJpaAuditing
@EnableJpaRepositories("pi.faktura.repository")
@SpringBootApplication
public class FakturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakturaApplication.class, args);
	}

}
