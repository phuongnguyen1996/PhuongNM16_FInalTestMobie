package page;

public class Example {
    String x;
    String y;

    public void readJson() {
        x = "hello";
        y = "mai";
    }

    public void check() {
        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.readJson();
        example.check();
    }
}
