// 필요한 Swing 및 AWT 패키지를 불러옵니다.
import javax.swing.*;  // GUI 컴포넌트(JFrame, JLabel, JButton 등)를 사용하기 위한 패키지
import java.awt.*;     // GUI의 레이아웃(FlowLayout)과 폰트(Font) 기능을 사용하기 위한 패키지

/**
 * ExerciseTimer 클래스는 운동 타이머의 GUI 인터페이스를 생성합니다.
 * 이 클래스는 JFrame을 상속받아 독립적인 창을 만듭니다.
 */
public class ExerciseTimer extends JFrame {
    // GUI 컴포넌트들을 멤버 변수로 선언합니다.
    private JLabel timeLabel;      // 시간을 표시할 레이블
    private JButton startButton;   // "시작" 버튼
    private JButton resetButton;   // "리셋" 버튼

    /**
     * ExerciseTimer 클래스의 생성자입니다.
     * 이 생성자에서 GUI 컴포넌트들을 초기화하고 창에 배치합니다.
     */
    public ExerciseTimer() {
        // --- GUI 기본 설정 ---
        setTitle("운동 타이머");              // 창의 제목을 "운동 타이머"로 설정
        setSize(300, 200);                  // 창의 크기를 가로 300, 세로 200 픽셀로 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창의 닫기 버튼(X)을 누르면 프로그램이 종료되도록 설정
        setLayout(new FlowLayout());        // 컴포넌트들이 순서대로 정렬되도록 FlowLayout을 사용

        // --- 컴포넌트 초기화 및 설정 ---
        // 시간을 표시하는 레이블을 생성하고 초기 텍스트와 폰트를 설정
        timeLabel = new JLabel("01:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        // "시작" 버튼 생성
        startButton = new JButton("시작");

        // "리셋" 버튼 생성
        resetButton = new JButton("리셋");

        // --- 컴포넌트를 창에 추가 ---
        add(timeLabel);     // 레이블을 창에 추가
        add(startButton);   // 시작 버튼을 창에 추가
        add(resetButton);   // 리셋 버튼을 창에 추가
    }

    /**
     * 프로그램의 메인 메서드입니다.
     * 이 메서드가 실행될 때 GUI를 생성하고 화면에 표시합니다.
     */
    public static void main(String[] args) {
        // SwingUtilities.invokeLater()를 사용하여 GUI 관련 작업을 AWT 이벤트 디스패치 스레드에서 실행합니다.
        // 이는 스레드 안전성을 보장하며, GUI가 올바르게 작동하도록 돕는 표준적인 방법입니다.
        SwingUtilities.invokeLater(() -> {
            ExerciseTimer timer = new ExerciseTimer(); // ExerciseTimer 객체 생성
            timer.setVisible(true);                    // 창을 화면에 보이도록 설정
        });
    }
}
