import config.GuiConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ResourceBundle;

/**
 * Created by Tomas on 18.11.2017.
 */
public class IdeaStage extends Application {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(GuiConfig.class);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Idea");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMinX() + 10);
        primaryStage.setY(primaryScreenBounds.getMinY() + 10);
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());

        FXMLLoader loader = new FXMLLoader();
        loader.setResources(ResourceBundle.getBundle("fa.fontawesome"));
        loader.setLocation(getClass().getResource("fxml/views/main_view.fxml"));
        loader.setControllerFactory(context::getBean);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
