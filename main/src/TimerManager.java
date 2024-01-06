
import java.util.Timer;
import java.util.TimerTask;

class TimerManager {
    private int secondsRemaining;
    private Timer timer;
    private BuchstabenManager buchstabenManager;

    public TimerManager(BuchstabenManager buchstabenManager) {
        this.buchstabenManager = buchstabenManager;
    }

    public void startTimer() {
        secondsRemaining = 300;
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handleTimerTick();
            }
        }, 0, 1000); // Starte den Timer sofort und wiederhole alle 1000 Millisekunden (1 Sekunde)
    }

    private void handleTimerTick() {
        secondsRemaining--;

        if (secondsRemaining <= 0) {
            timer.cancel(); // Timer stoppen, wenn die Zeit abgelaufen ist
            buchstabenManager.handleTimeUp();
        }
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public String getFormattedTime() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        int hundredths = (int) ((secondsRemaining - Math.floor(secondsRemaining)) * 100);

        return String.format("%02d:%02d:%02d", minutes, seconds, hundredths);
    }

    public int getSecondsRemaining(){
        return secondsRemaining;
    }
}
