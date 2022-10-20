package pkg.marblesolitaire.view;

import java.awt.Dimension;

import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This class represents the view of a triangular marble solitaire board.
 */
public class TriangleSolitaireView extends AbsView {

  private int dimension;

  public TriangleSolitaireView(ReadOnlyMarbleSolitaireModel model) {
    super(model);
    this.dimension = model.getArm();
  }

  @Override
  protected void panelSetUp(ReadOnlyMarbleSolitaireModel model) {
    this.panel = new TriangleSolitairePanel(model);
    this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  @Override
  int adaptCol(int row, int col) {
    return (col - this.dimension + 1 + row) / 2;
  }

}
