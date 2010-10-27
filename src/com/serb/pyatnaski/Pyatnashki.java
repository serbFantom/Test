package com.serb.pyatnaski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Pyatnashki extends JFrame {
    
    private static final int ROW_NUMBER=4;
    private static final int COL_NUMBER=4;
    private JPanel panel = new JPanel(new GridLayout(ROW_NUMBER, COL_NUMBER, 2, 2));
    private JMenuBar menu = null;
    private final String fileItems[] = new String []{"New", "Exit"};
    private static Random generator = new Random();
    private int[][] numbers = new int[ROW_NUMBER][COL_NUMBER];

    private static final int CELLS_NUMBER=16;

    public Pyatnashki() {
        super("Pyatnashki by SerB");
        setBounds(200, 200, 300, 300);
        setResizable(false);
        createMenu();
        setJMenuBar(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        init();
        panel.setDoubleBuffered(true);
        
        super.addKeyListener(new UserKeyListener());

        container.add(panel);
        repaintField();
    }

    public void init() {
        int[] invariants = new int[CELLS_NUMBER];

        for (int i = 0; i < ROW_NUMBER; i++) {
            for (int j = 0; j < COL_NUMBER; j++) {
                numbers[i][j] = 0;
                invariants[i*ROW_NUMBER + j] = 0;
            }
        }

        for (int i = 1; i < CELLS_NUMBER; i++) {
            int k;
            int l;
            do {
                k = generator.nextInt(100) % 4;
                l = generator.nextInt(100) % 4;
            }
            while (numbers[k][l] != 0);
            numbers[k][l] = i;
            invariants[k*ROW_NUMBER+l] = i;
        }

        boolean change = true;
        int counter = 1;
        while (change) {
            change = false;
            for (int i = 0; i < CELLS_NUMBER; i++) {
                if (invariants[i] != i) {
                    for (int j = 0; j < CELLS_NUMBER; j++) {
                        if (invariants[j] == i) {
                            int temp = invariants[i];
                            invariants[i] = invariants[j];
                            invariants[j] = temp;
                            change = true;
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        if (counter % 2 != 0) {
            int temp = numbers[0][0];
            numbers[0][0] = numbers[3][3];
            numbers[3][3] = temp;
        }
    }

    public void repaintField() {
        panel.removeAll();

        for (int i = 0; i < ROW_NUMBER; i++) {
            for (int j = 0; j < COL_NUMBER; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                button.setFocusable(false);
                panel.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);
                } else
                    button.addActionListener(new ClickListener());
            }
        }

        panel.validate();
    }

    public boolean checkWin() {
        boolean status = true;
        for (int i = 0; i < ROW_NUMBER; i++) {
            for (int j = 0; j < COL_NUMBER; j++) {
                if (i == 3 && j > 2)
                    break;
                if (numbers[i][j] != i * ROW_NUMBER + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }

    private void createMenu() {
        menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        for (int i = 0; i < fileItems.length; i++) {
            JMenuItem item = new JMenuItem(fileItems[i]);
            item.setActionCommand(fileItems[i].toLowerCase());
            item.addActionListener(new NewMenuListener());
            fileMenu.add(item);
        }
        fileMenu.insertSeparator(1);

        menu.add(fileMenu);
    }

    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("exit".equals(command)) {
                System.exit(0);
            }
            if ("new".equals(command)) {
                init();
                repaintField();
            }
        }
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setVisible(false);
            String name = button.getText();
            change(Integer.parseInt(name));
        }
    }

    //TODO:implement hidden keys sequence for hacking game
    private class UserKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped e= "+e.getKeyCode());
            //if (e.getKeyCode() == )
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyTyped e= "+e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased e= "+e.getKeyCode());
        }
    }

    public void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < ROW_NUMBER; k++) {
            for (int l = 0; l < COL_NUMBER; l++) {
                if (numbers[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0) {
            if (numbers[i - 1][j] == 0) {
                numbers[i - 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (i < 3) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
            }
        }
        if (j < 3) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
            }
        }
        repaintField();
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "YOU WIN!", "Congratulations", 1);
            init();
            repaintField();
            setVisible(false);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame app = new Pyatnashki();
        app.setVisible(true);
    }
}