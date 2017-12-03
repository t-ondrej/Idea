package fxcontrollers;

import utils.TooltippedTableCell;
import entity.impl.Target;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.interfaces.ITargetService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class TargetViewController extends BaseController<Target, Long> implements Initializable {

    @FXML private TableView<Target> targetTableView;
    @FXML private TableColumn<Target, Long> idColumn;
    @FXML private TableColumn<Target, Boolean> anonymisedColumn;
    @FXML private TableColumn<Target, String> asnColumn;
    @FXML private TableColumn<Target, String> attachHandColumn;
    @FXML private TableColumn<Target, String> descriptionColumn;
    @FXML private TableColumn<Target, String> emailColumn;
    @FXML private TableColumn<Target, String> hostnameColumn;
    @FXML private TableColumn<Target, Boolean> impreciseColumn;
    @FXML private TableColumn<Target, String> ip4Column;
    @FXML private TableColumn<Target, String> ip6Column;
    @FXML private TableColumn<Target, String> macColumn;
    @FXML private TableColumn<Target, String> netnameColumn;
    @FXML private TableColumn<Target, String> noteColumn;
    @FXML private TableColumn<Target, String> portColumn;
    @FXML private TableColumn<Target, String> protoColumn;
    @FXML private TableColumn<Target, String> refColumn;
    @FXML private TableColumn<Target, String> routerColumn;
    @FXML private TableColumn<Target, Boolean> spoofedColumn;
    @FXML private TableColumn<Target, String> typeColumn;
    @FXML private TableColumn<Target, String> urlColumn;

    @Autowired
    private ITargetService targetService;

    private ObservableList<Target> targetModels;

    public TargetViewController(ITargetService targetService) {
        this.targetService = targetService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        targetModels = FXCollections.observableArrayList(targetService.getAll());

        initBaseController(targetTableView, targetModels, targetService);

        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        anonymisedColumn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getAnonymised() == null ? false : cellData.getValue().getAnonymised()));
        asnColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getAsn())));
        asnColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        attachHandColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getAttachHand())));
        attachHandColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getDescription())));
        descriptionColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getEmail())));
        emailColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        hostnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getHostname())));
        hostnameColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        impreciseColumn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getImprecise() == null ? false : cellData.getValue().getImprecise()));
        ip4Column.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getIp4())));
        ip4Column.setCellFactory(TooltippedTableCell.forTableColumn());
        ip6Column.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getIp6())));
        ip6Column.setCellFactory(TooltippedTableCell.forTableColumn());
        macColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getMac())));
        macColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        netnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getNetname())));
        netnameColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        noteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()));
        noteColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        portColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getPort())));
        portColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        protoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getProto())));
        protoColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        refColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getRef())));
        refColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        routerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getRouter())));
        routerColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        spoofedColumn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getSpoofed() == null ? false : cellData.getValue().getSpoofed()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getType())));
        typeColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        urlColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getUrl())));
        urlColumn.setCellFactory(TooltippedTableCell.forTableColumn());

        targetTableView.getItems().addAll(targetModels);
    }

}
