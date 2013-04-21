package ex

class GroovyBean {
    String name
    def GroovyBean(String myname) {
        this.name = myname
    }
    String greeting(String yourname) {
        return sprintf("Good morning %s. I'm %s.", yourname, name)
    }
}
