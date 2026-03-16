package Study;

public class Week2_4 {

	public static void main(String[] args) {
		// 배열 90도 회전 시키기
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int n = matrix.length; // 열 길이
		
		// 새로운 배열을 담을 배열 생성
		int[][] rotated = new int[n][n];
		
		// 90도 회전을 위한 for 문
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				// 핵심 공식 : 원본의 (i, j)가 회전 후 (j, n-1-i)로 이동 ex) (0,0)이라면 0,3-1-0 = (0,2)
				rotated[j][n - 1 - i] = matrix[i][j];
			}
		}
		
		System.out.println("--- 90도 회전 결과 ---");
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				System.out.print
				(rotated[i][j]  + " ");
			}
			System.out.println(
					);
			
		}
		
	}

}
