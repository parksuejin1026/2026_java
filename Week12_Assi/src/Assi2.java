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
    
    private JLabel myLabel = new JLabel();      // 내 선택 이미지가 보일 레이블
    private JLabel comLabel = new JLabel();     // 컴퓨터 선택 이미지가 보일 레이블
    
    private JLabel meTextLabel = new JLabel("me");
    private JLabel comTextLabel = new JLabel("com");
    private JLabel resultLabel = new JLabel("Ready"); // 초기 상태 메시지

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
        buttonPanel.setBackground(Color.DARK_GRAY);
        c.add(buttonPanel, BorderLayout.NORTH);
        
        // CENTER 영역
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        resultPanel.setBackground(Color.YELLOW);
        
        resultLabel.setForeground(Color.RED);
        
        myLabel.setIcon(image[2]);
        comLabel.setIcon(image[2]);
        
        resultPanel.add(myLabel);
        resultPanel.add(meTextLabel);
        resultPanel.add(comLabel);
        resultPanel.add(comTextLabel);
        resultPanel.add(resultLabel);
        
        c.add(resultPanel, BorderLayout.CENTER);
        
        MyActionListener listener = new MyActionListener();
        gawi.addActionListener(listener);
        bawi.addActionListener(listener);
        bo.addActionListener(listener);
        
        setSize(600, 450); 
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int userSelect = -1;

            if (clickedButton.getIcon() == image[0]) {
                userSelect = 0; // 가위
            } else if (clickedButton.getIcon() == image[1]) {
                userSelect = 1; // 바위
            } else if (clickedButton.getIcon() == image[2]) {
                userSelect = 2; // 보
            }

            int comSelect = (int) (Math.random() * 3);

            myLabel.setIcon(image[userSelect]);
            comLabel.setIcon(image[comSelect]);
         
            int matchResult = (userSelect - comSelect + 3) % 3;
            
            if (matchResult == 0) {
                resultLabel.setText("Same !!!");
                resultLabel.setForeground(Color.RED);
            } else if (matchResult == 1) {
                resultLabel.setText("You Win !!!");
                resultLabel.setForeground(Color.BLUE); 
            } else {
                resultLabel.setText("Computer Win !!!");
                resultLabel.setForeground(Color.BLACK);  
            }
        }
    }

    public static void main(String[] args) {
        new Assi2();
    }
}