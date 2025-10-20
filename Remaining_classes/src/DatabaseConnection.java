public class DatabaseConnection {
    private static DatabaseConnection inst;

    private DatabaseConnection() {
        System.out.println("Database connected");
    }

    public static synchronized DatabaseConnection getInst() {
        if (inst == null) {
            inst = new DatabaseConnection();
        }
        return inst;
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }

    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInst();
        DatabaseConnection db2 = DatabaseConnection.getInst();

        System.out.println("Same instance: " + (db1 == db2));

        db1.executeQuery("SELECT * FROM users");
    }
}
