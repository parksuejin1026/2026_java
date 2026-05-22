import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Assi2 extends JFrame {
    // 가위, 바위, 보 이미지 배열 (0: 가위, 1: 바위, 2: 보)
    private ImageIcon[] image = {
            new ImageIcon("images/gawi.jpg"),
            new ImageIcon("images/bawi.jpg"),
            new ImageIcon("images/bo.jpg")
    };
    
    // [클린 코드]: 화면 갱신을 위해 이벤트 리스너 외부에 컴포넌트들을 멤버 변수로 미리 선언합니다.
    private JLabel myLabel = new JLabel();      // 내 선택 이미지가 보일 레이블
    private JLabel comLabel = new JLabel();     // 컴퓨터 선택 이미지가 보일 레이블
    private JLabel resultLabel = new JLabel("가위, 바위, 보 중 하나를 선택하세요!"); // 승패 결과 텍스트 레이블

    public Assi2() {
        setTitle("과제 2 - 가위바위보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        // --- 1. NORTH 영역: 사용자가 누를 이미지 버튼들 ---
        JPanel buttonPanel = new JPanel();
        JButton gawi = new JButton(image[0]);
        JButton bawi = new JButton(image[1]);
        JButton bo = new JButton(image[2]);
        
        buttonPanel.add(gawi);
        buttonPanel.add(bawi);
        buttonPanel.add(bo);
        buttonPanel.setBackground(Color.BLACK);
        c.add(buttonPanel, BorderLayout.NORTH);
        
        // --- 2. CENTER 영역: 판정 결과 텍스트 ---
        resultLabel.setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20)); // 글씨 스타일 구별
        c.add(resultLabel, BorderLayout.CENTER);
        
        // --- 3. SOUTH 영역: 플레이어와 컴퓨터의 이미지가 보일 공간 ---
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 2)); // 왼쪽은 나, 오른쪽은 컴퓨터 (1행 2열 배치)
        
        // 이미지 정렬 및 초기 테두리 설정 (시각적 구분용)
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        comLabel.setHorizontalAlignment(JLabel.CENTER);
        
        resultPanel.add(myLabel);
        resultPanel.add(comLabel);
        resultPanel.setBackground(Color.LIGHT_GRAY); // 영역 확인용 배경색
        c.add(resultPanel, BorderLayout.SOUTH);
        
        // --- 4. 이벤트 처리 (통합 리스너 사용으로 중복 코드 방지) ---
        MyActionListener listener = new MyActionListener();
        gawi.addActionListener(listener);
        bawi.addActionListener(listener);
        bo.addActionListener(listener);
        
        setSize(600, 600); // 이미지 크기를 고려하여 창 크기를 조금 넓혔습니다.
        setVisible(true);
    }

    // [Best Practice]: 버튼 3개의 로직이 동일하므로 하나의 이벤트 클래스로 묶어 통합 관리합니다.
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int userSelect = -1;

            // 1. 사용자가 어떤 버튼을 눌렀는지 판별하여 정수(0, 1, 2) 매핑
            if (clickedButton.getText().equals("") && clickedButton.getIcon() == image[0]) {
                userSelect = 0; // 가위
            } else if (clickedButton.getIcon() == image[1]) {
                userSelect = 1; // 바위
            } else if (clickedButton.getIcon() == image[2]) {
                userSelect = 2; // 보
            }

            // 2. 컴퓨터가 랜덤으로 가위, 바위, 보(0~2) 선택
            int comSelect = (int) (Math.random() * 3);

            // 3. 화면의 이미지 레이블 업데이트
            myLabel.setIcon(image[userSelect]);
            comLabel.setIcon(image[comSelect]);

            // 4. 승패 판정 알고리즘 연산 및 결과 출력
            // 공식: (나 - 컴퓨터 + 3) % 3 ➔ 0:비김, 1:나의승리, 2:컴퓨터승리
            int matchResult = (userSelect - comSelect + 3) % 3;

            if (matchResult == 0) {
                resultLabel.setText("비겼습니다! (무승부)");
                resultLabel.setForeground(Color.BLACK);
            } else if (matchResult == 1) {
                resultLabel.setText("축하합니다! 당신이 이겼습니다.");
                resultLabel.setForeground(Color.BLUE); // 이기면 파란색 글씨
            } else {
                resultLabel.setText("아쉽네요! 컴퓨터가 이겼습니다.");
                resultLabel.setForeground(Color.RED);  // 지면 빨간색 글씨
            }
        }
    }

    public static void main(String[] args) {
        new Assi2();
    }
}