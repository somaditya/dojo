package com.amdocs.codeninja.singleton;

public final class DbConnection {
    private static DbConnection instance;

    private String connectionString;

    private DbConnection(String connectionString) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.connectionString = connectionString;
    }

    public static DbConnection getInstance(String connectionString) {
        if (instance == null) {
            instance = new DbConnection(connectionString);
        }

        return instance;
    }

    public static void main(String[] args) {
        DbConnection connection1 = DbConnection.getInstance("Oracle");
        DbConnection connection2 = DbConnection.getInstance("Postgres");

        System.out.println(connection1.connectionString);
        System.out.println(connection2.connectionString);
    }
}
