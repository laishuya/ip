package luigi;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import luigi.ui.MainWindow;

/**
 * A GUI for Luigi using FXML.
 */
public class Main extends Application {
    private static String FILE_PATH = "./data/luigi.txt";
    private Luigi luigi = new Luigi(FILE_PATH);

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Luigi the Chatbot");
            fxmlLoader.<MainWindow>getController().setLuigi(luigi); // inject the Luigi instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
