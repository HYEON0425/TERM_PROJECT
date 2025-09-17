import javax.swing.*;
import java.awt.*;

public class ExerciseTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton resetButton;

    public ExerciseTimer() {
        // GUI 기본 설정
        setTitle("운동 타이머");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 타이머 표시 레이블
        timeLabel = new JLabel("01:00"); // 초기 시간 표시
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        // 시작 버튼
        startButton = new JButton("시작");

        // 리셋 버튼
        resetButton = new JButton("리셋");

        // 컴포넌트 추가
        add(timeLabel);
        add(startButton);
        add(resetButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExerciseTimer timer = new ExerciseTimer();
            timer.setVisible(true);
        });
    }
}
