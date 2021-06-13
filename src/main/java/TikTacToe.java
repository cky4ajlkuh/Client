import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class TikTacToe extends JFrame implements Runnable {

    private final static ImageIcon iconH = new ImageIcon("-.png");
    private final static ImageIcon iconX = new ImageIcon("x.png");
    private final static ImageIcon iconO = new ImageIcon("o.png");
    private final static JButton replay = new JButton("Еще раз!");

    public static final LinkedList<Element> elements = new LinkedList<>();
    public static final ArrayList<JButton> jButtons = new ArrayList<>();

    public TikTacToe(String s) {
        super(s);
        Image image = new ImageIcon("фон.png").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });

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
                .addComponent(replay)
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
                .addComponent(replay)
        );
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(1280, 720));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyClient.send("close");
                try {
                    MyClient.client.close();
                    MyClient.reader.close();
                    MyClient.writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        replay.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyClient.send("replay");
            }
        });

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

    public static void createJButtons() {
        IntStream.range(0, 9).mapToObj(i -> new JButton(" ", iconH)).forEach(jButtons::add);
    }

    public static void startGame() {
        if (MyClient.rand == 0) {
            JOptionPane.showMessageDialog(null, "Вы играете за Нолики! ");
            for (int i = 0; i < 9; i++) {
                jButtons.get(i).setEnabled(false);
            }
        }
        if (MyClient.rand == 1) {
            JOptionPane.showMessageDialog(null, "Вы играете за Крестики! ");
        }
    }

    public static void setIconH() {
        elements.clear();
        IntStream.range(0, 9).forEach(i -> jButtons.get(i).setIcon(iconH));
        jButtons.forEach(jButton -> jButton.setEnabled(true));
    }

    public static void end(String str) throws IOException {
        JOptionPane.showMessageDialog(null, str + " победили! ");
        jButtons.forEach(jbutton -> jbutton.setEnabled(false));
    }

    public static void checkValue() {
        jButtons.forEach(jButton -> jButton.setEnabled(true));
        IntStream.range(0, elements.size()).forEach(i -> jButtons.get(elements.get(i).getNumber()).setEnabled(false));
        if (MyClient.rand == 1) {
            jButtons.get(elements.getLast().getNumber()).setIcon(iconO);
        }
        if (MyClient.rand == 0) {
            jButtons.get(elements.getLast().getNumber()).setIcon(iconX);
        }
    }

    private String string(int number, char value) throws IOException {
        elements.add(new Element(number, value));
        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, new Element(number, value));
        return stringWriter.toString();
    }

    @Override
    public void run() {
    }
}