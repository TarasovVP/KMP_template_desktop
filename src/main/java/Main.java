import com.tarasovvp.kmptemplate.SystemInfo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        SystemInfo systemInfo = new SystemInfo();
        Label infoLabel = new Label(systemInfo.getInfo());
        infoLabel.setStyle("-fx-font-size: 18px;");
        Label deviceLabel = new Label("Device: " + systemInfo.getDeviceModel());
        Label osLabel = new Label("OS: " + systemInfo.getOsVersion());
        VBox content = new VBox(infoLabel, deviceLabel, osLabel);
        content.setAlignment(Pos.CENTER);
        StackPane root = new StackPane(content);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("KMP Desktop App");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
