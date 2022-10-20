package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This class represents an European Marble Solitaire Board.
 */
public class EuropeanBoard extends AbsBoard {

  /**
   * Construct an EuropeanBoard.
   *
   * @param arm  arm thickness of board.
   * @param sRow row of empty cell
   * @param sCol column of empty cell
   * @throws IllegalArgumentException if arm thickness is invalid or empty cell position is invalid
   */
  public EuropeanBoard(int arm, int sRow, int sCol) {
    super(3 * arm - 2, 3 * arm - 2);
    checkArmNumber(arm);
    if (sCol > 3 * arm - 3 || sRow < 0 || sRow > 3 * arm - 3 || sCol < 0) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d).", sRow, sCol));
    }
    if ((sRow < arm) && (sCol < arm - sRow - 1 || sCol > 2 * arm - 2 + sRow)) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d).", sRow, sCol));
    } else if ((sRow > 2 * arm - 2) && (sCol < sRow - 2 * arm + 2 || sCol > 5 * arm - 5 - sRow)) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d)", sRow, sCol));
    }
    setBoard(arm, sRow, sCol);
  }

  void setBoard(int arm, int sRow, int sCol) {
    for (int i = 0; i < arm * 3 - 2; i++) {
      for (int j = 0; j < arm * 3 - 2; j++) {
        if (i == sRow && j == sCol) {
          board[i][j] = Marble.E;
        } else if (Rules.isWithinScopeEuropean(arm, i, j)) {
          board[i][j] = Marble.O;
        }
      }
    }
  }

}
