package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fortress extends Piece_Base{
	//private Image img;
	private ImageView view = new ImageView();
	private int maxtier;
	private int tier;

	public Fortress(int side, int x, int y) {
		super(side, x, y);
		this.name = "Fortress";
		if(side == 0) {
			this.url = "White_FortressT1.png";
		}
		else {
			this.url = "Black_FortressT1.png";
		}
		this.img = new Image(this.url);
		this.view.setImage(img);
		this.maxtier = 1;
		this.tier = 1;
	}

	public int getTier() {
		return tier;
	}
	
	public Image getImg() {
		return img;
	}
	
	public void changeside() {	
		// cannot tier up
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
		this.img = new Image(this.url);
		this.view.setImage(img);
		
	}
	
	public void tierup() {
		if(tier < maxtier) {
			this.tier+=1;
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
		return number;
	}

}
