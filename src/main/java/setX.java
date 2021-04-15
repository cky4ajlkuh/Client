import javax.swing.*;
import java.awt.*;

public class setX extends JFrame{

        public setX() {
            drawQR();
            setVisible(false);
            setSize(526, 556);
            setResizable(false);
            setLocationRelativeTo(null);
        }

        private void drawQR() {
            Image image = new ImageIcon("DRYEawRU8aA.jpg").getImage();
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.drawImage(image, 0, 0, null);
                }
            });
        }
    }
