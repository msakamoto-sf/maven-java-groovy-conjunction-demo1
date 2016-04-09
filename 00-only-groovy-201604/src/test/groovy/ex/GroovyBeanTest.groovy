package ex

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import java.util.*
import org.junit.Test

class GroovyBeanTest {
    @Test void greeting() {
        def b = new GroovyBean("Jon")
        assertThat b.greeting("Bob"), is("Good morning Bob. I'm Jon.")

        Properties msg = new Properties()
        msg.load(getClass().getClassLoader().getResourceAsStream('ex/msg.properties'))

        assertThat b.greeting(msg.getProperty('msg1')), is("Good morning good evening. I'm Jon.")
        assertThat b.greeting(msg.getProperty('msg2')), is("Good morning happy programming. I'm Jon.")
    }
}
