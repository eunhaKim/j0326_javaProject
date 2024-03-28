package homework;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberJoin extends JFrame{
	JTextField txtId,txtPwd,txtName,txtAge;
	ButtonGroup bgGender = new ButtonGroup();
	JRadioButton rdFemale,rdMale;
	JComboBox cbYY,cbMM,cbDD;
	JButton btnJoin, btnReset, btnCancel;
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = null;
	int res = 0;
	
	public MemberJoin() {
		super("회원가입창");
		setSize(600,400);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 586, 41);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 586, 21);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setLayout(null);
		pn2.setBounds(0, 43, 586, 274);
		getContentPane().add(pn2);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(47, 26, 46, 15);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(47, 67, 72, 15);
		pn2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setBounds(47, 108, 46, 15);
		pn2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("나이");
		lblNewLabel_1_1_1_1.setBounds(47, 149, 46, 15);
		pn2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("성별");
		lblNewLabel_1_1_1_1_1.setBounds(47, 190, 46, 15);
		pn2.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("입사일");
		lblNewLabel_1_1_1_1_1_1.setBounds(47, 231, 46, 15);
		pn2.add(lblNewLabel_1_1_1_1_1_1);
		
		txtId = new JTextField();
		txtId.setBounds(129, 23, 96, 21);
		pn2.add(txtId);
		txtId.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(129, 64, 96, 21);
		pn2.add(txtPwd);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(129, 105, 96, 21);
		pn2.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(129, 146, 96, 21);
		pn2.add(txtAge);
		
		rdFemale = new JRadioButton("여자");
		rdFemale.setSelected(true);
		bgGender.add(rdFemale);
		rdFemale.setBounds(130, 186, 105, 23);
		pn2.add(rdFemale);
		
		rdMale = new JRadioButton("남자");
		rdMale.setBounds(259, 186, 105, 23);
		bgGender.add(rdMale);
		pn2.add(rdMale);
		
		// 년도/월/일 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi=0;
		for(int i=0; i<yy.length ; i++) {
			imsi = 2024-i;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length ; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length ; i++) {
			dd[i] = (i+1) + "";
		}
		
		cbYY = new JComboBox(yy);
		cbYY.setBounds(129, 227, 65, 23);
		pn2.add(cbYY);
		
		cbMM = new JComboBox(mm);
		cbMM.setBounds(236, 227, 65, 23);
		pn2.add(cbMM);
		
		cbDD = new JComboBox(dd);
		cbDD.setBounds(340, 227, 65, 23);
		pn2.add(cbDD);
		
		JLabel lblNewLabel_2 = new JLabel("년");
		lblNewLabel_2.setBounds(204, 231, 31, 15);
		pn2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("월");
		lblNewLabel_2_1.setBounds(309, 231, 31, 15);
		pn2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("일");
		lblNewLabel_2_2.setBounds(415, 231, 31, 15);
		pn2.add(lblNewLabel_2_2);
		
		
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(0, 322, 586, 41);
		getContentPane().add(pn3);
		
		btnJoin = new JButton("회원가입");
		btnJoin.setBounds(137, 10, 87, 23);
		pn3.add(btnJoin);
		
		btnCancel = new JButton("가입취소");
		btnCancel.setBounds(361, 10, 87, 23);
		pn3.add(btnCancel);
		
		btnReset = new JButton("다시입력");
		btnReset.setBounds(249, 10, 87, 23);
		pn3.add(btnReset);
		
		// ----------------------------위쪽은 UI--------------------------------
		setLocationRelativeTo(null); // 윈도우창 가운데 정렬
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		// ----------------------------아래쪽은 메소드----------------------------
		
		// 회원가입버튼
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText().trim();
				String pwd = txtPwd.getText().trim();
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이은 숫자로 입력하세요");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
					// 회원명 중복처리
					vo = dao.getNameSerch(name);
					if(vo.getName() != null) {
						JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다시 성명을 입력해주세요.");
						txtName.requestFocus();
					}
					else {
						// 정상적으로 자료가 입력되었다면 vo에 담아져 있는 겂을 DB에 저장한다.
						vo.setName(name);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaInput(vo);
						
						if(res != 0) {
							JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
							dispose();
							new MartMain();
						}
						else {
							JOptionPane.showMessageDialog(null, "회원에 가입실패입니다. 다시 가입해주세요.");
							txtName.requestFocus();
						}
					}
				}
			}
		});
		
		// 리셋버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtId.requestFocus();
			}
		});
		
		// 취소버튼
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MartMain();
			}
		});
	}
//	public static void main(String[] args) {
//		new MemberJoin();
//	}
}
