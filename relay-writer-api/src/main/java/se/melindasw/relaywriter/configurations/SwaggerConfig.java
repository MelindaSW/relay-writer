package se.melindasw.relaywriter.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .directModelSubstitute(LocalTime.class, String.class)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiEndPointsInfo());
  }

  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder()
        .title("relay-writer-api by MelindaSW")
        .description("API for the dnd relay writer app")
        .contact(new Contact("Melinda Sandström-Wagner", "https://github.com/MelindaSW", ""))
        .version("0.0.1")
        .build();
  }
}
