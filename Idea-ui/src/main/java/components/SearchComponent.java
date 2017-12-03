package components;

import com.jfoenix.controls.JFXTextField;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 3.12.2017.
 */
public class SearchComponent extends StackPane {


    @FXML private JFXTextField searchTextField;
    private EventHandler onSearchAction;

    public SearchComponent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/components/search_component.fxml"));
            loader.setResources(ResourceBundle.getBundle("fa.fontawesome"));

            loader.setController(this);
            loader.setRoot(this);
            loader.load();

            double tabHeight = Screen.getPrimary().getVisualBounds().getHeight() * 0.05 - 5;
            this.setPrefHeight(tabHeight);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void s(Event e) {
        onSearchAction.handle(e);
    }

    public String getTextFieldText() {
        return searchTextField.getText();
    }

    @FXML
    public EventHandler getOnSearchAction() {
        return onSearchAction;
    }

    @FXML
    public void setOnSearchAction(EventHandler onSearchAction) {
        this.onSearchAction = onSearchAction;
    }
}
