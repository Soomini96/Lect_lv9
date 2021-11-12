package basic;

import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//class Alert extends JFrame {
//	private JLabel label = new JLabel();
//
//	public Alert(String text) {
//		setLayout(null);
//		setBounds(900, 300, 400, 400);
//		this.label.setText(text);
//		this.label.setBounds(0, 0, 200, 200);
//		this.label.setHorizontalAlignment(JLabel.CENTER);
//		this.label.setVerticalAlignment(JLabel.CENTER);
//		add(this.label);
//
//		setVisible(true);
//		revalidate();
//	}
//}

public class 아이디패스워드이름 extends JFrame implements ActionListener {

	private Vector<JLabel> label = new Vector<>();
	private Vector<JTextField> input = new Vector<>();

	private JButton join = new JButton();
	private JButton logIn = new JButton();

	private String log = "";
	private JLabel logLabel = new JLabel();

	// user : Vector<String> -> id, pw, name
	private Vector<Vector<String>> users = new Vector<Vector<String>>();
//	private Vector<String> ids = new Vector<>();
//	private Vector<String> pws = new Vector<>();
//	private Vector<String> names = new Vector<>();

	public 아이디패스워드이름() {
		super("Sign In");
		setLayout(null);
		setBounds(900, 300, 300, 180);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setJTextField();
		setLabel();
		setButton();

		setVisible(true);
		revalidate();

	}

	private void setButton() {
		this.join.setText("<html>회원가입<br>GOGO♫</html>");
		this.join.setBounds(170, 40, 100, 45);
		this.join.addActionListener(this);
		add(this.join);

		this.logIn.setText("로그인");
		this.logIn.setBounds(170, 85, 100, 45);
		this.logIn.addActionListener(this);
		add(this.logIn);
	}

	private void setLabel() {
		String[] text = { "ID", "PW", "Name" };
		int x = 20;
		int y = 50;
		for (int i = 0; i < 3; i++) {
			this.label.add(new JLabel(text[i]));
			this.label.get(i).setBounds(x, y, 50, 10);
			this.label.get(i).setHorizontalAlignment(JLabel.LEFT);
			this.label.get(i).setVerticalAlignment(JLabel.CENTER);

			add(this.label.get(i));
			y += 30;
		}

		this.logLabel.setBounds(0, 10, 300, 20);
		this.logLabel.setText("로그인 or 회원가입을 해주세요!");
		this.logLabel.setHorizontalAlignment(JLabel.CENTER);
		this.logLabel.setFont(new Font("", Font.BOLD, 15));
		add(this.logLabel);
	}

	private void setJTextField() {
		int x = 60;
		int y = 40;
		for (int i = 0; i < 3; i++) {
			this.input.add(new JTextField());
			this.input.get(i).setBounds(x, y, 100, 30);
			add(this.input.get(i));
			y += 30;
		}
	}

	public static void main(String[] args) {
		new 아이디패스워드이름();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.join) {
			Vector<String> info = new Vector<>();

			for (int i = 0; i < this.input.size(); i++) {
				info.add(this.input.get(i).getText());
			}
			if (checkJoin(info)) {
				this.users.add(info);
				JOptionPane.showMessageDialog(null, "회원가입 성공!");
			} else {
				JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
			}
		} else if (target == this.logIn) {
			if (this.log == "") {
				Vector<String> info = new Vector<>();
				for (int i = 0; i < this.input.size(); i++) {
					info.add(this.input.get(i).getText());
				}

				if (checkLogIn(info)) {
					this.log = info.get(0);
					this.logIn.setText("로그아웃");
					this.logLabel.setText(info.get(0) + "님, 환영합니다.");
					JOptionPane.showMessageDialog(null, "로그인 성공!");
				} else {
					JOptionPane.showMessageDialog(null, "올바르지 않은 입력입니다.");
				}
			} else {
				this.log = "";
				this.logLabel.setText("로그인 or 회원가입을 해주세요!");
				this.logIn.setText("로그인");
				JOptionPane.showMessageDialog(null, "로그아웃");
			}
		}
	}

	private boolean checkLogIn(Vector<String> info) {
		boolean check = false;
		String id = info.get(0);
		String pw = info.get(1);
		String name = info.get(2);

		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).get(0).equals(id) && this.users.get(i).get(1).equals(pw)) {
				check = true;
				if (!name.equals("") && !name.equals(this.users.get(i).get(2))) { // 이름은 있지만 잘못 쓴 경우
					check = false;
				}
			}
		}
		return check;
	}

	private boolean checkJoin(Vector<String> info) {
		String id = info.get(0);
		boolean check = true;
		// 아이디 중복 체크
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).get(0).equals(id)) {
				check = false;
			}
		}
		// 빈 데이터 안됨
		for (int i = 0; i < info.size(); i++) {
			if (info.get(i).equals("")) {
				check = false;
			}
		}
		return check;
	}

}
