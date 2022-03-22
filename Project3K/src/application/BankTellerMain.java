package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * This is the Main class
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class BankTellerMain extends Application {

	/**
	 * start() sets the scene for our BankTellerView.fxml via SceneBuilder.
	 * @param stage Object of type Stage.
	 */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BankTellerView.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Bank App");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main() launches our .fxml file via SceneBuilder.
     * @param args Object of type String.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
