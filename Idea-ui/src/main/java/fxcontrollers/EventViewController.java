package fxcontrollers;

import entity.impl.Event;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.interfaces.IEventService;
import utils.TooltippedTableCell;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class EventViewController extends BaseController<Event, String> implements Initializable {

    @FXML private TableView<Event> eventTableView;
    @FXML private TableColumn<Event, String> idColumn;
    @FXML private TableColumn<Event, String> formatColumn;
    @FXML private TableColumn<Event, Date> createTimeColumn;
    @FXML private TableColumn<Event, Date> detectTimeColumn;
    @FXML private TableColumn<Event, Date> winStartTimeColumn;
    @FXML private TableColumn<Event, Date> winEndTimeColumn;
    @FXML private TableColumn<Event, Date> eventTimeColumn;
    @FXML private TableColumn<Event, Date> ceaseTimeColumn;
    @FXML private TableColumn<Event, Integer> confidenceColumn;
    @FXML private TableColumn<Event, String> noteColumn;
    @FXML private TableColumn<Event, Integer> connCountColumn;
    @FXML private TableColumn<Event, String> categoryColumn;
    @FXML private TableColumn<Event, String> refColumn;
    @FXML private TableColumn<Event, String> altnamesColumn;
    @FXML private TableColumn<Event, String> corelidColumn;
    @FXML private TableColumn<Event, String> aggridColumn;
    @FXML private TableColumn<Event, String> predidColumn;
    @FXML private TableColumn<Event, String> relidColumn;
    @FXML private TableColumn<Event, Integer> flowCountColumn;
    @FXML private TableColumn<Event, Integer> packetCountColumn;
    @FXML private TableColumn<Event, Integer> byteCountColumn;
    @FXML private TableColumn<Event, String> descriptionColumn;

    @Autowired
    private IEventService eventService;

    private ObservableList<Event> eventModels;

    public EventViewController(IEventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBaseController(eventTableView, eventModels, eventService);
        initTableView();

        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        idColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        formatColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormat()));
        formatColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        createTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCreateTime()));
        detectTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDetectTime()));
        winStartTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getWinStartTime()));
        winEndTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getWinEndTime()));
        eventTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEventTime()));
        ceaseTimeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCeaseTime()));
        confidenceColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getConfidence()).asObject());
        noteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()));
        noteColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        connCountColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getConnCount()).asObject());
        categoryColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getCategory())));
        categoryColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        refColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getRef())));
        refColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        altnamesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getAltnames())));
        altnamesColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        corelidColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getCorrelID())));
        corelidColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        aggridColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getAggrId())));
        aggridColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        predidColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getPredId())));
        predidColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        relidColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getRelId())));
        relidColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        flowCountColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getFlowCount()).asObject());
        packetCountColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPacketCount()).asObject());
        byteCountColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getByteCount()).asObject());
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        descriptionColumn.setCellFactory(TooltippedTableCell.forTableColumn());
    }
}
