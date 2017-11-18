import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Tomas on 14.11.2017.
 */
@SpringBootApplication
@ComponentScan({"controllers", "services", "dao"})
public class IdeaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(IdeaApplication.class)
                .sources(JpaConfiguration.class)
                .run(args);
    }
}
