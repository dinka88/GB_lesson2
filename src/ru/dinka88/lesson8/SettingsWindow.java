package ru.dinka88.lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int MODE_H_VS_A = 0;
    static final int MODE_H_VS_H = 1;

    private GameWindow gameWindow;

    private final JRadioButton radioButtonHvsAi = new JRadioButton("Human vs Ai", true);
    private JRadioButton radioButtonHvsH = new JRadioButton("Human vs Human");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

    public SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Setting game");

        setLayout(new GridLayout(8,1));

        add(new JLabel(" Select game mode:"));
        add(radioButtonHvsAi);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAi);
        gameMode.add(radioButtonHvsH);

        add(new JLabel(" Select field's size:"));
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);

        add(sliderFieldSize);
        add(new JLabel(" Select dots to win:"));
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(e ->{
            sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
        });

        JButton buttonStartNewGame = new JButton("StartNewGame");
        buttonStartNewGame.setBackground(Color.cyan);
        add(buttonStartNewGame);

        buttonStartNewGame.addActionListener(e ->{
            setVisible(false);

            int mode;
            if(radioButtonHvsAi.isSelected()){
                mode = MODE_H_VS_A;
            } else {
                mode = MODE_H_VS_H;
            }

            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(mode,fieldSize,fieldSize,dotsToWin);
        });

        setVisible(false);
    }

}
