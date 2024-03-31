package mall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;

public class MallJoinUser extends JFrame{
	private static final Border red = null;
	private NumberButton btnReset, btnJoin, btnExit;
	private RoundedButton btnAdminLogin, btnUserLogin;
	private JTextField textId,textPwd,textName,textTel,textAddr;
	private JFileChooser chooser;
	
	private MemberDao dao = new MemberDao();
	private MemberVo vo = null;
	int res=0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public MallJoinUser() {
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
		btnUserLogin.setText("사용자 로그인");
		btnUserLogin.setForeground(new Color(255, 255, 255));
		btnUserLogin.setBackground(new Color(125, 181, 44));
		btnUserLogin.setBounds(207, 344, 97, 23);
		pn1.add(btnUserLogin);
		
		JLabel lblNewLabel_1 = new JLabel("회원가입을 해주세요.");
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
		lblBg.setIcon(new ImageIcon(MallJoinUser.class.getResource("/img/loginBg.gif")));
		lblBg.setBounds(0, 0, 389, 463);
		pn1.add(lblBg);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(391, 0, 395, 463);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		btnReset = new NumberButton("0");
		btnReset.setText("다시입력");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("굴림", Font.BOLD, 16));
		btnReset.setBackground(new Color(4, 73, 150));
		btnReset.setBounds(129, 374, 133, 87);
		pn2.add(btnReset);
		
		btnJoin = new NumberButton("종료");
		btnJoin.setText("회원가입");
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setFont(new Font("굴림", Font.BOLD, 16));
		btnJoin.setBackground(new Color(19, 137, 201));
		btnJoin.setBounds(-3, 374, 133, 87);
		pn2.add(btnJoin);
		
		btnExit = new NumberButton("접속");
		btnExit.setText("종료");
		
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("굴림", Font.BOLD, 16));
		btnExit.setBackground(new Color(125, 181, 44));
		btnExit.setBounds(261, 374, 133, 87);
		pn2.add(btnExit);
		
		JLabel lblNewLabel_1_1 = new JLabel("아이디");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(77, 144, 100, 15);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(77, 173, 100, 15);
		pn2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(78, 206, 100, 15);
		pn2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("성별");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(76, 237, 100, 15);
		pn2.add(lblNewLabel_4);
		
		JLabel lblJoinPic = new JLabel("");
		lblJoinPic.setFont(new Font("굴림", Font.PLAIN, 16));
		lblJoinPic.setIcon(new ImageIcon(MallJoinUser.class.getResource("/img/imgMember.gif")));
		lblJoinPic.setBounds(181, 42, 98, 74);
		pn2.add(lblJoinPic);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 16));
		textId.setColumns(10);
		textId.setBounds(181, 140, 155, 25);
		pn2.add(textId);
		
		textPwd = new JTextField();
		textPwd.setFont(new Font("굴림", Font.PLAIN, 16));
		textPwd.setColumns(10);
		textPwd.setBounds(181, 170, 155, 25);
		pn2.add(textPwd);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 16));
		textName.setColumns(10);
		textName.setBounds(182, 202, 154, 25);
		pn2.add(textName);
		
		JLabel lblNewLabel_5 = new JLabel("연락처");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(77, 268, 100, 15);
		pn2.add(lblNewLabel_5);
		
		textTel = new JTextField();
		textTel.setFont(new Font("굴림", Font.PLAIN, 16));
		textTel.setColumns(10);
		textTel.setBounds(182, 264, 154, 25);
		pn2.add(textTel);
		
		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(78, 300, 100, 15);
		pn2.add(lblNewLabel_6);
		
		textAddr = new JTextField();
		textAddr.setFont(new Font("굴림", Font.PLAIN, 16));
		textAddr.setColumns(10);
		textAddr.setBounds(183, 297, 153, 25);
		pn2.add(textAddr);
		
		RoundedButton btnPic = new RoundedButton("사진등록");
		btnPic.setText("사진등록");
		btnPic.setForeground(Color.WHITE);
		btnPic.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnPic.setBackground(new Color(4, 73, 150));
		btnPic.setBounds(76, 43, 100, 28);
		pn2.add(btnPic);
		
		JRadioButton rdMale = new JRadioButton("남자");
		buttonGroup.add(rdMale);
		rdMale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdMale.setBackground(Color.WHITE);
		rdMale.setBounds(248, 232, 66, 23);
		pn2.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		buttonGroup.add(rdFemale);
		rdFemale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdFemale.setSelected(true);
		rdFemale.setBackground(Color.WHITE);
		rdFemale.setBounds(180, 232, 66, 23);
		pn2.add(rdFemale);
		
		// ----------------------------------------------------------
		setLocationRelativeTo(null);
		setResizable(false);
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
				dispose();
				new MallLoginUser();
			}
		});
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText(null);
				textPwd.setText(null);
				textName.setText(null);
				textTel.setText(null);
				textAddr.setText(null);
				textId.requestFocus();
			}
		});
		// 종료하기 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "쇼핑몰 관리 시스템을 종료하시겠습니까?","시즈템 종료창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		
		// 회원가입
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pic = "";
				if(!lblJoinPic.getText().trim().equals("")) pic = lblJoinPic.getText().trim();
				else pic = "images/member.jpg";
				
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
	
	public static void main(String[] args) {
		new MallJoinUser();
	}
}
