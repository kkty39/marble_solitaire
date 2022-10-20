package pkg.marblesolitaire.model;

/**
 * This interface represents the operations offered by the board of marble solitaire model. One
 * object of the board represents one board of the game marble solitaire.
 */
public interface IBoard {
  /**
   * Return the number of row of board.
   *
   * @return the number of row of board
   */
  int getRowLen();

  /**
   * Return the number of columns of board.
   *
   * @return the number of columns of board
   */
  int getColLen();

  /**
   * Return the marble of indicated position specified in row and column.
   *
   * @param row row of marble located
   * @param col column of marble located
   * @return the marble of indicated position
   */
  Marble getMarble(int row, int col);

  /**
   * Set the state of marble with indicated row and column value.
   *
   * @param row    row of marble to be located
   * @param col    column of marble to be located
   * @param marble to be set
   */
  void setMarble(int row, int col, Marble marble);

  Marble[][] getReadOnlyBoard();

}
