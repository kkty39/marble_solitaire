package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This is the implementation of a TriangleSolitaireModel. It uses a triangular solitaire board.
 */
public class TriangleSolitaireModelImpl extends AbsSolitaireModelImpl {

  public TriangleSolitaireModelImpl() {
    super(5);
    this.board = new TriangularBoard(this.arm, 0, 0);
  }

  public TriangleSolitaireModelImpl(int arm) {
    super(arm);
    this.board = new TriangularBoard(this.arm, 0, 0);
  }

  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    super(5);
    this.board = new TriangularBoard(this.arm, sRow, sCol);
  }

  public TriangleSolitaireModelImpl(int arm, int sRow, int sCol) {
    super(arm);
    this.board = new TriangularBoard(this.arm, sRow, sCol);
  }

  @Override
  protected void setInitScore() {
    this.score = (this.arm - 1) * (this.arm + 2) / 2;
  }

  @Override
  boolean checkRules(int fromRow, int fromCol, int toRow, int toCol) {
    if (super.checkRules(fromRow, fromCol, toRow, toCol)) {
      return true;
    }
    if ((Math.abs(fromRow - toRow) == 2) && Math.abs(fromCol - toCol) == 2) {
      return isValidCellPosition(fromRow, fromCol, toRow, toCol);
    }
    return false;
  }

  @Override
  protected boolean isWithinScope(int i, int j) {
    return Rules.isWithinScopeTriangle(i, j);
  }

  @Override
  boolean hasValidMove(int i, int j) {
    return (isValidMove(i, j, i - 2, j)) || (isValidMove(i, j, i + 2, j))
            || (isValidMove(i, j, i, j - 2)) || (isValidMove(i, j, i, j + 2))
            || isValidMove(i, j, i + 2, j + 2) || isValidMove(i, j, i - 2, j - 2);
  }

  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < arm; i++) {
      int temp;
      for (temp = 1; temp < arm - i; temp++) {
        state.append(" ");
      }
      for (temp = 1; temp <= arm; temp++) {
        if (temp == arm || board.getMarble(i, temp) == null) {
          state.append(board.getMarble(i, temp - 1).getPiece());
          break;
        }
        state.append(board.getMarble(i, temp - 1).getPiece()).append(" ");
      }
      state.append("\n");
    }
    state.setLength(state.length() - 1);
    return state.toString();
  }

}
