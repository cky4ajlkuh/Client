import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TikTakToe extends JFrame {

    private final static char x = 'X';
    private final static char o = 'O';
    private final static char zero = 'H';
    private final static int size = 3;
    private final static char[][] field = new char[size][size];
    private final static ImageIcon iconH = new ImageIcon("Screenshot 2021-04-15 222334.jpg");
    private final static ImageIcon iconX = new ImageIcon("Screenshot 2021-04-15 222216.jpg");
    private final static ImageIcon iconO = new ImageIcon("Screenshot 2021-04-15 222237.jpg");
    private final static JLabel labelH = new JLabel(iconH);
    private final static JLabel labelX = new JLabel(iconX);
    private final static JLabel labelO = new JLabel(iconO);

    JMenu menu = new JMenu("Tik-Tak toe");
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
    JPanel panel00 = new JPanel();
    JPanel panel01 = new JPanel();
    JPanel panel02 = new JPanel();
    JPanel panel10 = new JPanel();
    JPanel panel11 = new JPanel();
    JPanel panel12 = new JPanel();
    JPanel panel20 = new JPanel();
    JPanel panel21 = new JPanel();
    JPanel panel22 = new JPanel();

    public TikTakToe(String s) {
        super(s);
        Image image = new ImageIcon("DRYEawRU8aA.jpg").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });
        initPanels();
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
                        .addComponent(panel00)
                        .addComponent(panel10)
                        .addComponent(panel20)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(panel01)
                        .addComponent(panel11)
                        .addComponent(panel21)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(panel02)
                        .addComponent(panel12)
                        .addComponent(panel22)
                )
        );
        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panel00)
                        .addComponent(panel10)
                        .addComponent(panel20)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panel01)
                        .addComponent(panel11)
                        .addComponent(panel21)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panel02)
                        .addComponent(panel12)
                        .addComponent(panel22)
                )

        );
        setVisible(false);
        setResizable(false);
        setSize(new Dimension(1600, 1600));


        try {
            panel00.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    invalidValue(0, 0);
                    setX(0, 0, x);
                    Sout(field);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, ":c");
            e.printStackTrace();
        }
        field21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1, 0);
                field21.setText("X");
                setX(1, 0, 'X');
                Sout(field);
                field21.setEnabled(false);
            }
        });
        field31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2, 0);
                field31.setText("X");
                setX(2, 0, 'X');
                Sout(field);
                field31.setEnabled(false);
            }
        });
        field12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(0, 1);
                field12.setText("X");
                setX(0, 1, 'X');
                Sout(field);
                field12.setEnabled(false);
            }
        });
        field22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1, 1);
                field22.setText("X");
                setX(1, 1, 'X');
                Sout(field);
                field22.setEnabled(false);
            }
        });
        field32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2, 1);
                field32.setText("X");
                setX(2, 1, 'X');
                Sout(field);
                field32.setEnabled(false);
            }
        });
        field13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(0, 2);
                field13.setText("X");
                setX(0, 2, 'X');
                Sout(field);
                field13.setEnabled(false);
            }
        });
        field23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(1, 2);
                field23.setText("X");
                setX(1, 2, 'X');
                Sout(field);
                field23.setEnabled(false);
            }
        });
        field33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                invalidValue(2, 2);
                field33.setText("X");
                setX(2, 2, 'X');
                Sout(field);
                field33.setEnabled(false);
            }
        });
    }

    public void setXImage() {
        Image image = new ImageIcon("DRYEawRU8aA.jpg").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });
    }

    public void initPanels() {
        panel00.setBackground(Color.cyan);
        panel01.add(new JLabel(iconH));
        panel02.add(new JLabel(iconH));
        panel10.add(new JLabel(iconH));
        panel11.add(new JLabel(iconH));
        panel12.add(new JLabel(iconH));
        panel20.add(new JLabel(iconH));
        panel21.add(new JLabel(iconH));
        panel22.add(new JLabel(iconH));
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

    public void invalidValue(int x, int y) {
        if (field[x][y] == o | field[x][y] == TikTakToe.x) {
            try {
                throw new CheckField();
            } catch (CheckField field) {
                JOptionPane.showMessageDialog(this, ":c");
                field.printStackTrace();
            }
        }
    }
}
