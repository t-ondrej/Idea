package sk.upjs.ics.fxcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.stage.Screen;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class MainViewController implements Initializable {

    @FXML private TabPane mainTabPane;

    public void initialize(URL location, ResourceBundle resources) {
        double tabWidth = Screen.getPrimary().getVisualBounds().getWidth() * 0.2 - 5;
        double tabHeight = Screen.getPrimary().getVisualBounds().getHeight() * 0.05 - 5;

        mainTabPane.setTabMinWidth(tabWidth);
        mainTabPane.setTabMinHeight(tabHeight);

        mainTabPane.setTabMaxWidth(tabWidth);
        mainTabPane.setTabMaxHeight(tabHeight);
    }

}
