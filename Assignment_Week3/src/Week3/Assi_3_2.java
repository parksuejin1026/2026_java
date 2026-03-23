package Week3;

import java.util.*;
public class Assi_3_2 {
	
	public static void main(String[] args) {
		/*
		 *  1) 5 * 5 배열의 맵을 만들고 그 맵을 길과 벽으로 구성하세요.
  			2) 사용자로부터 상하좌우를 입력 받아 이동할 수 있도록 하세요.
  			3) 내 캐릭터는 길로만 움직일 수 있으며 맵 밖으로 나가거나 길 밖으로 나갈 수 없도록 하세요. 
      		("맵 밖으로 나갈 수 없습니다", "벽이 있어서 이동할 수 없습니다.")
  			4) 마지막 목적지 위치 (4,4)에 도착하면 끝나도록 하세요.
  			5) 사용자가 입력한 횟수를 세어 몇 번 만에 목적지에 도착하는지 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		int map [][] = { { 0, 0, 0, 0, 1}, // 0 
						 {1, 1, 1, 0, 1}, // 1
						 {1, 1, 1, 0, 1}, // 2
						 {1, 1, 1, 0, 1}, // 3
						 {1, 1, 1, 0, 2} }; // 4
		int x_max = 4, x_min = 0;
		int y_max = 4, y_min = 0;
		
		int x = 0, y = 0; // 주인공의 위치를 가지는 변수
		// 입력을 받아서 상하좌우 (1, 2, 3, 4)
		while(true) {
		System.out.println("이동하고 싶은 위치를 입력해주세요 상(1) 하(2) 좌(3) 우(4) : ");
		int input = sc.nextInt();
	
		if (input == 1) { // 상
			y--; // 배열 기준에선 행의 값이 감소하는 게 상승하는 거
			if (y < y_min) {
				y++;
				System.out.println("5X5 미로에서 벗어날 수 없습니다. 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				continue;
			}
			if (map[y][x] == 1) { // y는 행, x는 열
				y++;
				System.out.println("벽에 막혔습니다! 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				continue;
			}
			System.out.println("성공적으로 이동하였습니다. 현재 위치 ["+y+"]["+x+"]");
		}
		else if (input == 2) {
			y++; // 배열 기준에선 행의 값이 증가하는 게 내려가는 거
			if (y > y_max) {
				y--;
				System.out.println("5X5 미로에서 벗어날 수 없습니다. 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				
				continue;
			}
			if (map[y][x] == 1) { // y는 행, x는 열
				y--;
				System.out.println("벽에 막혔습니다! 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				
				continue;
			}
			System.out.println("성공적으로 이동하였습니다. 현재 위치 ["+y+"]["+x+"]");
		}
		else if (input == 3) {
			x--; // 배열 기준에선 열의 값이 감소하는 게 왼쪽으로 이동하는 거
			if (x < x_min) {
				x++;
				System.out.println("5X5 미로에서 벗어날 수 없습니다. 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				
				continue;
			}
			if (map[y][x] == 1) { // y는 행, x는 열
				x++;
				System.out.println("벽에 막혔습니다! 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]" );
				
				continue;
			}
			System.out.println("성공적으로 이동하였습니다. 현재 위치 ["+y+"]["+x+"]");
		}
		else if (input == 4) {
			x++; // 배열 기준에선 행의 값이 감소하는 게 상승하는 거
			if (x > x_max) {
				x--;
				System.out.println("5X5 미로에서 벗어날 수 없습니다. 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x  +"]");
				
				continue;
			}
			if (map[y][x] == 1) { // y는 행, x는 열
				x--;
				System.out.println("벽에 막혔습니다! 이전으로 돌아갑니다. 현재 위치[" + y + "][" + x + "]");
				continue;
			}
			System.out.println("성공적으로 이동하였습니다. 현재 위치 ["+y+"]["+x+"]");
		}
		
		if (map[y][x] == 2) {
			System.out.println("축하드립니다! 탈출에 성공하셨습니다.");
			break;
		}
		}
		System.out.println("지도를 공개하겠습니다!!");
		for(int i = 0; i < map.length ; i++) {
			for (int j = 0 ; j < map[i].length ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
	}


