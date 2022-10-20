package pkg.marblesolitaire.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import pkg.marblesolitaire.model.Marble;
import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This class represents a MarbleSolitairePanel to draw the Marble Solitaire Board.
 */
public class MarbleSolitairePanel extends AbsPanel {

  public MarbleSolitairePanel(ReadOnlyMarbleSolitaireModel model) {
    super(model);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Marble[][] board = model.getBoard();
    int x = getCellX(this.fromY) - CELL_DIM / 10;
    int y = getCellY(this.fromX) - CELL_DIM / 2;
    paintSelected(g2d, x, y);
    paintBoard(board, g2d);
    paintGameStateString(g2d);

  }


}
