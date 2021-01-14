package uk.co.stringerj.tidetimes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import feign.RequestInterceptor;

@SpringBootApplication
@EnableFeignClients
public class TideTimesApplication {

  public static void main(String[] args) {
    SpringApplication.run(TideTimesApplication.class, args);
  }

  @Bean
  public RequestInterceptor applyAdmiraltySecurityHeader(
      @Value("${client.admiralty.key}") String key) {
    return template -> {
      template.header("Ocp-Apim-Subscription-Key", key);
    };
  }

  @Bean
  public WebMvcConfigurer configurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
      }
    };
  }
}
