package Bar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Management;

public class Piece_Bar extends GridPane{
	private ObservableList<PieceButton> PieceButtonList = FXCollections.observableArrayList();
	private ObservableList<Label> PieceLabelList = FXCollections.observableArrayList();
	public int side;
	public int oside;
	private Label archerLabel;
	private Label cannonLabel;
	private Label captainLabel;
	private Label fortressLabel;
	private Label generalLabel;
	private Label knightLabel;
	private Label major_generalLabel;
	private Label musketeerLabel;
	private Label pawnLabel;
	private Label samuraiLabel;
	private Label spyLabel;
	private AudioClip sound = new AudioClip(ClassLoader.getSystemResource("audio/buttonpress.wav").toString());

	public Piece_Bar(int side) {
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
		this.side = side;
		//sound = new AudioClip(ClassLoader.getSystemResource("audio/buttonpress.wav").toString());
		PieceButton Archer = new PieceButton("Archer",side);
		Archer.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Archer);
			}
		});
		
		PieceButton Cannon = new PieceButton("Cannon",side);
		Cannon.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Cannon);
			}
		});
		
		PieceButton Captain = new PieceButton("Captain",side);
		Captain.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Captain);
			}
		});
		
		PieceButton Fortress = new PieceButton("Fortress",side);
		Fortress.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Fortress);
			}
		});
		
		PieceButton General = new PieceButton("General",side);
		General.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(General);
			}
		});
		
		PieceButton Knight = new PieceButton("Knight",side);
		Knight.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Knight);
			}
		});
		
		PieceButton Major_General = new PieceButton("Major_General",side);
		Major_General.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Major_General);
			}
		});
		
		PieceButton Musketeer = new PieceButton("Musketeer",side);
		Musketeer.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Musketeer);
			}
		});
		
		PieceButton Pawn = new PieceButton("Pawn",side);
		Pawn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Pawn);
			}
		});
		
		PieceButton Samurai = new PieceButton("Samurai",side);
		Samurai.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Samurai);
			}
		});
		
		PieceButton Spy = new PieceButton("Spy",side);
		Spy.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				setSelectedButton(Spy);
			}
		});
		
		this.PieceButtonList.addAll(Archer,Cannon,Captain,Fortress,General,Knight,
				Major_General,Musketeer,Pawn,Samurai,Spy);
		
		this.add(Archer, 0, side);
		this.add(Cannon, 1, side);
		this.add(Captain, 2, side);
		this.add(Fortress, 3, side);
		this.add(General, 4, side);
		this.add(Knight, 5, side);
		this.add(Major_General, 6, side);
		this.add(Musketeer, 7, side);
		this.add(Pawn, 8, side);
		this.add(Samurai, 9, side);
		this.add(Spy, 10, side);
		
		this.archerLabel = new Label();
		this.archerLabel.textProperty().setValue(Archer.getPiece().getOff_FieldText());
		this.archerLabel.setFont(new Font(16));
		
		this.cannonLabel = new Label();
		this.cannonLabel.textProperty().setValue(Cannon.getPiece().getOff_FieldText());
		this.cannonLabel.setFont(new Font(16));
		
		this.captainLabel = new Label();
		this.captainLabel.textProperty().setValue(Captain.getPiece().getOff_FieldText());
		this.captainLabel.setFont(new Font(16));
		
		this.fortressLabel = new Label();
		this.fortressLabel.textProperty().setValue(Fortress.getPiece().getOff_FieldText());
		this.fortressLabel.setFont(new Font(16));
		
		this.generalLabel = new Label();
		this.generalLabel.textProperty().setValue(General.getPiece().getOff_FieldText());
		this.generalLabel.setFont(new Font(16));
		
		this.knightLabel = new Label();
		this.knightLabel.textProperty().setValue(Knight.getPiece().getOff_FieldText());
		this.knightLabel.setFont(new Font(16));
		
		this.major_generalLabel = new Label();
		this.major_generalLabel.textProperty().setValue(Major_General.getPiece().getOff_FieldText());
		this.major_generalLabel.setFont(new Font(16));
		
		this.musketeerLabel = new Label();
		this.musketeerLabel.textProperty().setValue(Musketeer.getPiece().getOff_FieldText());
		this.musketeerLabel.setFont(new Font(16));
		
		this.pawnLabel = new Label();
		this.pawnLabel.textProperty().setValue(Pawn.getPiece().getOff_FieldText());
		this.pawnLabel.setFont(new Font(16));
		
		this.samuraiLabel = new Label();
		this.samuraiLabel.textProperty().setValue(Samurai.getPiece().getOff_FieldText());
		this.samuraiLabel.setFont(new Font(16));
		
		this.spyLabel = new Label();
		this.spyLabel.textProperty().setValue(Spy.getPiece().getOff_FieldText());
		this.spyLabel.setFont(new Font(16));
		
		this.oside = 1;
		if(side > 0) {
			oside = 0;
		}
		this.PieceLabelList.addAll(archerLabel,cannonLabel,captainLabel,fortressLabel,generalLabel,
				knightLabel,major_generalLabel,musketeerLabel,pawnLabel,samuraiLabel,spyLabel);
		
		this.add(archerLabel, 0, oside);
		this.add(cannonLabel, 1, oside);
		this.add(captainLabel, 2, oside);
		this.add(fortressLabel, 3, oside);
		this.add(generalLabel, 4, oside);
		this.add(knightLabel, 5, oside);
		this.add(major_generalLabel, 6, oside);
		this.add(musketeerLabel, 7, oside);
		this.add(pawnLabel, 8, oside);
		this.add(samuraiLabel, 9, oside);
		this.add(spyLabel, 10, oside);
		
		//PieceLabelList.get(0).setFont(new Font(10));
		
		for(int i = 0; i < PieceLabelList.size(); i++) {
			GridPane.setHalignment(PieceLabelList.get(i), HPos.CENTER);
		}
	
	}
	
	public void resetPieceBar() {
		for(int i = 0; i < this.PieceButtonList.size(); i++) {
			String name = this.PieceButtonList.get(i).getPiece().getName();
			if(name.equals("Archer")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
			else if(name.equals("Cannon")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
			else if(name.equals("Captain")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(1);
			}
			else if(name.equals("Fortress")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
			else if(name.equals("General")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(6);
			}
			else if(name.equals("Knight")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
			else if(name.equals("Major_General")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(4);
			}
			else if(name.equals("Musketeer")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(1);
			}
			else if(name.equals("Pawn")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(9);
			}
			else if(name.equals("Samurai")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
			else if(name.equals("Spy")) {
				this.PieceButtonList.get(i).getPiece().setOff_field(2);
			}
		}
	}
	
	public void updateLabel() {
		for(int i = 0; i < this.PieceLabelList.size(); i++) {
			this.PieceLabelList.get(i).textProperty().setValue(this.PieceButtonList.get(i).getPiece().getOff_FieldText());
		}
	}
	
	public void setSelectedButton(PieceButton piece) {
		Management.setSelectedPieceforinit(piece);
		Management.setSelectforplace(piece);
		Management.resetPieceBar();
		//this.resetButtonsBackGroundColor();
		sound.play();
		piece.highlight();
	}
	
	public void resetButtonsBackGroundColor() {
		for(int i = 0; i < PieceButtonList.size(); i++) {
			this.PieceButtonList.get(i).unhighlight();
		}
	}
}
