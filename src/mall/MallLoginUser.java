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

public class MallLoginUser extends JFrame{
	private static final Border red = null;
	private NumberButton btnReset, btnExit, btnLogin;
	private RoundedButton btnAdminLogin, btnUserLogin;
	private JTextField txtId, txtPwd;
	private JLabel lbId,lbPwd,line1,line3,line2;
	
	
	public MallLoginUser() {
		super("관리자로그인");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(800,500);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 392, 500);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnAdminLogin = new RoundedButton("관리자 로그인");
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(163, 163, 163));
		btnAdminLogin.setBounds(100, 344, 97, 23);
		pn1.add(btnAdminLogin);
		
		
		btnUserLogin = new RoundedButton("사용자 로그인");
		btnUserLogin.setEnabled(false);
		btnUserLogin.setText("사용자 로그인");
		btnUserLogin.setForeground(new Color(255, 255, 255));
		btnUserLogin.setBackground(new Color(125, 181, 44));
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
		lblBg.setIcon(new ImageIcon(MallLoginUser.class.getResource("/img/loginBg.jpg")));
		lblBg.setBounds(0, 0, 389, 463);
		pn1.add(lblBg);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(391, 0, 395, 463);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		line2 = new JLabel("");
		line2.setIcon(new ImageIcon(MallLoginUser.class.getResource("/img/line.jpg")));
		line2.setBounds(-2, 174, 397, 21);
		pn2.add(line2);
		
		line3 = new JLabel("");
		line3.setIcon(new ImageIcon(MallLoginUser.class.getResource("/img/arrowLine.jpg")));
		line3.setBounds(-2, 266, 397, 21);
		pn2.add(line3);
		
		line1 = new JLabel("");
		line1.setIcon(new ImageIcon(MallLoginUser.class.getResource("/img/arrowLine.jpg")));
		line1.setBounds(-3, 87, 397, 21);
		pn2.add(line1);
		
		btnReset = new NumberButton("0");
		btnReset.setText("다시입력");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("굴림", Font.BOLD, 16));
		btnReset.setBackground(new Color(4, 73, 150));
		btnReset.setBounds(129, 374, 133, 87);
		pn2.add(btnReset);
		
		btnExit = new NumberButton("종료");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("굴림", Font.BOLD, 16));
		btnExit.setBackground(new Color(19, 137, 201));
		btnExit.setBounds(-3, 374, 133, 87);
		pn2.add(btnExit);
		
		btnLogin = new NumberButton("접속");
		
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("굴림", Font.BOLD, 16));
		btnLogin.setBackground(new Color(125, 181, 44));
		btnLogin.setBounds(261, 374, 133, 87);
		pn2.add(btnLogin);
		
		txtId = new JTextField();
		txtId.setForeground(new Color(0, 0, 160));
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setFont(new Font("굴림", Font.PLAIN, 28));
		txtId.setBounds(2, 92, 393, 87);
		txtId.setBorder(new EmptyBorder(5,3,5,3));
		pn2.add(txtId);
		txtId.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setHorizontalAlignment(SwingConstants.CENTER);
		txtPwd.setForeground(new Color(0, 0, 160));
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 28));
		txtPwd.setColumns(10);
		txtPwd.setBorder(new EmptyBorder(5,3,5,3));
		txtPwd.setBounds(1, 270, 393, 94);
		pn2.add(txtPwd);
		
		lbId = new JLabel("아이디");
		lbId.setForeground(new Color(4, 73, 150));
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lbId.setBounds(12, 26, 375, 41);
		pn2.add(lbId);
		
		lbPwd = new JLabel("비밀번호");
		lbPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lbPwd.setForeground(new Color(4, 73, 150));
		lbPwd.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lbPwd.setBounds(14, 205, 375, 41);
		pn2.add(lbPwd);
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ----------------------------------------------------------
		
		// 어드민 로그인 버튼
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallLoginAdmin();
			}
		});
		// 사용자 로그인 버튼
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText(null);
				txtPwd.setText(null);
			}
		});
		// 접속하기 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	
	public static void main(String[] args) {
		new MallLoginUser();
	}
}
