package util;

public class Rq {
    private final String cmd;
    private final int id;

    public Rq(String input) {
        String[] parts = input.split(" ");
        this.cmd = parts[0];
        this.id = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
    }

    public String getCmd() { return cmd; }
    public int getId() { return id; }
}
