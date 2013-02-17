import java.io.*;
import java.util.*;

public class database{
	public static void main(String args[]) throws IOException{
		int n;
		
		System.out.print("�{�I�ɖ{��ǉ�����i1�j �{�I����{��T���i2�j\n>>");
		
		while(true){
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String buf = br.readLine();
			n = Integer.parseInt(buf);
			
			if(n == 1 || n == 2){
				break;
			}
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.print("1��2�̐�������͂��Ă��������I\n>>");
		}
		
		switch(n){
			case 1:
				input();
			case 2:
				search();
		}
	}
	
	public static void input(){		
		try{
			String str, name, author, category;
			int i = 1;
			FileWriter fp = new FileWriter("database.txt", true);
			
			while (true){
				System.out.println(i + "���ڂɓ����{�̖��O�A���̖{�̒��ҁA�J�e�S������͂��Ă��������B�iCtrl + Z�ŏI���j");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader input = new BufferedReader(isr);
				
				if((str = input.readLine()) == null){
					System.out.println("�I�����܂��B");
					fp.close();
					break;
				}
				
				StringTokenizer st = new StringTokenizer(str, " ");
				name = st.nextToken();
				author = st.nextToken();
				category = st.nextToken();
				
				fp.write(name + " " + author + " " + category + "\n");
				System.out.println("�{�I�ɒǉ����܂����I");
				i++;
			}				
		}catch(IOException e){
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.println("�t�@�C�����I�[�v���ł��܂���I>> " + e);
		}
	}
	
	public static void search(){
		try{
			String str, name, author, category, dname = "", dauthor = "", dcategory = "";
			int flg = 0;
			
			while(true){
				System.out.println("�{�̖��O�A���̖{�̒��ҁA�{�̃J�e�S���[����͂��Ă��������B�i�킩��Ȃ����ڂ������0����́j");
				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader input = new BufferedReader(isr);
				str = input.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				name = st.nextToken();
				author = st.nextToken();
				category = st.nextToken();
				
				if(name.equals("0") && author.equals("0") && category.equals("0")){
					java.awt.Toolkit.getDefaultToolkit( ).beep( );
					System.out.println("1�ȏ�킩�鍀�ڂ���͂��Ă��������I");
				}else{
					break;
				}
			}
			
			Scanner scanner = new Scanner(new File("database.txt"));
			FileReader fp = new FileReader("database.txt");
			BufferedReader br = new BufferedReader(fp);
			
			while((str = br.readLine()) != null){
				dname = scanner.next();
				dauthor = scanner.next();
				dcategory = scanner.next();
				
				if(name.equals(dname) || author.equals(dauthor) || category.equals(dcategory)){
					System.out.println("");
					System.out.println("�Y������{��������܂����I");
					System.out.printf("%-30s %-30s %-30s\n", "����", "����", "�J�e�S���[");
					System.out.printf("%-30s %-30s %-30s\n", dname, dauthor, dcategory);
					flg = 1;
				}
			}
			
			if(flg != 1){
				System.out.println("������܂���ł����B");
			}
			
			br.close();
			scanner.close();
			fp.close();
		}catch(IOException e){
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.println("�t�@�C�����I�[�v���ł��܂���I>> " + e);
		}
	}
}