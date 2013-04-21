package ex;

public class JavaBean {
    String name;
    public JavaBean(String myname) {
        this.name = myname;
    }
    public String greeting(String yourname) {
        return "Hello, " + yourname + ". I'm " + this.name + " in Java World.";
    }
}
