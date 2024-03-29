package mall;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MallMain extends JFrame{
	private RoundedButton btnMember, btnProduct, btnOrder, btnLogout, btnExit, btnJoin;
	private NumberButton btnCondition, btnDelete1, btnDelete2, btnModify;
	private JPanel pn1, pn2, pn2_1,pn2_2;
	private JTextField txtCondition;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12;
	private JTextField txtId, txtPwd, txtName, txtGender, txtTel, txtAddr, txtDate, txtPoint, textId, textPwd, textName, textTel, textAddr;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private Vector title, vData;
	private JComboBox cbCondition;
	
	MallDao dao = new MallDao();
	private DefaultTableModel dtm;
	int res=0;
	
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
		
		// JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("사진주소");
		title.add("아이디");
		title.add("비번");
		title.add("이름");
		title.add("성별");
		title.add("연락처");
		title.add("주소");
		title.add("가입일");
		title.add("포인트");
		
		vData = dao.getMemberList();
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter(dtm));
		table.setBackground(new Color(255, 255, 255));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 516, 178);
		pn2_1.add(scrollPane);
		
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
		
		lblNewLabel_4 = new JLabel("성별");
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
		
		txtGender = new JTextField();
		txtGender.setColumns(10);
		txtGender.setBounds(201, 95, 96, 21);
		pn2_2.add(txtGender);
		
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
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cbCondition.setBackground(new Color(255, 255, 255));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "연락처"}));
		cbCondition.setBounds(7, 27, 90, 23);
		pn2.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(102, 27, 211, 24);
		pn2.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new NumberButton("검색");
		btnCondition.setText("검색");
		btnCondition.setForeground(Color.WHITE);
		btnCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCondition.setBackground(new Color(4, 73, 150));
		btnCondition.setBounds(318, 27, 82, 24);
		pn2.add(btnCondition);
		
		btnDelete1 = new NumberButton("선택회원 삭제");
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
		
		btnDelete2 = new NumberButton("선택회원 삭제");
		btnDelete2.setText("선택회원 삭제");
		btnDelete2.setForeground(Color.WHITE);
		btnDelete2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete2.setBackground(new Color(19, 137, 201));
		btnDelete2.setBounds(405, 239, 118, 24);
		pn2.add(btnDelete2);
		
		btnModify = new NumberButton("수정");
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
		
		JLabel lblNewLabel_4_1 = new JLabel("성별");
		lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(39, 172, 60, 15);
		pn2_2_1.add(lblNewLabel_4_1);
		
		JLabel lblJoinPic = new JLabel("");
		lblJoinPic.setIcon(new ImageIcon(MallMain.class.getResource("/img/imgMember.jpg")));
		lblJoinPic.setBounds(103, 23, 96, 73);
		pn2_2_1.add(lblJoinPic);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(103, 100, 96, 21);
		pn2_2_1.add(textId);
		
		textPwd = new JTextField();
		textPwd.setColumns(10);
		textPwd.setBounds(103, 123, 96, 21);
		pn2_2_1.add(textPwd);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(103, 146, 96, 21);
		pn2_2_1.add(textName);
		
		lblNewLabel_11 = new JLabel("연락처");
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(39, 196, 46, 15);
		pn2_2_1.add(lblNewLabel_11);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(104, 192, 96, 21);
		pn2_2_1.add(textTel);
		
		lblNewLabel_12 = new JLabel("주소");
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(39, 218, 60, 15);
		pn2_2_1.add(lblNewLabel_12);
		
		textAddr = new JTextField();
		textAddr.setColumns(10);
		textAddr.setBounds(104, 215, 96, 21);
		pn2_2_1.add(textAddr);
		
		RoundedButton btnPic = new RoundedButton("종료");
		btnPic.setText("사진등록");
		btnPic.setForeground(Color.WHITE);
		btnPic.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPic.setBackground(new Color(4, 73, 150));
		btnPic.setBounds(31, 23, 68, 23);
		pn2_2_1.add(btnPic);
		
		RoundedButton btnPicDel = new RoundedButton("종료");
		btnPicDel.setText("사진삭제");
		btnPicDel.setForeground(Color.WHITE);
		btnPicDel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPicDel.setBackground(new Color(192, 192, 192));
		btnPicDel.setBounds(31, 52, 68, 23);
		pn2_2_1.add(btnPicDel);
		
		JRadioButton rdMale = new JRadioButton("남자");
		rdMale.setBackground(new Color(255, 255, 255));
		buttonGroupGender.add(rdMale);
		rdMale.setBounds(154, 169, 60, 23);
		pn2_2_1.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		rdFemale.setBackground(new Color(255, 255, 255));
		buttonGroupGender.add(rdFemale);
		rdFemale.setSelected(true);
		rdFemale.setBounds(103, 169, 56, 23);
		pn2_2_1.add(rdFemale);
		
		btnJoin = new RoundedButton("회원등록");
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
		// 회원테이블에서 행 선택시 아래 선택정보 표시
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {  //클릭    
					int row = table.getSelectedRow();
					// 테이블의 모델객체 얻어오기
					TableModel data = table.getModel();
					// 선택한 테이블의 row의 값들을 아래에 출력
					txtId.setText((String)data.getValueAt(row, 2));
					txtPwd.setText((String)data.getValueAt(row, 3));
					txtName.setText((String)data.getValueAt(row, 4));
					txtGender.setText((String)data.getValueAt(row, 5));
					txtTel.setText((String)data.getValueAt(row, 6));
					txtAddr.setText((String)data.getValueAt(row, 7));
					txtDate.setText((String)data.getValueAt(row, 8));
					txtPoint.setText(data.getValueAt(row, 9).toString());
				}
				// if (e.getClickCount() == 2) { } // 더블클릭    
				// if (e.getButton() == 3) { } // 오른쪽 클릭
			}
		});
		
		// 회원관리 버튼
		btnMember.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
				new MallMain();
			}
		});
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MallMain();
			}
		});
		// 선택회원 삭제버튼1
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int idx = (int) table.getValueAt(row, 0);
				int ans = JOptionPane.showConfirmDialog(null, "선택한 회원을 삭제 하시겠습니까?");
				if(ans == 0) {
					res = dao.setDeleteMember(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 삭제완료!!");
						dispose();
						new MallMain();
					}
					else JOptionPane.showMessageDialog(null, "삭제된 회원이 없습니다!!");
				}
			}
		});
		// 선택한 회원 수정
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "아직 작업중");
			}
		});
		// 선택회원 삭제버튼2
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int idx = (int) table.getValueAt(row, 0);
				int ans = JOptionPane.showConfirmDialog(null, "선택한 회원을 삭제 하시겠습니까?");
				if(ans == 0) {
					res = dao.setDeleteMember(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 삭제완료!!");
						dispose();
						new MallMain();
					}
					else JOptionPane.showMessageDialog(null, "삭제된 회원이 없습니다!!");
				}
			}
		});
		// 조건검색
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionSearch();
			}
		});
		btnCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				conditionSearch();
			}
		});
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
		
		// 회원가입
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textId.getText().trim();
				System.out.println(id);
				
//				String pwd = textPwd.getText().trim();
//				String name = textName.getText().trim();
//				String gender = "";
//				String tel = textTel.getText().trim();
//				String addr = textAddr.getText().trim();
				
				// 유효성 검사
				if(!Pattern.matches("^\\w+$", id)) {
					JOptionPane.showMessageDialog(null, "아이디는 영어,숫자,언더바(_)만 가능합니다.");
					textId.setText("");
					textId.requestFocus();
				}
				else {
					if(id.length()>11) {
						JOptionPane.showMessageDialog(null, "아이디는 10자리까지만 가능합니다.");
						textId.setText("");
						textId.requestFocus();
					}
					else JOptionPane.showMessageDialog(null, "이아이디는 사용가능합니다.");
				}
			}
		});
		
	}
	
	protected void conditionSearch() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(cbCondi.trim().equals("")) {
			JOptionPane.showInternalMessageDialog(null, "검색할 내용을 입력하세요");
			txtCondition.requestFocus();
			return;
		}
		if(cbCondi.equals("이름")) vData = dao.getConditionSearch("name",txtCondi);
		else if(cbCondi.equals("주소")) vData = dao.getConditionSearch("addr",txtCondi);
		else vData = dao.getConditionSearch("tel",txtCondi);
		
		if(vData.size() == 0) JOptionPane.showMessageDialog(null, "검색된 회원이 없습니다.");
		else dtm.setDataVector(vData, title);
		
	}

	public static void main(String[] args) {
		new MallMain();
	}
}
