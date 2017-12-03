package fxcontrollers;

import components.SearchComponent;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TabPane;
import javafx.stage.Screen;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class MainViewController implements Initializable {

    @FXML private EventViewController eventViewController;
    @FXML private AttachViewController attachViewController;
    @FXML private NodeViewController nodeViewController;
    @FXML private SourceViewController sourceViewController;
    @FXML private TargetViewController targetViewController;

    @FXML private TabPane mainTabPane;

    private ISearchHandler currentSearchHandler;

    public void initialize(URL location, ResourceBundle resources) {
        currentSearchHandler = eventViewController;

        double tabWidth = Screen.getPrimary().getVisualBounds().getWidth() * 0.2 - 5;
        double tabHeight = Screen.getPrimary().getVisualBounds().getHeight() * 0.05 - 5;

        mainTabPane.setTabMinWidth(tabWidth);
        mainTabPane.setTabMinHeight(tabHeight);

        mainTabPane.setTabMaxWidth(tabWidth);
        mainTabPane.setTabMaxHeight(tabHeight);

        mainTabPane.getSelectionModel().selectedItemProperty().addListener(
                (ov, oldTab, newTab) -> {
                    switch (newTab.getText()) {
                        case "Events":
                            this.currentSearchHandler = eventViewController;
                            break;
                        case "Attachs":
                            this.currentSearchHandler = attachViewController;
                            break;
                        case "Nodes":
                            this.currentSearchHandler = nodeViewController;
                            break;
                        case "Sources":
                            this.currentSearchHandler = sourceViewController;
                            break;
                        case "Targets":
                            this.currentSearchHandler = targetViewController;
                            break;
                    }
                }
        );
    }

    @FXML
    public void onSearchButtonClicked() {
        Parent n1 = (Parent)mainTabPane.getSelectionModel().getSelectedItem().getContent();
        List<Node> ss =  n1.getChildrenUnmodifiable();//.filtered(s -> s.getId().equals("searchControl"));
        SearchComponent searchComponent = (SearchComponent)ss.get(0);
        currentSearchHandler.handleSearchAction(searchComponent.getTextFieldText());
    }
}
