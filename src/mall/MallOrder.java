package mall;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MallOrder extends JFrame{
	private JLabel lbLogo;
	private RoundedButton btnMember, btnProduct, btnOrder;
	private RoundedButton btnExit, btnLogout;
	
	public MallOrder() {
		super("주문관리 페이지");
		getContentPane().setBackground(new Color(4, 73, 150));
		setSize(800,500);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 786, 49);
		getContentPane().add(pn1);
		
		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(MallMain.class.getResource("/img/logo.png")));
		lbLogo.setBounds(10, 10, 133, 29);
		pn1.add(lbLogo);
		
		btnMember = new RoundedButton("회원관리");
		btnMember.setText("회원관리");
		btnMember.setForeground(Color.BLACK);
		btnMember.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnMember.setBackground(Color.WHITE);
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
		btnOrder.setForeground(Color.BLACK);
		btnOrder.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setBounds(366, 14, 97, 23);
		pn1.add(btnOrder);
		
		btnExit = new RoundedButton("종료");
		btnExit.setText("종료");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnExit.setBackground(new Color(4, 73, 150));
		btnExit.setBounds(705, 15, 68, 23);
		pn1.add(btnExit);
		
		btnLogout = new RoundedButton("로그아웃");
		btnLogout.setText("로그아웃");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLogout.setBackground(new Color(163, 163, 163));
		btnLogout.setBounds(629, 15, 68, 23);
		pn1.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 786, 415);
		getContentPane().add(panel);
		
		
// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
// ----------------------------------------------------------
		// 로고 누르면 메인으로 이동
		lbLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MallMain();
			}
		});
		// 회원관리 버튼
		btnMember.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MallMember();
			}
		});
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallMember();
			}
		});
		// 재고관리 버튼
		btnProduct.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MallProduct();
			}
		});
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallProduct();
			}
		});
		// 주문관리 버튼
		btnOrder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MallOrder();
			}
		});
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallOrder();
			}
		});		
		// 로그아웃
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?","로그아웃창",JOptionPane.YES_NO_OPTION);
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
				int ans = JOptionPane.showConfirmDialog(null, "쇼핑몰 관리 시스템을 종료하시겠습니까?","시스템 종료창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MallOrder();
	}
}
