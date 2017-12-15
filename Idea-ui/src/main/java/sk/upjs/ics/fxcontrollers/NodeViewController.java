package sk.upjs.ics.fxcontrollers;

import sk.upjs.ics.entity.impl.Node;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.upjs.ics.services.interfaces.INodeService;
import sk.upjs.ics.utils.TooltippedTableCell;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class NodeViewController extends BaseController<Node, Long> implements Initializable {

    @FXML private TableView<Node> nodeTableView;
    @FXML private TableColumn<Node, Long> idColumn;
    @FXML private TableColumn<Node, Time> aggrWinColumn;
    @FXML private TableColumn<Node, String> nameColumn;
    @FXML private TableColumn<Node, String> noteColumn;
    @FXML private TableColumn<Node, String> swColumn;
    @FXML private TableColumn<Node, String> typeColumn;

    @Autowired
    private INodeService nodeService;

    private ObservableList<Node> nodeModels;

    public NodeViewController(INodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBaseController(nodeTableView, nodeModels, nodeService);
        initTableView();

        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        aggrWinColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAggrWin()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        nameColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        noteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()));
        noteColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        swColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getSw())));
        swColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getType())));
        typeColumn.setCellFactory(TooltippedTableCell.forTableColumn());
    }
}
