package mall;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MallMain extends JFrame{
	private RoundedButton btnMember, btnProduct, btnOrder, btnLogout, btnExit, btnJoin;
	private JPanel pn1, pn2, pn2_1,pn2_2;
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12, lblNewLabel_13, lblNewLabel_14, lblNewLabel_1_2;
	private JTextField txtId, txtPwd, txtName, txtAge, txtTel, txtAddr, txtDate, txtPoint, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8;
	
	public MallMain() {
		super("쇼핑몰 회원관리");
		getContentPane().setBackground(new Color(4, 73, 150));
		setSize(800,500);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 4, 786, 49);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(MallMain.class.getResource("/img/logo.png")));
		lbLogo.setBounds(10, 10, 133, 29);
		pn1.add(lbLogo);
		
		btnMember = new RoundedButton("회원관리");
		btnMember.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnMember.setText("회원관리");
		btnMember.setForeground(new Color(4, 73, 150));
		btnMember.setBackground(new Color(255, 255, 255));
		btnMember.setBounds(167, 14, 97, 23);
		pn1.add(btnMember);
		
		btnProduct = new RoundedButton("재고관리");
		btnProduct.setText("재고관리");
		btnProduct.setForeground(new Color(0, 0, 0));
		btnProduct.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnProduct.setBackground(Color.WHITE);
		btnProduct.setBounds(265, 14, 97, 23);
		pn1.add(btnProduct);
		
		btnOrder = new RoundedButton("주문관리");
		btnOrder.setText("주문관리");
		btnOrder.setForeground(new Color(0, 0, 0));
		btnOrder.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setBounds(366, 14, 97, 23);
		pn1.add(btnOrder);
		
		btnExit = new RoundedButton("종료");
		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnExit.setText("종료");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(4, 73, 150));
		btnExit.setBounds(705, 15, 68, 23);
		pn1.add(btnExit);
		
		btnLogout = new RoundedButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLogout.setText("로그아웃");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(new Color(163, 163, 163));
		btnLogout.setBounds(629, 15, 68, 23);
		pn1.add(btnLogout);
		
		pn2 = new JPanel();
		pn2.setBackground(new Color(245, 245, 245));
		pn2.setBounds(0, 52, 786, 415);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		NumberButton btnReset = new NumberButton("다시입력");
		btnReset.setText("다시입력");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("굴림", Font.BOLD, 16));
		btnReset.setBackground(new Color(4, 73, 150));
		btnReset.setBounds(168, -37, 133, 36);
		pn2.add(btnReset);
		
		pn2_1 = new JPanel();
		pn2_1.setBackground(new Color(255, 255, 255));
		pn2_1.setBounds(8, 56, 516, 180);
		pn2.add(pn2_1);
		pn2_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 516, 178);
		pn2_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		pn2_2 = new JPanel();
		pn2_2.setBackground(Color.WHITE);
		pn2_2.setBounds(8, 267, 517, 135);
		pn2.add(pn2_2);
		pn2_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(142, 30, 46, 15);
		pn2_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(142, 52, 60, 15);
		pn2_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(142, 75, 60, 15);
		pn2_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("나이");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(142, 98, 60, 15);
		pn2_2.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MallMain.class.getResource("/img/member7.jpg")));
		lblNewLabel_5.setBounds(13, 15, 106, 106);
		pn2_2.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(201, 26, 96, 21);
		pn2_2.add(txtId);
		txtId.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(201, 49, 96, 21);
		pn2_2.add(txtPwd);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(201, 72, 96, 21);
		pn2_2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(201, 95, 96, 21);
		pn2_2.add(txtAge);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(379, 26, 96, 21);
		pn2_2.add(txtTel);
		
		lblNewLabel_6 = new JLabel("연락처");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(320, 30, 46, 15);
		pn2_2.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("주소");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(320, 52, 60, 15);
		pn2_2.add(lblNewLabel_7);
		
		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(379, 49, 96, 21);
		pn2_2.add(txtAddr);
		
		lblNewLabel_8 = new JLabel("가입일");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(320, 75, 60, 15);
		pn2_2.add(lblNewLabel_8);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(379, 72, 96, 21);
		pn2_2.add(txtDate);
		
		lblNewLabel_9 = new JLabel("포인트");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(320, 98, 60, 15);
		pn2_2.add(lblNewLabel_9);
		
		txtPoint = new JTextField();
		txtPoint.setColumns(10);
		txtPoint.setBounds(379, 95, 96, 21);
		pn2_2.add(txtPoint);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "나이", "주소", "연락처"}));
		comboBox.setBounds(7, 27, 90, 23);
		pn2.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(102, 27, 211, 24);
		pn2.add(textField);
		textField.setColumns(10);
		
		NumberButton btnSearch = new NumberButton("접속");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setText("검색");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnSearch.setBackground(new Color(4, 73, 150));
		btnSearch.setBounds(318, 27, 82, 24);
		pn2.add(btnSearch);
		
		NumberButton btnDelete1 = new NumberButton("접속");
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete1.setText("선택회원 삭제");
		btnDelete1.setForeground(Color.WHITE);
		btnDelete1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete1.setBackground(new Color(19, 137, 201));
		btnDelete1.setBounds(405, 27, 118, 24);
		pn2.add(btnDelete1);
		
		lblNewLabel = new JLabel("선택된 회원정보");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(MallMain.class.getResource("/img/icoMember.png")));
		lblNewLabel.setBounds(11, 244, 135, 15);
		pn2.add(lblNewLabel);
		
		lblNewLabel_10 = new JLabel("회원등록");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_10.setIcon(new ImageIcon(MallMain.class.getResource("/img/icoMember.png")));
		lblNewLabel_10.setBounds(547, 31, 135, 15);
		pn2.add(lblNewLabel_10);
		
		NumberButton btnDelete2 = new NumberButton("접속");
		btnDelete2.setText("선택회원 삭제");
		btnDelete2.setForeground(Color.WHITE);
		btnDelete2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete2.setBackground(new Color(19, 137, 201));
		btnDelete2.setBounds(405, 239, 118, 24);
		pn2.add(btnDelete2);
		
		NumberButton btnModify = new NumberButton("접속");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModify.setText("수정");
		btnModify.setForeground(Color.WHITE);
		btnModify.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnModify.setBackground(new Color(4, 73, 150));
		btnModify.setBounds(318, 239, 82, 24);
		pn2.add(btnModify);
		
		JPanel pn2_2_1 = new JPanel();
		pn2_2_1.setLayout(null);
		pn2_2_1.setBackground(Color.WHITE);
		pn2_2_1.setBounds(529, 56, 250, 303);
		pn2.add(pn2_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("아이디");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(39, 104, 46, 15);
		pn2_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("비밀번호");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(39, 126, 60, 15);
		pn2_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("이름");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(39, 150, 60, 15);
		pn2_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("나이");
		lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(39, 172, 60, 15);
		pn2_2_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(MallMain.class.getResource("/img/imgMember.jpg")));
		lblNewLabel_5_1.setBounds(103, 23, 96, 73);
		pn2_2_1.add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 100, 96, 21);
		pn2_2_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 123, 96, 21);
		pn2_2_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 146, 96, 21);
		pn2_2_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 169, 96, 21);
		pn2_2_1.add(textField_4);
		
		lblNewLabel_11 = new JLabel("연락처");
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(39, 196, 46, 15);
		pn2_2_1.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 192, 96, 21);
		pn2_2_1.add(textField_5);
		
		lblNewLabel_12 = new JLabel("주소");
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(39, 218, 60, 15);
		pn2_2_1.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(104, 215, 96, 21);
		pn2_2_1.add(textField_6);
		
		lblNewLabel_13 = new JLabel("가입일");
		lblNewLabel_13.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(39, 241, 60, 15);
		pn2_2_1.add(lblNewLabel_13);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(104, 238, 96, 21);
		pn2_2_1.add(textField_7);
		
		lblNewLabel_14 = new JLabel("포인트");
		lblNewLabel_14.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(39, 264, 60, 15);
		pn2_2_1.add(lblNewLabel_14);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(104, 261, 96, 21);
		pn2_2_1.add(textField_8);
		
		lblNewLabel_1_2 = new JLabel("사진등록");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(39, 25, 60, 71);
		pn2_2_1.add(lblNewLabel_1_2);
		
		btnJoin = new RoundedButton("종료");
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnJoin.setText("회원등록");
		btnJoin.setForeground(Color.WHITE);
		btnJoin.setBackground(new Color(4, 73, 150));
		btnJoin.setBounds(529, 367, 250, 34);
		pn2.add(btnJoin);
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ----------------------------------------------------------
		// 로그아웃
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?");
				if(ans == 0) {
					// 로그아웃 처리
					dispose();
					new MallLoginAdmin();
				}
			}
		});
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "쇼핑몰 관리 시스템을 종료하시겠습니까?");
				if(ans == 0) System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MallMain();
	}
}
