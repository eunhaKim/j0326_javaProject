package mall;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class T8_File extends JFrame {
	private JFileChooser chooser;
	private JButton btnUpload, btnExit, btnDelete;
	private JLabel lblImage;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;

	public T8_File() {
		super("파일처리 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 48);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnUpload = new JButton("그림업로드");
		btnUpload.setFont(new Font("굴림", Font.PLAIN, 16));
		btnUpload.setBounds(12, 10, 114, 28);
		pn1.add(btnUpload);
		
		btnDelete = new JButton("그림삭제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 16));
		btnDelete.setBounds(138, 10, 114, 28);
		pn1.add(btnDelete);
		
		btnExit = new JButton("종  료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(458, 10, 114, 28);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 51, 584, 342);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("사진이 출력됩니다.");
		lblImage.setFont(new Font("굴림", Font.PLAIN, 18));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(257, 10, 315, 322);
		pn2.add(lblImage);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 233, 322);
//		pn2.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 393, 584, 48);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		// JTable설계
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더안의 정보를 가져오기
		getFolderInfor();
		
		dtm = new DefaultTableModel(vData, title);
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 233, 322);
		pn2.add(scrollPane);
		
// =============================================================================
		setVisible(true);
// =====================아래로 메소드처리영역========================================================
		
		// JTable에 등록된 그림을 선택후 그림 삭제처리...
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				String image = table.getValueAt(row, col).toString();
				//System.out.println("image : " + image);
				if(image != null) {
					int ans = JOptionPane.showConfirmDialog(null, "다음파일을 삭제하시겠습니까?\n"+image,"삭제화면", JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						File file = new File(image);
						file.delete();
						JOptionPane.showMessageDialog(null, "파일을 삭제처리했습니다.");
						lblImage.setIcon(null);
						getFolderInfor();
						dtm.setDataVector(vData, title);
					}
					else JOptionPane.showMessageDialog(null, "삭제취소!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요.");
				}
			}
		});
		
		// Jtable 클릭시 그림파일의 정보를 레이블에 뿌려주기(그림 보여주기)
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				String image = table.getValueAt(row, col).toString();
				lblImage.setIcon(new ImageIcon(image));
				
				ImageIcon icon = new ImageIcon(image);
				Image img = icon.getImage();
				Image updateImg = img.getScaledInstance(349, 234, Image.SCALE_SMOOTH);
				
				ImageIcon updateIcon = new ImageIcon(updateImg);	// 변경된 크기의 이미지로 다시 생성..
				
				lblImage.setIcon(updateIcon);		// 생성된 이미지를 레이블에 아이콘으로 등록후 뿌려준다.(setText())
				lblImage.setText(image);
			}
		});
		
		// 그림 업로드 처리
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 생성
				chooser = new JFileChooser();
				
				// 파일 확장자 선별 출력처리..
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg","gif");
				chooser.setFileFilter(filter);
				
				// 파일 다이얼로그박스 출력처리
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {	// 사용자가 화일을 선택하지않고 창을 닫거나 취소한경우..
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
					// 사용자가 파일을 선택하고 '열기' 버튼을 누른경우(또는 선택한 파일명을 더블클릭한 경우)
					String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
					lblImage.setIcon(new ImageIcon(filePath));
					
					// 파일 업로드하기
					try {
						File imageFile = new File(filePath);		// 업로드 되는 파일의 위치정보+파일명
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);	// 파일명+확장자
						String extension = filePath.substring(filePath.lastIndexOf(".")+1);	// 확장자
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("myImages/" + fileName);	// 서버에 저장되는 폴더+파일명
						if(!file.exists()) file.mkdir();	// 폴더가 존재하지않으면 폴더를 만들어준다.
						
						ImageIO.write(image, extension, file);	// images를 file로 업로드시켜준다.
						//System.out.println("파일명 : " + fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
					
						getFolderInfor();	// 폴더안의 정보를 가져오기
						dtm.setDataVector(vData, title);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}
	
	// 폴더안의 파일 목록(정보)을 가져오는 메소드
	private void getFolderInfor() {
		File folder = new File("myImages");
		File files[] = folder.listFiles();
//		for(File f : files) {
//			System.out.println(f.getName());
//		}
		vData = new Vector<>();
		if(files.length != 0) {
			for(int i=0; i<files.length; i++) {
				//System.out.println("파일("+(i+1)+") : " + files[i]);
				Vector vo = new Vector<>();
				vo.add(files[i]);
				vData.add(vo);
			}
			//dtm.setDataVector(vData, title);
		}
	}

	public static void main(String[] args) {
		new T8_File();
	}
}