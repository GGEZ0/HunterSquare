package Bar;

import Application.Board;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.States;

public class StatusBar extends VBox{
	//private Label warning;
	private Label currentside;
	private Label currentState;
	private Button AddButton;
	private Button MoveButton;
	private Button AtkButton;
	private Button StkButton;
	private Button SrdButton;
	private Button DoneButton;
	private Board board;
	
	public StatusBar(Board board) {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(15);
		this.setFillWidth(true);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LAVENDER, null, null)));
		
		Image img1 = new Image("background/statusimg5.png");
		Pane p = new Pane();
		p.setPrefHeight(130);
		p.setPrefWidth(100);
		BackgroundFill bgFill = new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(300,130,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(img1, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		p.setBackground(new Background(bgFillA,bgImgA));
		this.getChildren().add(p);
		
		Text t = new Text("Status Bar");
		t.setFont(Font.font("Forte",FontWeight.NORMAL,40));
		this.getChildren().add(t);
		
		/*Label s = new Label("Status Bar");
		s.setFont(new Font(25));
		this.getChildren().add(s);*/
		
		this.board = board;
		
		this.currentside = new Label("WHITE TURN");
		this.currentside.setFont(new Font(18));
		this.getChildren().add(currentside);
		
		this.currentState = new Label("STATE : " + this.board.getState());
		this.currentState.setFont(new Font(18));
		this.getChildren().add(currentState);
		// TODO setOnAction and update when it change not done 
		this.AddButton = new Button();
		this.AddButton.setText("ADD");
		this.AddButton.prefWidth(150);
		AddButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AddHandler();				
			}
		});
		this.getChildren().add(AddButton);
		
		this.MoveButton = new Button();
		this.MoveButton.setText("MOVE");
		this.MoveButton.prefWidth(150);
		MoveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				MoveHandler();
			}
		});
		this.getChildren().add(MoveButton);
		
		this.AtkButton = new Button();
		this.AtkButton.setText("ATTACK");
		this.AtkButton.prefWidth(150);
		AtkButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AtkHandler();
			}
		});
		this.getChildren().add(AtkButton);
		
		this.StkButton = new Button();
		this.StkButton.setText("STACK");
		this.StkButton.prefWidth(150);
		StkButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				StkHandler();
			}
		});
		this.getChildren().add(StkButton);
		
		this.SrdButton = new Button();
		this.SrdButton.setText("SURRENDER");
		this.SrdButton.prefWidth(150);
		SrdButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SrdHandler();
			}
		});
		this.getChildren().add(SrdButton);
		
		this.DoneButton = new Button();
		this.DoneButton.setText("DONE");
		this.DoneButton.prefWidth(150);
		DoneButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// error
				if(board.getCurrentside() == 0) {
					board.whitedone = true;
					board.switchcurrentside();
				}
				else {
					board.blackdone = true;
					board.switchcurrentside();
				}
			}
		});
		this.getChildren().add(DoneButton);
			
	}
	
	public void updateStatusbar() {
		if(this.board.getCurrentside() == 0) {
			this.currentside.textProperty().setValue("WHITE TURN");
		}
		else {
			this.currentside.textProperty().setValue("BLACK TURN");
		}
		//this.currentside.textProperty().setValue("" + this.board.getCurrentside());
		this.currentState.textProperty().setValue("STATE : " + this.board.getState());
	}
	
	public void SrdHandler() {
		// TODO	
		if(this.board.getCurrentside() == 0) {
			this.board.showWinner(1);
		}
		else {
			this.board.showWinner(0);
		}
		//this.board.resetBoard();
	}
	
	public void AddHandler() {
		if(!this.board.getState().equals(States.INIT)) {
			this.board.setState(States.ADD);
			this.currentState.textProperty().setValue("STATE : " + this.board.getState());
			for(int i = 0; i < this.board.getPieceCells().size(); i++) {
				this.board.getPieceCells().get(i).unhighlight();
			}
		}
	}
	
	public void MoveHandler() {
		if(!this.board.getState().equals(States.INIT)) {
			this.board.setState(States.MOVE);
			this.currentState.textProperty().setValue("STATE : " + this.board.getState());
			for(int i = 0; i < this.board.getPieceCells().size(); i++) {
				this.board.getPieceCells().get(i).unhighlight();
			}
		}
	}
	
	public void AtkHandler() {
		if(!this.board.getState().equals(States.INIT)) {
			this.board.setState(States.ATTACK);
			this.currentState.textProperty().setValue("STATE : " + this.board.getState());
			for(int i = 0; i < this.board.getPieceCells().size(); i++) {
				this.board.getPieceCells().get(i).unhighlight();
			}
		}
	}
	
	public void StkHandler() {
		if(!this.board.getState().equals(States.INIT)) {
			this.board.setState(States.STACK);
			this.currentState.textProperty().setValue("STATE : " + this.board.getState());
			for(int i = 0; i < this.board.getPieceCells().size(); i++) {
				this.board.getPieceCells().get(i).unhighlight();
			}
		}
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	/*public Button getDoneButton() {
		return DoneButton;
	}*/

	public void setDoneButton(Button doneButton) {
		DoneButton = doneButton;
	}

	public Node getDoneButton() {
		return DoneButton;
	}
	
	
	

}
