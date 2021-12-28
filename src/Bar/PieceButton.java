package Bar;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PieceButton extends Button{
	private Pieces piece;
	
	PieceButton(String piecename, int side){
		this.piece = new Pieces(piecename, side);
		this.setPadding(new Insets(3));
		Image img = new Image(piece.getUrl());
		ImageView view = new ImageView(img);
		view.setFitHeight(48);
		view.setFitWidth(48);
		this.setGraphic(view);
		
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setTooltip();
	}

	public Pieces getPiece() {
		return piece;
	}
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void setTooltip() {
		Tooltip	tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText(piece.getName());
		this.setOnMouseMoved((MouseEvent e) -> {
			if (piece != null)
			tooltip.show(this, e.getScreenX(), e.getScreenY()+10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});		
	}
	

}
