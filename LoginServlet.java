import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        HttpSession session = request.getSession();
        session.setAttribute("authenticatedUser", email);


        // Validate the data here

        // Use JPA to check the user's credentials
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager em = emf.createEntityManager();

        // Implement code to validate the user's credentials here using JPA

        if (authenticationIsSuccessful) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticatedUser", email);
            response.getWriter().println("Login successful!");
        } else {
            response.getWriter().println("Login failed. Please check your credentials.");
        }

        em.close();
        emf.close();
    }
}
