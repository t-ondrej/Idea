import configuration.JpaConfiguration;
import configuration.JpaProdConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Tomas on 14.11.2017.
 */
@SpringBootApplication
@ComponentScan("controllers")
public class IdeaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(IdeaApplication.class)
                .sources(JpaProdConfiguration.class)
                .run(args);
    }
}
