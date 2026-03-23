package game;

public class Main {

	public static void main(String[] args) {
		StageManager stage = new StageManager();
        while (!stage.checkEnd()) {
            stage.playTurn();
        }
        System.out.println("게임 종료!");
    }
}


