import sk.upjs.ics.configuration.JpaProdConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Tomas on 14.11.2017.
 */
@SpringBootApplication
@ComponentScan({"sk.upjs.ics.controllers", "sk.upjs.ics.errorhandling"})
public class IdeaApplication {

   /* @Bean
    private ServletContextTemplateResolver servletContextTemplateResolver() {
        ServletContextTemplateResolver sct = new ServletContextTemplateResolver();
        sct.setPrefix("/WEB-INF/templates/");
        sct.setSuffix(".html");
        sct.setTemplateMode("HTML5");

        return sct;
    }

    /*@Bean
    private SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine ste = new SpringTemplateEngine();
        ste.setTemplateResolver(servletContextTemplateResolver());

        return ste;
    }*/

    public static void main(String[] args) {
        new SpringApplicationBuilder(IdeaApplication.class)
                .sources(JpaProdConfig.class)
                .run(args);
    }
}
