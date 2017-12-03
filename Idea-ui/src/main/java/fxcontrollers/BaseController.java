package fxcontrollers;

import components.TooltippedTableCell;
import entity.IEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import services.interfaces.IEntityService;

import java.util.List;

/**
 * Created by Tomas on 2.12.2017.
 */
public abstract class BaseController<T extends IEntity, ID> implements ISearchHandler {

    private TableView<T> entityTableView;

    private ObservableList<T> entityTableModels;

    private IEntityService<T, ID> entityService;

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

    public void handleSearchAction(String keyword) {
        List<T> result;
        if (keyword.trim().equals(""))
            result = entityService.getAll();
        else
            result = entityService.doFulltextSearch(keyword);
        entityTableModels = FXCollections.observableArrayList(result);

        refresh();
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
