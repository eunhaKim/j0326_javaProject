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

public class MallLoginAdmin extends JFrame{
	private static final Border red = null;
	private NumberButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnExit, btnLogin;
	private RoundedButton btnAdminLogin, btnUserLogin;
	private JTextField txtInput;
	
	
	public MallLoginAdmin() {
		super("관리자로그인");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(800,500);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 392, 500);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnAdminLogin = new RoundedButton("관리자 로그인");
		btnAdminLogin.setEnabled(false);
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(19, 137, 201));
		btnAdminLogin.setBounds(100, 344, 97, 23);
		pn1.add(btnAdminLogin);
		
		
		btnUserLogin = new RoundedButton("사용자 로그인");
		btnUserLogin.setText("사용자 로그인");
		btnUserLogin.setForeground(new Color(255, 255, 255));
		btnUserLogin.setBackground(new Color(151, 151, 151));
		btnUserLogin.setBounds(207, 344, 97, 23);
		pn1.add(btnUserLogin);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 4자리를 입력해주세요.");
		lblNewLabel_1.setForeground(new Color(0, 0, 64));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(86, 293, 239, 35);
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("쇼핑몰 시스템 접속을 위해서");
		lblNewLabel.setForeground(new Color(0, 0, 64));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 272, 239, 35);
		pn1.add(lblNewLabel);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(MallLoginAdmin.class.getResource("/img/loginBg.jpg")));
		lblBg.setBounds(0, 0, 389, 463);
		pn1.add(lblBg);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(391, 0, 395, 463);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		btn1 = new NumberButton("1");
		
		btn1.setBackground(new Color(245, 245, 245));
		btn1.setFont(new Font("굴림", Font.BOLD, 18));
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBounds(-3, 116, 133, 87);
		pn2.add(btn1);
		
		btn2 = new NumberButton("2");
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("굴림", Font.BOLD, 18));
		btn2.setBackground(new Color(245, 245, 245));
		btn2.setBounds(129, 116, 133, 87);
		pn2.add(btn2);
		
		
		btn3 = new NumberButton("3");
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("굴림", Font.BOLD, 18));
		btn3.setBackground(new Color(245, 245, 245));
		btn3.setBounds(261, 116, 133, 87);
		pn2.add(btn3);
		
		btn4 = new NumberButton("4");
		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("굴림", Font.BOLD, 18));
		btn4.setBackground(new Color(245, 245, 245));
		btn4.setBounds(-3, 202, 133, 87);
		pn2.add(btn4);
		
		btn5 = new NumberButton("5");
		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("굴림", Font.BOLD, 18));
		btn5.setBackground(new Color(245, 245, 245));
		btn5.setBounds(129, 202, 133, 87);
		pn2.add(btn5);
		
		btn6 = new NumberButton("6");
		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("굴림", Font.BOLD, 18));
		btn6.setBackground(new Color(245, 245, 245));
		btn6.setBounds(261, 202, 133, 87);
		pn2.add(btn6);
		
		btn7 = new NumberButton("7");
		btn7.setForeground(Color.BLACK);
		btn7.setFont(new Font("굴림", Font.BOLD, 18));
		btn7.setBackground(new Color(245, 245, 245));
		btn7.setBounds(-3, 288, 133, 87);
		pn2.add(btn7);
		
		btn8 = new NumberButton("8");
		btn8.setForeground(Color.BLACK);
		btn8.setFont(new Font("굴림", Font.BOLD, 18));
		btn8.setBackground(new Color(245, 245, 245));
		btn8.setBounds(129, 288, 133, 87);
		pn2.add(btn8);
		
		btn9 = new NumberButton("9");
		btn9.setForeground(Color.BLACK);
		btn9.setFont(new Font("굴림", Font.BOLD, 18));
		btn9.setBackground(new Color(245, 245, 245));
		btn9.setBounds(261, 288, 133, 87);
		pn2.add(btn9);
		
		btn0 = new NumberButton("0");
		btn0.setForeground(Color.BLACK);
		btn0.setFont(new Font("굴림", Font.BOLD, 18));
		btn0.setBackground(new Color(245, 245, 245));
		btn0.setBounds(129, 374, 133, 87);
		pn2.add(btn0);
		
		btnExit = new NumberButton("종료");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("굴림", Font.BOLD, 16));
		btnExit.setBackground(new Color(163, 163, 163));
		btnExit.setBounds(-3, 374, 133, 87);
		pn2.add(btnExit);
		
		btnLogin = new NumberButton("접속");
		
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("굴림", Font.BOLD, 16));
		btnLogin.setBackground(new Color(4, 73, 150));
		btnLogin.setBounds(261, 374, 133, 87);
		pn2.add(btnLogin);
		
		txtInput = new JTextField();
		txtInput.setForeground(new Color(4, 73, 150));
		txtInput.setHorizontalAlignment(SwingConstants.CENTER);
		txtInput.setFont(new Font("굴림", Font.PLAIN, 28));
		txtInput.setBounds(10, 10, 375, 96);
		txtInput.setBorder(new EmptyBorder(5,3,5,3));
		pn2.add(txtInput);
		txtInput.setColumns(10);
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ----------------------------------------------------------
		// 숫자버트
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(1);
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(2);
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(3);
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(4);
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(5);
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(6);
			}
		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(7);
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(8);
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(9);
			}
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumBtnCheck(0);
			}
		});
		// 어드민 로그인 버튼
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// 사용자 로그인 버튼
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallLoginUser();
			}
		});
		// 접속하기 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtInput.getText().equals("1234")) {
					JOptionPane.showMessageDialog(null, "관리자님으로 접속하였습니다.");
					dispose();
					new MallMain();
				}
				else {
					JOptionPane.showMessageDialog(null, "관리자님 비밀번호가 틀립니다. 다시 입력해주세요.");
					txtInput.setText(null);
				}
			}
		});
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "쇼핑몰 관리 시스템을 종료하시겠습니까?");
				if(ans == 0) System.exit(0);
			}
		});
	}
	protected void NumBtnCheck(int i) {
		if(txtInput.getText().length() >= 4) {
			JOptionPane.showMessageDialog(null, "비밀번호는 4자리입니다. 다시 입력해주세요");
			txtInput.setText(null);
		}
		else {
			txtInput.setText(txtInput.getText()+i);
		}
	}
	public static void main(String[] args) {
		new MallLoginAdmin();
	}
}
