import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {
    Label title;
    Label name;
    Label id;
    Image image;
    ImageView imageView;
    Button showHeader;
    Button showFooter;
    GridPane gridPane;
    HBox headerBox;
    HBox footerBox;
    VBox headerButtonBox;
    VBox footerButtonBox;
    VBox imageBox;
    Scene scene;

    @Override

    public void start(Stage primaryStage) throws Exception {
        title = new Label("Welcome to Activity 1");//title in header
        name = new Label("Ahmad Alketnani");//name in footer
        id = new Label("120200317");//id in footer
        image = new Image("image.png");// image in center


        showHeader = new Button("show header");//button to show  header
        showHeader.setOnAction(e -> headerBox.setVisible(true));

        showFooter = new Button("show footer");//button to show footer
        showFooter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (footerBox.isVisible()){
                    footerBox.setVisible(false);
                }else{
                    footerBox.setVisible(true);
                }
            }
        });
//      image view to show image
        imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(600);


//        HBox for header
        headerBox = new HBox(10, title);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setVisible(false);
        headerBox.setPadding(new Insets(10));

//        HBox for footer
        footerBox = new HBox(50, name, id);
        footerBox.setAlignment(Pos.CENTER);
        footerBox.setVisible(false);
        footerBox.setPadding(new Insets(10));

//      VBox for button to show header
        headerButtonBox = new VBox(showHeader);
        headerButtonBox.setAlignment(Pos.CENTER);
        headerButtonBox.setPadding(new Insets(10));

//      VBox for image
        imageBox = new VBox(imageView);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.setPadding(new Insets(10 ));

//      VBox for button to show footer
        footerButtonBox = new VBox(showFooter);
        footerButtonBox.setAlignment(Pos.CENTER);
        footerButtonBox.setPadding(new Insets(10));

//      grid panel to all controls
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(headerBox, 2, 0);
        gridPane.add(headerButtonBox, 1, 1);
        gridPane.add(imageBox, 2, 1);
        gridPane.add(footerButtonBox, 3, 1);
        gridPane.add(footerBox, 2, 3);


//      main scene
        scene = new Scene(gridPane, 900, 600);

        primaryStage.setTitle("Activity 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
