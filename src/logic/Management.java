package logic;

import Application.PieceCell;
import Bar.PieceButton;
import Bar.Piece_Bar;
import Bar.StatusBar;

public class Management {
	private static PieceButton selectedPieceforinit;
	private static PieceCell selectformove_atk_stk;
	private static PieceButton selectforplace;
	private static Piece_Bar whitepiecebar;
	private static Piece_Bar blackpiecebar;
	private static StatusBar sb;

	public static void updateLabelWhite() {
		Management.whitepiecebar.updateLabel();
	}
	
	public static void newgameforPieceBar() {
		Management.whitepiecebar.resetPieceBar();
		Management.blackpiecebar.resetPieceBar();
		Management.updateLabelWhite();
		Management.updateLabelBlack();
		
	}
	
	public static void resetPieceBar() {
		Management.whitepiecebar.resetButtonsBackGroundColor();
		Management.blackpiecebar.resetButtonsBackGroundColor();
	}
	
	public static StatusBar getSb() {
		return sb;
	}
	
	public static void updateStatusBar() {
		Management.sb.updateStatusbar();
	}

	public static void setSb(StatusBar sb) {
		Management.sb = sb;
	}

	public static void updateLabelBlack() {
		Management.blackpiecebar.updateLabel();
	}
	
	public static void setSelectedPieceforinit(PieceButton selectedPieceforinit) {
		Management.selectedPieceforinit = selectedPieceforinit;
	}

	public static PieceButton getSelectedPieceforinit() {
		return selectedPieceforinit;
	}
	
	public static void DecreasethisPiece() {
		Management.selectedPieceforinit.getPiece().decreaseoff_field();
	}

	public static PieceCell getSelectformove_atk_stk() {
		return selectformove_atk_stk;
	}

	public static void setSelectformove_atk_stk(PieceCell selectformove_atk_stk) {
		Management.selectformove_atk_stk = selectformove_atk_stk;
	}

	public static PieceButton getSelectforplace() {
		return selectforplace;
	}

	public static void setSelectforplace(PieceButton selectforplace) {
		Management.selectforplace = selectforplace;
	}

	public static void setBalckpiecebar(Piece_Bar balckpiecebar) {
		Management.blackpiecebar = balckpiecebar;
	}

	public static void setWhitepiecebar(Piece_Bar whitepiecebar) {
		Management.whitepiecebar = whitepiecebar;
	}
	
	
	
	
	
	

}
