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

    // 타이머 시작 메소드
    private void startTimer() {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    SwingUtilities.invokeLater(() -> {
                        timeLabel.setText(formatTime(secondsLeft));
                    });
                } else {
                    stopTimer();
                    JOptionPane.showMessageDialog(ExerciseTimer.this,
                            "운동 시간이 완료되었습니다!", "알림",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }, 1000, 1000); // 1초 딜레이, 1초마다 실행
    }

    // 타이머 정지 메소드
    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    // 타이머 리셋 메소드
    private void resetTimer() {
        stopTimer();
        secondsLeft = 60; // 기본값으로 리셋
        timeLabel.setText(formatTime(secondsLeft));
        startButton.setText("시작");
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