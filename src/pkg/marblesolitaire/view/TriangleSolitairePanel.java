package pkg.marblesolitaire.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import pkg.marblesolitaire.model.Marble;
import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This class represents a panel to draw a triangular marble solitaire board.
 */
public class TriangleSolitairePanel extends AbsPanel {

  public TriangleSolitairePanel(ReadOnlyMarbleSolitaireModel model) {
    super(model);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Marble[][] board = transformBoard(model.getBoard());
    int col = adaptCol(model.getArm(), this.fromX, this.fromY);
    int x = getCellX(col) - CELL_DIM / 10;
    int y = getCellY(this.fromX) - CELL_DIM / 2;
    paintSelected(g2d, x, y);
    paintBoard(board, g2d);
    paintGameStateString(g2d);

  }

  static int adaptCol(int dimension, int row, int col) {
    return dimension - 1 - row + col * 2;
  }

  Marble[][] transformBoard(Marble[][] board) {
    int dim = board.length;
    Marble[][] ret = new Marble[dim][2 * dim - 1];
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < i + 1; j++) {
        int col = adaptCol(dim, i, j);
        ret[i][col] = board[i][j];
      }
    }
    return ret;
  }

}
