import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TikTacToe extends JFrame implements Runnable {

    private final static char x = 'X';
    private final static char o = 'O';
    private final static char zero = 'H';
    private final static int size = 3;
    private final static char[][] field = new char[size][size];
    private final static ImageIcon iconH = new ImageIcon("Screenshot 2021-04-15 222334.jpg");
    private final static ImageIcon iconX = new ImageIcon("Screenshot 2021-04-15 222216.jpg");
    private final static ImageIcon iconO = new ImageIcon("Screenshot 2021-04-15 222237.jpg");

    JMenu menu = new JMenu("Tik-Tak toe");
    JMenuBar bar = new JMenuBar();
    JButton start = new JButton("Start!");
    JButton field11 = new JButton(" ", iconH);
    JButton field12 = new JButton(" ", iconH);
    JButton field13 = new JButton(" ", iconH);
    JButton field21 = new JButton(" ", iconH);
    JButton field22 = new JButton(" ", iconH);
    JButton field23 = new JButton(" ", iconH);
    JButton field31 = new JButton(" ", iconH);
    JButton field32 = new JButton(" ", iconH);
    JButton field33 = new JButton(" ", iconH);

    public TikTacToe(String s) {
        super(s);
        Image image = new ImageIcon("DRYEawRU8aA.jpg").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });
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
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(1400, 1400));

        field11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(0, 0);
                    field11.setIcon(iconO);
                    setX(0, 0, 'O');
                    Sout(field);
                    field11.setEnabled(false);
                    MyClient.send(new char[]{'0', '0', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(0, 0);
                    field11.setIcon(iconX);
                    setX(0, 0, 'X');
                    Sout(field);
                    field11.setEnabled(false);
                    MyClient.send(new char[]{'0', '0', 'X'});
                }
            }
        });
        field21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(1, 0);
                    field21.setIcon(iconO);
                    setX(1, 0, 'O');
                    Sout(field);
                    field21.setEnabled(false);
                    MyClient.send(new char[]{'1', '0', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(1, 0);
                    field21.setIcon(iconX);
                    setX(1, 0, 'X');
                    Sout(field);
                    field21.setEnabled(false);
                    MyClient.send(new char[]{'1', '0', 'X'});
                }
            }
        });
        field31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(2, 0);
                    field31.setIcon(iconO);
                    setX(2, 0, 'O');
                    Sout(field);
                    field31.setEnabled(false);
                    MyClient.send(new char[]{'2', '0', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(2, 0);
                    field31.setIcon(iconX);
                    setX(2, 0, 'X');
                    Sout(field);
                    field31.setEnabled(false);
                    MyClient.send(new char[]{'2', '0', 'X'});
                }
            }
        });
        field12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(0, 1);
                    field12.setIcon(iconO);
                    setX(0, 1, 'O');
                    Sout(field);
                    field12.setEnabled(false);
                    MyClient.send(new char[]{'0', '1', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(0, 1);
                    field12.setIcon(iconX);
                    setX(0, 1, 'X');
                    Sout(field);
                    field12.setEnabled(false);
                    MyClient.send(new char[]{'0', '1', 'X'});
                }
            }
        });
        field22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(1, 1);
                    field22.setIcon(iconO);
                    setX(1, 1, 'O');
                    Sout(field);
                    field22.setEnabled(false);
                    MyClient.send(new char[]{'1', '1', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(1, 1);
                    field22.setIcon(iconX);
                    setX(1, 1, 'X');
                    Sout(field);
                    field22.setEnabled(false);
                    MyClient.send(new char[]{'1', '1', 'X'});
                }
            }
        });
        field32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(2, 1);
                    field32.setIcon(iconO);
                    setX(2, 1, 'O');
                    Sout(field);
                    field32.setEnabled(false);
                    MyClient.send(new char[]{'2', '1', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(2, 1);
                    field32.setIcon(iconX);
                    setX(2, 1, 'X');
                    Sout(field);
                    field32.setEnabled(false);
                    MyClient.send(new char[]{'2', '1', 'X'});
                }
            }
        });
        field13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(0, 2);
                    field13.setIcon(iconO);
                    setX(0, 2, 'O');
                    Sout(field);
                    field13.setEnabled(false);
                    MyClient.send(new char[]{'0', '2', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(0, 2);
                    field13.setIcon(iconX);
                    setX(0, 2, 'X');
                    Sout(field);
                    field13.setEnabled(false);
                    MyClient.send(new char[]{'0', '2', 'X'});
                }
            }
        });
        field23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(1, 2);
                    field23.setIcon(iconO);
                    setX(1, 2, 'O');
                    Sout(field);
                    field23.setEnabled(false);
                    MyClient.send(new char[]{'1', '2', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(1, 2);
                    field23.setIcon(iconX);
                    setX(1, 2, 'X');
                    Sout(field);
                    field23.setEnabled(false);
                    MyClient.send(new char[]{'1', '2', 'X'});
                }
            }
        });
        field33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    invalidValue(2, 2);
                    field33.setIcon(iconO);
                    setX(2, 2, 'O');
                    Sout(field);
                    field33.setEnabled(false);
                    MyClient.send(new char[]{'2', '2', 'O'});
                } else if (MyClient.rand == 1) {
                    invalidValue(2, 2);
                    field33.setIcon(iconX);
                    setX(2, 2, 'X');
                    Sout(field);
                    field33.setEnabled(false);
                    MyClient.send(new char[]{'2', '2', 'X'});
                }
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

    public void setX(int x, int y, char value) {
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
        if (field[x][y] == o | field[x][y] == TikTacToe.x) {
            try {
                throw new CheckField();
            } catch (CheckField field) {
                JOptionPane.showMessageDialog(this, ":c");
                field.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }
}