package ch05.sec07;

public class Test01 {

	public static void main(String[] args) {
		//
		int tdData[][][] = new int[3][2][3];
		int num = 1;
		
		for(int i = 0; i < tdData.length; i++) {
			for(int k = 0; k < tdData[i].length; k++) {
				for(int j = 0; j < tdData[i][k].length; j++) {
					
					System.out.print(num + "\t");
					num++;
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
