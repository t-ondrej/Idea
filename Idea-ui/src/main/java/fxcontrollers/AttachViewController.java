package fxcontrollers;

import components.TooltippedTableCell;
import entity.impl.Attach;
import javafx.beans.property.SimpleIntegerProperty;
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
import services.interfaces.IAttachService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tomas on 27.11.2017.
 */
@Component
public class AttachViewController extends BaseController<Attach, Long> implements Initializable {

    @FXML private TableView<Attach> attachTableView;
    @FXML private TableColumn<Attach, Long> idColumn;
    @FXML private TableColumn<Attach, String> contentColumn;
    @FXML private TableColumn<Attach, String> contentCharsetColumn;
    @FXML private TableColumn<Attach, String> contentEncodingColumn;
    @FXML private TableColumn<Attach, String> contentIdColumn;
    @FXML private TableColumn<Attach, String> contentTypeColumn;
    @FXML private TableColumn<Attach, String> externalUriColumn;
    @FXML private TableColumn<Attach, String> filenameColumn;
    @FXML private TableColumn<Attach, String> handleColumn;
    @FXML private TableColumn<Attach, String> hashColumn;
    @FXML private TableColumn<Attach, String> noteColumn;
    @FXML private TableColumn<Attach, String> refColumn;
    @FXML private TableColumn<Attach, Integer> sizeColumn;
    @FXML private TableColumn<Attach, String> typeColumn;

    @Autowired
    private IAttachService attachService;

    private ObservableList<Attach> attachModels;

    public AttachViewController(IAttachService attachService) {
        this.attachService = attachService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        attachModels = FXCollections.observableArrayList(attachService.getAll());

        initBaseController(attachTableView, attachModels, attachService);

        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        contentColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContent()));
        contentColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        contentCharsetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContentCharset()));
        contentCharsetColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        contentEncodingColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContentEncoding()));
        contentEncodingColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        contentIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getContentId())));
        contentIdColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        contentTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContentType()));
        contentTypeColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        externalUriColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getExternalUri())));
        externalUriColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        filenameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getFileName())));
        filenameColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        handleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getFileName())));
        handleColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        hashColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getHash().toString())));
        hashColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        noteColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()));
        noteColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        refColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getRef().toString())));
        refColumn.setCellFactory(TooltippedTableCell.forTableColumn());
        sizeColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSize() == null ? 0 : cellData.getValue().getSize()).asObject());
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getType())));
        typeColumn.setCellFactory(TooltippedTableCell.forTableColumn());

        attachTableView.getItems().addAll(attachModels);
    }

}
