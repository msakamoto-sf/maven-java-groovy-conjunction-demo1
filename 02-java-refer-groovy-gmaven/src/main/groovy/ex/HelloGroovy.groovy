package ex

import java.util.*

import javax.servlet.*
import javax.servlet.http.*

public class HelloGroovy extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType('text/html')

        GroovyBean gb = new GroovyBean('Groovy')
        JavaBean jb = new JavaBean('Java')

        Properties msg = new Properties()
        msg.load(getClass().getClassLoader().getResourceAsStream('ex/msg.properties'))

        PrintWriter out = resp.getWriter()
        out.println('<html>')
        out.println('<body>')
        out.println(gb.greeting(msg.getProperty('msg1')))
        out.println('<br>')
        out.println(gb.javagreeting(msg.getProperty('msg1')))
        out.println('<br>')
        out.println(gb.greeting(msg.getProperty('msg2')))
        out.println('<br>')
        out.println(gb.javagreeting(msg.getProperty('msg2')))
        out.println('<br>')
        out.println(jb.greeting(msg.getProperty('msg1')))
        out.println('<br>')
        out.println(jb.groovygreeting(msg.getProperty('msg1')))
        out.println('<br>')
        out.println(jb.greeting(msg.getProperty('msg2')))
        out.println('<br>')
        out.println(jb.groovygreeting(msg.getProperty('msg2')))
        out.println('<br>')
        out.println('</body>')
        out.println('</html>')
        out.close();
    }
}
