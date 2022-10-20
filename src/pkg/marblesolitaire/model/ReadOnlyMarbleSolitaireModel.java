package pkg.marblesolitaire.model;

/**
 * This is a read only MarbleSolitaireModel interface. It provides only getter methods and could
 * not change game status.
 */
public interface ReadOnlyMarbleSolitaireModel {

  /**
   * Return the current game state, a a 2D array of Marble.
   *
   * @return the current game board
   */
  Marble[][] getBoard();

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Return a string that represents the current state of the board. The string should have one
   * line per row of the game board. Each slot on the game board is a single character (O, X or
   * space for a marble, empty and invalid position respectively). Slots in a row should be
   * separated by a space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  String getGameState();

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  int getScore();

  /**
   * Return the number of arm thickness or dimension of board.
   *
   * @return the number of arm thickness or dimension of board
   */
  int getArm();

}
