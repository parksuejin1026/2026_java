package Study;

import java.util.*;

public class Week2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("로또 번호 생성기");
		Random r = new Random();
		
		int[] lottoNum = new int[6]; // 로또 번호를 저장할 배열 생성
		
		int count = 0;
		
		while(count < 6) {
			int randomNum = r.nextInt(45)+1;
			
			boolean isDuplicate = false;
			for (int i = 0 ; i < count ; i++) {
				if (lottoNum[i] == randomNum) {
					isDuplicate = true;
					break;
				}
			}
			
			if (!isDuplicate) {
				lottoNum[count] = randomNum;
				count++;
			}
		}
		
		Arrays.sort(lottoNum);
		
		System.out.println("이번 주 로또 예상 번호 : " + Arrays.toString(lottoNum));
		
	
			
			
		
	}

}
