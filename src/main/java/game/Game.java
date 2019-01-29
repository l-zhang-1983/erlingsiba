package game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class Game {
	
	public static void main(String[] args) {
		int size = Game.DEFAULT_SIZE;
		if (args.length > 1 && StringUtils.isNumeric(args[0])) {
			size = Integer.valueOf(args[0]);
			if (size > Game.MAX_SIZE) {
				size = Game.DEFAULT_SIZE;
			}
		}
		Game game = new Game(size);
		
		game.placeDigit(size);
		game.output(size);
	}
	
	public Game(int size) {
		this.matrix = new int[size][size];
	}
	
	private void placeDigit(int size) {
		int count = 0;
		int i, j;
		while (count < 2) {
			i = random.nextInt(size);
			j = random.nextInt(size);
			if (matrix[i][j] == 0) {
				matrix[i][j] = 2;
				count++;
			}
		}
	}
	
	private void output(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println(matrix[i][size - 1]);
		}
	}
	
	private int[][] matrix;
	private static final int DEFAULT_SIZE = 4;
	private static final int MAX_SIZE = 10;
	
	private Random random = new Random(System.currentTimeMillis());
}
