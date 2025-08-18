import com.tarasovvp.kmptemplate.SystemInfo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label(new SystemInfo().getInfo());
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        StackPane root = new StackPane(label);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("KMP Desktop App");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
