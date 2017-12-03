package config;

import configuration.JpaProdConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Tomas on 29.11.2017.
 */
@ComponentScan("fxcontrollers")
@Import(JpaProdConfig.class)
@Configuration
public class GuiConfig {

}
