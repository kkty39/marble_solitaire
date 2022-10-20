package pkg.marblesolitaire.controller;

import pkg.marblesolitaire.MarbleSolitaire;
import pkg.marblesolitaire.model.EuropeanSolitaireModelImpl;
import pkg.marblesolitaire.model.MarbleSolitaireModel;
import pkg.marblesolitaire.model.MarbleSolitaireModelImpl;
import pkg.marblesolitaire.model.TriangleSolitaireModelImpl;

/**
 * This is a factory that produces MarbleSolitaireModel according to the arguments given.
 */
public class ModelFactory {

  /**
   * Build and return a MarbleSolitaireModel according to requirements from arguments.
   *
   * @param type type of game mode (e.g. English, European, and Triangular)
   * @param size size of board
   * @param sRow row number of empty cell
   * @param sCol column number of empty cell
   * @return a MarbleSolitaireModel
   */
  public static MarbleSolitaireModel buildModel(String type, int size, int sRow, int sCol) {
    if (type == null) {
      MarbleSolitaire.showError("Type cannot be null.");
    }
    assert type != null;
    MarbleSolitaireModel ret;
    if (size == -1 && sRow == -1 && sCol == -1) {
      ret = createDefaultBoard(type);
    } else if (sRow == -1 && sCol == -1) {
      ret = createBoardWithSize(type, size);
    } else if (size == -1) {
      ret = createBoardWithHole(type, sRow, sCol);
    } else {
      ret = createCustomizedBoard(type, size, sRow, sCol);
    }
    return ret;
  }

  private static MarbleSolitaireModel createDefaultBoard(String type) {
    switch (type) {
      case "english":
        return new MarbleSolitaireModelImpl();
      case "european":
        return new EuropeanSolitaireModelImpl();
      case "triangular":
        return new TriangleSolitaireModelImpl();
      default:
        MarbleSolitaire.showError("No such model available.");
        return null;
    }
  }

  private static MarbleSolitaireModel createBoardWithSize(String type, int size) {
    switch (type) {
      case "english":
        return new MarbleSolitaireModelImpl(size);
      case "european":
        return new EuropeanSolitaireModelImpl(size);
      case "triangular":
        return new TriangleSolitaireModelImpl(size);
      default:
        MarbleSolitaire.showError("No such model available.");
        return null;
    }
  }

  private static MarbleSolitaireModel createBoardWithHole(String type, int sRow, int sCol) {
    switch (type) {
      case "english":
        return new MarbleSolitaireModelImpl(sRow, sCol);
      case "european":
        return new EuropeanSolitaireModelImpl(sRow, sCol);
      case "triangular":
        return new TriangleSolitaireModelImpl(sRow, sCol);
      default:
        MarbleSolitaire.showError("No such model available.");
        return null;
    }
  }

  private static MarbleSolitaireModel createCustomizedBoard(String type, int size,
                                                            int sRow, int sCol) {
    switch (type) {
      case "english":
        return new MarbleSolitaireModelImpl(size, sRow, sCol);
      case "european":
        return new EuropeanSolitaireModelImpl(size, sRow, sCol);
      case "triangular":
        return new TriangleSolitaireModelImpl(size, sRow, sCol);
      default:
        MarbleSolitaire.showError("No such model available.");
        return null;
    }
  }

}
