package mall;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class NumberButton extends JButton {


  public NumberButton() {
      super();
      decorate();
  }

  public NumberButton(String text) {
      super(text);
      decorate();
  }

  public NumberButton(Action action) {
      super();
      decorate();
  }

  public NumberButton(Icon icon) {
      super(icon);
      decorate();
  }

  public NumberButton(String text, Icon icon) {
      super(text, icon);
      decorate();
  }

  protected void decorate() {
       setBorderPainted(true);
       setOpaque(false);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
      int width = getWidth();
      int height = getHeight();

      Graphics2D graphics = (Graphics2D) g;

      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      if (getModel().isArmed()) {
          graphics.setColor(getBackground().darker());
      } else if (getModel().isRollover()) {
          graphics.setColor(getBackground().brighter());
      } else {
          graphics.setColor(getBackground());
      }

      graphics.fillRoundRect(0, 0, width, height, 0, 0);

      FontMetrics fontMetrics = graphics.getFontMetrics();
      Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

      int textX = (width - stringBounds.width) / 2;
      int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

      graphics.setColor(getForeground());
      graphics.setFont(getFont());
      graphics.drawString(getText(), textX, textY);
      graphics.dispose();
      

      super.paintComponent(g);
  }
}
