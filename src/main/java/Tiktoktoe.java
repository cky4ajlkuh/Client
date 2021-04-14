import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tiktoktoe extends JFrame {

    private final static char x = 'X';
    private final static char o = 'O';
    private final static char zero = 'H';
    private final static int size = 3;
    private final static char[][] field = new char[size][size];


    JMenu menu = new JMenu("Tik-Tok toe");
    JMenuBar bar = new JMenuBar();
    JButton start = new JButton("Start!");
    JButton field11 = new JButton(" ");
    JButton field12 = new JButton(" ");
    JButton field13 = new JButton(" ");
    JButton field21 = new JButton(" ");
    JButton field22 = new JButton(" ");
    JButton field23 = new JButton(" ");
    JButton field31 = new JButton(" ");
    JButton field32 = new JButton(" ");
    JButton field33 = new JButton(" ");

    public Tiktoktoe(String s) {
        super(s);
        initialization();
        Sout(field);
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

        field11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(0,0);
                field11.setText("X");
                setX(0,0, 'X');
                Sout(field);
                field11.setEnabled(false);
            }
        });
        field21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1,0);
                field21.setText("X");
                setX(1,0, 'X');
                Sout(field);
                field21.setEnabled(false);
            }
        });
        field31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2,0);
                field31.setText("X");
                setX(2,0, 'X');
                Sout(field);
                field31.setEnabled(false);
            }
        });
        field12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(0,1);
                field12.setText("X");
                setX(0,1, 'X');
                Sout(field);
                field12.setEnabled(false);
            }
        });
        field22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1,1);
                field22.setText("X");
                setX(1,1, 'X');
                Sout(field);
                field22.setEnabled(false);
            }
        });
        field32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2,1);
                field32.setText("X");
                setX(2,1, 'X');
                Sout(field);
                field32.setEnabled(false);
            }
        });
        field13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(0,2);
                field13.setText("X");
                setX(0,2, 'X');
                Sout(field);
                field13.setEnabled(false);
            }
        });
        field23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1,2);
                field23.setText("X");
                setX(1,2, 'X');
                Sout(field);
                field23.setEnabled(false);
            }
        });
        field33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2,2);
                field33.setText("X");
                setX(2,2, 'X');
                Sout(field);
                field33.setEnabled(false);
            }
        });
    }

    public static void Sout(char[][] field) {
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static void initialization() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = zero;
            }
        }
    }

    private void setX(int x, int y, char value) {
        checkBorders(x, y);
        field[x][y] = value;
    }

    private boolean checkBorders(int x, int y) {
        if (x < size || y < size) {
            if (x > 0 || y > 0) {
                return true;
            }
        }
        return false;
    }

    public void invalidValue (int x, int y) {
        if (field[x][y] == o | field[x][y] == Tiktoktoe.x) {
            try {
                throw new CheckField();
            } catch (CheckField field){
                JOptionPane.showMessageDialog(this, ":c");
                field.printStackTrace();
            }
        }
    }

}
