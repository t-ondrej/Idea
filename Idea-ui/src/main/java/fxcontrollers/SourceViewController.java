package fxcontrollers;

import components.TooltippedTableCell;
import entity.impl.Source;
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
import services.interfaces.ISourceService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class SourceViewController extends BaseController<Source, Long> implements Initializable {

    @FXML private TableView<Source> sourceTableView;
    @FXML private TableColumn<Source, Long> idColumn;
    @FXML private TableColumn<Source, Boolean> anonymisedColumn;
    @FXML private TableColumn<Source, String> asnColumn;
    @FXML private TableColumn<Source, String> attachHandColumn;
    @FXML private TableColumn<Source, String> descriptionColumn;
    @FXML private TableColumn<Source, String> emailColumn;
    @FXML private TableColumn<Source, String> hostnameColumn;
    @FXML private TableColumn<Source, Boolean> impreciseColumn;
    @FXML private TableColumn<Source, String> ip4Column;
    @FXML private TableColumn<Source, String> ip6Column;
    @FXML private TableColumn<Source, String> macColumn;
    @FXML private TableColumn<Source, String> netnameColumn;
    @FXML private TableColumn<Source, String> noteColumn;
    @FXML private TableColumn<Source, String> portColumn;
    @FXML private TableColumn<Source, String> protoColumn;
    @FXML private TableColumn<Source, String> refColumn;
    @FXML private TableColumn<Source, String> routerColumn;
    @FXML private TableColumn<Source, Boolean> spoofedColumn;
    @FXML private TableColumn<Source, String> typeColumn;
    @FXML private TableColumn<Source, String> urlColumn;

    @Autowired
    private ISourceService sourceService;

    private ObservableList<Source> sourceModels;

    public SourceViewController(ISourceService sourceService) {
        this.sourceService = sourceService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sourceModels = FXCollections.observableArrayList(sourceService.getAll());

        initBaseController(sourceTableView, sourceModels, sourceService);

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

        sourceTableView.getItems().addAll(sourceModels);

    }

}
