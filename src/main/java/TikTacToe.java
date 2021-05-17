import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class TikTacToe extends JFrame implements Runnable {

    private final static ImageIcon iconH = new ImageIcon("-.png");
    private final static ImageIcon iconX = new ImageIcon("x.png");
    private final static ImageIcon iconO = new ImageIcon("o.png");

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
        setSize(new Dimension(1280, 720));

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

    public static void end(String str) throws IOException {
        JOptionPane.showMessageDialog(null, str + " победили! ");
        for (JButton jbutton : jButtons) {
            jbutton.setEnabled(false);
        }
        MyClient.client.close();
    }

    public static void finish() throws IOException {
        if (elements.size() >= 5) {
            for (int i = 0; i < elements.size(); i++) {
                for (int j = 0; j < elements.size(); j++) {
                    for (Element element : elements) {
                        if (elements.get(i).getNumber() == 0) {
                            if (elements.get(j).getNumber() == 3) {
                                if (element.getNumber() == 6) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                            if (elements.get(j).getNumber() == 1) {
                                if (element.getNumber() == 2) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                            if (elements.get(j).getNumber() == 4) {
                                if (element.getNumber() == 8) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                        if (elements.get(i).getNumber() == 1) {
                            if (elements.get(j).getNumber() == 4) {
                                if (element.getNumber() == 7) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                        if (elements.get(i).getNumber() == 2) {
                            if (elements.get(j).getNumber() == 5) {
                                if (element.getNumber() == 8) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                        if (elements.get(i).getNumber() == 3) {
                            if (elements.get(j).getNumber() == 4) {
                                if (element.getNumber() == 5) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                        if (elements.get(i).getNumber() == 6) {
                            if (elements.get(j).getNumber() == 7) {
                                if (element.getNumber() == 8) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                        if (elements.get(i).getNumber() == 2) {
                            if (elements.get(j).getNumber() == 4) {
                                if (element.getNumber() == 6) {
                                    if (elements.get(i).getValue() == 'X' && elements.get(j).getValue() == 'X' && element.getValue() == 'X') {
                                        end("Крестики");
                                    }
                                    if (elements.get(i).getValue() == 'O' && elements.get(j).getValue() == 'O' && element.getValue() == 'O') {
                                        end("Нолики");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (elements.size() == 9) {
            JOptionPane.showMessageDialog(null, "Победила Дружба! ");
        }
    }

    public static void checkValue() {
        jButtons.forEach(jButton -> jButton.setEnabled(true));
        for (int i = 0; i != elements.size(); i++) {
            jButtons.get(elements.get(i).getNumber()).setEnabled(false);
        }
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
