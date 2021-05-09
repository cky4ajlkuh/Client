import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class TikTacToe extends JFrame implements Runnable {

    private final static ImageIcon iconH = new ImageIcon("-.png");
    private final static ImageIcon iconX = new ImageIcon("x.png");
    private final static ImageIcon iconO = new ImageIcon("o.png");

    public static final ArrayList<JButton> jButtons = new ArrayList<>();
    private static final ArrayList<JButton> block = new ArrayList<>();
    private static final ArrayList<Integer> array = new ArrayList<>();
    JMenu menu = new JMenu("Tik-Tac Toe");
    JMenuBar bar = new JMenuBar();

    public TikTacToe(String s) {
        super(s);
        Image image = new ImageIcon("DRYEawRU8aA.jpg").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });

        for (int i = 0; i < 9; i++) {
            jButtons.add(new JButton(" ", iconH));
        }

        if (MyClient.rand == 0) {
            JOptionPane.showMessageDialog(this, "Вы играете за Нолики! ");
            for (int i = 0; i < 9; i++) {
                jButtons.get(i).setEnabled(false);
            }
        }
        if (MyClient.rand == 1) {
            JOptionPane.showMessageDialog(this, "Вы играете за Крестики! ");
        }

        bar.add(menu);
        setJMenuBar(bar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(jButtons.get(0))
                        .addComponent(jButtons.get(1))
                        .addComponent(jButtons.get(2))
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(jButtons.get(3))
                        .addComponent(jButtons.get(4))
                        .addComponent(jButtons.get(5))
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(jButtons.get(6))
                        .addComponent(jButtons.get(7))
                        .addComponent(jButtons.get(8))
                )
        );
        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtons.get(0))
                        .addComponent(jButtons.get(1))
                        .addComponent(jButtons.get(2))
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtons.get(3))
                        .addComponent(jButtons.get(4))
                        .addComponent(jButtons.get(5))
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtons.get(6))
                        .addComponent(jButtons.get(7))
                        .addComponent(jButtons.get(8))
                )
        );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(1000, 1000));

        jButtons.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(0).isEnabled()) {
                        jButtons.get(0).setIcon(iconO);
                        MyClient.send(new char[]{'0', 'O'});
                        array.add(0);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(0).isEnabled()) {
                        jButtons.get(0).setIcon(iconX);
                        MyClient.send(new char[]{'0', 'X'});
                        array.add(0);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(1).isEnabled()) {
                        jButtons.get(1).setIcon(iconO);
                        MyClient.send(new char[]{'1', 'O'});
                        array.add(1);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(1).isEnabled()) {
                        jButtons.get(1).setIcon(iconX);
                        MyClient.send(new char[]{'1', 'X'});
                        array.add(1);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(2).isEnabled()) {
                        jButtons.get(2).setIcon(iconO);
                        MyClient.send(new char[]{'2', 'O'});
                        array.add(2);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(2).isEnabled()) {
                        jButtons.get(2).setIcon(iconX);
                        MyClient.send(new char[]{'2', 'X'});
                        array.add(2);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(3).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(3).isEnabled()) {
                        jButtons.get(3).setIcon(iconO);
                        MyClient.send(new char[]{'3', 'O'});
                        array.add(3);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(3).isEnabled()) {
                        jButtons.get(3).setIcon(iconX);
                        MyClient.send(new char[]{'3', 'X'});
                        array.add(3);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(4).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(4).isEnabled()) {
                        jButtons.get(4).setIcon(iconO);
                        MyClient.send(new char[]{'4', 'O'});
                        array.add(4);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(4).isEnabled()) {
                        jButtons.get(4).setIcon(iconX);
                        MyClient.send(new char[]{'4', 'X'});
                        array.add(4);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(5).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(5).isEnabled()) {
                        jButtons.get(5).setIcon(iconO);
                        MyClient.send(new char[]{'5', 'O'});
                        array.add(5);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(5).isEnabled()) {
                        jButtons.get(5).setIcon(iconX);
                        MyClient.send(new char[]{'5', 'X'});
                        array.add(5);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(6).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(6).isEnabled()) {
                        jButtons.get(6).setIcon(iconO);
                        MyClient.send(new char[]{'6', 'O'});
                        array.add(6);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(6).isEnabled()) {
                        jButtons.get(6).setIcon(iconX);
                        MyClient.send(new char[]{'6', 'X'});
                        array.add(6);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(7).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(7).isEnabled()) {
                        jButtons.get(7).setIcon(iconO);
                        MyClient.send(new char[]{'7', 'O'});
                        array.add(7);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(7).isEnabled()) {
                        jButtons.get(7).setIcon(iconX);
                        MyClient.send(new char[]{'7', 'X'});
                        array.add(7);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });

        jButtons.get(8).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MyClient.rand == 0) {
                    if (jButtons.get(8).isEnabled()) {
                        jButtons.get(8).setIcon(iconO);
                        MyClient.send(new char[]{'8', 'O'});
                        array.add(8);
                    }
                } else if (MyClient.rand == 1) {
                    if (jButtons.get(8).isEnabled()) {
                        jButtons.get(8).setIcon(iconX);
                        MyClient.send(new char[]{'8', 'X'});
                        array.add(8);
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
    }

    public static void checkValue() {
        int j = Character.getNumericValue(MyClient.str[0]);
        array.add(j);
        jButtons.forEach(jButton -> jButton.setEnabled(true));
        for (Integer integer : array) {
            jButtons.get(integer).setEnabled(false);
        }
        if (MyClient.rand == 1) {
            jButtons.get(j).setIcon(iconO);
        }
        if (MyClient.rand == 0) {
            jButtons.get(j).setIcon(iconX);
        }
    }


    @Override
    public void run() {

    }
}
