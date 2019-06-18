package GSLC;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner datas = new Scanner(System.in);
	ArrayList<String> data=new ArrayList<String>();
		
	void add(){
		String word;
		boolean string;
		if (data.size() == 10) {
			
			System.out.println("Data is full");
			datas.nextLine();
			
		}
		else {
		
		do {
			string = true;
			System.out.println("Input word (5 to 50 characters)");
		word = datas.nextLine();
	
		for (int index = 0; index < data.size();index ++) {
				if (word.equals(data.get(index))) {
					
				
				string = false;
				break;
				}
		}
		
		}
		while (word.length()<5||word.length()>50 || string == false);
			data.add(word);
			
			
		}
	
	}
	void look(){	
	if(data.size()==0)
		System.out.println("There is no data");
		for ( int x = 0 ; x < data.size() ;x++) {
			System.out.println(data.get(x));
			
	}

		datas.nextLine();

	}
	
	
	void game() {
		ArrayList<Integer> found = new ArrayList<Integer>();
		for(int huruf=0;huruf<51;huruf++) {
			found.add(0);
		}
		int total;
		String kata;
		boolean valid = true;
			if(data.size()==0) {
				System.out.println("Add Data");
				datas.nextLine();
			}
			else {
				int angka = rand(data.size());
				total=data.get(angka).length();
				do {
					for(int huruf = 0; total > huruf;huruf++) {
						if(found.get(huruf)==0){
							System.out.printf("-");
						}else {
							System.out.printf("%c",data.get(angka).charAt(huruf));
						}
								
					}
					
					do {
						System.out.println("\n\nMasukan Huruf");
						kata = datas.nextLine();
						System.out.println(kata.length());
					}while(kata.length()!=1);
					
					char kata1=kata.charAt(0);
					
					if(data.contains(kata)) {
						int index=-2;
						do {	
							index = data.get(angka).indexOf(kata1,index);
							if(index!=-1) {
								found.set(index, 1);
//								System.out.println(">>>");
							}
						}while (index!=-1);
					}
					
					for(int x=0;x<total;x++) {
						if(found.get(x)==0) {
							break;
						}
						else if(x== total-1) {
							valid=false;
						}
					}
				} while(valid);
			}
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		menu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	int rand( int max) {
		int min = 0;
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
		void menu() {
	int chose=0;
	do {	
			
			System.out.println("1.	Add data");
			System.out.println("2.	Look data");
			System.out.println("3.	Game");
			System.out.println("4.	Exit");
			chose = datas.nextInt();
			datas.nextLine();
				switch (chose) {
					case 1:	
						add();
						break;
					case 2:
						look();
						break;
					case 3:
						game();
						
						break;
				}
			
			}
				while (chose != 4);
		}	
		
}
