package pkg.marblesolitaire.model;

/**
 * This is an abstract implementation of MarbleSolitaireModel.
 */
public abstract class AbsSolitaireModelImpl implements MarbleSolitaireModel {

  protected int arm;
  protected int score;
  protected IBoard board;

  protected AbsSolitaireModelImpl(int arm) {
    this.arm = arm;
    setInitScore();
  }

  protected abstract void setInitScore();

  boolean isInvalidCell(int row, int col) {
    return row < 0 || col < 0 || row > board.getRowLen() - 1 || col > board.getColLen() - 1;
  }

  boolean isValidCellPosition(int fromRow, int fromCol, int toRow, int toCol) {
    return this.board.getMarble(fromRow, fromCol) == Marble.O
            && this.board.getMarble(toRow, toCol) == Marble.E
            && this.board.getMarble((fromRow + toRow) / 2,
            (fromCol + toCol) / 2) == Marble.O;
  }

  void setMarble(int fromRow, int fromCol, int toRow, int toCol) {
    this.board.setMarble(fromRow, fromCol, Marble.E);
    this.board.setMarble(toRow, toCol, Marble.O);
    this.board.setMarble((fromRow + toRow) / 2, (fromCol + toCol) / 2, Marble.E);
  }

  /**
   * Check if the move is valid and return the boolean value where true represents a valid move
   * while false represents an invalid move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @return the boolean value of whether the move is valid
   */
  boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (isInvalidCell(toRow, toCol)) {
      return false;
    }
    return checkRules(fromRow, fromCol, toRow, toCol);
  }

  @Override
  public boolean checkCellValidity(int row, int col) {
    if (isInvalidCell(row, col)) {
      return false;
    }
    return isWithinScope(row, col);
  }

  boolean checkRules(int fromRow, int fromCol, int toRow, int toCol) {
    if ((Math.abs(fromCol - toCol) == 2 && fromRow == toRow)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2)) {
      return isValidCellPosition(fromRow, fromCol, toRow, toCol);
    }
    return false;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (isInvalidCell(toRow, toCol)) {
      throw new IllegalArgumentException("Invalid destination position.");
    } else if (isInvalidCell(fromRow, fromCol)) {
      throw new IllegalArgumentException("Invalid beginning position.");
    }
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(
              String.format("Invalid move from(%d, %d) to (%d,%d)",
                      fromRow, fromCol, toRow, toCol));
    }
    setMarble(fromRow, fromCol, toRow, toCol);
    score--;
  }

  boolean hasValidMove(int i, int j) {
    return (isValidMove(i, j, i - 2, j)) || (isValidMove(i, j, i + 2, j))
            || (isValidMove(i, j, i, j - 2)) || (isValidMove(i, j, i, j + 2));
  }

  protected abstract boolean isWithinScope(int i, int j);

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < board.getRowLen(); i++) {
      for (int j = 0; j < board.getColLen(); j++) {
        if (isWithinScope(i, j)) {
          if (hasValidMove(i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < board.getRowLen(); i++) {
      for (int j = 0; j < board.getColLen(); j++) {
        if (board.getMarble(i, j) == null) {
          state.append("  ");
          continue;
        }
        state.append(board.getMarble(i, j).getPiece()).append(" ");
        if (j <= board.getColLen() - 2) {
          if (board.getMarble(i, j + 1) == null) {
            break;
          }
        }
      }
      state.setLength(state.length() - 1);
      state.append("\n");
    }
    state.setLength(state.length() - 1);
    return state.toString();
  }

  @Override
  public int getScore() {
    return this.score;
  }

  @Override
  public Marble[][] getBoard() {
    return board.getReadOnlyBoard();
  }

  @Override
  public int getArm() {
    return this.arm;
  }
}
