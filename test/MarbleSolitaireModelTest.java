import org.junit.Before;
import org.junit.Test;

import pkg.marblesolitaire.model.MarbleSolitaireModel;
import pkg.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A JUnit test class for the MarbleSolitaireModel class.
 */

public class MarbleSolitaireModelTest {
  private MarbleSolitaireModel m1;
  private MarbleSolitaireModel m2;
  private MarbleSolitaireModel m3;
  private MarbleSolitaireModel m4;
  private MarbleSolitaireModel m5;

  @Before
  public void setUp() {
    m1 = new MarbleSolitaireModelImpl();
    m2 = new MarbleSolitaireModelImpl(2, 2);
    m3 = new MarbleSolitaireModelImpl(5);
    m4 = new MarbleSolitaireModelImpl(5, 0, 6);
    m5 = new MarbleSolitaireModelImpl(11, 2, 15);
  }

  //Invalid out of bound empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness1() {
    new MarbleSolitaireModelImpl(-1, 5);
  }

  //Invalid out of bound empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness2() {
    new MarbleSolitaireModelImpl(4, 7);
  }

  //Invalid space at blocked position
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness3() {
    new MarbleSolitaireModelImpl(0, 0);
  }

  //Invalid negative arm thickness
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness4() {
    new MarbleSolitaireModelImpl(-3);
  }

  //Invalid arm thickness of 1, cannot start the game
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness5() {
    new MarbleSolitaireModelImpl(1);
  }

  //Invalid arm thickness of an even number
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness6() {
    new MarbleSolitaireModelImpl(4);
  }

  //Invalid arm thickness of zero
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness7() {
    new MarbleSolitaireModelImpl(0);
  }

  //Large number of arm thickness
  @Test
  public void testIllegalArmThickness8() {
    MarbleSolitaireModelImpl model = new MarbleSolitaireModelImpl(101);
    assertEquals(50600, model.getScore());
  }

  //Invalid out of bound empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness9() {
    new MarbleSolitaireModelImpl(5, -3, 7);
  }

  //Invalid out of bound empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness10() {
    new MarbleSolitaireModelImpl(5, 5, 13);
  }

  //Invalid out of bound empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness11() {
    new MarbleSolitaireModelImpl(5, -5, 13);
  }

  //Invalid empty slot at blocked position
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness12() {
    new MarbleSolitaireModelImpl(5, 0, 12);
  }

  //Invalid space at a blocked position
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness13() {
    new MarbleSolitaireModelImpl(5, 10, 2);
  }

  //Invalid arm thickness of one
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness14() {
    new MarbleSolitaireModelImpl(1, 3, 3);
  }

  //Invalid arm thickness of even number
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness15() {
    new MarbleSolitaireModelImpl(6, 3, 3);
  }

  //Invalid arm thickness of zero
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness16() {
    new MarbleSolitaireModelImpl(0, 6, 6);
  }

  //Invalid arm thickness of negative number
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness17() {
    new MarbleSolitaireModelImpl(-3, 6, 6);
  }

  //Invalid space at a blocked space
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness18() {
    new MarbleSolitaireModelImpl(5, 2, 12);
  }

  //Invalid arm thickness and empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArmThickness19() {
    new MarbleSolitaireModelImpl(-3, 15, 6);
  }

  //Large number of arm thickness
  @Test
  public void testIllegalArmThickness20() {
    MarbleSolitaireModelImpl model = new MarbleSolitaireModelImpl(101, 0, 103);
    assertEquals(50600, model.getScore());
  }

  //Test for getGameState() method of class MarbleSolitaireModel
  @Test
  public void testGetGameState() {
    String state1 = "    O O O\n    O O O\n"
            + "O O O O O O O\nO O O _ O O O\n"
            + "O O O O O O O\n    O O O\n    O O O";
    assertEquals(state1, m1.getGameState());

    String state2 = "    O O O\n    O O O\n"
            + "O O _ O O O O\nO O O O O O O\n"
            + "O O O O O O O\n    O O O\n    O O O";
    assertEquals(state2, m2.getGameState());

    String state3 = "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O";
    assertEquals(state3, m3.getGameState());

    String state4 = "        O O _ O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O";
    assertEquals(state4, m4.getGameState());

    String state5 = "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O _ O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O";
    assertEquals(state5, m5.getGameState());
  }

  //Out of bound beginning position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    m1.move(-1, 0, 0, 2);
  }

  //Out of bound beginning position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    m1.move(0, 10, 0, 2);
  }

  //Out of bound beginning position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    m1.move(-3, 10, 0, 2);
  }

  //Out of bound ending position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    m1.move(0, 3, 0, 7);
  }

  //Out of bound ending position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    m1.move(3, 6, 3, 8);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove6() {
    m1.move(3, 6, -2, 7);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove7() {
    m1.move(-3, 6, -2, 7);
  }

  //Moving from a space
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove8() {
    m1.move(3, 3, 3, 5);
  }

  //Moving from a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove9() {
    m1.move(1, 3, 3, 3);
    m1.move(1, 1, 1, 3);
  }

  //Moving to an occupied cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove10() {
    m1.move(3, 0, 3, 2);
  }

  //Moving to a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove11() {
    m1.move(1, 3, 1, 1);
  }

  //Moving without crossing a marble
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove12() {
    m1.move(1, 3, 3, 3);
    m1.move(0, 3, 2, 3);
  }

  //Invalid same column move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove13() {
    m1.move(0, 3, 3, 3);
  }

  //Invalid same row move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove14() {
    m1.move(3, 0, 3, 3);
  }

  //Invalid diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove15() {
    m1.move(2, 2, 3, 3);
  }

  //Invalid single move up
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove16() {
    m1.move(4, 3, 3, 3);
  }

  //Invalid single move down
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove17() {
    m1.move(2, 3, 3, 3);
  }

  //Invalid single move right
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove18() {
    m1.move(3, 2, 3, 3);
  }

  //Invalid single move left
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove19() {
    m1.move(3, 4, 3, 3);
  }

  //Random invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove20() {
    m1.move(2, 4, 3, 3);
  }

  //Out of bound beginning position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove21() {
    m2.move(-1, 0, 0, 2);
  }

  //Out of bound beginning position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove22() {
    m2.move(0, 10, 0, 2);
  }

  //Out of bound beginning position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove23() {
    m2.move(-3, 10, 0, 2);
  }

  //Out of bound ending position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove24() {
    m2.move(0, 3, 0, 7);
  }

  //Out of bound ending position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove25() {
    m2.move(3, 6, 3, 8);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove26() {
    m2.move(3, 6, -2, 7);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove27() {
    m2.move(0, 10, -2, 4);
  }

  //Moving from a space
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove28() {
    m2.move(2, 2, 2, 4);
  }

  //Moving from a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove29() {
    m2.move(2, 4, 2, 2);
    m2.move(0, 3, 2, 3);
    m2.move(0, 1, 0, 3);
  }

  //Moving to an occupied cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove30() {
    m2.move(3, 0, 3, 2);
  }

  //Moving to a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove31() {
    m2.move(1, 3, 1, 1);
  }

  //Moving without crossing a marble
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove32() {
    m2.move(2, 4, 2, 2);
    m2.move(2, 5, 2, 3);
  }

  //Invalid same column move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove33() {
    m2.move(5, 2, 2, 2);
  }

  //Invalid same row move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove34() {
    m2.move(2, 5, 2, 2);
  }

  //Invalid diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove35() {
    m2.move(3, 3, 2, 2);
  }

  //Invalid single move up
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove36() {
    m2.move(3, 5, 2, 2);
  }

  //Invalid single move down
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove37() {
    m2.move(1, 2, 2, 2);
  }

  //Invalid single move right
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove38() {
    m2.move(2, 1, 2, 2);
  }

  //Invalid single move left
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove39() {
    m1.move(2, 3, 2, 2);
  }

  //Random invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove40() {
    m2.move(2, 6, 3, 3);
  }

  //Out of bound beginning position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove41() {
    m3.move(-1, 0, 0, 2);
  }

  //Out of bound beginning position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove42() {
    m3.move(0, 15, 0, 2);
  }

  //Out of bound beginning position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove43() {
    m3.move(-3, 10, 0, 2);
  }

  //Out of bound ending position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove44() {
    m3.move(0, 3, 0, 13);
  }

  //Out of bound ending position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove45() {
    m3.move(3, 6, 3, 14);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove46() {
    m3.move(3, 6, -2, 7);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove47() {
    m3.move(-3, 6, -2, 7);
  }

  //Moving from a space
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove48() {
    m3.move(6, 6, 6, 8);
  }

  //Moving from a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove49() {
    m3.move(6, 8, 6, 6);
    m3.move(4, 7, 6, 7);
    m3.move(2, 7, 4, 7);
    m3.move(2, 9, 2, 7);
  }

  //Moving to an occupied cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove50() {
    m3.move(5, 4, 5, 6);
  }

  //Moving to a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove51() {
    m3.move(3, 7, 3, 9);
  }

  //Moving without crossing a marble
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove52() {
    m3.move(6, 8, 6, 6);
    m3.move(9, 9, 6, 7);
  }

  //Invalid same column move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove53() {
    m3.move(6, 6, 6, 6);
  }

  //Invalid same row move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove54() {
    m3.move(6, 3, 6, 6);
  }

  //Invalid diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove55() {
    m3.move(5, 7, 6, 6);
  }

  //Invalid single move up
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove56() {
    m3.move(7, 6, 6, 6);
  }

  //Invalid single move down
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove57() {
    m3.move(5, 6, 6, 6);
  }

  //Invalid single move right
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove58() {
    m3.move(6, 5, 6, 6);
  }

  //Invalid single move left
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove59() {
    m3.move(6, 7, 6, 6);
  }

  //Random invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove60() {
    m3.move(4, 8, 5, 7);
  }

  //Out of bound beginning position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove61() {
    m4.move(-1, 0, 0, 2);
  }

  //Out of bound beginning position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove62() {
    m4.move(0, 15, 0, 2);
  }

  //Out of bound beginning position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove63() {
    m4.move(-3, 10, 0, 2);
  }

  //Out of bound ending position (row)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove64() {
    m4.move(0, 3, 0, 13);
  }

  //Out of bound ending position (column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove65() {
    m4.move(3, 6, 3, 14);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove66() {
    m4.move(3, 6, -2, 7);
  }

  //Out of bound ending position (both row and column)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove67() {
    m4.move(-3, 6, -2, 7);
  }

  //Moving from a space
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove68() {
    m4.move(0, 6, 0, 8);
  }

  //Moving from a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove69() {
    m4.move(0, 8, 3, 6);
    m4.move(3, 7, 0, 7);
    m4.move(1, 9, 1, 7);
  }

  //Moving to an occupied cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove70() {
    m4.move(3, 7, 1, 7);
  }

  //Moving to a blocked cell
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove71() {
    m4.move(1, 7, 1, 9);
  }

  //Moving without crossing a marble
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove72() {
    m4.move(2, 3, 0, 6);
    m4.move(3, 6, 1, 6);
  }

  //Invalid same column move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove73() {
    m4.move(3, 6, 0, 6);
  }

  //Invalid same row move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove74() {
    m4.move(2, 6, 0, 6);
    m4.move(4, 6, 2, 6);
    m4.move(4, 9, 4, 6);
  }

  //Invalid diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove75() {
    m4.move(1, 7, 0, 6);
  }

  //Invalid single move up
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove76() {
    m4.move(1, 6, 0, 6);
  }

  //Invalid single move down
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove77() {
    m5.move(2, 15, 1, 15);
  }

  //Invalid single move right
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove78() {
    m4.move(0, 5, 0, 6);
  }

  //Invalid single move left
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove79() {
    m3.move(0, 7, 0, 6);
  }

  //Random invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove80() {
    m4.move(4, 7, 6, 7);
  }

  //Test for move() method of class MarbleSolitaireModel
  @Test
  public void testMove() {
    m1.move(3, 1, 3, 3);
    String moveOne = "    O O O\n    O O O\n"
            + "O O O O O O O\nO _ _ O O O O\n"
            + "O O O O O O O\n    O O O\n    O O O";
    assertEquals(moveOne, m1.getGameState());
    assertEquals(31, m1.getScore());
    m1.move(3, 4, 3, 2);
    m1.move(3, 6, 3, 4);
    moveOne = "    O O O\n    O O O\n"
            + "O O O O O O O\nO _ O _ O _ _\n"
            + "O O O O O O O\n"
            + "    O O O\n    O O O";
    assertEquals(moveOne, m1.getGameState());
    assertEquals(29, m1.getScore());

    String moveTwo = "    O O O\n    O O O\n"
            + "_ _ O O O O O\nO O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n    O O O";
    assertEquals(32, m2.getScore());
    m2.move(2, 0, 2, 2);
    assertEquals(moveTwo, m2.getGameState());
    assertEquals(31, m2.getScore());

    String moveThree = "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "O O O O _ O O O O O O O O\n"
            + "O O O O _ O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O";
    assertEquals(104, m3.getScore());
    m3.move(6, 4, 6, 6);
    m3.move(4, 4, 6, 4);
    assertEquals(moveThree, m3.getGameState());
    assertEquals(102, m3.getScore());

    String moveFour = "        _ _ O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n        O O O O O\n"
            + "        O O O O O\n        O O O O O";
    m4.move(0, 4, 0, 6);
    assertEquals(moveFour, m4.getGameState());
    assertEquals(103, m4.getScore());

    String moveFive = "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O _ _ O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O";
    m5.move(2, 17, 2, 15);
    assertEquals(moveFive, m5.getGameState());
    assertEquals(559, m5.getScore());
  }

  //Test for isGameOver() method of class MarbleSolitaireModel
  @Test
  public void testIsGameOver() {
    assertFalse(m1.isGameOver());
    assertFalse(m2.isGameOver());
    assertFalse(m3.isGameOver());
    assertFalse(m4.isGameOver());
    assertFalse(m5.isGameOver());

    m1.move(3, 1, 3, 3);
    m1.move(3, 4, 3, 2);
    m1.move(3, 6, 3, 4);
    m1.move(5, 3, 3, 3);
    m1.move(3, 3, 3, 5);
    m1.move(1, 3, 3, 3);
    m1.move(5, 4, 3, 4);
    m1.move(2, 4, 4, 4);
    m1.move(3, 2, 3, 4);
    assertFalse(m1.isGameOver());
    m1.move(3, 5, 3, 3);
    m1.move(4, 1, 4, 3);
    m1.move(2, 1, 2, 3);
    m1.move(0, 4, 2, 4);
    m1.move(4, 4, 4, 2);
    m1.move(5, 2, 3, 2);
    m1.move(3, 2, 3, 4);
    m1.move(3, 4, 1, 4);
    m1.move(4, 6, 4, 4);
    assertFalse(m1.isGameOver());
    m1.move(0, 2, 2, 2);
    assertFalse(m1.isGameOver());
    m1.move(2, 2, 2, 4);
    assertFalse(m1.isGameOver());
    m1.move(2, 5, 2, 3);
    assertTrue(m1.isGameOver());

    m2.move(2, 0, 2, 2);
    assertFalse(m2.isGameOver());
    m3.move(6, 4, 6, 6);
    m3.move(4, 4, 6, 4);
    assertFalse(m3.isGameOver());
    m4.move(0, 4, 0, 6);
    assertFalse(m4.isGameOver());
    m5.move(2, 17, 2, 15);
    assertFalse(m5.isGameOver());
  }

  //Test for getScore() method of class MarbleSolitaireModel
  @Test
  public void testGetSore() {
    assertEquals(32, m1.getScore());
    assertEquals(32, m2.getScore());
    assertEquals(104, m3.getScore());
    assertEquals(104, m4.getScore());
    assertEquals(560, m5.getScore());

    m1.move(3, 1, 3, 3);
    m1.move(3, 4, 3, 2);
    m1.move(3, 6, 3, 4);
    m1.move(5, 3, 3, 3);
    m1.move(3, 3, 3, 5);
    m1.move(1, 3, 3, 3);
    m1.move(5, 4, 3, 4);
    m1.move(2, 4, 4, 4);
    m1.move(3, 2, 3, 4);
    assertEquals(23, m1.getScore());
    m1.move(3, 5, 3, 3);
    m1.move(4, 1, 4, 3);
    m1.move(2, 1, 2, 3);
    m1.move(0, 4, 2, 4);
    m1.move(4, 4, 4, 2);
    m1.move(5, 2, 3, 2);
    m1.move(3, 2, 3, 4);
    m1.move(3, 4, 1, 4);
    m1.move(4, 6, 4, 4);
    assertEquals(14, m1.getScore());
    m1.move(0, 2, 2, 2);
    assertEquals(13, m1.getScore());
    m1.move(2, 2, 2, 4);
    assertEquals(12, m1.getScore());
    m1.move(2, 5, 2, 3);
    assertEquals(11, m1.getScore());
  }
}