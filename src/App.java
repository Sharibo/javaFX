import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
            new PieChart.Data("Data 1", 20),
            new PieChart.Data("Data 2", 10),
            new PieChart.Data("Data 3", 30)
        );

        Button btn1 = new Button("Add data");

        btn1.setOnAction((event) -> {
            data.add( new PieChart.Data("Data " + (data.size() + 1),
                      10 + new Random().nextInt(30)) );
        });

        Button btn2 = new Button("Delete data");

        btn2.setOnAction((event) -> {
            if (!data.isEmpty()) {
                data.remove( new Random().nextInt(data.size()) );
            }
        });

        //* . . . . .

        PieChart pie = new PieChart(data);
        
        FlowPane root = new FlowPane();
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(pie);

        Scene scene = new Scene(root, 450, 500);

        primaryStage.setTitle("Data demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}