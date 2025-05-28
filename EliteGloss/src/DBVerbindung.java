import java.sql.Connection;
import java.sql.DriverManager;

public class DBVerbindung {
    public static Connection verbinde() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/elitegloss_db", "root", "");
        } catch (Exception e) {
            System.err.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
            return null;
        }
    }
}