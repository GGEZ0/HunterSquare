package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Major_General extends Piece_Base{
	//private Image img;
	private ImageView view = new ImageView();
	private int maxtier;
	private int tier;

	public Major_General(int side, int x, int y) {
		super(side, x, y);
		this.name = "Major_General";
		if(side == 0) {
			this.url = "White_Major_GeneralT1.png";
		}
		else {
			this.url = "Black_Major_GeneralT1.png";
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
				this.url = "Black_Major_GeneralT1.png";
			}
			else if(tier == 2) {
				this.url = "Black_Major_GeneralT2.png";
			}
			else if(tier == 3) {
				this.url = "Black_Major_GeneralT3.png";
			}
		}
		else if(this.side == 1) {
			this.side = 0;
			if(tier == 1) {
				this.url = "White_Major_GeneralT1.png";
			}
			else if(tier == 2) {
				this.url = "White_Major_GeneralT2.png";
			}
			else if(tier == 3) {
				this.url = "White_Major_GeneralT3.png";
			}
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
	}
	
	public void tierdown() {
		this.tier -= 1;
		if(side == 0 && tier == 2) {
			this.url = "White_Major_GeneralT2.png";
		}
		else if(side == 1 && tier == 2){
			this.url = "Black_Major_GeneralT2.png";
		}
		else if(side == 0 && tier == 1) {
			this.url = "White_Major_GeneralT1.png";
		}
		else if(side == 1 && tier == 1){
			this.url = "Black_Marjor_GeneralT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		
	}
	
	public void tierup() {
		if(tier < maxtier) {
			this.tier+=1;
			if(side == 0 && tier == 2) {
				this.url = "White_Major_GeneralT2.png";
			}
			else if(side == 1 && tier == 2){
				this.url = "Black_Major_GeneralT2.png";
			}
			else if(side == 0 && tier == 3) {
				this.url = "White_Major_GeneralT3.png";
			}
			else if(side == 1 && tier == 3){
				this.url = "Black_Major_GeneralT3.png";
			}
			this.img = new Image(this.url);
			this.view.setImage(img);
		}
	}
	
	public ArrayList<Integer> genpath() {
		ArrayList<Integer> number = new ArrayList<Integer>();
		if(tier == 1) {
			if(side == 0) {
				for(int i = -1; i <= 1; i +=2) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
							number.add(((this.Pos_y - 1) * 9) + this.Pos_x + i);
							}
					}	
				}
			}
			if(side == 1) {
				for(int i = -1; i <= 1; i +=2) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
							number.add(((this.Pos_y + 1) * 9) + this.Pos_x + i);
							}
					}	
				}
			}		
		}
		if(tier == 2) {
			if(side == 0) {
				for(int i = -1; i <= 1; i++) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
							number.add(((this.Pos_y - 1) * 9) + this.Pos_x + i);
							}
					}
				}
				for(int i = -1; i <= 1; i +=2) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
							number.add(((this.Pos_y + 1) * 9) + this.Pos_x + i);
							}
					}	
				}
			}
			else {
				for(int i = -1; i <= 1; i++) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
							number.add(((this.Pos_y + 1) * 9) + this.Pos_x + i);
							}
					}
				}
				for(int i = -1; i <= 1; i +=2) {
					if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
						if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
							number.add(((this.Pos_y - 1) * 9) + this.Pos_x + i);
							}
					}	
				}
				
			}
							
		}
		if(tier == 3) {
			if(side == 0) {
				for(int i = -1; i <= 1; i++) {
					for(int j = -1; j <= 0; j++) {
						if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
							if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
								number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
								}
						}
					}			
				}
				if(this.Pos_y + 1 <= 8 && this.Pos_y + 1 >= 0) {
					number.add(((this.Pos_y + 1) * 9) + this.Pos_x);
					}
			}
			if(side == 1) {
				for(int i = -1; i <= 1; i++) {
					for(int j = 0; j <= 1; j++) {
						if(this.Pos_x + i <= 8 && this.Pos_x + i >= 0) {
							if(this.Pos_y + j <= 8 && this.Pos_y + j >= 0) {
								number.add(((this.Pos_y + j) * 9) + this.Pos_x + i);
								}
						}
					}			
				}
				if(this.Pos_y - 1 <= 8 && this.Pos_y - 1 >= 0) {
					number.add(((this.Pos_y - 1) * 9) + this.Pos_x);
					}
			}
		}
		return number;
	}

}
