package sk.upjs.ics.fxcontrollers;

import sk.upjs.ics.components.SearchComponent;
import sk.upjs.ics.entity.IEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import sk.upjs.ics.services.interfaces.IEntityService;

import java.util.List;

/**
 * Created by Tomas on 2.12.2017.
 */
public abstract class BaseController<T extends IEntity, ID> implements ISearchHandler {

    private TableView<T> entityTableView;

    private ObservableList<T> entityTableModels;

    private IEntityService<T, ID> entityService;

    @FXML protected SearchComponent searchComponent;

    public void handleSearchAction() {
        String keyword = searchComponent.getSearchWord();

        Service<List<T>> fetchDataService = new Service<List<T>>() {
            protected Task<List<T>> createTask() {
                return new Task<List<T>>() {
                    protected List<T> call() throws Exception {
                        return keyword.trim().equals("")
                                ? entityService.getAll()
                                : entityService.doFulltextSearch(keyword);
                    }
                };
            }
        };

        fetchDataService.setOnSucceeded((eventHandler) -> {
            entityTableModels = FXCollections.observableArrayList(fetchDataService.getValue());
            refresh();
        });

        fetchDataService.start();
    }

    protected void initBaseController(
            TableView<T> entityTableView,
            ObservableList<T> entityTableModels,
            IEntityService<T, ID> entityService
    ) {
        this.entityTableView = entityTableView;
        this.entityTableModels = entityTableModels;
        this.entityService = entityService;

        fitTable();
    }

    protected void initTableView() {
        Service<List<T>> fetchDataService = new Service<List<T>>() {
            protected Task<List<T>> createTask() {
                return new Task<List<T>>() {
                    protected List<T> call() throws Exception {
                        return entityService.getAll();
                    }
                };
            }
        };

        fetchDataService.setOnSucceeded((eventHandler) -> {
            entityTableModels = FXCollections.observableArrayList(fetchDataService.getValue());
            refresh();
        });

        fetchDataService.start();
    }

    private void refresh() {
        entityTableView.getItems().clear();
        entityTableView.getItems().addAll(entityTableModels);
    }

    private void fitTable() {
        entityTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        entityTableView.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
        entityTableView.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight() * 0.83);
    }
}
