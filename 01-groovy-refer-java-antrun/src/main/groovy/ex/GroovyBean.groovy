package ex

class GroovyBean {
    String name
    def GroovyBean(String myname) {
        this.name = myname
    }
    String greeting(String yourname) {
        return sprintf("Good morning %s. I'm %s in Groovy World.", yourname, name)
    }
    String javagreeting(String yourname) {
        def jb = new JavaBean(name)
        return jb.greeting(yourname)
    }
}
