package pkg.marblesolitaire.controller;

import pkg.marblesolitaire.MarbleSolitaire;
import pkg.marblesolitaire.model.MarbleSolitaireModel;
import pkg.marblesolitaire.view.MarbleSolitaireSwingView;
import pkg.marblesolitaire.view.MarbleSolitaireView;
import pkg.marblesolitaire.view.TriangleSolitaireView;

/**
 * This is a factory that produces different classes of MarbleSolitaireView.
 */
public class ViewFactory {

  /**
   * Produce and return a MarbleSolitaireView accordingly.
   *
   * @param type type of game mode (e.g. English, European, and Triangular)
   * @param m    a MarbleSolitaireModel
   * @return a MarbleSolitaireView
   */
  public static MarbleSolitaireView buildView(String type, MarbleSolitaireModel m) {
    if (type == null) {
      MarbleSolitaire.showError("Type cannot be null.");
    }
    assert type != null;
    if ("triangular".equals(type)) {
      return new TriangleSolitaireView(m);
    }
    return new MarbleSolitaireSwingView(m);
  }

}
