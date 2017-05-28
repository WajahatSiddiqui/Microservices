package com.wajahat.learn.spring.jpah2.readinglist;

import com.wajahat.learn.spring.jpah2.readinglist.repository.ReadingListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class ReadingListApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	/*@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
	}*/

	@Bean
	CommandLineRunner runner(ReadingListRepository readingListRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				readingListRepository.findAll()
						.forEach(System.out::println);
			}
		};
	}

}
