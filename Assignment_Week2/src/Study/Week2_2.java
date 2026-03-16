package Study;

public class Week2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("별 그리기");
		int count = 0;
		
		for (int i = 0 ; i < 5 ; i++) { // 5번 반복해서 그림 그리는 for 문
			for (int j = 0 ; j < 5 ; j++) { // 별 그리는 for문
				if (j > count) { // 
					System.out.print(" ");
				} else  {
					System.out.print("*");
				}
				
			}
			System.out.println("");
			count++;
		}
		
		int count2 = 0;
		
		System.out.println("별 그리기 2");
		
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 5 ; j > 0 ; j--) {
				if ( j > count2) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			count2++;
			System.out.println("");
		}
		
	}

}
