package homework;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MartMain extends JFrame{
	private final JPanel pn1 = new JPanel();
	JButton btnJoin, btnLogin, btnList, btnSearch, btnExit;
	
	public MartMain() {
		super("마트메인페이지");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(600,400);
		
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setLayout(null);
		pn2.setBounds(0, 40, 586, 282);
		getContentPane().add(pn2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MartMain.class.getResource("/img/membership.jpg")));
		lblNewLabel.setBounds(0, 0, 586, 282);
		pn2.add(lblNewLabel);
		pn1.setBackground(new Color(0, 0, 0));
		pn1.setBounds(0, 0, 586, 41);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel martName = new JLabel("멤버쉽");
		martName.setForeground(new Color(255, 255, 255));
		martName.setHorizontalAlignment(SwingConstants.CENTER);
		martName.setFont(new Font("나눔고딕", Font.BOLD, 18));
		martName.setBounds(41, 10, 499, 21);
		pn1.add(martName);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(0, 0, 0));
		pn3.setLayout(null);
		pn3.setBounds(0, 322, 586, 41);
		getContentPane().add(pn3);
		
		btnJoin = new JButton("회원가입");
		btnJoin.setBounds(22, 10, 87, 23);
		pn3.add(btnJoin);
		
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(131, 10, 73, 23);
		pn3.add(btnLogin);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(472, 10, 87, 23);
		pn3.add(btnExit);
		
		btnList = new JButton("회원리스트");
		btnList.setBounds(226, 10, 115, 23);
		pn3.add(btnList);
		
		btnSearch = new JButton("회원검색");
		btnSearch.setBounds(363, 10, 87, 23);
		pn3.add(btnSearch);
		
		// ----------------------------위쪽은 UI--------------------------------
		setLocationRelativeTo(null); // 윈도우창 가운데 정렬
		setResizable(false); // 윈도우창 사이즈 조정 안되게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------아래쪽은 메소드----------------------------
		
		// 회원가입버튼
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberJoin();
			}
		});
		// 로그인버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// 회원리스트 조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// 회원검색
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 회원 이름을 입력하세요.");
			}
		});
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MartMain();
	}
}
