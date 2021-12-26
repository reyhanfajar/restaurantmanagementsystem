package application;

import javafx.application.Application;
import application.Food;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class TableViewSample extends Application {
    private TableView<Food> table = new TableView<Food>();
    private final ObservableList<Food> data =
            FXCollections.observableArrayList(
            new Food("1", "Nasi Goreng", "25.000"),
            new Food("2", "Ayam Goreng", "30.000"),
            new Food("3", "Soto Kudus", "20.000"));
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View");
        stage.setWidth(450);
        stage.setHeight(550);
 
        final Label label = new Label("Admin List Menu");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
             new Callback<TableColumn, TableCell>() {
                 public TableCell call(TableColumn p) {
                    return new EditingCell();
                 }
             };
 
        TableColumn idCol = new TableColumn("Id");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
            new PropertyValueFactory<Food, String>("id"));
        idCol.setCellFactory(cellFactory);
        idCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Food, String>>() {
                @Override
                public void handle(CellEditEvent<Food, String> t) {
                    ((Food) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setId(t.getNewValue());
                }
             }
        );
 
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
            new PropertyValueFactory<Food, String>("name"));
        nameCol.setCellFactory(cellFactory);
        nameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Food, String>>() {
                @Override
                public void handle(CellEditEvent<Food, String> t) {
                    ((Food) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                }
            }
        );
 
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(200);
        priceCol.setCellValueFactory(
            new PropertyValueFactory<Food, String>("price"));
        priceCol.setCellFactory(cellFactory);
        priceCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Food, String>>() {
                @Override
                public void handle(CellEditEvent<Food, String> t) {
                    ((Food) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPrice(t.getNewValue());
                }
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(idCol, nameCol, priceCol);
 
        final TextField addId = new TextField();
        addId.setPromptText("Id");
        addId.setMaxWidth(idCol.getPrefWidth());
        final TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Name");
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(priceCol.getPrefWidth());
        addPrice.setPromptText("Price");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Food(
                        addId.getText(),
                        addName.getText(),
                        addPrice.getText()));
                addId.clear();
                addName.clear();
                addPrice.clear();
            }
        });
 
        hb.getChildren().addAll(addId, addName, addPrice, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}