package ex;

public class JavaBean {
    String name;
    public JavaBean(String myname) {
        this.name = myname;
    }
    public String greeting(String yourname) {
        return "Hello, " + yourname + ". I'm " + this.name + " in Java World.";
    }
    public String groovygreeting(String yourname) {
        GroovyBean gb = new GroovyBean(this.name);
        return gb.greeting(yourname);
    }
}
