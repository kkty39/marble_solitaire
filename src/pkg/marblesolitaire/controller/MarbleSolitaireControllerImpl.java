package pkg.marblesolitaire.controller;

import pkg.marblesolitaire.model.MarbleSolitaireModel;
import pkg.marblesolitaire.view.MarbleSolitaireView;

/**
 * This is the implementation of MarbleSolitaireController interface. It directs how the model and
 * view should work.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;
  private boolean isSelected;

  /**
   * Construct an implementation of MarbleSolitaireController.
   *
   * @param m a MarbleSolitaireModel
   * @param v a MarbleSolitaireView
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel m, MarbleSolitaireView v) {
    this.model = m;
    this.view = v;
    this.fromX = -1;
    this.fromY = -1;
    this.toX = -1;
    this.toY = -1;
    this.isSelected = false;
    this.view.makeVisible();
  }

  @Override
  public void playGame() {
    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public boolean isSelected() {
    return this.isSelected;
  }

  @Override
  public void handleCell(int row, int col) {
    if (this.isSelected) {
      this.toX = row;
      this.toY = col;
      this.moveMarble();
      this.isSelected = false;
    } else {
      this.fromX = row;
      this.fromY = col;
      this.isSelected = this.model.checkCellValidity(this.fromX, this.fromY);
    }
    this.view.refresh();
  }

  @Override
  public void moveMarble() {
    try {
      model.move(fromX, fromY, toX, toY);
      view.refresh();
    } catch (IllegalArgumentException e) {
      // do nothing if move was illegal
    }
  }

  @Override
  public int getFromX() {
    return this.fromX;
  }

  @Override
  public int getFromY() {
    return this.fromY;
  }


}
