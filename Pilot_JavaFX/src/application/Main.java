package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.paint.Color; 
import javafx.stage.StageStyle;


public class Main extends Application {
	//Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view1.fxml"));//loading first FXML
			Scene scene = new Scene(loader.load());
			scene.setFill(Color.TRANSPARENT);
	        primaryStage.setScene(scene);
	        primaryStage.initStyle(StageStyle.TRANSPARENT);//for styling purpose
	        primaryStage.setResizable(false);
	        primaryStage.setTitle("Calculator");//setting title
	        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("calculator.png")));//setting icon
	        //getting controller and calling initializer function
	        ((SampleController)loader.getController()).init(primaryStage);
	        primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
        Application.launch(Main.class, args);
	}
}
