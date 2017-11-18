import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Tomas on 18.11.2017.
 */
public class IdeaStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Idea");
        primaryStage.show();
    }
}
