package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This class extends the abstract class of a Board. It represents the triangular version of Board.
 */
public class TriangularBoard extends AbsBoard {

  /**
   * Construct a triangular Board.
   *
   * @param dimension dimension of board
   * @param sRow      row number of empty cell
   * @param sCol      column number of empty cell
   */
  public TriangularBoard(int dimension, int sRow, int sCol) {
    super(dimension, dimension);
    if (dimension <= 0) {
      throw new IllegalArgumentException("Dimension should be positive.");
    }
    if (sRow < 0 || sCol < 0 || sRow > dimension - 1 || sCol > dimension - 1 || sCol > sRow) {
      throw new IllegalArgumentException(String.format(
              "Invalid empty cell position (%d,%d)", sRow, sCol));
    }
    setBoard(dimension, sRow, sCol);
  }

  void setBoard(int dimension, int sRow, int sCol) {
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (Rules.isWithinScopeTriangle(i, j)) {
          if (i == sRow && j == sCol) {
            board[i][j] = Marble.E;
          } else {
            board[i][j] = Marble.O;
          }
        }
      }
    }
  }
}
