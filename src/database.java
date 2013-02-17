import java.io.*;
import java.util.*;

public class database{
	public static void main(String args[]) throws IOException{
		int n;
		
		System.out.print("本棚に本を追加する（1） 本棚から本を探す（2）\n>>");
		
		while(true){
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String buf = br.readLine();
			n = Integer.parseInt(buf);
			
			if(n == 1 || n == 2){
				break;
			}
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.print("1か2の整数を入力してください！\n>>");
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
				System.out.println(i + "冊目に入れる本の名前、その本の著者、カテゴリを入力してください。（Ctrl + Zで終了）");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader input = new BufferedReader(isr);
				
				if((str = input.readLine()) == null){
					System.out.println("終了します。");
					fp.close();
					break;
				}
				
				StringTokenizer st = new StringTokenizer(str, " ");
				name = st.nextToken();
				author = st.nextToken();
				category = st.nextToken();
				
				fp.write(name + " " + author + " " + category + "\n");
				System.out.println("本棚に追加しました！");
				i++;
			}				
		}catch(IOException e){
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.println("ファイルをオープンできません！>> " + e);
		}
	}
	
	public static void search(){
		try{
			String str, name, author, category, dname = "", dauthor = "", dcategory = "";
			int flg = 0;
			
			while(true){
				System.out.println("本の名前、その本の著者、本のカテゴリーを入力してください。（わからない項目があれば0を入力）");
				
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader input = new BufferedReader(isr);
				str = input.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				name = st.nextToken();
				author = st.nextToken();
				category = st.nextToken();
				
				if(name.equals("0") && author.equals("0") && category.equals("0")){
					java.awt.Toolkit.getDefaultToolkit( ).beep( );
					System.out.println("1つ以上わかる項目を入力してください！");
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
					System.out.println("該当する本が見つかりました！");
					System.out.printf("%-30s %-30s %-30s\n", "著名", "著者", "カテゴリー");
					System.out.printf("%-30s %-30s %-30s\n", dname, dauthor, dcategory);
					flg = 1;
				}
			}
			
			if(flg != 1){
				System.out.println("見つかりませんでした。");
			}
			
			br.close();
			scanner.close();
			fp.close();
		}catch(IOException e){
			java.awt.Toolkit.getDefaultToolkit().beep();
			System.out.println("ファイルをオープンできません！>> " + e);
		}
	}
}