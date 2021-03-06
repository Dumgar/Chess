package game;
import game.Exeptions.MoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    Coord coordFrom;
    Coord coordTo;
    Player player1;
    Player player2;
    Board board;
    boolean player1Check = false;
    boolean player2Check = false;


	public Game(){
        this.board = new Board();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String playerName;
        try {
            System.out.println("Введите имя первого игрока, он играет белыми:");
            playerName = reader.readLine();
            player1 = new Player(playerName, true);
            System.out.println("Введите имя второго игрока, он играет черными:");
            playerName = reader.readLine();
            player2 = new Player(playerName, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


	public void startGame(Player player1, Player player2) {
        while (true) {
            getStep(player1);
            if (player1.check = board.checkCheck(player1.color)) {
                if (board.checkMate(player1.color)) {
                    player1.mate = true;
                    break;
                }
            }
            getStep(player2);
            if (player2.check = board.checkCheck(player2.color)) {
                if (board.checkMate(player2.color)) {
                    player2.mate = true;
                    break;
                }
            }
        }

        if (player1.mate) System.out.println("Победил игрок " + player2.name);
        if (player2.mate) System.out.println("Победил игрок " + player1.name);

	}

    public void getStep(Player player) {
        Coord from;
        Coord to;
        System.out.println("Ходит игрок " + player.name + ":");
        String step = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            step = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (step.length() == 4) {
            from = makeCoord(step, player)[0];
            to = makeCoord(step, player)[1];
            if (colorCheck(player, from)) {
                try {
                    Board nextStepBoard = board;
                    nextStepBoard.move(from, to);
                    if (nextStepBoard.checkCheck(player.color)){
                        System.out.println("Такой ход невозможен. Вам шах.");
                        getStep(player);
                    }
                    board = nextStepBoard;
                } catch (MoveException e) {
                    e.printStackTrace();
                    getStep(player);
                }
            }else getStep(player);
        } else if (step.equals("surrender")) {
            System.out.println("Вы признали своё поражение!");
            System.exit(0);
        } else {
            System.out.println("Нет такой команды. Попробуйте еще раз.");
            getStep(player);
        }
    }

    private Coord[] makeCoord(String temp, Player player) {
        Coord[] coords = new Coord[2];
        temp = temp.toLowerCase();
        if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'i' && temp.charAt(1) >= '1' && temp.charAt(1) <= '8') {
            coordFrom = new Coord(temp.charAt(0), Character.getNumericValue(temp.charAt(1)));
            coords[0] = coordFrom;
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep(player);
        }
        if (temp.charAt(2) >= 'a' && temp.charAt(2) <= 'i' && temp.charAt(3) >= '1' && temp.charAt(3) <= '8') {
            coordTo = new Coord(temp.charAt(2), Character.getNumericValue(temp.charAt(3)));
            coords[1] = coordTo;
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep(player);
        }
        return coords;
    }

    private boolean colorCheck(Player player, Coord current) {
        if (board.getCell(current) == null) {
            System.out.println("Клетка пустая");
            getStep(player);
            return false;
        }
        if (player.color != board.getCell(current).getColor()) {
            System.out.println("Эта фигура не вашего цвета! Попробуйте еще раз.");
            getStep(player);
            return false;
        }
        return true;
    }


//	TODO Непонятно пока как определять победителя, создавать ли класс игрок или как-то флагами это все делать.

}
