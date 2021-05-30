import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HomeGUI extends Application {
    private static MyGymManager manager;

    public static void main(String[] args) {
        launch(args);
    }

    public static void setManager(MyGymManager manager0) {
        manager = manager0;
    }

    @Override
    public void start(Stage primaryStage) {
        TableView tableView = new TableView();

        TableColumn<String, DefaultMember> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<String, DefaultMember> column2 = new TableColumn<>("Membership Num");
        column2.setCellValueFactory(new PropertyValueFactory<>("membershipNum"));

        TableColumn<String, DefaultMember> column3 = new TableColumn<>("Membership Date");
        column3.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));

        TableColumn<String, DefaultMember> column4 = new TableColumn<>("Weight");
        column4.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<String, DefaultMember> column5 = new TableColumn<>("Height");
        column5.setCellValueFactory(new PropertyValueFactory<>("height"));









        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);




        for (DefaultMember m : this.manager.getMemList()) {
            tableView.getItems().add(m);
        }

        //tableView.getItems().add(new DefaultMember("12", ));
        Label label1 = new Label("Name:");
        TextField txtName = new TextField();
        Button btnNameSearch = new Button("Search");
        Button btnAll = new Button("All");
        Label label2 = new Label("Number:");
        TextField txtNum = new TextField();
        Button btnNumSearch = new Button("Search");

        btnNameSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tableView.getItems().clear();
                List<DefaultMember> found = manager.getMembyFirstname(txtName.getText());
                for (DefaultMember m : found) {
                    tableView.getItems().add(m);
                }
            }
        });

        btnNumSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tableView.getItems().clear();
                DefaultMember found = manager.getMembyMembershipNum(txtNum.getText());
                tableView.getItems().add(found);
            }
        });

        btnAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tableView.getItems().clear();
                for (DefaultMember m : manager.getMemList()) {
                    tableView.getItems().add(m);
                }
            }
        });

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(label1, txtName, btnNameSearch);
        hb1.setSpacing(10);
        hb1.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, txtNum, btnNumSearch);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hb1, hb2, btnAll, tableView);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}