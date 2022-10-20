package pkg.marblesolitaire;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pkg.marblesolitaire.model.MarbleSolitaireModel;
import pkg.marblesolitaire.controller.MarbleSolitaireController;
import pkg.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import pkg.marblesolitaire.view.MarbleSolitaireView;
import pkg.marblesolitaire.controller.ModelFactory;
import pkg.marblesolitaire.controller.ViewFactory;

/**
 * This is the main class for the game MarbleSolitaire. Currently there are three modes of boards:
 * English, European, and Triangular.
 */
public final class MarbleSolitaire {

  /**
   * This is the main method of launching the game.
   *
   * @param args arguments passed in from command line to initialize game status
   */
  public static void main(String[] args) {

    if (args.length == 0) {
      showError("Please enter arguments.");
    }

    String type = args[0];
    int size = -1;
    int sRow = -1;
    int sCol = -1;
    for (int i = 0; i < args.length; ++i) {
      if (args[i].equals("-size")) {
        size = stringToInt(args[i + 1]);
      }
      if (args[i].equals("-hole")) {
        sRow = stringToInt(args[i + 1]);
        sCol = stringToInt(args[i + 2]);
      }
    }

    MarbleSolitaireModel m = ModelFactory.buildModel(type, size, sRow, sCol);
    MarbleSolitaireView v = ViewFactory.buildView(type, m);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(m, v);
    c.playGame();

  }

  static int stringToInt(String str) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      showError("Argument  " + str + "  should be in the format of integer.");
      return -1;
    }
  }

  /**
   * Pop out a window showing error message and exit the program.
   *
   * @param msg the incorrect part of argument from command line
   */
  public static void showError(String msg) {
    class ErrorMessage extends JFrame {
      void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    ErrorMessage dummy = new ErrorMessage();
    dummy.showErrorMessage(msg);
    System.exit(-1);
  }


}
