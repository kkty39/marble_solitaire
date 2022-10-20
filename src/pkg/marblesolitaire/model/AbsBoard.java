package pkg.marblesolitaire.model;

import java.util.Arrays;

/**
 * This is the abstract Board. It implements the interface of IBoard. The board provides method to
 * generate a read-only board, get number of board row and board columns.
 */
public abstract class AbsBoard implements IBoard {

  protected Marble[][] board;

  protected AbsBoard(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Row or column number should be positive.");
    }
    board = new Marble[row][col];
  }

  protected void checkArmNumber(int arm) throws IllegalArgumentException {
    if (arm < 3) {
      throw new IllegalArgumentException("Arm thickness should be greater than 1.");
    } else if (arm % 2 != 1) {
      throw new IllegalArgumentException("Arm thickness should be a positive odd number.");
    }
  }

  @Override
  public Marble[][] getReadOnlyBoard() {
    Marble[][] ret = new Marble[board.length][board[0].length];
    for (int r = 0; r < board.length; r++) {
      ret[r] = Arrays.copyOf(board[r], board[r].length);
    }
    return ret;
  }

  @Override
  public int getRowLen() {
    return board.length;
  }

  @Override
  public int getColLen() {
    return board[0].length;
  }

  @Override
  public Marble getMarble(int row, int col) {
    return board[row][col];
  }

  @Override
  public void setMarble(int row, int col, Marble marble) {
    board[row][col] = marble;
  }
}
