package Piece;

import java.util.ArrayList;

import javafx.scene.image.Image;

public abstract class Piece_Base implements TierChecker{
	protected int side;
	protected int Pos_x;
	protected int Pos_y;
	protected String name;
	protected String url;
	protected Image img;
	
	public Piece_Base(int side, int x, int y) {		
		this.side = side;
		this.Pos_x = x;
		this.Pos_y = y;
	}	
	public abstract ArrayList<Integer> genpath();
	
	public abstract boolean cantierup();
	
	public abstract void changeside();
	
	public abstract void tierup();
	
	public abstract void tierdown();
	
	public int getTier() {
		return 0;
	}
	
	public Image getImg() {
		return img;
	}
	
	public int getSide() {
		return side;
	}
	
	public void setSide(int side) {
		this.side = side;
	}
	
	public int getPos_x() {
		return Pos_x;
	}

	public void setPos_x(int pos_x) {
		Pos_x = pos_x;
	}

	public int getPos_y() {
		return Pos_y;
	}

	public void setPos_y(int pos_y) {
		Pos_y = pos_y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
