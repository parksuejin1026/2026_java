package Study;

public class ArrayExam {

	public static void main(String[] args) {
		int[] data = new int[3];
		data[0] = 85;
		data[1] = 90;
		data[2] = 78;
		
		int[] scores = {85, 90, 78};
		int sum = 0;
		
		for (int score : scores) {
			sum += score;
		}
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (double) sum / scores.length);
	}

}
