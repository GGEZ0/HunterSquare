package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece_Base{
	//private Image img;
	private ImageView view = new ImageView();
	private int maxtier;
	private int tier;

	public Knight(int side, int x, int y) {
		super(side, x, y);
		this.name = "Knight";
		if(side == 0) {
			this.url = "White_KnightT1.png";
		}
		else {
			this.url = "Black_KnightT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		this.maxtier = 3;
		this.tier = 1;
	}
	
	public Image getImg() {
		return img;
	}

	public int getTier() {
		return tier;
	}
	
	public boolean cantierup() {
		if(tier < maxtier) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void changeside() {	
		if(this.side == 0) {
			this.side = 1;
			if(tier == 1) {
				this.url = "Black_KnightT1.png";
			}
			else if(tier == 2) {
				this.url = "Black_KnightT2.png";
			}
			else if(tier == 3) {
				this.url = "Black_KnightT3.png";
			}
		}
		else if(this.side == 1) {
			this.side = 0;
			if(tier == 1) {
				this.url = "White_KnightT1.png";
			}
			else if(tier == 2) {
				this.url = "White_KnightT2.png";
			}
			else if(tier == 3) {
				this.url = "White_KnightT3.png";
			}
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
	}
	
	public void tierdown() {
		this.tier -= 1;
		if(side == 0 && tier == 2) {
			this.url = "White_KnightT2.png";
		}
		else if(side == 1 && tier == 2){
			this.url = "Black_KnightT2.png";
		}
		else if(side == 0 && tier == 1) {
			this.url = "White_KnightT1.png";
		}
		else if(side == 1 && tier == 1){
			this.url = "Black_KnightT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		
	}
	
	public void tierup() {
		if(tier < maxtier) {
			this.tier+=1;
			if(side == 0 && tier == 2) {
				this.url = "White_KnightT2.png";
			}
			else if(side == 1 && tier == 2){
				this.url = "Black_KnightT2.png";
			}
			else if(side == 0 && tier == 3) {
				this.url = "White_KnightT3.png";
			}
			else if(side == 1 && tier == 3){
				this.url = "Black_KnightT3.png";
			}
			this.img = new Image(this.url);
			this.view.setImage(img);
		}
	}
	
	public ArrayList<Integer> genpath() {
		ArrayList<Integer> number = new ArrayList<Integer>();
		if(tier == 1) {
			if(side == 0) {
				for(int i  = -1; i <= 1; i += 2) {
					for(int j = -2; j <= 0; j += 2) {
						if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
							if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
								number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
							}
						}
					}
				}
			}
			else {
				for(int i  = -1; i <= 1; i += 2) {
					for(int j = 0; j <= 2; j += 2) {
						if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
							if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
								number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
							}
						}
					}
				}
			}
			
		}
		if(tier == 2) {
			if(side == 0) {
				if(this.Pos_x - 2  <= 8 && this.Pos_x - 2 >= 0) {
					if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
						number.add(((this.Pos_y - 1) * 9) + this.Pos_x - 2);
					}
				}
				if(this.Pos_x - 1  <= 8 && this.Pos_x - 1 >= 0) {
					if(this.Pos_y - 2 <= 8 && this.Pos_y - 2 >= 0) {
						number.add(((this.Pos_y - 2) * 9) + this.Pos_x - 1);
					}
				}
				if(this.Pos_x + 1  <= 8 && this.Pos_x + 1 >= 0) {
					if(this.Pos_y - 2 <= 8 && this.Pos_y - 2 >= 0) {
						number.add(((this.Pos_y - 2) * 9) + this.Pos_x + 1);
					}
				}
				if(this.Pos_x + 2  <= 8 && this.Pos_x + 2 >= 0) {
					if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
						number.add(((this.Pos_y - 1) * 9) + this.Pos_x + 2);
					}
				}
			}
			else {
				if(this.Pos_x - 2  <= 8 && this.Pos_x - 2 >= 0) {
					if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
						number.add(((this.Pos_y + 1) * 9) + this.Pos_x - 2);
					}
				}
				if(this.Pos_x - 1  <= 8 && this.Pos_x - 1 >= 0) {
					if(this.Pos_y + 2 <= 8 && this.Pos_y + 2 >= 0) {
						number.add(((this.Pos_y + 2) * 9) + this.Pos_x - 1);
					}
				}
				if(this.Pos_x + 1  <= 8 && this.Pos_x + 1 >= 0) {
					if(this.Pos_y + 2 <= 8 && this.Pos_y + 2 >= 0) {
						number.add(((this.Pos_y + 2) * 9) + this.Pos_x + 1);
					}
				}
				if(this.Pos_x + 2  <= 8 && this.Pos_x + 2 >= 0) {
					if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
						number.add(((this.Pos_y + 1) * 9) + this.Pos_x + 2);
					}
				}
			}
			
		}
		if(tier == 3) {
			for(int i = -2; i <= 2; i+=4) {
				for(int j = -1; j <= 1; j +=2) {
					if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
							number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
						}
					}
				}
			}
			for(int i = -1; i <= 1; i+=2) {
				for(int j = -2; j <= 2; j +=4) {
					if(this.Pos_x + i  <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
							number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
						}
					}
				}
			}
		}
		return number;
	}

}
