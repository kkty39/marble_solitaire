package pkg.marblesolitaire.controller;

/**
 * This interface is the controller of the whole game. It provides method to start the game.
 */
public interface MarbleSolitaireController {

  /**
   * A method that initializes the board and starts the game.
   */
  void playGame();

  /**
   * Move the marble in MarbleSolitaireModel.
   */
  void moveMarble();

  /**
   * Check there is a cell being selected as the "moveFrom" position.
   *
   * @return a boolean value indicating whether a cell is selected or not
   */
  boolean isSelected();

  /**
   * To determine if the cell serves as the origin or destination.
   *
   * @param row row number of cell
   * @param col column number of cell
   */
  void handleCell(int row, int col);

  /**
   * Return the value of x coordinate of cell.
   *
   * @return the value of x coordinate of cell
   */
  int getFromX();

  /**
   * Return the value of y coordinate of cell.
   *
   * @return the value of y coordinate of cell
   */
  int getFromY();
}
