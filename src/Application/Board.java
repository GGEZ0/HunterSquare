package Application;

import java.util.Optional;

import Piece.Blank;
import Piece.King;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import logic.Management;
import logic.States;

public class Board extends GridPane{
	//private Piece_Base[][] piece;
	private ObservableList<PieceCell> PieceCells = FXCollections.observableArrayList();
	private States state;
	public boolean whitedone; // button done in statusbar
	public boolean blackdone;
	public int WhitePieceOnfield;
	public int BlackPieceOnfield;
	private int currentside;
	
	public Board() {
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(5));
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		//this.setBackground(new Background(new BackgroundFill(Color.LAVENDER, null, null)));
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				PieceCell pane = new PieceCell(this, new Blank(-1,j,i));
				this.add(pane,j,i);
				PieceCells.add(pane);
			}
		}
		
		Image image = new Image("background/boardbackground.jpg");
		BackgroundFill bgFill = new BackgroundFill(Color.CORNSILK, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(900,600,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		
		this.PieceCells.get(76).setPiece(new King(0,4,8));
		this.PieceCells.get(76).setBackgroundColor(new Image("White_KingT1.png"));
		this.PieceCells.get(4).setPiece(new King(1,4,0));
		this.PieceCells.get(4).setBackgroundColor(new Image("Black_KingT1.png"));
		
		this.WhitePieceOnfield = 1;
		this.BlackPieceOnfield = 1;
		
		this.currentside = 0;
		this.state = States.INIT;
		this.whitedone = false;
		this.blackdone = false;
	}
	
	public void resetBoard() {
		for(int i = 0; i < PieceCells.size(); i++) {
			int x = i % 9;
			int y = (i-x)/9;
			this.PieceCells.get(i).setPiece(new Blank(-1,x,y));
			this.PieceCells.get(i).setBackgroundColor();
		}
		this.PieceCells.get(76).setPiece(new King(0,4,8));
		this.PieceCells.get(76).setBackgroundColor(new Image("White_KingT1.png"));
		this.PieceCells.get(4).setPiece(new King(1,4,0));
		this.PieceCells.get(4).setBackgroundColor(new Image("Black_KingT1.png"));
		
		this.WhitePieceOnfield = 1;
		this.BlackPieceOnfield = 1;
		
		this.currentside = 0;
		this.state = States.INIT;
		this.whitedone = false;
		this.blackdone = false;
		
		Management.updateStatusBar();
		Management.newgameforPieceBar();
		Management.getSb().getDoneButton().setVisible(true);
	}
	
	public void showWinner(int side) {
		String rside;
		if(side == 0) {
			rside = "WHITE";
		}
		else {
			rside = "BLACK";
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("GAME END!!!");
		alert.setHeaderText(null);
		alert.setContentText("The winner is " + rside);
		ButtonType ok = new ButtonType("Reset");
		alert.getButtonTypes().setAll(ok);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ok) {
			this.resetBoard();
		}
	}
	
	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	public ObservableList<PieceCell> getPieceCells() {
		return PieceCells;
	}

	public int getWhitePieceOnfield() {
		return WhitePieceOnfield;
	}


	public void setWhitePieceOnfield(int whitePieceOnfield) {
		WhitePieceOnfield = whitePieceOnfield;
	}


	public int getBlackPieceOnfield() {
		return BlackPieceOnfield;
	}


	public void setBlackPieceOnfield(int blackPieceOnfield) {
		BlackPieceOnfield = blackPieceOnfield;
	}


	public int getCurrentside() {
		return currentside;
	}
	
	public void switchcurrentside() {
		if(!this.state.equals(States.INIT)) {
			this.state = States.NONE;
			if(currentside == 0) {
				this.currentside = 1;
			}
			else {
				this.currentside = 0;
			}
		}
		else if(whitedone && blackdone) {
			this.state = States.NONE;
			this.currentside = 0;
			Management.getSb().getDoneButton().setVisible(false);
		}
		else if(whitedone == true && blackdone == false) {
			this.currentside = 1;
		}
		else if(whitedone == false && blackdone == true) {
			this.currentside = 0;
		}
		else {
			if(currentside == 0) {
				this.currentside = 1;
			}
			else {
				this.currentside = 0;
			}
		}
		Management.updateStatusBar();
		Management.resetPieceBar();
	}

	public void setCurrentside(int currentside) {
		this.currentside = currentside;
	}

}
