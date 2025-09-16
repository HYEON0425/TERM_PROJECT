import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ExerciseTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton resetButton;
    private Timer timer;
    private int secondsLeft;

    public ExerciseTimer() {
        // 기본 운동 시간을 60초(1분)로 설정
        secondsLeft = 60;

        // GUI 설정
        setTitle("운동 타이머");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 타이머 표시 레이블
        timeLabel = new JLabel(formatTime(secondsLeft));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        // 시작 버튼
        startButton = new JButton("시작");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startButton.getText().equals("시작")) {
                    startTimer();
                    startButton.setText("일시정지");
                } else {
                    stopTimer();
                    startButton.setText("시작");
                }
            }
        });

        // 리셋 버튼
        resetButton = new JButton("리셋");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTimer();
            }
        });

        // 컴포넌트 추가
        add(timeLabel);
        add(startButton);
        add(resetButton);
    }

    // 시간 포맷팅 메소드 (MM:SS 형식)
    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExerciseTimer timer = new ExerciseTimer();
            timer.setVisible(true);
        });
    }
}
