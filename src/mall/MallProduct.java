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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class MallProduct extends JFrame{
	private RoundedButton btnMember, btnProduct, btnOrder, btnLogout, btnExit, btnJoin, btnPic;
	private NumberButton btnCondition, btnDelete1, btnDelete2, btnModify, btnPic2;
	private JButton btnGreen;
	private JPanel pn1, pn2, pn2_1,pn2_2;
	private JTextField txtCondition;
	private JTable table;
	private JEditorPane txtPInfo;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblImage, lblJoinPic, lblNewLabel_6, lblNewLabel_10;
	private JTextField txtPName, txtPCnt, txtPPrice, textPName, textPCnt, textPPrice;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private final ButtonGroup buttonGroupGender2 = new ButtonGroup();
	private Vector title, vData;
	private JComboBox cbCondition;
	private JFileChooser chooser;
	
	ProductDao dao = new ProductDao();
	private DefaultTableModel dtm;
	private ProductVo vo = null;
	int res=0;
	private JScrollPane scrollPane_2;
	private JTextField txtPIdx;
	
	public MallProduct() {
		super("쇼핑몰 재고관리");
		getContentPane().setBackground(new Color(4, 73, 150));
		setSize(800,500);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(0, 4, 786, 49);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(MallProduct.class.getResource("/img/logo.png")));
		lbLogo.setBounds(10, 10, 133, 29);
		pn1.add(lbLogo);
		
		btnMember = new RoundedButton("회원관리");
		btnMember.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnMember.setText("회원관리");
		btnMember.setForeground(new Color(0, 0, 0));
		btnMember.setBackground(new Color(255, 255, 255));
		btnMember.setBounds(167, 14, 97, 23);
		pn1.add(btnMember);
		
		btnProduct = new RoundedButton("재고관리");
		btnProduct.setText("재고관리");
		btnProduct.setForeground(new Color(4, 73, 150));
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
		pn2_1.setBounds(258, 60, 516, 115);
		pn2.add(pn2_1);
		pn2_1.setLayout(null);
		
		// JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("사진주소");
		title.add("상품명");
		title.add("재고량");
		title.add("단가");
		title.add("상세정보");
		
		vData = dao.getProductList();
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter(dtm));
		table.setBackground(new Color(255, 255, 255));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 516, 113);
		pn2_1.add(scrollPane);
		
		pn2_2 = new JPanel();
		pn2_2.setBackground(Color.WHITE);
		pn2_2.setBounds(257, 269, 517, 132);
		pn2.add(pn2_2);
		pn2_2.setLayout(null);
		
		btnPic2 = new NumberButton("사진수정");
		btnPic2.setForeground(new Color(255, 255, 255));
		btnPic2.setBackground(new Color(19, 137, 201));
		btnPic2.setBounds(13, 98, 106, 23);
		pn2_2.add(btnPic2);
		
		lblNewLabel_1 = new JLabel("상품명");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(141, 58, 46, 15);
		pn2_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("재고량");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(141, 80, 60, 15);
		pn2_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("단가");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(141, 103, 60, 15);
		pn2_2.add(lblNewLabel_3);
		
		lblImage = new JLabel("");
		lblImage.setBackground(new Color(192, 192, 192));
		lblImage.setIcon(new ImageIcon("pImages/product.jpg"));
		lblImage.setBounds(13, 15, 106, 106);
		pn2_2.add(lblImage);
		
		txtPName = new JTextField();
		txtPName.setBounds(200, 54, 96, 21);
		pn2_2.add(txtPName);
		txtPName.setColumns(10);
		
		txtPCnt = new JTextField();
		txtPCnt.setColumns(10);
		txtPCnt.setBounds(200, 77, 96, 21);
		pn2_2.add(txtPCnt);
		
		txtPPrice = new JTextField();
		txtPPrice.setColumns(10);
		txtPPrice.setBounds(200, 100, 96, 21);
		pn2_2.add(txtPPrice);
		
		lblNewLabel_6 = new JLabel("제품 상세정보");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(320, 30, 187, 15);
		pn2_2.add(lblNewLabel_6);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(319, 51, 188, 70);
		pn2_2.add(scrollPane_2);
		
		txtPInfo = new JEditorPane();
		scrollPane_2.setViewportView(txtPInfo);
		
		txtPIdx = new JTextField();
		txtPIdx.setEditable(false);
		txtPIdx.setColumns(10);
		txtPIdx.setBounds(200, 31, 96, 21);
		pn2_2.add(txtPIdx);
		
		JLabel lblNewLabel_1_2 = new JLabel("번호");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(141, 35, 46, 15);
		pn2_2.add(lblNewLabel_1_2);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cbCondition.setBackground(new Color(255, 255, 255));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"상품명", "상세정보"}));
		cbCondition.setBounds(257, 26, 90, 23);
		pn2.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBounds(352, 26, 211, 24);
		pn2.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new NumberButton("검색");
		btnCondition.setText("검색");
		btnCondition.setForeground(Color.WHITE);
		btnCondition.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCondition.setBackground(new Color(4, 73, 150));
		btnCondition.setBounds(568, 26, 82, 24);
		pn2.add(btnCondition);
		
		btnDelete1 = new NumberButton("선택회원 삭제");
		btnDelete1.setText("선택상품 삭제");
		btnDelete1.setForeground(Color.WHITE);
		btnDelete1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete1.setBackground(new Color(19, 137, 201));
		btnDelete1.setBounds(655, 26, 118, 24);
		pn2.add(btnDelete1);
		
		lblNewLabel = new JLabel("선택된 상품정보");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(MallProduct.class.getResource("/img/icoMember.png")));
		lblNewLabel.setBounds(258, 246, 135, 15);
		pn2.add(lblNewLabel);
		
		lblNewLabel_10 = new JLabel("상품등록");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_10.setIcon(new ImageIcon(MallProduct.class.getResource("/img/icoMember.png")));
		lblNewLabel_10.setBounds(21, 30, 135, 15);
		pn2.add(lblNewLabel_10);
		
		btnDelete2 = new NumberButton("선택회원 삭제");
		btnDelete2.setText("선택상품 삭제");
		btnDelete2.setForeground(Color.WHITE);
		btnDelete2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete2.setBackground(new Color(19, 137, 201));
		btnDelete2.setBounds(654, 241, 118, 24);
		pn2.add(btnDelete2);
		
		btnModify = new NumberButton("수정");
		btnModify.setText("수정");
		btnModify.setForeground(Color.WHITE);
		btnModify.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnModify.setBackground(new Color(4, 73, 150));
		btnModify.setBounds(567, 241, 82, 24);
		pn2.add(btnModify);
		
		btnGreen = new JButton("");
		btnGreen.setIcon(new ImageIcon(MallProduct.class.getResource("/img/bnr.gif")));
		btnGreen.setBounds(259, 185, 515, 44);
		pn2.add(btnGreen);
		
		JPanel pn2_2_1 = new JPanel();
		pn2_2_1.setBounds(10, 59, 240, 342);
		pn2.add(pn2_2_1);
		pn2_2_1.setLayout(null);
		pn2_2_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("상품명");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(39, 104, 46, 15);
		pn2_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("재고량");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(39, 126, 60, 15);
		pn2_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("단가");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(39, 150, 60, 15);
		pn2_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("상세정보를 입력해주세요.");
		lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(39, 176, 160, 15);
		pn2_2_1.add(lblNewLabel_4_1);
		
		lblJoinPic = new JLabel("");
		lblJoinPic.setIcon(new ImageIcon(MallProduct.class.getResource("/img/imgProduct.jpg")));
		lblJoinPic.setBounds(103, 23, 96, 73);
		pn2_2_1.add(lblJoinPic);
		
		textPName = new JTextField();
		textPName.setColumns(10);
		textPName.setBounds(103, 100, 96, 21);
		pn2_2_1.add(textPName);
		
		textPCnt = new JTextField();
		textPCnt.setColumns(10);
		textPCnt.setBounds(103, 123, 96, 21);
		pn2_2_1.add(textPCnt);
		
		textPPrice = new JTextField();
		textPPrice.setColumns(10);
		textPPrice.setBounds(103, 146, 96, 21);
		pn2_2_1.add(textPPrice);
		
		btnPic = new RoundedButton("사진등록");
		btnPic.setText("사진등록");
		btnPic.setForeground(Color.WHITE);
		btnPic.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPic.setBackground(new Color(4, 73, 150));
		btnPic.setBounds(31, 23, 68, 23);
		pn2_2_1.add(btnPic);
		
		btnJoin = new RoundedButton("회원등록");
		btnJoin.setBounds(12, 291, 218, 34);
		pn2_2_1.add(btnJoin);
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnJoin.setText("상품등록");
		btnJoin.setForeground(Color.WHITE);
		btnJoin.setBackground(new Color(4, 73, 150));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 197, 162, 81);
		pn2_2_1.add(scrollPane_1);
		
		JEditorPane textPInfo = new JEditorPane();
		scrollPane_1.setViewportView(textPInfo);
				
		
		
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ----------------------------------------------------------
		
		// 상품등록
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pPic = "";
				if(!lblJoinPic.getText().trim().equals("")) pPic = lblJoinPic.getText().trim();
				else pPic = "pImages/product.jpg";
				
				String pName = textPName.getText().trim();
				String pCnt = textPCnt.getText().trim();
				String pPrice = textPPrice.getText().trim();
				String pInfo = textPInfo.getText().trim();
				
				// 유효성 검사
				if(!Pattern.matches("^[\\w-가-힛\\s]{1,}$", pName)) { 
					JOptionPane.showMessageDialog(null, "상품명은 한글,영문,숫자 '-,_' 조합 허용 1자이상 가능합니다.");
					textPName.setText("");
					textPName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]{1,}$", pCnt)) { 
					JOptionPane.showMessageDialog(null, "재고량은 숫자만 입력하세요");
					textPCnt.setText("");
					textPCnt.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]{1,}$", pPrice)) { 
					JOptionPane.showMessageDialog(null, "단가는 숫자만 입력하세요");
					textPCnt.setText("");
					textPCnt.requestFocus();
				}
				else {
					// 모든 체크가 끝나면 DB에 새로운 상품을 등록처리한다.
					// 상품명 중복처리
					vo = dao.getPNameSearch(pName);
					if(vo.getpName() != null) {
						JOptionPane.showMessageDialog(null, "중복된 상품명이 있습니다. 다시 입력해주세요.");
						textPName.setText("");
						textPName.requestFocus();
					}
					else {
						vo.setpPic(pPic);
						vo.setpName(pName);
						vo.setpCnt(Integer.parseInt(pCnt));
						vo.setpPrice(Integer.parseInt(pPrice));								
						vo.setpInfo(pInfo);
						
						res = dao.setProductInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(null, "상품이 등록되었습니다.");
							dispose();
							new MallProduct();
						}
						else {
							JOptionPane.showMessageDialog(null, "상품등록 실패입니다. 다시 등록해주세요.");
							textPName.requestFocus();
						}
						
					}
				}
			}
		});
		
		// 상품등록시 사진등록
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
						File file = new File("pImages/" + fileName);	// 서버에 저장되는 폴더+파일명
						if(!file.exists()) file.mkdir();	// 폴더가 존재하지않으면 폴더를 만들어준다.
						
						ImageIO.write(image, extension, file);	// images를 file로 업로드시켜준다.
						//System.out.println("파일명 : " + fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
						lblJoinPic.setText("pImages/" + fileName); // 복사된 이미지 위치를 넣어준다.
					
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		});
		// 선택된 상품정보내 사진수정
		btnPic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblImage.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "선택된 상품이 없습니다.");
					return;
				}
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
					lblImage.setIcon(new ImageIcon(filePath));
					ImageIcon icon = new ImageIcon(filePath);
					Image img = icon.getImage();
					Image updateImg = img.getScaledInstance(106, 106, Image.SCALE_SMOOTH);
					
					ImageIcon updateIcon = new ImageIcon(updateImg);	// 변경된 크기의 이미지로 다시 생성..
					
					lblImage.setIcon(updateIcon);		// 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
					
					// 파일 업로드
					try {
						File imageFile = new File(filePath);		// 업로드 되는 파일의 위치정보+파일명
						// String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);	// 파일명+확장자
						String fileName = System.nanoTime()+filePath.substring(filePath.lastIndexOf("."));	// 파일명(나노타임)+확장자
						String extension = filePath.substring(filePath.lastIndexOf(".")+1);	// 확장자
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("pImages/" + fileName);	// 서버에 저장되는 폴더+파일명
						if(!file.exists()) file.mkdir();	// 폴더가 존재하지않으면 폴더를 만들어준다.
						
						ImageIO.write(image, extension, file);	// images를 file로 업로드시켜준다.
						//System.out.println("파일명 : " + fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
						lblImage.setText("pImages/" + fileName); // 복사된 이미지 위치를 넣어준다.
					
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		
		// 상품테이블에서 행 선택시 아래 선택정보 표시
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {  //클릭    
					int row = table.getSelectedRow();
					// 테이블의 모델객체 얻어오기
					TableModel data = table.getModel();
					// 선택한 테이블의 row의 값들을 아래에 출력
					txtPIdx.setText(data.getValueAt(row, 0).toString());
					txtPName.setText(data.getValueAt(row, 2).toString());
					txtPCnt.setText(data.getValueAt(row, 3).toString());
					txtPPrice.setText(data.getValueAt(row, 4).toString());
					txtPInfo.setText(data.getValueAt(row, 5).toString());
					
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
				int ans = JOptionPane.showConfirmDialog(null, "선택한 상품을 삭제 하시겠습니까?","선택상품 삭제창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setDeleteProduct(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "상품 삭제완료!!");
						dispose();
						new MallProduct();
					}
					else JOptionPane.showMessageDialog(null, "삭제된 상품이 없습니다!!");
				}
			}
		});
		// 선택한 회원 수정
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pPIdx = txtPIdx.getText().trim();				
				String pPic = lblImage.getText().trim();				
				String pName = txtPName.getText().trim();
				String pCnt = txtPCnt.getText().trim();
				String pPrice = txtPPrice.getText().trim();
				String pInfo = txtPInfo.getText().trim();
				
			// 유효성 검사
				if(!Pattern.matches("^[\\w-가-힛\\s]{1,}$", pName)) { 
					JOptionPane.showMessageDialog(null, "상품명은 한글,영문,숫자 '-,_' 조합 허용 1자이상 가능합니다.");
					textPName.setText("");
					textPName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]{1,}$", pCnt)) { 
					JOptionPane.showMessageDialog(null, "재고량은 숫자만 입력하세요");
					textPCnt.setText("");
					textPCnt.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]{1,}$", pPrice)) { 
					JOptionPane.showMessageDialog(null, "단가는 숫자만 입력하세요");
					textPCnt.setText("");
					textPCnt.requestFocus();
				}
				else {
					// 모든 체크가 끝나면 DB에 수정처리한다.
					vo = new ProductVo();
					vo.setpIdx(Integer.parseInt(pPIdx));
					vo.setpPic(pPic);
					vo.setpName(pName);
					vo.setpCnt(Integer.parseInt(pCnt));
					vo.setpPrice(Integer.parseInt(pPrice));
					vo.setpInfo(pInfo);
					res = dao.setProductUpdate(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "상품정보가 수정되었습니다.");
						dispose();
						new MallProduct();
					}
					else {
						JOptionPane.showMessageDialog(null, "상품정보 수정실패입니다.");
						txtPName.requestFocus();
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
					res = dao.setDeleteProduct(idx);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 삭제완료!!");
						dispose();
						new MallProduct();
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
		if(cbCondi.equals("상품명")) vData = dao.getConditionSearch("pName",txtCondi);
		else if(cbCondi.equals("상세정보")) vData = dao.getConditionSearch("pInfo",txtCondi);
		
		if(vData.size() == 0) JOptionPane.showMessageDialog(null, "검색된 회원이 없습니다.");
		else dtm.setDataVector(vData, title);
		
	}

	public static void main(String[] args) {
		new MallProduct();
	}
}
