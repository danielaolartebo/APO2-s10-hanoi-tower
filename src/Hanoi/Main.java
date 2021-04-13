package Hanoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static BufferedWriter bw;
	static BufferedReader br;
	static int torre1=0;
	static int torre2=0;
	static int torre3 = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new FileReader("data/input.txt"));
		bw = new BufferedWriter(new FileWriter("data/output.txt"));
		int m = Integer.parseInt(br.readLine());
		int n = 0;
		for(int i =0;i<m;i++) {
			n = Integer.parseInt(br.readLine());
			bw.write(n + " " + 0 + " " + 0 + "\n");
			torre1 = n;
			torre2 = 0;
			torre3 = 0;
			hanoi(n,1,2,3);
			bw.write("\n");
		}
		br.close();
		bw.close();
	}
	
	public static void hanoi(int n, int origen, int auxiliar , int destino) throws IOException {
		
		if(n == 1) {
			if(origen == 1 && destino == 2) {
				torre1--;
				torre2++;
			}else if(origen == 1 && destino ==3) {
				torre1--;
				torre3++;
			}else if(origen == 2 && destino == 1){
				torre1++;
				torre2--;
			}else if(origen == 2 && destino == 3){
				torre2--;
				torre3++;
			}else if(origen == 3 && destino ==1) {
				torre1++;
				torre3--;
				;
			}else if(origen ==3 && destino == 2) {
				torre3--;
				torre2++;
			}
			bw.write(torre1 + " " + torre2 + " "+ torre3 + "\n");
		}else {
			hanoi((n-1),origen,destino,auxiliar);
			hanoi(1,origen,auxiliar,destino);
		    hanoi((n-1),auxiliar,origen,destino);
			}
	}
}
