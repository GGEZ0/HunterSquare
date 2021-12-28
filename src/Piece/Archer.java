package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Archer extends Piece_Base{
	//private Image img;
	private ImageView view = new ImageView();
	private int tier;
	private int maxtier;

	public Archer(int side, int x, int y) {
		super(side, x, y);
		this.name = "Archer";
		if(side == 0) {
			this.url = "White_ArcherT1.png";
		}
		else {
			this.url = "Black_ArcherT1.png";
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
				this.url = "Black_ArcherT1.png";
			}
			else if(tier == 2) {
				this.url = "Black_ArcherT2.png";
			}
			else if(tier == 3) {
				this.url = "Black_ArcherT3.png";
			}
		}
		else if(this.side == 1) {
			this.side = 0;
			if(tier == 1) {
				this.url = "White_ArcherT1.png";
			}
			else if(tier == 2) {
				this.url = "White_ArcherT2.png";
			}
			else if(tier == 3) {
				this.url = "White_ArcherT3.png";
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
			this.url = "White_ArcherT2.png";
		}
		else if(side == 1 && tier == 2){
			this.url = "Black_ArcherT2.png";
		}
		else if(side == 0 && tier == 1) {
			this.url = "White_ArcherT1.png";
		}
		else if(side == 1 && tier == 1){
			this.url = "Black_ArcherT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		
	}
	
	public void tierup() {
		if(tier < maxtier) {
			this.tier+=1;
			if(side == 0 && tier == 2) {
				this.url = "White_ArcherT2.png";
			}
			else if(side == 1 && tier == 2){
				this.url = "Black_ArcherT2.png";
			}
			else if(side == 0 && tier == 3) {
				this.url = "White_ArcherT3.png";
			}
			else if(side == 1 && tier == 3){
				this.url = "Black_ArcherT3.png";
			}
			this.img = new Image(this.url);
			this.view.setImage(img);
		}
	}
	
	public ArrayList<Integer> genpath() {
		ArrayList<Integer> number = new ArrayList<Integer>();
		if(tier == 1) {
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
							number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
							}
					}
				}			
			}
		}
		if(tier == 2) {
			for(int i = -2; i <= 2; i+=4) {
				for(int j = -2; j <= 2; j ++) {
					if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
							number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
						}
					}
				}
			}
			for(int i = -2; i <= 2; i+=4) {
				for(int j = -1; j <= 1; j++) {
					if(this.Pos_y + i <= 8 && this.Pos_y + i >= 0) {
						if(this.Pos_x + j <= 8 && this.Pos_x + j >= 0) {
							number.add(((this.Pos_y + i) * 9) + this.Pos_x + j);
						}
					}
				}
			}			
		}
		// ยังผิดอยู่ "แก้แล้ว"
		if(tier == 3) {
			for(int i = -3; i <= 3; i+=6) {
				for(int j = -3; j <= 3; j ++) {
					if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
							number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
						}
					}
				}
			}
			for(int i = -3; i <= 3; i+=6) {
				for(int j = -2; j <= 2; j++) {
					if(this.Pos_y + i <= 8 && this.Pos_y + i >= 0) {
						if(this.Pos_x + j <= 8 && this.Pos_x + j >= 0) {
							number.add(((this.Pos_y + i) * 9) + this.Pos_x + j);
						}
					}
				}
			}		
		}
		return number;
	}
	

}
