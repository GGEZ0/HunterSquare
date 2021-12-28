package Piece;

import java.util.ArrayList;

public class Blank extends Piece_Base{

	public Blank(int side, int x, int y) {
		super(side, x, y);
		this.name = "blank";
	}
	
	public void tierup() {		
	}

	public ArrayList<Integer> genpath() {
		return null;
	}

	public boolean cantierup() {
		return false;
	}

	public void tierdown() {		
	}

	public int getTier() {
		return 0;
	}

	public void changeside() {	
	}

}
