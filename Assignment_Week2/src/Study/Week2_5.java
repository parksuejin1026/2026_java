package Study;

public class Week2_5 {

	public static void main(String[] args) {
		int[] arr = new int[2];
		int count = 0;
		
		for (int i = 0 ; i <= 5 ; i++) {
			
			if(count == arr.length) {
				System.out.println("[알림] 공간 부족! 현재 크기 : " + arr.length); 
				
				// 새로운 배열 생성
				int[] newArr = new int[arr.length * 2];
				
				for (int j = 0 ; j < arr.length ; j++) {
					newArr[j] = arr[j];
				}
				
				arr = newArr;
				System.out.println("[알림] 이사 완료! 늘어난 크기 : " + arr.length) ;
				
			}
				arr[count] = i * 10;
				count++ ;
	
			}
			System.out.println("최종 저장된 데이터 : ");
			for (int i = 0; i < count ; i++) {
				System.out.print(arr[i] + " ");
		}
	}

}
