package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This class represents the implementation of methods in the MarbleSolitaireModel interface. An
 * object of MarbleSolitaireModelImpl has an interface of IBoard,which represents the board of game
 * Marble Solitaire, and a score value of score that keeps the number of marbles on the board.
 */
public class MarbleSolitaireModelImpl extends AbsSolitaireModelImpl {

  /**
   * Construct a default implementation of Marble Solitaire Model where arm thickness is three and
   * the empty slot is at center. Set the score as number of marbles on board.
   */
  public MarbleSolitaireModelImpl() {
    super(3);
    this.board = new EnglishBoard(3, 3, 3);
  }

  /**
   * Construct an implementation of Marble Solitaire Model using given row and column numbers of
   * empty slot with default number of arm thickness of 3. Set the score as number of marbles on
   * board.
   *
   * @param sRow row number of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException if row/column number of empty slot is out of bound or at
   *                                  blocked places
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    super(3);
    this.board = new EnglishBoard(3, sRow, sCol);
  }

  /**
   * Construct an implementation of Marble Solitaire Model using given number of arm thickness. Set
   * the score as number of marbles on board.
   *
   * @param arm the number of marbles in the top row
   * @throws IllegalArgumentException if arm thickness is not a positive odd number, or is less
   *                                  than one(which cannot construct a board)
   */
  public MarbleSolitaireModelImpl(int arm) {
    super(arm);
    this.board = new EnglishBoard(arm, (3 * arm - 3) / 2, (3 * arm - 3) / 2);
  }

  /**
   * Construct an implementation of Marble Solitaire Model using given number of arm thickness, row
   * number and column number of empty slot. Set the score as number of marbles on board.
   *
   * @param arm  the number of marbles in the top row
   * @param sRow row number of the empty slot
   * @param sCol column number of the empty slot
   * @throws IllegalArgumentException if arm thickness is not a positive odd number, or is less
   *                                  than one(which cannot construct a board), or if row/column
   *                                  number of empty slot is out of bound or at blocked places
   */
  public MarbleSolitaireModelImpl(int arm, int sRow, int sCol) {
    super(arm);
    this.board = new EnglishBoard(arm, sRow, sCol);
  }

  @Override
  protected void setInitScore() {
    this.score = this.arm * this.arm  * 5 - 4 * this.arm  - 1;
  }

  @Override
  protected boolean isWithinScope(int i, int j) {
    return Rules.isWithinScopeEnglish(this.arm, i, j);
  }

}
