package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This class represents the implementation of the methods in the abstract Board. This Board is for
 * the mode of English. An object of Board has a double array of Marbles. Each space of array is
 * either null or contains an enum of Marble ("O" or "E"), representing the state of occupied or
 * space.
 */
public class EnglishBoard extends AbsBoard {

  /**
   * Construct a Board object using given values of arm thickness, row of space, column of empty
   * slot.
   *
   * @param arm  the number of marbles in the top row
   * @param sRow row number of the empty slot
   * @param sCol column number of the empty slot
   * @throws IllegalArgumentException if arm thickness is not a positive odd number, or is less than
   *                                  one(which cannot construct a board), or if row/column number
   *                                  of empty slot is out of bound or at blocked places
   */
  public EnglishBoard(int arm, int sRow, int sCol) {
    super(3 * arm - 2, 3 * arm - 2);
    checkArmNumber(arm);
    if (sCol > 3 * arm - 3 || sRow < 0 || sRow > 3 * arm - 3) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d).", sRow, sCol));
    } else if ((sCol < arm - 1 || sCol > 2 * arm - 2)
            && (sRow < arm - 1 || sRow > 2 * arm - 2)) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d).", sRow, sCol));
    }
    setBoard(arm, sRow, sCol);
  }

  /**
   * Set up the board in initiated status using given value of arm thickness.
   *
   * @param arm  the number of marbles in the top row
   * @param sRow row number of the empty slot
   * @param sCol column number of the empty slot
   */
  void setBoard(int arm, int sRow, int sCol) {
    for (int i = 0; i < arm * 3 - 2; i++) {
      for (int j = 0; j < arm * 3 - 2; j++) {
        if (i == sRow && j == sCol) {
          board[i][j] = Marble.E;
        } else if (Rules.isWithinScopeEnglish(arm, i, j)) {
          board[i][j] = Marble.O;
        }
      }
    }
  }


}
