package Application;

import Piece.Blank;
import Piece.Piece_Base;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import logic.Management;
import logic.States;

public class PieceCell extends Pane{
	private Board board;
	private Piece_Base piece;
	public boolean hightlight;
	private AudioClip selectplace = new AudioClip(ClassLoader.getSystemResource("audio/buttonpress.wav").toString());
	private AudioClip place = new AudioClip(ClassLoader.getSystemResource("audio/press.wav").toString());
	private AudioClip action = new AudioClip(ClassLoader.getSystemResource("audio/hit.wav").toString());
	
	PieceCell(Board board, Piece_Base piece){
		this.setPrefWidth(60);
		this.setPrefHeight(60);
		this.setMinHeight(60);
		this.setMinWidth(60);
		this.setPadding(new Insets(8));
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent  e) {
						onClickHandler();
						//System.out.println(e.getX());
					}
			});
		
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackgroundColor();
		
		this.board = board;
		this.piece = piece;
	}

	public void onClickHandler() {	
		//System.out.println(this.piece.getName().equals("King"));
		//System.out.println(this.piece.getName());
		if(this.getBoard().getState().equals(States.NONE)) {
			// warning please choose your action
		}
		else if(this.getBoard().getState() == (States.INIT)) {
			if((this.board.getCurrentside() == 0) && 
					((this.piece.getPos_y()*9)+this.piece.getPos_x() > 80 || 
					(this.piece.getPos_y()*9)+this.piece.getPos_x() < 54)) {
					//warning out of range 				
			}
			else if((this.board.getCurrentside() == 1) && 
					((this.piece.getPos_y()*9)+this.piece.getPos_x() > 26 || 
					(this.piece.getPos_y()*9)+this.piece.getPos_x() < 0)) {
					//warning out of range 				
			}

			// check select it available
			else if(Management.getSelectedPieceforinit() != null &&
					Management.getSelectedPieceforinit().getPiece().side == this.board.getCurrentside()) {
				if(this.getPiece().getName().equals("blank")) {
					if(Management.getSelectedPieceforinit().getPiece().getOff_field() < 1) {
						// warning You have use up all of these Piece
					}
					else {
						int x = this.piece.getPos_x();
						int y = this.piece.getPos_y();
						String name = Management.getSelectedPieceforinit().getPiece().getName();
						int s = this.board.getCurrentside();
						this.piece = Management.getSelectedPieceforinit().getPiece().getPieceBase(name, s);
						/*if(this.piece.equals(Management.getSelectedPieceforinit().getPiece().p)) {
							System.out.println("success");
						}*/
						this.piece.setPos_x(x);
						this.piece.setPos_y(y);
						setBackgroundColor(this.piece.getImg());
						place.play();
						Management.DecreasethisPiece();
						if(Management.getSelectedPieceforinit().getPiece().side == 0) {
							Management.updateLabelWhite();
							this.board.WhitePieceOnfield++;
							if(this.board.WhitePieceOnfield >= 26) {
								this.board.whitedone = true;
							}
						}
						else {
							Management.updateLabelBlack();
							this.board.BlackPieceOnfield++;
							if(this.board.BlackPieceOnfield >= 26) {
								this.board.blackdone = true;
							}
						}
						Management.setSelectedPieceforinit(null);
						this.board.switchcurrentside();
					}
				
				}
				else {
					if(this.piece.getName().equals(Management.getSelectedPieceforinit().getPiece().getName())) {
						if(Management.getSelectedPieceforinit().getPiece().getOff_field() < 1) {
							// warning You have use up all of these Piece
						}
						else{
							if(this.piece.cantierup()) {
								this.piece.tierup();
								setBackgroundColor(this.piece.getImg());
								place.play();
								Management.DecreasethisPiece();
								if(Management.getSelectedPieceforinit().getPiece().side == 0) {
									Management.updateLabelWhite();
									this.board.WhitePieceOnfield++;
									if(this.board.WhitePieceOnfield >= 26) {
										this.board.whitedone = true;
									}
								}
								else {
									Management.updateLabelBlack();
									this.board.BlackPieceOnfield++;
									if(this.board.BlackPieceOnfield >= 26) {
										this.board.blackdone = true;
									}
								}
								Management.setSelectedPieceforinit(null);
								this.board.switchcurrentside();
							}
						}
					}
					else {
						// warning it is not the same type of piece
					}
				}
			}
		}
		else if(this.getBoard().getState().equals(States.ADD)) {
			if(Management.getSelectforplace() != null &&
					Management.getSelectforplace().getPiece().side == this.board.getCurrentside()) {
				// วางแล้วจะกิน king ไม่ได้ วางได้หมด ยกเว้น 3 ช่องในของฝั่งตรงข้าม
				if((this.board.getCurrentside() == 0) && 
						((this.piece.getPos_y()*9)+this.piece.getPos_x() > 80 || 
						(this.piece.getPos_y()*9)+this.piece.getPos_x() < 27)) {
						//warning out of range 				
				}
				else if((this.board.getCurrentside() == 1) && 
						((this.piece.getPos_y()*9)+this.piece.getPos_x() > 53 || 
						(this.piece.getPos_y()*9)+this.piece.getPos_x() < 0)) {
						//warning out of range 				
				}				
				else if(this.board.getCurrentside() == 0 && this.board.getWhitePieceOnfield() < 26 ||
						this.board.getCurrentside() == 1 && this.board.getBlackPieceOnfield() < 26) {
					if(this.getPiece().getName().equals("blank")) {
						if(Management.getSelectforplace().getPiece().getOff_field() < 1) {
							// warning You have use up all of these Piece
						}
						else {
							int x = this.piece.getPos_x();
							int y = this.piece.getPos_y();
							int side = this.board.getCurrentside();
							String name = Management.getSelectforplace().getPiece().getName();
							//Piece_Base p = Management.getSelectforplace().getPiece().getPieceBase(name, s);
							this.piece = Management.getSelectforplace().getPiece().getPieceBase(name, side);
							this.piece.setPos_x(x);
							this.piece.setPos_y(y);
							setBackgroundColor(this.piece.getImg());
							place.play();
							Management.DecreasethisPiece();
							if(Management.getSelectforplace().getPiece().side == 0) {
								Management.updateLabelWhite();
								this.board.WhitePieceOnfield++;
							}
							else {
								Management.updateLabelBlack();
								this.board.BlackPieceOnfield++;
							}
							Management.setSelectforplace(null);
							this.board.switchcurrentside();
						}
							
						}
					else {
						if(this.piece.getName().equals(Management.getSelectforplace().getPiece().getName())) {
							if(Management.getSelectforplace().getPiece().getOff_field() < 1) {
								// warning You have use up all of these Piece
							}
							else{
								if(this.piece.cantierup()) {
									this.piece.tierup();
									setBackgroundColor(this.piece.getImg());
									place.play();
									Management.DecreasethisPiece();
									if(Management.getSelectforplace().getPiece().side == 0) {
										Management.updateLabelWhite();
										this.board.WhitePieceOnfield++;
									}
									else {
										Management.updateLabelBlack();
										this.board.BlackPieceOnfield++;
									}
									Management.setSelectforplace(null);
									this.board.switchcurrentside();
								}
							}
						}
						else {
							// warning it is not the same type of piece
						}
					}
				}
					
			}
		}
		else if(this.getBoard().getState().equals(States.MOVE)) {
			if( (Management.getSelectformove_atk_stk() != null)) {
				if((!Management.getSelectformove_atk_stk().getPiece().getName().equals("blank")) &&
						Management.getSelectformove_atk_stk().getPiece().getSide() == this.board.getCurrentside()) {
					if(this.hightlight && this.piece.getName().equals("blank")) {
						int x1 = Management.getSelectformove_atk_stk().getPiece().getPos_x();
						int y1 = Management.getSelectformove_atk_stk().getPiece().getPos_y();
						int x2 = this.piece.getPos_x();
						int y2 = this.piece.getPos_y();
						int enc = (y1*9)+x1;
						this.setPiece(Management.getSelectformove_atk_stk().getPiece());
						this.piece.setPos_x(x2);
						this.piece.setPos_y(y2);
						setBackgroundColor(this.piece.getImg());
						place.play();
						this.board.getPieceCells().get(enc).setPiece(new Blank(-1,x1,y1));
						this.board.getPieceCells().get(enc).setBackgroundColor();
						this.unhighlightall();
						Management.setSelectformove_atk_stk(null);
						this.board.switchcurrentside();
						//Management.getSelectformove_atk_stk().setPiece(new Blank(-1,x,y));
					}
					else if(!this.hightlight && !this.piece.getName().equals("blank") && 
						this.piece.getSide() == this.board.getCurrentside()){
						this.unhighlightall();
						Management.setSelectformove_atk_stk(this);
						selectplace.play();
						for(int i = 0; i < this.piece.genpath().size(); i++) {
							this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
						}
					}
				}
			}
			else if(!this.hightlight && !this.piece.getName().equals("blank") && 
					this.piece.getSide() == this.board.getCurrentside()){
				this.unhighlightall();
				Management.setSelectformove_atk_stk(this);
				selectplace.play();
				for(int i = 0; i < this.piece.genpath().size(); i++) {
					this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
				}
			}					
		}
		else if(this.getBoard().getState().equals(States.ATTACK)) {
			if( (Management.getSelectformove_atk_stk() != null)) {
				if((!Management.getSelectformove_atk_stk().getPiece().getName().equals("blank") &&
						Management.getSelectformove_atk_stk().getPiece().getSide() == this.board.getCurrentside())) {
					if(this.hightlight && (!this.piece.getName().equals("blank")) && 
							this.piece.getSide() != this.board.getCurrentside()){
						this.piece.tierdown();
						action.play();
						if(this.piece.getTier() < 1) {
							if(this.piece.getName().equals("King")) {
								// game end
								this.board.showWinner(this.board.getCurrentside());
							}
							int x = this.piece.getPos_x();
							int y = this.piece.getPos_y();
							this.setBackgroundColor();
							this.piece = new Blank(-1,x,y);
						}
						else {
							setBackgroundColor(this.piece.getImg());
						}
						if(this.board.getCurrentside() == 0) {
							this.board.BlackPieceOnfield -= 1;
						}
						else if(this.board.getCurrentside() == 1) {
							this.board.WhitePieceOnfield -= 1;
						}
						Management.setSelectformove_atk_stk(null);
						this.unhighlightall();
						this.board.switchcurrentside();
					}
					else if(!this.hightlight && !this.piece.getName().equals("blank") && 
							this.piece.getSide() == this.board.getCurrentside()) {
						this.unhighlightall();
						selectplace.play();
						Management.setSelectformove_atk_stk(this);
						for(int i = 0; i < this.piece.genpath().size(); i++) {
							this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
						}				
					}
				}
				else if(!this.hightlight && !this.piece.getName().equals("blank") && 
						this.piece.getSide() == this.board.getCurrentside()) {
					this.unhighlightall();
					selectplace.play();
					Management.setSelectformove_atk_stk(this);
					for(int i = 0; i < this.piece.genpath().size(); i++) {
						this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
					}				
				}
					
			}
			// highlight Cell not done "done"
			else if(!this.hightlight && !this.piece.getName().equals("blank") && 
					this.piece.getSide() == this.board.getCurrentside()) {
				this.unhighlightall();
				selectplace.play();
				Management.setSelectformove_atk_stk(this);
				for(int i = 0; i < this.piece.genpath().size(); i++) {
					this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
				}				
			}		
		}
		else if(this.getBoard().getState().equals(States.STACK)) {
			if((Management.getSelectformove_atk_stk() != null)) {
				if((!Management.getSelectformove_atk_stk().getPiece().getName().equals("blank")) &&
						Management.getSelectformove_atk_stk().getPiece().getSide() == this.board.getCurrentside()) {
					if(this.hightlight && (!this.piece.getName().equals("blank")) && 
							this.piece.getName().equals(Management.getSelectformove_atk_stk().getPiece().getName())){
						if(this.piece.getSide() == Management.getSelectformove_atk_stk().getPiece().getSide()) {
							if(this.piece.cantierup()) {
								action.play();
								this.piece.tierup();
								int x = Management.getSelectformove_atk_stk().getPiece().getPos_x();
								int y = Management.getSelectformove_atk_stk().getPiece().getPos_y();
								int enc = (y*9)+x;
								this.board.getPieceCells().get(enc).setPiece(new Blank(-1,x,y));
								this.board.getPieceCells().get(enc).setBackgroundColor();
								setBackgroundColor(this.piece.getImg());
								/*if(Management.getSelectformove_atk_stk().getPiece().getSide() == 0) {								
									this.board.WhitePieceOnfield++;
								}
								else {
									this.board.BlackPieceOnfield++;
								}*/
								this.unhighlightall();
								Management.setSelectformove_atk_stk(null);
								this.board.switchcurrentside();
							}
						}
						else { // difference side
							if(this.piece.cantierup()) {
								action.play();
								this.piece.tierup();
								this.piece.changeside();
								this.piece.tierup();
								int x = Management.getSelectformove_atk_stk().getPiece().getPos_x();
								int y = Management.getSelectformove_atk_stk().getPiece().getPos_y();
								int enc = (y*9)+x;
								this.board.getPieceCells().get(enc).setPiece(new Blank(-1,x,y));
								this.board.getPieceCells().get(enc).setBackgroundColor();
								setBackgroundColor(this.piece.getImg());
								if(Management.getSelectformove_atk_stk().getPiece().getSide() == 0) {								
									this.board.WhitePieceOnfield = this.board.WhitePieceOnfield + (this.piece.getTier()-1);
									this.board.BlackPieceOnfield = this.board.BlackPieceOnfield - (this.piece.getTier()-1);
								}
								else {
									this.board.BlackPieceOnfield = this.board.BlackPieceOnfield + (this.piece.getTier()-1);
									this.board.WhitePieceOnfield = this.board.WhitePieceOnfield - (this.piece.getTier()-1);
								}
								this.unhighlightall();
								Management.setSelectformove_atk_stk(null);
								this.board.switchcurrentside();
							}
						}
					}
					else if(!this.hightlight && !this.piece.getName().equals("blank") && 
							this.piece.getSide() == this.board.getCurrentside() && this.piece.getTier() < 2) {
						selectplace.play();
						this.unhighlightall();
						Management.setSelectformove_atk_stk(this);
						for(int i = 0; i < this.piece.genpath().size(); i++) {
							this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
						}
					}
				}				
			}
			else if(!this.hightlight && !this.piece.getName().equals("blank") && 
					this.piece.getSide() == this.board.getCurrentside() && this.piece.getTier() < 2) {
				selectplace.play();
				this.unhighlightall();
				Management.setSelectformove_atk_stk(this);
				for(int i = 0; i < this.piece.genpath().size(); i++) {
					this.board.getPieceCells().get(this.piece.genpath().get(i)).highlight();
				}
			}		
		}		
	}
	
	public void setBackgroundColor() {
		this.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));		
	}

	public void setBackgroundColor(Image image) {
		BackgroundFill bgFill = new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(60,60,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
	}
	
	public void highlight() {
		if(this.piece.getName().equals("blank")) {
			this.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		else {
			BackgroundFill bgFill = new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY);
			BackgroundFill[] bgFillA = {bgFill};
			BackgroundSize bgSize = new BackgroundSize(60,60,false,false,false,false);
			BackgroundImage bgImg = new BackgroundImage(this.piece.getImg(), null, null, null, bgSize);
			BackgroundImage[] bgImgA = {bgImg};
			this.setBackground(new Background(bgFillA,bgImgA));
		}
		//this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.hightlight = true;
	}
	
	public void unhighlight() {
		if(this.piece.getName().equals("blank")) {
			this.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		else {
			this.setBackgroundColor(this.piece.getImg());
		}
		//this.setBackground(new Background(new BackgroundFill(Color.MOCCASIN, CornerRadii.EMPTY, Insets.EMPTY)));
		this.hightlight = false;
	}
	
	public void unhighlightall() {
		for(int i = 0; i < this.board.getPieceCells().size(); i++) {
			this.board.getPieceCells().get(i).unhighlight();
		}
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Piece_Base getPiece() {
		return piece;
	}

	public void setPiece(Piece_Base piece) {
		this.piece = piece;
	}
	

}
