package pkg.marblesolitaire.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pkg.marblesolitaire.controller.MarbleSolitaireController;
import pkg.marblesolitaire.model.ReadOnlyMarbleSolitaireModel;

/**
 * This is the abstract implementation of the interface MarbleSolitaireView. It provides methods
 * that could be used to set up the view.
 */
public abstract class AbsView extends JFrame implements MarbleSolitaireView {
  protected final int WIDTH = 700;
  protected final int HEIGHT = 700;
  protected AbsPanel panel;

  /**
   * Construct an abstract view.
   *
   * @param model a read only MarbleSolitaireModel
   */
  public AbsView(ReadOnlyMarbleSolitaireModel model) {
    super();
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panelSetUp(model);
    scrollPaneSetUp();
  }

  protected abstract void panelSetUp(ReadOnlyMarbleSolitaireModel model);

  protected void scrollPaneSetUp() {
    JScrollPane scrollPane = new JScrollPane(this.panel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    setBounds(0, 0, WIDTH, HEIGHT);
    add(scrollPane, BorderLayout.CENTER);
  }

  @Override
  public void addClickListener(MarbleSolitaireController controller) {
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = (e.getY() - AbsPanel.OFFSET) / AbsPanel.CELL_DIM;
        int col = (e.getX() - AbsPanel.OFFSET) / AbsPanel.CELL_DIM;
        col = adaptCol(row, col);
        controller.handleCell(row, col);
        panel.setIsSelected(controller.isSelected());
        panel.setFromX(controller.getFromX());
        panel.setFromY(controller.getFromY());
      }
    };
    panel.addMouseListener(ml);
  }

  int adaptCol(int row, int col) {
    return col;
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

}
