import javax.swing.*;
import java.awt.*;

public class Tiktoktoe extends JFrame {
    JMenu menu = new JMenu("Tik-Tok toe");
    JMenuBar bar = new JMenuBar();
    JButton start = new JButton("Start!");
    JButton field11 = new JButton("11");
    JButton field12 = new JButton("12");
    JButton field13 = new JButton("13");
    JButton field21 = new JButton("21");
    JButton field22 = new JButton("22");
    JButton field23 = new JButton("23");
    JButton field31 = new JButton("31");
    JButton field32 = new JButton("32");
    JButton field33 = new JButton("33");

    public Tiktoktoe(String s) {
        super(s);
        bar.add(menu);
        setJMenuBar(bar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(field11)
                        .addComponent(field21)
                        .addComponent(field31)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(field12)
                        .addComponent(field22)
                        .addComponent(field32)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(field13)
                        .addComponent(field23)
                        .addComponent(field33)
                )
        );
        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(field11)
                        .addComponent(field21)
                        .addComponent(field31)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(field12)
                        .addComponent(field22)
                        .addComponent(field32)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(field13)
                        .addComponent(field23)
                        .addComponent(field33)
                )
        );
        setVisible(false);
        setResizable(false);
        setSize(new Dimension(1600, 600));
    }

}
