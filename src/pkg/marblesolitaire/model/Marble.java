package pkg.marblesolitaire.model;

/**
 * The enum represents a state of a Marble on board. O: occupied. E: empty.
 */
public enum Marble {
  O("O"),
  E("_");

  private final String piece;

  Marble(String marble) {
    this.piece = marble;
  }

  public String getPiece() {
    return this.piece;
  }
}
