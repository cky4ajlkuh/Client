import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class TikTacToe extends JFrame implements Runnable {

    private final static ImageIcon iconH = new ImageIcon("-.png");
    private final static ImageIcon iconX = new ImageIcon("x.png");
    private final static ImageIcon iconO = new ImageIcon("o.png");

    public static final ArrayList<Sosiska> sosiski = new ArrayList<>();
    public static final ArrayList<JButton> jButtons = new ArrayList<>();
    public static final ArrayList<Character> numbers = new ArrayList<>();
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
                if (jButtons.get(0).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(0).setIcon(iconO);
                            MyClient.send(string(0, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(0).setIcon(iconX);
                            MyClient.send(string(0, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });

        jButtons.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(1).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(1).setIcon(iconO);
                            MyClient.send(string(1, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(1).setIcon(iconX);
                            MyClient.send(string(1, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });

        jButtons.get(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(2).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(2).setIcon(iconO);
                            MyClient.send(string(2, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(2).setIcon(iconX);
                            MyClient.send(string(2, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(3).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(3).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(3).setIcon(iconO);
                            MyClient.send(string(3, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(3).setIcon(iconX);
                            MyClient.send(string(3, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(4).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(4).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(4).setIcon(iconO);
                            MyClient.send(string(4, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(4).setIcon(iconX);
                            MyClient.send(string(4, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(5).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(5).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(5).setIcon(iconO);
                            MyClient.send(string(5, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(5).setIcon(iconX);
                            MyClient.send(string(5, 'O'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(6).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(6).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(6).setIcon(iconO);
                            MyClient.send(string(6, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(6).setIcon(iconX);
                            MyClient.send(string(6, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
        jButtons.get(7).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(7).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(7).setIcon(iconO);
                            MyClient.send(string(7, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(7).setIcon(iconX);
                            MyClient.send(string(7, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });

        jButtons.get(8).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jButtons.get(8).isEnabled()) {
                    try {
                        if (MyClient.rand == 0) {
                            jButtons.get(8).setIcon(iconO);
                            MyClient.send(string(8, 'O'));
                        } else if (MyClient.rand == 1) {
                            jButtons.get(8).setIcon(iconX);
                            MyClient.send(string(8, 'X'));
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                jButtons.forEach(jButton -> jButton.setEnabled(false));
            }
        });
    }
/*
    public static void finish() {
        if (numbers.size() >= 5) {
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    for (int k = 0; k < numbers.size(); k++) {
                        if (numbers.get(i) == '0') {
                            if (numbers.get(j) == '1') {
                                if (numbers.get(k) == '2') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                            if (numbers.get(j) == '3') {
                                if (numbers.get(k) == '6') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '1') {
                            if (numbers.get(j) == '4') {
                                if (numbers.get(k) == '7') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '2') {
                            if (numbers.get(j) == '5') {
                                if (numbers.get(k) == '8') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '3') {
                            if (numbers.get(j) == '4') {
                                if (numbers.get(k) == '5') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '6') {
                            if (numbers.get(j) == '7') {
                                if (numbers.get(k) == '8') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '0') {
                            if (numbers.get(j) == '4') {
                                if (numbers.get(k) == '8') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.get(i) == '2') {
                            if (numbers.get(j) == '4') {
                                if (numbers.get(k) == '6') {
                                    if (numbers.get(i + 1) == 'X' && numbers.get(j + 1) == 'X' && numbers.get(k + 1) == 'X') {
                                        JOptionPane.showMessageDialog(null, "Крестики победили! ");
                                    }
                                    if (numbers.get(i + 1) == 'O' && numbers.get(j + 1) == 'O' && numbers.get(k + 1) == 'O') {
                                        JOptionPane.showMessageDialog(null, "Нолики победили! ");
                                    }
                                }
                            }
                        }
                        if (numbers.size() == 18) {
                            JOptionPane.showMessageDialog(null, "Ничья! ");
                            break;

                        }
                    }
                }
            }
        }
    }

    public static void checkValue() {
        int j = Character.getNumericValue(MyClient.array[0]);
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
*/

    private String string(int number, char value) throws IOException {
        sosiski.add(new Sosiska(number, value));
        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, new Sosiska(number, value));
        return stringWriter.toString();
    }

    @Override
    public void run() {
    }
}
