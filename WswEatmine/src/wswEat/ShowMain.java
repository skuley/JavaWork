package wswEat;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

public class ShowMain {
	
	private Scanner sc;

	public static void main(String[] args) {
		//String icon = "wswEat.Data/Eat.png";
		//new MainWindow();
		
		System.out.println("점심 메뉴 랜덤으로 뽑기");
		
		ShowMain sm = new ShowMain();
		sm.showMenu();
		
		

	} // main
	
	public void showMenu() {
		sc = new Scanner(System.in);
		
		System.out.println(" 한식 / 중식 / 양식 ");
		System.out.print(" 택 1 : ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("한식을 선택하셨습니다.");
			break;
			
		case 2:
			System.out.println("중식을 선택하셨습니다.");
			break;
			
		case 3: 
			
			break;

		default:
			System.out.println("선택지에 없는 번호를 입력하셨습니다.");
			break;
		}
		
		
	}

}

class MainWindow extends JFrame {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int x = screenSize.width;
	int y = screenSize.height;

	public MainWindow() {
		int width = 600;
		int height = 800;
		setBounds((x / 2) - (width / 2), (y / 2) - (height / 2), width, height);
		
		setVisible(true);
	}
}
