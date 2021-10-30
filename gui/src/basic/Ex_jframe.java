//package basic;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*; // 자바의 모든 클래스 사용
//
//// GUI : Graphic User Interface
//// ㄴ awt : 무겁다 
//// ㄴ swing : 가볍다
//
//// JFrame : 최상위 컨테이너
//// JPanel : 컨테이너 <- 컴포넌트 (요소들을 붙여나가 add()면서 완성함)
//// ㄴ JButton, JTextField, JLabel, JCheckBox ...
//
//class MyPanel extends JPanel implements ActionListener{
//	// 버튼 만들기
//	// JButton
////	JButton bt = new JButton();
//	
//	// 버튼 연습
//	// 정방형으로 3*3 버튼의 나열
//	final int SIZE = 50;
//	JButton[] map = new JButton[9];
//	
//	public MyPanel() {
//		setLayout(null);
//		setBounds(0, 0, 400, 400);
//		setBackground(Color.orange);
//		
////		this.bt.setBounds(50, 50, 50, 50);
////		this.bt.setVisible(true);
////		add(this.bt);
//		
//		// map의 각 버튼 세팅
//		// 모두 -> panel에 add
//		int garo = 0;
//		int sero = 0;
//		for (int i = 0; i < this.map.length; i++) {
////			this.map[i] = new JButton();
////			this.map[i].setBounds(garo, sero, SIZE, SIZE);
////			
////			// mac os 에 대해서만 추가 설정(버튼액션설정)
////			this.map[i].setOpaque(true);
////			this.map[i].setBorderPainted(false);
////			
////			this.map[i].setVisible(true);
////			this.map[i].addActionListener(this);
////			add(this.map[i]);
////			
////			if(i%3==2) {
////				garo = 0;
////				sero += SIZE+1 ;
////			}else {
////				garo += SIZE+1;
////			}
//		}
//	}
//
////	@Override
////	public void actionPerformed(ActionEvent e) {
////		JButton temp = (JButton) e.getSource(); // 이벤트가 발생한 객체를 가져옴
////		for(int i=0; i<this.map.length; i++) {
////			if(this.map[i] == temp) {
////				System.out.println(i); // 콘솔에 액션이 발생한 인덱스를 출력
////				temp.setBackground(Color.blue);
////			}
////		}
//////		System.out.println(e.getSource());
////		
////		// 버튼 클릭 시 -> 버튼의 색이 변경되도록 처리
////	}
//}
//
//class MyFrame extends JFrame {
//
//	// 사용자가 현재 쓰고 있는 컴퓨터의 픽셀 사이즈를 알려줌
//	// 사용자의 피시 사이즈에 맞추어 만들수 있게 됨
//	private Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
//	public int width = dm.width;
//	public int height = dm.height;
//	
//	private final int W = 800;
//	private final int H = 600;
//	
//	
//	public MyFrame(String title) {
//		// 부모 생성자를 활용한 프레임의 제목 설정
//		super(title);
//		setLayout(null); // 디폴트 레이아웃 구성을 삭제함
//		// 프레임의 크기 설정
//		// setBounds(x,y,width, height);
//		setBounds(this.width/2-W/2,this.height/2 - H/2,W,H);
////		setBounds(100,100,800,600);
//		// 프레임의 종료 연산(명령)을 결정 (생략시, 프레임은 사라지지만, 스레드가 종료X)-> 램이 쌓임 pc사망
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		// 프레임을 눈에 보이게 설정
//		setVisible(true);
//		
//		add(new MyPanel());
////		this.setContentPane(new MyPanel()); // 윈도우..?
//	}
//}
//
//
//public class Ex_jframe {
//	public static void main(String[] args) {
//		
//		MyFrame frame = new MyFrame("Green IT");
//	}
//}
