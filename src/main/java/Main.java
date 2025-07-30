import com.tarasovvp.kmptemplate.data.repository.DemoObjectRepository;
import com.tarasovvp.kmptemplate.data.repository.PlatformRepository;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        PlatformRepository platformRepo = new PlatformRepository();
        DemoObjectRepository demoRepo = new DemoObjectRepository();

        HBox topPanel = getHBox(platformRepo);

        ListView<String> listView = new ListView<>();
        demoRepo.getDemoObjects().forEach(demo ->
                listView.getItems().add(demo.getName() + ": " + demo.getDescription())
        );

        BorderPane root = new BorderPane();
        root.setTop(topPanel);
        root.setCenter(listView);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("KMP Desktop App");
        stage.setScene(scene);
        stage.show();
    }

    private static HBox getHBox(PlatformRepository platformRepo) {
        Label platformInfoLabel = new Label(platformRepo.getPlatformInfo());
        platformInfoLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> platformInfoLabel.setText(platformRepo.getPlatformInfo()));

        HBox topPanel = new HBox(10, platformInfoLabel, refreshButton);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPadding(new Insets(15));
        topPanel.setStyle("-fx-background-color: #f0f0f0;");
        return topPanel;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
