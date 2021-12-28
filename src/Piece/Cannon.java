package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cannon extends Piece_Base{
	//private Image img;
	private ImageView view = new ImageView();
	private int maxtier;
	private int tier;
	
	public Cannon(int side, int x, int y) {
		super(side, x, y);
		this.name = "Cannon";
		if(side == 0) {
			this.url = "White_CannonT1.png";
		}
		else {
			this.url = "Black_CannonT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		this.maxtier = 3;
		this.tier = 1;
	}

	public int getTier() {
		return tier;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void changeside() {	
		if(this.side == 0) {
			this.side = 1;
			if(tier == 1) {
				this.url = "Black_CannonT1.png";
			}
			else if(tier == 2) {
				this.url = "Black_CannonT2.png";
			}
			else if(tier == 3) {
				this.url = "Black_CannonT3.png";
			}
		}
		else if(this.side == 1) {
			this.side = 0;
			if(tier == 1) {
				this.url = "White_CannonT1.png";
			}
			else if(tier == 2) {
				this.url = "White_CannonT2.png";
			}
			else if(tier == 3) {
				this.url = "White_CannonT3.png";
			}
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
	}
	
	public boolean cantierup() {
		if(tier < maxtier) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void tierdown() {
		this.tier -= 1;
		if(side == 0 && tier == 2) {
			this.url = "White_CannonT2.png";
		}
		else if(side == 1 && tier == 2){
			this.url = "Black_CannonT2.png";
		}
		else if(side == 0 && tier == 1) {
			this.url = "White_CannonT1.png";
		}
		else if(side == 1 && tier == 1){
			this.url = "Black_CannonT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		
	}
	
	public void tierup() {
		if(tier < maxtier) {
			this.tier+=1;
			if(side == 0 && tier == 2) {
				this.url = "White_CannonT2.png";
			}
			else if(side == 1 && tier == 2){
				this.url = "Black_CannonT2.png";
			}
			else if(side == 0 && tier == 3) {
				this.url = "White_CannonT3.png";
			}
			else if(side == 1 && tier == 3){
				this.url = "Black_CannonT3.png";
			}
			this.img = new Image(this.url);
			this.view.setImage(img);
		}
	}
	
	public ArrayList<Integer> genpath() {
		ArrayList<Integer> number = new ArrayList<Integer>();
		if(tier == 1) {
			for(int i = -1; i <= 1; i++) {
				if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
					number.add(((this.Pos_y) * 9) + this.Pos_x + i);
				}
				if(this.Pos_y + i  <= 8 && this.Pos_y + i >= 0) {
					number.add(((this.Pos_y + i) * 9) + this.Pos_x);
				}
			}
		}
		if(tier == 2) {
			for(int i  = -2; i <= 2; i++) {
				if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
					number.add(((this.Pos_y) * 9) + this.Pos_x + i);
				}
				if(this.Pos_y + i  <= 8 && this.Pos_y + i >= 0) {
					number.add(((this.Pos_y + i) * 9) + this.Pos_x);
				}
			}
		}
		if(tier == 3) {
			for(int i  = -8; i <= 8; i++) {
				if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
					number.add(((this.Pos_y) * 9) + this.Pos_x + i);
				}
				if(this.Pos_y + i  <= 8 && this.Pos_y + i >= 0) {
					number.add(((this.Pos_y + i) * 9) + this.Pos_x);
				}
			}
		}
		return number;
	}

}
