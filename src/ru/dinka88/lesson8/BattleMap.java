package ru.dinka88.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!Logic.gameFinished){
            Logic.setHumanCoords(cellX, cellY);
        }


        System.out.printf("cellX: %d  cellY: %d \n", cellX, cellY);

        repaint();
        if (Logic.gameWinUser){
            showText("Вы выйграли!");
        }else if (Logic.gameWinAi){
            showText("Вы проиграли!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j]==Logic.DOT_X){
                    drawX(g, j, i);
                }else if (Logic.map[i][j]==Logic.DOT_O){
                    drawO(g, j, i);
                }
            }
        }

    }
    // Дорисовка Х
    private void drawX(Graphics g, int cellX, int cellY) {
//        g = (Graphics2D)g;

        g.setColor(Color.red);
        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine(cellX * cellWidth, (cellY+1) * cellHeight,
                (cellX + 1) * cellWidth, cellY  * cellHeight);
    }
    // Прорисовка О
    private void drawO(Graphics g, int cellX, int cellY) {
//        g = (Graphics2D)g;

        g.setColor(Color.red);
        g.drawOval(cellX * cellWidth,cellY * cellHeight,cellWidth,cellHeight);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();
    }
    // Запуск программы снова
    public void showText(String total){
        Object[] possibilities = {"STOP", "New Game"};
        Object result = JOptionPane.showInputDialog(gameWindow, "Продолжить?",
                total, JOptionPane.PLAIN_MESSAGE, null, possibilities, "STOP");
        if (result== "STOP"){
            System.exit(0);
        }else {
            gameWindow.getSettingsWindow().setVisible(true);
            Logic.clear();
        }



    }
}

