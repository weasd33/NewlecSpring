package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan("spring.di.ui")
@Configuration // 설정을 위한 클래스
public class NewlecDIConfig {
	
	@Bean
	public Exam exam() {
		return new NewlecExam();
	}
}
