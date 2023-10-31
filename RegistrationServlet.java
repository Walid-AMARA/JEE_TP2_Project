import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        // Validate the data here

        // Use JPA to persist the user entity
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager em = emf.createEntityManager();

        User newUser = new User();
        newUser.setNom(nom);
        newUser.setPrenom(prenom);
        newUser.setEmail(email);
        newUser.setMotDePasse(motDePasse);

        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();

        em.close();
        emf.close();

        // Provide confirmation messages to the user
        response.getWriter().println("Registration successful!");
    }
}
