import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Menu1 extends Application{
    public static void main(String[] args){
    launch(args);
    }
    public void init(Stage page){
     Image img=new Image("BackgroundF.png");
     ImageView imgV =new ImageView();
     imgV.setImage(img);
     page.setTitle("GAME");
     page.setWidth(600);
     page.setHeight(400);
     Button btnClose=new Button();
     Button btnStart=new Button();
     btnStart.setText("Start");
     btnStart.setStyle("-fx-font-size: 22;-fx-base: black");
     btnClose.setStyle("-fx-font-size: 20;-fx-base: black");
     btnStart.setOnAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent e){
             new Games();
             page.close();}
         });
     btnClose.setText("Close");
     btnClose.setOnAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent e){
             page.close();
         }
         });
     VBox btn=new VBox();
     btn.getChildren().add(btnStart);
     btn.getChildren().add(btnClose);
     btn.setLayoutX(250);
     btn.setLayoutY(150);
     Group group=new Group();
     Label label=new Label("",imgV);
     group.getChildren().addAll(label,btn);
     Scene scene =new Scene(group);
     page.setScene(scene);
   //  page.show();
        page.setResizable(false);
    }
    public void start(Stage page){
     init(page);
     page.show();
    }
    public Menu1(){
     Stage page=new Stage();
     init(page);
    }
}

     
