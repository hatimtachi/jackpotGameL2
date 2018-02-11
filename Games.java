import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
public class Games extends Application {
    private Image[] images;
    private ImageView[] imgV1,imgV2,imgV3;
    private Integer count3=0,count2=0,i=0,count=0,nombreTour=15;
    private Integer stopR,stop2R,stop3R;
    AnimationTimer timer = new MyTimer();
    Condition condi=new Condition();
    private Label creditl=new Label();
    private Label textC=new Label();
    private Label textBet=new Label();
    private Label betl=new Label();
    private Label Winl=new Label();
    private Label labelRandom2=new Label();
    private Label labelRandom3=new Label();
    private Label labelRandom=new Label();
    private Stage page=new Stage();
    private boolean IfClique=false,exit=false;
    private Label textWin=new Label();
    public void init(Stage page) {
        if(exit==false){page.close();}
	images=new Image[7];
	imgV1=new ImageView[7];
	imgV2=new ImageView[7];
	imgV3=new ImageView[7];     
	/**
	 * download les images du random
	 */
	for(int i=0;i<7;i++){
	    images[i]=new Image("img"+(i+1)+".png");
	    imgV1[i]=new ImageView(images[i]);
	    imgV2[i]=new ImageView(images[i]);
	    imgV3[i]=new ImageView(images[i]);
	}
	/**
	 * affichage du random par default
	 */
	labelRandom.setGraphic(imgV1[6]);
	labelRandom2.setGraphic(imgV2[6]);
	labelRandom3.setGraphic(imgV3[6]);
	/**
	 * download les images des boutton
	 */
	Image[] imgBtn=new Image[3];
	ImageView[] imgVbtn=new ImageView[3];
	for(int i=0;i<3;i++){
	    imgBtn[i]=new Image("Btn"+(i+1)+".png");
	    imgVbtn[i]=new ImageView(imgBtn[i]);
	}
	/**
	 * le btn spin
	 */
	Button btnSpin=new Button();
	btnSpin.setLayoutX(420);
	btnSpin.setLayoutY(665);
	Label labelSpin=new Label("",imgVbtn[0]);
	btnSpin.setGraphic(labelSpin);
	btnSpin.setDefaultButton(false);
	btnSpin.setStyle("-fx-font-size: 1;-fx-base: black");
	btnSpin.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e){
		    if(condi.credit>0){
			count=0;count2=0;count3=0;i=0;
			anim();
		    }
		    if(condi.credit<=0){
			GameO go=new GameO();
			page.close();
			go.GamesOver().centerOnScreen();
			go.GamesOver().show();
		    }
		}
	    });
	/**
	 * creation du boutton mise est sa fonction
	 */
	Button btnMise=new Button();
	Label labelMise=new Label("",imgVbtn[2]);
	btnMise.setStyle("-fx-font-size: 1;-fx-base: black");
	btnMise.setGraphic(labelMise);
	btnMise.setLayoutX(300);
	btnMise.setLayoutY(665);
	btnMise.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e){
		    if(condi.mise>=3){
			condi.mise=0;
		    }
		    condi.mise++;
		    textBet.setText(""+condi.getMise());
		}
	    });
	/**
	 * creation du text credit et bit et winne
	 */
	Image img =new Image("backCredit.png");
	ImageView imgV=new ImageView(img);
	creditl.setGraphic(imgV);
	creditl.setLayoutX(100);
	creditl.setLayoutY(580);
	textC.setTextFill(Color.WHITE);
	textC.setLayoutX(130);
	textC.setLayoutY(580);
	textC.setStyle("-fx-font-size:20");
	textC.setText("$"+condi.credit);
	img =new Image("backBet.png");
	imgV=new ImageView(img);
	betl.setGraphic(imgV);
	betl.setLayoutX(280);
	betl.setLayoutY(580);
	textBet.setTextFill(Color.WHITE);
	textBet.setStyle("-fx-font-size:20");
	textBet.setText(""+condi.mise);
	textBet.setLayoutX(295);
	textBet.setLayoutY(580);
	img =new Image("backWinne.png");
	imgV=new ImageView(img);
	Winl.setGraphic(imgV);
	Winl.setLayoutX(395);
	Winl.setLayoutY(580);
	textWin.setText("$"+condi.getWin());
	textWin.setStyle("-fx-font-size:20");
	textWin.setTextFill(Color.WHITE);
	textWin.setLayoutX(400);
	textWin.setLayoutY(580);
	Group groupText =new Group();
	groupText.getChildren().addAll(creditl,textC,betl,textBet,Winl,textWin);
	img=new Image("son1.png");
	imgV=new ImageView(img);
	/**
	 * creation du boutton du son
	 * position et ce qu'il faut qu'il fasse
	 */
	Button btnSon=new Button();
	btnSon.setGraphic(imgV);
	btnSon.setLayoutX(100);
	btnSon.setLayoutY(670);
	btnSon.setStyle("-fx-font-size: 1;-fx-base: black");
	btnSon.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e){
		    if( IfClique==false){
			Image img=new Image("son2.png");
			ImageView imgV=new ImageView(img);
			btnSon.setGraphic(imgV);
			IfClique=true;
		    }
		    else{
			Image img=new Image("son1.png");
			ImageView imgV=new ImageView(img);
			btnSon.setGraphic(imgV);
			IfClique=false;
		    }
		}
	    });
	/**
	 * Fin button
	 */
	/**
	 * position des label de random
	 */
	labelRandom.setLayoutX(70);
	labelRandom.setLayoutY(420);
	labelRandom2.setLayoutX(230);
	labelRandom2.setLayoutY(420);
	labelRandom3.setLayoutY(420);
	labelRandom3.setLayoutX(395);
	Group glabelR=new Group();
	glabelR.getChildren().addAll(labelRandom,labelRandom2,labelRandom3,groupText);
	/**
	 * cree la scene qui ne change pas 
	 */
	Theback nb=new Theback();
	Group ngroup=new Group();
	ngroup=nb.back();
	/**
	 *fin de la creation de la scene
	 */
	Group group =new Group();
	group.getChildren().addAll(ngroup,btnSon,glabelR,btnSpin,btnMise);
	Scene scene =new Scene(group,Color.BLACK);
	page.setScene(scene);
    }
    public void setExit(boolean b){
	this.exit=b;
    }
    public void start(Stage page){
	init(page);
	page.setResizable(false);
	page.show();
    }
    public Games(){
	start(page);
    }
    public static void main(String[] args) {launch(args);}
    private void anim()
    {
	timer.start();
	/**
	 * s'il n'a pas de credit il peut pas jouer
	 */
	if(condi.getCredit()<=0){
	    timer.stop();
	}
    }
    /**
     *
     * @author Hatim
     *les animation et les random
     */
    private class MyTimer extends AnimationTimer
    {
	@Override
	public void handle(long now) {
	    doHandle();
	    doHandle2();
	    doHandle3();
	}
	public void doHandle(){          
	    i++;
	    if(count==nombreTour){
		stop();
	    }
	    if(count<nombreTour){
		condi.random();
		stopR=condi.getStopR();
		if(i%5==0){
		    if(labelRandom.getGraphic()==imgV1[stopR]){
			labelRandom.setGraphic(imgV1[stopR]);
			count++;
		    }
		    else{
			labelRandom.setGraphic(imgV1[stopR]);
			count++;
		    }
		}
	    }
	}
	public void doHandle2(){
	    if(count2==nombreTour)
		stop();
	    if(count2<nombreTour){
		stop2R=condi.getStopR2();
		if(i%5==0){
		    if(labelRandom2.getGraphic()==imgV2[stop2R]){
			labelRandom2.setGraphic(imgV2[stop2R]);
			count2++;
		    }
		    else{
			labelRandom2.setGraphic(imgV2[stop2R]);
			count2++;
		    }
		}
	    }
	}
	public void doHandle3(){
	    if(count3==nombreTour){
		stop();
		condi.getStopR();
		condi.getStopR2();
		condi.getStopR3();
		condi.condition();
		textC.setText("$"+condi.credit());
		textWin.setText("$"+condi.getWin()); 
	    }
	    if(count3<nombreTour){
		stop3R=condi.getStopR3();
		if(i%5==0){
		    if(labelRandom3.getGraphic()==imgV3[stop3R]){
			labelRandom3.setGraphic(imgV3[stop3R]);
			count3++;
		    }
		    else{
			labelRandom3.setGraphic(imgV3[stop3R]);
			count3++;
		    }
		}
	    }
	}
    }
}

     
