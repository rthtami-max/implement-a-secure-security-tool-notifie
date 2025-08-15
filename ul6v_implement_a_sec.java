import java.util.ArrayList;
import java.util.List;

public class SecurityNotifier {
    private String notifierName;
    private List<SecurityAlert> alerts;
    private Encryption encryption;

    public SecurityNotifier(String notifierName, Encryption encryption) {
        this.notifierName = notifierName;
        this.alerts = new ArrayList<>();
        this.encryption = encryption;
    }

    public void addAlert(SecurityAlert alert) {
        alerts.add(alert);
    }

    public void sendNotifications() {
        for (SecurityAlert alert : alerts) {
            String encryptedMessage = encryption.encrypt(alert.getMessage());
            System.out.println("Notifier " + notifierName + " sending alert: " + encryptedMessage);
        }
    }

    public static class SecurityAlert {
        private String message;

        public SecurityAlert(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public interface Encryption {
        String encrypt(String message);
    }
}