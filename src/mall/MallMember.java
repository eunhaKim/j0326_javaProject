package mall;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MallMember extends JFrame{
	private RoundedButton btnMember, btnProduct, btnOrder, btnLogout, btnExit, btnJoin, btnPic;
	private NumberButton btnCondition, btnDelete1, btnDelete2, btnModify;
	private JButton btnGreen;
	private JPanel pn1, pn2, pn2_1,pn2_2;
	private JTextField txtCondition;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblImage, lblJoinPic, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12;
	private JTextField txtId, txtPwd, txtName, txtTel, txtAddr, txtDate, txtPoint, textId, textPwd, textName, textTel, textAddr;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private final ButtonGroup buttonGroupGender2 = new ButtonGroup();
	private Vector title, vData;
	private JComboBox cbCondition;
	private JFileChooser chooser;
	
	private MemberDao dao = new MemberDao();
	private MemberVo vo = null;
	private DefaultTableModel dtm;
	int res=0;
	
	public MallMember() {
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
		lbLogo.setIcon(new ImageIcon(MallMember.class.getResource("/img/logo.png")));
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
		pn2_1.setBounds(8, 56, 516, 115);
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
		scrollPane.setBounds(0, 0, 516, 113);
		pn2_1.add(scrollPane);
		
		pn2_2 = new JPanel();
		pn2_2.setBackground(Color.WHITE);
		pn2_2.setBounds(8, 267, 517, 132);
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
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/member.jpg"));
		lblImage.setBounds(13, 15, 106, 106);
		pn2_2.add(lblImage);
		
		txtId = new JTextField();
		txtId.setEditable(false);
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
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(379, 72, 96, 21);
		pn2_2.add(txtDate);
		
		lblNewLabel_9 = new JLabel("포인트");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(320, 98, 60, 15);
		pn2_2.add(lblNewLabel_9);
		
		txtPoint = new JTextField();
		txtPoint.setEditable(false);
		txtPoint.setColumns(10);
		txtPoint.setBounds(379, 95, 96, 21);
		pn2_2.add(txtPoint);
		
		JRadioButton rFemale = new JRadioButton("여자");
		rFemale.setSelected(true);
		rFemale.setBackground(Color.WHITE);
		rFemale.setBounds(201, 96, 56, 23);
		buttonGroupGender2.add(rFemale);
		pn2_2.add(rFemale);
		
		JRadioButton rMale = new JRadioButton("남자");
		rMale.setBackground(Color.WHITE);
		rMale.setBounds(252, 96, 60, 23);
		buttonGroupGender2.add(rMale);
		pn2_2.add(rMale);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cbCondition.setBackground(new Color(255, 255, 255));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "연락처"}));
		cbCondition.setBounds(7, 22, 90, 23);
		pn2.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(102, 22, 211, 24);
		pn2.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new NumberButton("검색");
		btnCondition.setText("검색");
		btnCondition.setForeground(Color.WHITE);
		btnCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCondition.setBackground(new Color(4, 73, 150));
		btnCondition.setBounds(318, 22, 82, 24);
		pn2.add(btnCondition);
		
		btnDelete1 = new NumberButton("선택회원 삭제");
		btnDelete1.setText("선택회원 삭제");
		btnDelete1.setForeground(Color.WHITE);
		btnDelete1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete1.setBackground(new Color(19, 137, 201));
		btnDelete1.setBounds(405, 22, 118, 24);
		pn2.add(btnDelete1);
		
		lblNewLabel = new JLabel("선택된 회원정보");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(MallMember.class.getResource("/img/icoMember.png")));
		lblNewLabel.setBounds(11, 244, 135, 15);
		pn2.add(lblNewLabel);
		
		lblNewLabel_10 = new JLabel("회원등록");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_10.setIcon(new ImageIcon(MallMember.class.getResource("/img/icoMember.png")));
		lblNewLabel_10.setBounds(543, 26, 135, 15);
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
		pn2_2_1.setBounds(535, 56, 240, 342);
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
		
		lblJoinPic = new JLabel("");
		lblJoinPic.setIcon(new ImageIcon(MallMember.class.getResource("/img/imgMember.jpg")));
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
		
		btnPic = new RoundedButton("사진등록");
		btnPic.setText("사진등록");
		btnPic.setForeground(Color.WHITE);
		btnPic.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPic.setBackground(new Color(4, 73, 150));
		btnPic.setBounds(31, 23, 68, 23);
		pn2_2_1.add(btnPic);
		
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
		btnJoin.setBounds(12, 291, 218, 34);
		pn2_2_1.add(btnJoin);
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnJoin.setText("회원등록");
		btnJoin.setForeground(Color.WHITE);
		btnJoin.setBackground(new Color(4, 73, 150));
		
		btnGreen = new JButton("");
		btnGreen.setIcon(new ImageIcon(MallMember.class.getResource("/img/bnr.gif")));
		btnGreen.setBounds(9, 180, 515, 44);
		pn2.add(btnGreen);
		
		
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setResizable(false);
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
					if(data.getValueAt(row, 5).equals("여자")) rFemale.setSelected(true);
					else rMale.setSelected(true);
					txtTel.setText((String)data.getValueAt(row, 6));
					txtAddr.setText((String)data.getValueAt(row, 7));
					txtDate.setText((String)data.getValueAt(row, 8));
					txtPoint.setText(data.getValueAt(row, 9).toString());
					
					// Jtable 클릭시 그림파일의 정보를 레이블에 뿌려주기(그림 보여주기)
					String image = (String)data.getValueAt(row, 1);
					lblImage.setIcon(new ImageIcon(image));
					ImageIcon icon = new ImageIcon(image);
					Image img = icon.getImage();
					Image updateImg = img.getScaledInstance(106, 106, Image.SCALE_SMOOTH);
					
					ImageIcon updateIcon = new ImageIcon(updateImg);	// 변경된 크기의 이미지로 다시 생성..
					
					lblImage.setIcon(updateIcon);		// 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
					lblImage.setText(image);
				}
				// if (e.getClickCount() == 2) { } // 더블클릭    
				// if (e.getButton() == 3) { } // 오른쪽 클릭
			}
		});
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
		// 그린 링크 버튼
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
              URI uri = new URI("https://cheongju.greenart.co.kr/");
              desktop.browse(uri);
          } catch (IOException ex) {
              ex.printStackTrace();
          } catch (URISyntaxException ex) {
              ex.printStackTrace();
          }
				}
			}
		});
		
		// 선택회원 삭제버튼1
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int idx = (int) table.getValueAt(row, 0);
				int ans = JOptionPane.showConfirmDialog(null, "선택한 회원을 삭제 하시겠습니까?","선택회원 삭제창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setDeleteMember(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 삭제완료!!");
						dispose();
						new MallMember();
					}
					else JOptionPane.showMessageDialog(null, "삭제된 회원이 없습니다!!");
				}
			}
		});
		// 선택한 회원 수정
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText().trim();
				String pwd = txtPwd.getText().trim();
				String name = txtName.getText().trim();
				
				String gender = "";
				if(rMale.isSelected()) gender = "남자";
				else gender = "여자";

				String tel = txtTel.getText().trim();
				String addr = txtAddr.getText().trim();
				
				// 유효성 검사
				if(id.equals("")){
					JOptionPane.showMessageDialog(null, "선택된 회원이 없습니다. 회원 테이블에서 선택해주세요.");
				}
				else if(!Pattern.matches("^[\\w~!@#$%^&*()+-=]{4,}$", pwd)) { // 영문 숫자 키보드숫자특문 조합허용 6자이상
					JOptionPane.showMessageDialog(null, "비밀번호는 영문 숫자 키보드숫자특문 조합허용 4자이상 입력하세요");
					txtPwd.setText("");
					txtPwd.requestFocus();
				}
				else if(!Pattern.matches("^[a-zA-Z가-힣]+$", name)) { // 한글영어만허용 1자이상
					JOptionPane.showMessageDialog(null, "이름은 한글영어만허용 1자이상 입력하세요");
					txtName.setText("");
					txtName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+-[0-9]+-[0-9]+$", tel)) { 
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요.(중간에 '-' 구분자 넣어주세요.)");
					txtTel.setText("");
					txtTel.requestFocus();
				}
				else if(!Pattern.matches("^[\\w-가-힣]+$", addr)) {
					JOptionPane.showMessageDialog(null, "올바른 주소를 입력해주세요.");
					txtAddr.setText("");
					txtAddr.requestFocus();
				}
				else {
					
					
					// 모든 체크가 끝나면 DB에 수정처리한다.
					vo = new MemberVo();
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setName(name);
					vo.setGender(gender);
					vo.setTel(tel);
					vo.setAddr(addr);
					res = dao.setMemberUpdate(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
						dispose();
						new MallMember();
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 수정이 실패입니다.");
						txtId.requestFocus();
					}
						
					
				}
			}
		});
		// 선택회원 삭제버튼2
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int idx = (int) table.getValueAt(row, 0);
				int ans = JOptionPane.showConfirmDialog(null, "선택한 회원을 삭제 하시겠습니까?","선택회원 삭제창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setDeleteMember(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 삭제완료!!");
						dispose();
						new MallMember();
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
		// 회원가입
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pic = "";
				if(!lblJoinPic.getText().trim().equals("")) pic = lblJoinPic.getText().trim();
				else pic = "images/member.jpg";
				System.out.println("pic : "+pic);
				
				String id = textId.getText().trim();
				String pwd = textPwd.getText().trim();
				String name = textName.getText().trim();
				String gender = "여자";
				String tel = textTel.getText().trim();
				String addr = textAddr.getText().trim();
				
				// 유효성 검사
				if(!Pattern.matches("^[\\w]{4,}$", id)) { // 영문 숫자 '-,_' 조합 허용 4자이상
					JOptionPane.showMessageDialog(null, "아이디는 영문 숫자 '-,_' 조합 허용 4자이상 가능합니다.");
					textId.setText("");
					textId.requestFocus();
				}
				else if(!Pattern.matches("^[\\w~!@#$%^&*()+-=]{4,}$", pwd)) { // 영문 숫자 키보드숫자특문 조합허용 6자이상
					JOptionPane.showMessageDialog(null, "비밀번호는 영문 숫자 키보드숫자특문 조합허용 4자이상 입력하세요");
					textPwd.setText("");
					textPwd.requestFocus();
				}
				else if(!Pattern.matches("^[a-zA-Z가-힣]+$", name)) { // 한글영어만허용 1자이상
					JOptionPane.showMessageDialog(null, "이름은 한글영어만허용 1자이상 입력하세요");
					textName.setText("");
					textName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+-[0-9]+-[0-9]+$", tel)) { 
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요.(중간에 '-' 구분자 넣어주세요.)");
					textTel.setText("");
					textTel.requestFocus();
				}
				else if(!Pattern.matches("^[\\w-가-힣]+$", addr)) {
					JOptionPane.showMessageDialog(null, "올바른 주소를 입력해주세요.");
					textAddr.setText("");
					textAddr.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
					// 아이디 중복처리
					vo = dao.getIdSearch(id);
					if(vo.getId() != null) {
						JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다. 다시 입력해주세요.");
						textId.setText("");
						textId.requestFocus();
					}
					else {
						vo.setPic(pic);
						vo.setId(id);
						vo.setPwd(pwd);
						vo.setName(name);
						vo.setGender(gender);
						vo.setTel(tel);
						vo.setAddr(addr);
						
						res = dao.setMemberInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
							dispose();
							new MallMember();
						}
						else {
							JOptionPane.showMessageDialog(null, "회원에 가입실패입니다. 다시 가입해주세요.");
							textId.requestFocus();
						}
						
					}
				}
			}
		});
		// 회원가입시 사진등록
		btnPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 생성
				chooser = new JFileChooser();
				
				// 파일 확장자 선별 출력처리..
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF & PNG Images", "jpg","gif","png","jpeg");
				chooser.setFileFilter(filter);
				
				// 파일 다이얼로그박스 출력처리
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) { // 사용자가 화일을 선택하지않고 창을 닫거나 취소한경우..
					JOptionPane.showInternalMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				}
				else { // 사용자가 파일을 선택하고 열기 버튼을 누른경우
					String filePath = chooser.getSelectedFile().getPath();
					lblJoinPic.setIcon(new ImageIcon(filePath));
					ImageIcon icon = new ImageIcon(filePath);
					Image img = icon.getImage();
					Image updateImg = img.getScaledInstance(98, 74, Image.SCALE_SMOOTH);
					
					ImageIcon updateIcon = new ImageIcon(updateImg);	// 변경된 크기의 이미지로 다시 생성..
					
					lblJoinPic.setIcon(updateIcon);		// 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
					
					// 파일 업로드
					try {
						File imageFile = new File(filePath);		// 업로드 되는 파일의 위치정보+파일명
						// String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);	// 파일명+확장자
						String fileName = System.nanoTime()+filePath.substring(filePath.lastIndexOf("."));	// 파일명(나노타임)+확장자
						String extension = filePath.substring(filePath.lastIndexOf(".")+1);	// 확장자
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("images/" + fileName);	// 서버에 저장되는 폴더+파일명
						if(!file.exists()) file.mkdir();	// 폴더가 존재하지않으면 폴더를 만들어준다.
						
						ImageIO.write(image, extension, file);	// images를 file로 업로드시켜준다.
						//System.out.println("파일명 : " + fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
						lblJoinPic.setText("images/" + fileName); // 복사된 이미지 위치를 넣어준다.
					
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		});
	
	}
	
	// 조건검색
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
		new MallMember();
	}
}
