package Zombie;

import java.util.Random;

public class Hero {
    String name;
    int curPos;
    int lifePoint;
    private Random r = new Random();

    public Hero(String name, int curPos, int lifePoint) {
        this.name = name;
        this.curPos = curPos;
        this.lifePoint = lifePoint;
    }

    public void jump() {
        int num = r.nextInt(3) + 1;
        curPos += num;
        System.out.println(name + "이(가) " + num + "만큼 점프! 현재 위치: " + curPos);
    }

    public void leftMove() {
        curPos--;
        System.out.println(name + "이(가) 왼쪽 이동. 현재 위치: " + curPos);
    }

    public void rightMove() {
        curPos++;
        System.out.println(name + "이(가) 오른쪽 이동. 현재 위치: " + curPos);
    }
}