package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	public Game(){
		Board board = new Board();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String playerName;
        try {
            System.out.println("Введите имя первого игрока, он играет белыми:");
            playerName = reader.readLine();
            Player player1 = new Player(playerName, true);
            System.out.println("Введите имя второго игрока, он играет черными:");
            playerName = reader.readLine();
            Player player2 = new Player(playerName, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	private Board Board;

    private boolean gameInProgress = true;

	private Result result;

    Coord coordFrom;
    Coord coordTo;

	public void startGame() {

	}

    public String getStep() {
        String step;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            step = reader.readLine().trim();
            if (step.length() == 4) {
                makeCoord(step);
            } else if (step.equals("surrender")) {
                System.out.println("Вы признали своё поражение!");
                gameInProgress = false;
            } else {
                System.out.println("Нет такой команды. Попробуйте еще раз.");
                getStep();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void makeCoord(String temp) {
        temp = temp.toLowerCase();
        if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'i' && temp.charAt(1) >= '1' && temp.charAt(1) <= '8') {
            coordFrom = new Coord(temp.charAt(0), Character.getNumericValue(temp.charAt(1)));
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep();
        }
        if (temp.charAt(2) >= 'a' && temp.charAt(2) <= 'i' && temp.charAt(3) >= '1' && temp.charAt(3) <= '8') {
            coordTo = new Coord(temp.charAt(2), Character.getNumericValue(temp.charAt(3)));
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep();
        }
    }

//	TODO Непонятно пока как определять победителя, создавать ли класс игрок или как-то флагами это все делать.

}
