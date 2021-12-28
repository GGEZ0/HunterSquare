package Application;

import Bar.Piece_Bar;
import Bar.StatusBar;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Management;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setPrefWidth(850);
		vb.setSpacing(5);
		vb.setFillWidth(true);
		vb.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		Board board = new Board();
		Piece_Bar wb = new Piece_Bar(0);
		Piece_Bar bb = new Piece_Bar(1);
		StatusBar sb = new StatusBar(board);
		
		vb.getChildren().add(bb);
		vb.getChildren().add(board);
		vb.getChildren().add(wb);
		
		Management.setWhitepiecebar(wb);
		Management.setBalckpiecebar(bb);
		Management.setSb(sb);
		
		HBox hb = new HBox();
		hb.setSpacing(5);
		hb.setPadding(new Insets(10));
		hb.setPrefHeight(700);
		
		hb.getChildren().add(vb);
		hb.getChildren().add(sb);
		
		Scene scene = new Scene(hb);
		
		/*primaryStage.setScene(scene);
		primaryStage.setTitle("TEE_PEA");
		primaryStage.setResizable(false);
		primaryStage.show();*/
		
		
	//-----------------------------------------
	// all about intro (main menu etc)
		
		String buttonStyle = "-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial\"; -fx-background-color: linear-gradient(peru,orange);";
		String titleTextStyle = "-fx-font-size: 40px; -fx-font-family:\"Arial white\";-fx-fill: white;";
		
		
		//---------------------------------------------------------------------------------------
		//introScene
		
		VBox root = new VBox();
		
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		
		Text gameTitle = new Text("HunterSquare");
		//gameTitle.setFont(Font.font("Monospaced",FontWeight.BOLD,20));
		gameTitle.setStyle(titleTextStyle);
		
		
		Button playButton = new Button("Play");
		Button instructionButton = new Button("How to play");
		Button credits = new Button("Credits");
		Button exit = new Button("Exit");
		
		//set style
		
		
		
		//Image image = new Image("background/boardforstartmenu2.png");
		
		
		Image imageFormainmenu = new Image("background/backforstartmenu2.png");
		BackgroundFill bgFill = new BackgroundFill(Color.CORNSILK, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(900,600,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(imageFormainmenu, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		root.setBackground(new Background(bgFillA,bgImgA));
		
		//root.setStyle("-fx-background-image: url(\'background/backforstartmenu2.png\'); ");
		
		playButton.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial\"; -fx-background-color: linear-gradient(peru,orange);");
		instructionButton.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial\"; -fx-background-color: linear-gradient(peru,orange);");
		credits.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial\"; -fx-background-color: linear-gradient(peru,orange);");
		exit.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial\"; -fx-background-color: linear-gradient(peru,orange);");
		
		//#4568DC,#B06AB3
		//skyblue,steelblue,royalblue
		
		playButton.setPrefWidth(100);
		instructionButton.setPrefWidth(100);
		credits.setPrefWidth(100);
		exit.setPrefWidth(100);
		
		
		root.getChildren().addAll(gameTitle, playButton,instructionButton,credits,exit);
		
		Scene introScene = new Scene(root, 500, 300);
		

		//-------------------------------------------------------------------------------------------------
		//instructionScene1
		
		VBox instructionRoot1 = new VBox();
		
		instructionRoot1.setAlignment(Pos.CENTER);
		instructionRoot1.setSpacing(10);
		
		//instructionRoot1.setStyle("-fx-background-color: linear-gradient(#4568DC,#B06AB3)");
		instructionRoot1.setBackground(new Background(bgFillA,bgImgA));
		
		//*******************************
		//buttonBar1
		
		HBox buttonBar1 = new HBox();
		buttonBar1.setSpacing(10);
		buttonBar1.setAlignment(Pos.CENTER);
		
		Button nextButton1 = new Button("Next");
		Button goBack1 = new Button("Go back to main menu");
		
		nextButton1.setStyle(buttonStyle);
		goBack1.setStyle(buttonStyle);
		
		nextButton1.setPrefWidth(200);
		goBack1.setPrefWidth(200);
		
		buttonBar1.getChildren().addAll(goBack1,nextButton1);
		
		//*******************************
		//instructionBox1
		
		//Label instructionBox1 = new Label(" 1234567890123456789012345678901234567890 \n hello ");
		Label instructionBox1 = new Label(" The game will start by letting both players put their \n piece on the board. which can be done by clicking \n the icon on your side and clicking the cell on the \n board where the player want to place thier piece \n \n you can add up to 26 pieces but if you are satisfied \n with the amount at anytime you can press \n the done button. If the opponent side also press the \n done button then the game will start \n there will be text on the status bar telling whose turn \n to place their piece. \n Player can win by killing opponent's king or opponents \n click surrender button");
		instructionBox1.setPrefSize(400, 250);
		
		instructionBox1.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family:\"Arial\";-fx-background-color: linear-gradient(peru,orange);");
		
		

		//*******************************
		
		instructionRoot1.getChildren().addAll(instructionBox1,buttonBar1);
		Scene instructionScene1 = new Scene(instructionRoot1,500,300);
		
		
		//-------------------------------------------------------------------------------------------------
		//instructionScene2
		
		VBox instructionRoot2 = new VBox();
		
		instructionRoot2.setAlignment(Pos.CENTER);
		instructionRoot2.setSpacing(10);
		
		//instructionRoot2.setStyle("-fx-background-color: linear-gradient(#4568DC,#B06AB3)");
		instructionRoot2.setBackground(new Background(bgFillA,bgImgA));
		
		
		//*******************************
		//buttonBar2
		
		HBox buttonBar2 = new HBox();
		buttonBar2.setSpacing(10);
		buttonBar2.setAlignment(Pos.CENTER);
		
		//Button nextButton2 = new Button("Next");
		Button goBack2 = new Button("Go back to main menu");
		Button prevButton2 = new Button("Previous");
		
		//nextButton2.setStyle(buttonStyle);
		goBack2.setStyle(buttonStyle);
		prevButton2.setStyle(buttonStyle);
		
		//nextButton2.setPrefWidth(150);
		goBack2.setPrefWidth(200);
		prevButton2.setPrefWidth(200);
		
		buttonBar2.getChildren().addAll(prevButton2,goBack2);
		
		//*******************************
		//instructionBox2
		
		Label instructionBox2 = new Label(" In each turn Player can choose one of four action for \n their selected piece to perform : Adding, Moving, \n Attacking, and Stacking. If the player want to add their \n piece, they can do that by clicking ADD button \n ,clicking the selected piece \n and clicking the placement for the piece. \n If the player want to do other actions, simply click the \n button on the status bar correspond to that action, then \n click the piece that the player want to make it act out. \n then click the ActionBlock (highlighted in blue) \n (which is the location that the selected piece will \n perform their action). \n Note that all of this is allowed if it's that player turn");
		instructionBox2.setPrefSize(400, 250);
		instructionBox2.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family:\"Arial\";-fx-background-color: linear-gradient(peru,orange);");


		//*******************************
		
		instructionRoot2.getChildren().addAll(instructionBox2,buttonBar2);
		Scene instructionScene2 = new Scene(instructionRoot2,500,300);
		
		
		//-------------------------------------------------------------------------------------------------------
		//creditsScene
		
		
		VBox creditsRoot = new VBox();
		
		creditsRoot.setAlignment(Pos.CENTER);
		creditsRoot.setSpacing(10);
		
		//creditsRoot.setStyle("-fx-background-color: linear-gradient(#4568DC,#B06AB3)");
		creditsRoot.setBackground(new Background(bgFillA,bgImgA));
		
		
		//*******************************
		//button
		
		Button creditsgoBack = new Button("Go back to main menu");
		
		creditsgoBack.setAlignment(Pos.CENTER);
		
		creditsgoBack.setStyle(buttonStyle);

		creditsgoBack.setPrefWidth(200);

		
		//*******************************
		//creditsBox
		
		Label creditsBox = new Label(" Sukij Sunitsakul \n 6330548021 \n Sutee Siriboon \n 6330553121");
		creditsBox.setPrefSize(400, 200);
		creditsBox.setStyle("-fx-font-size: 32px; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family:\"Arial\";-fx-background-color: linear-gradient(peru,orange);");


		//*******************************
		
		creditsRoot.getChildren().addAll(creditsBox,creditsgoBack);
		Scene creditsScene = new Scene(creditsRoot,500,300);
		
		
		
		//-------------------------------------------------------------------------------------------------------
		
		// linking button with scenes
		
		instructionButton.setOnAction(e -> primaryStage.setScene(instructionScene1));
		credits.setOnAction(e -> primaryStage.setScene(creditsScene));
		nextButton1.setOnAction(e -> primaryStage.setScene(instructionScene2));
		prevButton2.setOnAction(e -> primaryStage.setScene(instructionScene1));
		goBack1.setOnAction(e -> primaryStage.setScene(introScene));
		goBack2.setOnAction(e -> primaryStage.setScene(introScene));
		creditsgoBack.setOnAction(e -> primaryStage.setScene(introScene));
		
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				primaryStage.close();
				
			}
		});
		
		playButton.setOnAction(e -> primaryStage.setScene(scene));
		
		
		
		//-------------------------------------------------------------------------------------------------
		
		

		primaryStage.setTitle("HunterSquare");
		primaryStage.setScene(introScene);
		primaryStage.show();
		
		primaryStage.setResizable(false);
		
		//-------------------------------------------------------------------------------------------------		
		
		

	}

	public static void main(String[] args) {
		launch(args);
	}
   
}
