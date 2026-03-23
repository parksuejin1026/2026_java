package game;

import java.util.ArrayList;
public class StageManager {
	private Hero hero;
	private ArrayList<Zombie> zombies = new ArrayList<>();
	
	public StageManager() {
		hero = new Hero("민주", 100, 1, 10);
		zombies.add(new NormalZombie("좀비 A", 5));
		zombies.add(new NormalZombie("좀비 B", 10));
	}
	
	public void playTurn() {
		hero.move();
		for (int i = 0; i < zombies.size(); i++) {
			Zombie z = zombies.get(i);
			z.move();
			if (hero.getCurPos() == z.getCurPos()) {
				hero.attack(z);;
				if(!z.isAlive()) { zombies.remove(i--); continue; }
				z.attack(hero);
				}
			}
		}
	
		public boolean checkEnd() {
			return !hero.isAlive() || zombies.isEmpty() || hero.getCurPos() >= 20;	}
}
