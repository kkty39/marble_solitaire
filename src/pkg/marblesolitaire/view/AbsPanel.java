package pkg.marblesolitaire.view;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import pkg.marblesolitaire.model.Marble;
import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This is the abstract Panel that extends JPanel. A Panel is where the Marble Solitaire Board is
 * drawn.
 */
public abstract class AbsPanel extends JPanel {
  protected int fromX;
  protected int fromY;
  protected ReadOnlyMarbleSolitaireModel model;
  protected static final int FONT_SIZE = 30;
  protected static final String FONT_FACE = "Arial Black";
  public static final int CELL_DIM = 60;
  public static final int OFFSET = 80;
  private boolean isSelected;

  /**
   * Construct an AbsPanel.
   *
   * @param model a read-only model of Marble Solitaire
   */
  public AbsPanel(ReadOnlyMarbleSolitaireModel model) {
    this.model = model;
    setBackground(Color.WHITE);
    this.isSelected = false;
  }

  void paintBoard(Marble[][] board, Graphics2D g2d) {
    g2d.setFont(new Font(FONT_FACE, Font.BOLD, FONT_SIZE));
    g2d.setColor(Color.BLACK);
    if (board != null) {
      for (int r = 0; r < board.length; r++) {
        for (int c = 0; c < board[0].length; c++) {
          if (board[r][c] != null) {
            g2d.drawString(board[r][c].getPiece(), getCellX(c), getCellY(r));
          }
        }
      }
    }
  }

  void paintGameStateString(Graphics2D g2d) {
    if (this.model.isGameOver()) {
      g2d.drawString("Game over!    Score: " + model.getScore(),
              OFFSET, OFFSET - 20);
    } else {
      g2d.drawString("Score: " + model.getScore(), OFFSET, OFFSET - 20);
    }
  }

  void paintSelected(Graphics2D g2d, int x, int y) {
    if (this.isSelected && !this.model.isGameOver()) {
      g2d.setColor(new Color(255, 0, 0, 30));
      g2d.fillRect(x, y, 5 * CELL_DIM / 8, 5 * CELL_DIM / 8);
    }
  }

  public void setIsSelected(boolean flag) {
    this.isSelected = flag;
  }

  public void setFromX(int x) {
    this.fromX = x;
  }

  public void setFromY(int y) {
    this.fromY = y;
  }

  protected static int getCellX(int c) {
    return (int) Math.round((c + 0.29) * CELL_DIM + OFFSET);
  }

  protected static int getCellY(int r) {
    return (int) Math.round((r + 0.7) * CELL_DIM + OFFSET);
  }
}
