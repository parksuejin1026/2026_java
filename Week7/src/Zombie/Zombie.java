package Zombie;

import java.util.Random;

public class Zombie {
    String name;
    int curPos;
    private Random r = new Random();

    public Zombie(String name, int curPos) {
        this.name = name;
        this.curPos = curPos;
    }

    public void move() {
        int num = r.nextInt(3) - 1; // -1, 0, 1
        curPos += num;
        System.out.println(name + " 이동! 현재 위치: " + curPos);
    }
}