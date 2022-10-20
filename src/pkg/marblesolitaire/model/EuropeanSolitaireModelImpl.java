package pkg.marblesolitaire.model;

import pkg.marblesolitaire.controller.Rules;

/**
 * This class is the implementation of abstract MarbleSolitaireImpl. It represents the European
 * style.
 */
public class EuropeanSolitaireModelImpl extends AbsSolitaireModelImpl {

  /**
   * Construct a default implementation of European Solitaire Model where arm thickness is three and
   * the empty slot is at center. Set the score as number of marbles on board.
   */
  public EuropeanSolitaireModelImpl() {
    super(3);
    this.board = new EuropeanBoard(3, 3, 3);
  }

  /**
   * Construct an implementation of Marble European Model using given row and column numbers of
   * empty slot with default number of arm thickness of 3. Set the score as number of marbles on
   * board.
   *
   * @param sRow row number of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException if row/column number of empty slot is out of bound or at
   *                                  blocked places
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    super(3);
    this.board = new EuropeanBoard(3, sRow, sCol);
  }

  /**
   * Construct an implementation of European Solitaire Model using given number of arm thickness.
   * Set the score as number of marbles on board.
   *
   * @param arm the number of marbles in the top row
   * @throws IllegalArgumentException if arm thickness is not a positive odd number, or is less than
   *                                  one(which cannot construct a board)
   */
  public EuropeanSolitaireModelImpl(int arm) {
    super(arm);
    this.board = new EuropeanBoard(arm, (3 * arm - 3) / 2, (3 * arm - 3) / 2);
  }

  /**
   * Construct an implementation of European Solitaire Model using given number of arm thickness,
   * row number and column number of empty slot. Set the score as number of marbles on board.
   *
   * @param arm  the number of marbles in the top row
   * @param sRow row number of the empty slot
   * @param sCol column number of the empty slot
   * @throws IllegalArgumentException if arm thickness is not a positive odd number, or is less than
   *                                  one(which cannot construct a board), or if row/column number
   *                                  of empty slot is out of bound or at blocked places
   */
  public EuropeanSolitaireModelImpl(int arm, int sRow, int sCol) {
    super(arm);
    this.board = new EuropeanBoard(arm, sRow, sCol);
  }

  @Override
  protected void setInitScore() {
    this.score = 7 * this.arm * this.arm - 10 * this.arm + 3;
  }

  @Override
  protected boolean isWithinScope(int i, int j) {
    return Rules.isWithinScopeEuropean(this.arm, i, j);
  }
}
