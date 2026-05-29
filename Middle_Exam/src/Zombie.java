import java.util.Random;

public class Zombie extends Thread {
    private int pos;
    private String name;
    private boolean running = true;
    private Random r = new Random();
    private Human player;
    
    public Zombie(int pos, String name, Human player) {
        this.pos = pos;
        this.name = name;
        this.player = player;
    }
    
    public int getPos() { return pos; }
    public void stopZombie() { this.running = false; }
    
    @Override
    public void run() {
        while (running) {
            try {
                int sleepTime = r.nextInt(1001) + 1000; 
                Thread.sleep(sleepTime); 
                
                int move = r.nextBoolean() ? 1 : -1; 
                pos += move; 
                if (pos < 1) pos = 1;
                if (pos > 20) pos = 20;
                
                if (this.pos == player.getPos()) {
                    System.out.println("\n☠ " + name + "와(과) 부딪혔습니다! GAMEOVER!");
                    ZombieGame.printFinalScore(); 
                    System.exit(0); 
                }
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}