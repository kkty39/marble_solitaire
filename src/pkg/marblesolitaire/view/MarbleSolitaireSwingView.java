package pkg.marblesolitaire.view;

import java.awt.Dimension;

import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This class extends the abstract view and represents a view that could be used by English mode and
 * European mode.
 */
public class MarbleSolitaireSwingView extends AbsView {

  public MarbleSolitaireSwingView(ReadOnlyMarbleSolitaireModel model) {
    super(model);
  }

  @Override
  protected void panelSetUp(ReadOnlyMarbleSolitaireModel model) {
    this.panel = new MarbleSolitairePanel(model);
    this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

}
