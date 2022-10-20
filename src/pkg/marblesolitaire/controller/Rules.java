package pkg.marblesolitaire.controller;

public class Rules {

  public static boolean isWithinScopeEnglish(int arm, int row, int col) {
    return !((row < arm - 1 || row > 2 * arm - 2) && (col < arm - 1 || col > 2 * arm - 2));
  }

  public static boolean isWithinScopeEuropean(int arm, int row, int col) {
    return (!((row < arm) && (col < arm - row - 1 || col > 2 * arm - 2 + row))
            && !((row > 2 * arm - 2)
            && (col < row - 2 * arm + 2 || col > 5 * arm - 5 - row)));
  }

  public static boolean isWithinScopeTriangle(int row, int col) {
    return col <= row;
  }


}
