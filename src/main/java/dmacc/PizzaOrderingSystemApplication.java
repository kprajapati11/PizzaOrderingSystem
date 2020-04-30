package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SuppressWarnings("deprecation")
@SpringBootApplication
public class PizzaOrderingSystemApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderingSystemApplication.class, args);
	}

	//Add converter and configuration annotation
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToItemConverter());
    }



}
