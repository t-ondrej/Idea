import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import sk.upjs.ics.configuration.JpaProdConfig;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by Tomas on 14.11.2017.
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan({"sk.upjs.ics.controllers", "sk.upjs.ics.errorhandling"})
public class IdeaApplication {

    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine ste = new SpringTemplateEngine();
        ste.setTemplateResolver(htmlTemplateResolver());

        return ste;
    }

    private ITemplateResolver htmlTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML /* https://github.com/thymeleaf/thymeleaf/issues/395 */);
        templateResolver.setCharacterEncoding("UTF8");
        templateResolver.setCheckExistence(true);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public Docket eventsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("sk.upjs.ics.controllers"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for IDEA",
                "1.0",
                "Terms of service",
                new Contact("Tomáš Ondrej", "https://idea.cesnet.cz/en/index", "t.ondrej@student.upjs.sk"),
                "MIT License Version",
                "https://opensource.org/licenses/MIT");
        return apiInfo;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(IdeaApplication.class)
                .sources(JpaProdConfig.class)
                .run(args);
    }
}
