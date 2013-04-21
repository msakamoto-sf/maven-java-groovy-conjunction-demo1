package ex;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;

public class JavaBeanTest {
    @Test
    public void greeting() throws IOException {
        JavaBean b = new JavaBean("Bob");
        assertThat(b.greeting("Jon"), is("Hello, Jon. I'm Bob in Java World."));

        Properties msg = new Properties();
        msg.load(getClass().getClassLoader().getResourceAsStream("ex/msg.properties"));

        assertThat(b.greeting(msg.getProperty("msg1")), is("Hello, good evening. I'm Bob in Java World."));
        assertThat(b.greeting(msg.getProperty("msg2")), is("Hello, happy programming. I'm Bob in Java World."));
    }
}
