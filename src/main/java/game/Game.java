package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    Coord coordFrom;
    Coord coordTo;
    Player player1;
    Player player2;

	public Game(){
        Board board = new Board();
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
        while (!player1.mate && !player2.mate) {
            getStep(player1);
            getStep(player2);
        }

        if (player1.mate) System.out.println("Победил игрок " + player2.name);
        if (player2.mate) System.out.println("Победил игрок " + player1.name);

	}

    public void getStep(Player player) {
        String step = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            step = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (step.length() == 4) {
            makeCoord(step, player);
        } else if (step.equals("surrender")) {
            System.out.println("Вы признали своё поражение!");
            player.mate = true;
        } else {
            System.out.println("Нет такой команды. Попробуйте еще раз.");
            getStep(player);
        }
    }

    private void makeCoord(String temp, Player player) {
        temp = temp.toLowerCase();
        if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'i' && temp.charAt(1) >= '1' && temp.charAt(1) <= '8') {
            coordFrom = new Coord(temp.charAt(0), Character.getNumericValue(temp.charAt(1)));
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep(player);
        }
        if (temp.charAt(2) >= 'a' && temp.charAt(2) <= 'i' && temp.charAt(3) >= '1' && temp.charAt(3) <= '8') {
            coordTo = new Coord(temp.charAt(2), Character.getNumericValue(temp.charAt(3)));
        } else {
            System.out.println("Неверный формат координаты. Попробуйте еще раз.");
            getStep(player);
        }
    }

//	TODO Непонятно пока как определять победителя, создавать ли класс игрок или как-то флагами это все делать.

}
