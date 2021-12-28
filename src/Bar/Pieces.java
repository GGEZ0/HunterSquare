package Bar;

import Piece.Archer;
import Piece.Cannon;
import Piece.Captain;
import Piece.Fortress;
import Piece.General;
import Piece.King;
import Piece.Knight;
import Piece.Major_General;
import Piece.Musketeer;
import Piece.Pawn;
import Piece.Piece_Base;
import Piece.Samurai;
import Piece.Spy;

public class Pieces {
	private String name;
	private String url;
	public int off_field;
	public int side;
	public Piece_Base p;
	
	Pieces(String name, int side){
		if(side == 0) {
			switch(name) {
			case "Archer" :		   url = "White_ArcherT1.png";        p = new Archer(0,0,0);        off_field = 2; break;
			case "Cannon" : 	   url = "White_CannonT1.png";        p = new Cannon(0,0,0);        off_field = 2; break;
			case "Captain" : 	   url = "White_CaptainT1.png";       p = new Captain(0,0,0);       off_field = 1; break;
			case "Fortress" :      url = "White_FortressT1.png";	  p = new Fortress(0,0,0);      off_field = 2; break;
			case "General" : 	   url = "White_GeneralT1.png";	      p = new General(0,0,0);       off_field = 6; break;
			case "King" :		   url = "White_KingT1.png";          p = new King(0,0,0);          off_field = 1; break;
			case "Knight" : 	   url = "White_KnightT1.png";        p = new Knight(0,0,0);        off_field = 2; break;
			case "Major_General" : url = "White_Major_GeneralT1.png"; p = new Major_General(0,0,0); off_field = 4; break;
			case "Musketeer" :     url = "White_MusketeerT1.png";	  p = new Musketeer(0,0,0);     off_field = 1; break;
			case "Pawn" : 	       url = "White_PawnT1.png";	      p = new Pawn(0,0,0);          off_field = 9; break;
			case "Samurai" :	   url = "White_SamuraiT1.png";       p = new Samurai(0,0,0);       off_field = 2; break;
			case "Spy" : 	       url = "White_SpyT1.png";           p = new Spy(0,0,0);           off_field = 2; break;
			}
		}
		else {
			switch(name) {
			case "Archer" :		   url = "Black_ArcherT1.png";        p = new Archer(1,0,0);        off_field = 2; break;
			case "Cannon" : 	   url = "Black_CannonT1.png";        p = new Cannon(1,0,0);        off_field = 2; break;
			case "Captain" : 	   url = "Black_CaptainT1.png";       p = new Captain(1,0,0);       off_field = 1; break;
			case "Fortress" :      url = "Black_FortressT1.png";	  p = new Fortress(1,0,0);      off_field = 2; break;
			case "General" : 	   url = "Black_GeneralT1.png";	      p = new General(1,0,0);       off_field = 6; break;
			case "King" :		   url = "Black_KingT1.png";          p = new King(1,0,0);          off_field = 1; break;
			case "Knight" : 	   url = "Black_KnightT1.png";        p = new Knight(1,0,0);        off_field = 2; break;
			case "Major_General" : url = "Black_Major_GeneralT1.png"; p = new Major_General(1,0,0); off_field = 4; break;
			case "Musketeer" :     url = "Black_MusketeerT1.png";	  p = new Musketeer(1,0,0);     off_field = 1; break;
			case "Pawn" : 	       url = "Black_PawnT1.png";	      p = new Pawn(1,0,0);          off_field = 9; break;
			case "Samurai" :	   url = "Black_SamuraiT1.png";       p = new Samurai(1,0,0);       off_field = 2; break;
			case "Spy" : 	       url = "Black_SpyT1.png";           p = new Spy(1,0,0);           off_field = 2; break;
			}	
		}
	this.name = name;
	this.side = side;
	}
	
	public Piece_Base getPieceBase(String name, int side) {
		if(name.equals("Archer")) {
			return new Archer(side,0,0);
		}
		else if(name.equals("Cannon")) {
			return new Cannon(side,0,0);
		}
		else if(name.equals("Captain")) {
			return new Captain(side,0,0);
		}
		else if(name.equals("Fortress")) {
			return new Fortress(side,0,0);
		}
		else if(name.equals("General")) {
			return new General(side,0,0);
		}
		else if(name.equals("King")) {
			return new King(side,0,0);
		}
		else if(name.equals("Knight")) {
			return new Knight(side,0,0);
		}
		else if(name.equals("Major_General")) {
			return new Major_General(side,0,0);
		}
		else if(name.equals("Musketeer")) {
			return new Musketeer(side,0,0);
		}
		else if(name.equals("Pawn")) {
			return new Pawn(side,0,0);
		}
		else if(name.equals("Samurai")) {
			return new Samurai(side,0,0);
		}
		else if(name.equals("Spy")) {
			return new Spy(side,0,0);
		}
		else {
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
	
	public int getOff_field() {
		return off_field;
	}
	
	public void decreaseoff_field() {
		if(this.off_field > 0) {
			this.off_field -= 1;
		}
	}
	
	public void setOff_field(int off_field) {
		this.off_field = off_field;
	}

	public String getOff_FieldText() {
		return "" + off_field;
	}
	

}
