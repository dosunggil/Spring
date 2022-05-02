package com.cho.app.exec;

public class ExecV2 {

	public static void main(String[] args) {

		int[] intKor = new int[5];
		int[] intEng = new int[5];
		int[] intMath = new int[5];

		int[] intSum = new int[5];

		for (int i = 0; i < intKor.length; i++) {

			int iKor = (int) (Math.random() * 100) + 1;
			int iEng = (int) (Math.random() * 100) + 1;
			int iMath = (int) (Math.random() * 100) + 1;

			int iSum = iKor + iEng + iMath;
			
			intKor[i] = iKor;
			intEng[i] = iEng;
			intMath[i] = iMath;
			intSum[i] = iSum;

		}

		for(int i = 0 ; i < intSum.length ; i ++) {
			for(int j = i+1 ; j < intSum.length ; j++) {
				if(intSum[i]>intSum[j]) {
					int _s = intSum[i];
					intSum[i]=intSum[j];
					intSum[j]=_s;
					
					int _k = intKor[i];
					intKor[i]=intKor[j];
					intKor[j]=_k;
					int _e = intEng[i];
					intEng[i]=intEng[j];
					intEng[j]=_e;
					int _m = intMath[i];
					intMath[i]=intMath[j];
					intMath[j]=_m;
				}
			}
		}
		for(int i = 0 ; i < intSum.length ; i++) {
			System.out.printf("%d\t",intKor[i]);
			System.out.printf("%d\t",intEng[i]);
			System.out.printf("%d\t",intMath[i]);
			System.out.printf("%d\n",intSum[i]);
		}
		
		/*
		 * for(int i : intKor) { System.out.print(i + "\t"); } System.out.println();
		 * for(int i : intEng) { System.out.print(i + "\t"); } System.out.println();
		 * for(int i : intMath) { System.out.print(i + "\t"); } System.out.println();
		 * System.out.println(); for(int i : intSum) { System.out.print(i + "\t"); }
		 */
	}
}
