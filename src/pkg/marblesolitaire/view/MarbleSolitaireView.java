package pkg.marblesolitaire.view;

import pkg.marblesolitaire.controller.MarbleSolitaireController;

/**
 * This interface represents the view of Marble Solitaire.
 */
public interface MarbleSolitaireView {

  void refresh();

  void makeVisible();

  void addClickListener(MarbleSolitaireController controller);

}
