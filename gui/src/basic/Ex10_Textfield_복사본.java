package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class JoinFrame extends JFrame {
	JLabel idLable = new JLabel("ID");
	JLabel pwLable = new JLabel("ID");
	JLabel nameLable = new JLabel("ID");
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField();

	public JoinFrame() {
		setLayout(null);
		setBounds(200, 200, 200, 200);

		setLabel();

		setVisible(true);
		revalidate();
	}

	private void setLabel() {
		idLable.setBounds(10, 20, 30, 20);
		idLable.setText("id : ");
		add(idLable);

		idField.setBounds(50, 20, 100, 20); 
		idField.setText("id ");
		add(idField);

		pwLable.setBounds(10, 50, 30, 20);
		pwLable.setText("pw : ");
		add(pwLable);

		pwField.setBounds(50, 50, 100, 20);
		pwField.setText("pw ");
		add(pwField);

		nameLable.setBounds(10, 80, 30, 20);
		nameLable.setText("name : ");
		add(nameLable);

		nameField.setBounds(50, 80, 100, 20);
		nameField.setText("name ");
		add(nameField);

	}
}

public class Ex10_Textfield_복사본 extends JFrame implements MouseListener, ActionListener, KeyListener {

	Vector<Vector<String>> users = new Vector<>();
	Vector<String> colName = new Vector<>();
	JTable table = null;
	// JLabel 내에서 html사용하기
	JLabel dataField = new JLabel(String.format("<html> %s <br> %d </html>", "text ", 123));

	JTextField text = new JTextField();
	JTextArea text2 = new JTextArea();

	JButton login = new JButton("Login");
	JButton join = new JButton("Join");

	JoinFrame joinFrame = null;
	
	JScrollPane js = null;

	public Ex10_Textfield_복사본() {
		setLayout(null);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 텍스트박스의 처리

		// 1. JTextField
//		text.setBounds(20, 40, 300, 50);
//		text.addKeyListener(this);
//		add(text);

		// 2. JTextArea
//		text2.setBounds(20, 100, 300, 50);
//		add(text2);

		setButton();
		setDataField();
//		initData();
		setTable();
		
		setFocusable(true);
		addKeyListener(this);
		setVisible(true);
		revalidate();

	}

	private void initData() {
		for(int i=0; i<1; i++) {
			Vector<String> data = new Vector<>();
			data.add(i+1 +"");
			data.add(i+1 +"");
			data.add(i+1 +"");
			this.users.add(data);
			
		}
		
	}

	private void setTable() { // 중요!
		
		// JTable(Vector<?>,Vector<?>)
		// 1) 실데이터 2) 컬럼 이름
		
		this.colName.add("id");
		this.colName.add("pw");
		this.colName.add("name");

		this.table = new JTable(users, colName);
		this.table.setBounds(20, 20, 450, 400);
		this.table.setGridColor(Color.black);
		this.table.setBorder(new LineBorder(Color.cyan));
		
		this.table.setCellEditor(null);
		this.table.setDragEnabled(true);
		this.table.setCellSelectionEnabled(true);
//		add(this.table);
		
		js = new JScrollPane(this.table);
		js.setBounds(20, 20, 450, 400);
		js.setAutoscrolls(true); // 필요 시에 -> 스크롤바가 등장
		add(js);
	}

	private void setDataField() {
		this.dataField.setBounds(0, 0, 500, 500);
		this.dataField.setVerticalAlignment(JLabel.TOP);
		add(this.dataField);

	}

	private void setButton() {
		this.join.setBounds(380, 400, 100, 40);
		this.join.addActionListener(this);
		add(this.join);
	}

	public static void main(String[] args) {
		new Ex10_Textfield_복사본();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			// 검증 후 회원가입 처리
			String tempId = this.joinFrame.idField.getText();
			String tempPw = this.joinFrame.pwField.getText();
			String tempName = this.joinFrame.nameField.getText();

			String id = tempId.equals("") || tempId.equals("id ") ? null : this.joinFrame.idField.getText();
			String pw = tempPw.equals("") || tempPw.equals("pw ") ? null : this.joinFrame.idField.getText();
			;
			String name = tempName.equals("") || tempName.equals("name ") ? null : this.joinFrame.nameField.getText();

			if (id != null && pw != null && name != null) {
				addUser(id, pw, name);
				JOptionPane.showMessageDialog(null, "회원가입 성공!");
				this.joinFrame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "회원정보를 다시 확인해주세요");
			}
		}


	}

	private void addUser(String id, String pw, String name) {
		// Vector<String> : user
		Vector<String> user = new Vector<>();
		user.add(id);
		user.add(pw);
		user.add(name);
		this.users.add(user);

		// 1) JLabel로 데이터 전체 출력
		updateDataField();
		
		this.js.revalidate();
		this.js.repaint();
		
		revalidate();
		repaint();
		table.revalidate();
		
		System.out.println("size: " + this.users.size());
	}

	private void updateDataField() {
		String data = "<html>";
		for (int i = 0; i < this.users.size(); i++) {
			data += this.users.get(i).get(0) + " / ";
			data += this.users.get(i).get(1) + " / ";
			data += this.users.get(i).get(2) + "<br>";
		}
		data += "</html>";
		this.dataField.setText(data);
	}

	// 2) JPanel 위에서 JComponent의 paintComponent()를 오버라이딩
	
//	int startX=30;
//	int startY=50;
//	@Override
//	public void paintComponents(Graphics g) {
//		super.paintComponents(g);
//		int x=startX;
//		int y=startY;
//		for(int i=0;i<this.users.size();i++) {
//			Vector<String> u = this.users.get(i);
//			g.drawString(String.format("%s / %s / %s", u.get(0),u.get(1),u.get(2)), x, y);
//			y+=15;
//		}
//		repaint();
//	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.join) {
			this.joinFrame = new JoinFrame();
			this.joinFrame.idField.addKeyListener(this);
			this.joinFrame.idField.addMouseListener(this);

			this.joinFrame.pwField.addKeyListener(this);
			this.joinFrame.pwField.addMouseListener(this);

			this.joinFrame.nameField.addKeyListener(this);
			this.joinFrame.nameField.addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.joinFrame.idField) {
			this.joinFrame.idField.setText("");
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}