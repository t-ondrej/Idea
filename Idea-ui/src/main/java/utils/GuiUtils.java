package utils;

import com.sun.javafx.scene.control.skin.NestedTableColumnHeader;
import com.sun.javafx.scene.control.skin.TableColumnHeader;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.javafx.scene.control.skin.TableViewSkin;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tomas on 30.11.2017.
 */
public class GuiUtils {
    private static Method columnToFitMethod;

    static {
        try {
            columnToFitMethod = TableViewSkin.class.getDeclaredMethod("resizeColumnToFitContent", TableColumn.class, int.class);
            columnToFitMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void autoFitTable3(TableView tableView) {
        TableViewSkin<?> skin = (TableViewSkin<?>) tableView.getSkin();
        TableHeaderRow headerRow = skin.getTableHeaderRow();
        NestedTableColumnHeader rootHeader = headerRow.getRootHeader();
        for (TableColumnHeader columnHeader : rootHeader.getColumnHeaders()) {
            try {
                TableColumn<?, ?> column = (TableColumn<?, ?>) columnHeader.getTableColumn();
                if (column != null) {
                    Method method = skin.getClass().getDeclaredMethod("resizeColumnToFitContent", TableColumn.class, int.class);
                    method.setAccessible(true);
                    method.invoke(skin, column, 30);
                }
            } catch (Throwable e) {
                e = e.getCause();
                e.printStackTrace(System.err);
            }
        }
    }

    public static void autoFitTable(TableView tableView) {
        tableView.getItems().addListener((ListChangeListener<Object>) c -> {
            for (Object column : tableView.getColumns()) {
                try {
                    columnToFitMethod.invoke(tableView.getSkin(), column, -1);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void customResize(TableView<?> view) {
        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
            });
        }
    }
}
