import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameO{
    private Image img;
    private ImageView imgV;
    private Stage page=new Stage();
    public Stage GamesOver(){
	Group group=new Group();
	img=new Image("game.png");
	imgV=new ImageView(img);
	Label lgame=new Label("",imgV);
	lgame.setLayoutX(40);
	lgame.setLayoutY(50);
	img=new Image("over.png");
	imgV=new ImageView(img);
	Label lover=new Label("",imgV);
	lover.setLayoutX(250);
	lover.setLayoutY(50);
	img=new Image("insertcoin.png");
	imgV=new ImageView(img);
	Label licoin=new Label("",imgV);
	licoin.setLayoutY(120);
	licoin.setLayoutX(120);
	img=new Image("btncoin.png");
	imgV=new ImageView(img);
	Button btncoin=new Button("",imgV);
	btncoin.setStyle("-fx-font-size: 1;-fx-base: black");
	btncoin.setLayoutX(380);
	btncoin.setLayoutY(105);
	img=new Image("exit.png");
	imgV=new ImageView(img);
	Button btnexit=new Button("",imgV);
	btnexit.setStyle("-fx-font-size: 1;-fx-base: black");
	btnexit.setLayoutX(180);
	btnexit.setLayoutY(200);
	/**
	 * set on action pour les deux button
	 */
	btnexit.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e){
		    page.close();
		}
	    });
	btncoin.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e){
		    Games g=new Games();
		    page.close();
		}
	    });
	group.getChildren().addAll(lgame,lover,licoin,btncoin,btnexit);
	Scene scene =new Scene(group,500,300,Color.BLACK);
	page.setScene(scene);
	return page;
    }
}
