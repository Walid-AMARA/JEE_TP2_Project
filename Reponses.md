**1. Concevez la structure de la base de données pour stocker les informations des utilisateurs. Quels types de données utiliserez-vous pour stocker le nom, le prénom, l'e-mail et le mot de passe ?**

- Le nom et le prénom seront stockés en utilisant le type de données `VARCHAR` avec une longueur maximale de 50 caractères.
- L'e-mail sera également stocké en tant que `VARCHAR` avec une longueur maximale de 100 caractères, et il devra avoir une contrainte d'unicité pour garantir que chaque e-mail est unique.
- Le mot de passe sera stocké en tant que `VARCHAR` avec une longueur maximale de 100 caractères pour permettre un stockage sécurisé des mots de passe.

**2. Comment utilisez-vous JPA pour mapper l'entité User à la base de données ? Montrez l'annotation JPA que vous utilisez.**

Voici l'annotation JPA utilisée dans la classe `User` :

```java
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "motDePasse", length = 100)
    private String motDePasse;
}
```
**3. Comment gérez-vous l'authentification des utilisateurs ? Expliquez le mécanisme que vous avez choisi (Form-Based Authentication, filtres, etc.).**

J'ai mis en place un mécanisme de gestion d'authentification en utilisant les sessions HTTP. Lorsqu'un utilisateur se connecte avec succès, j'enregistre l'e-mail de l'utilisateur dans la session. J'utilise également un filtre pour vérifier si l'utilisateur est authentifié avant d'autoriser l'accès à certaines pages.

**4. Quelles informations stockez-vous dans la session utilisateur ? Comment accédez-vous à ces informations dans les servlets ?**

Dans la session utilisateur, je stocke l'e-mail de l'utilisateur après son authentification. Pour accéder à ces informations dans les servlets, j'utilise la classe `HttpSession` pour récupérer la session actuelle et ses attributs, comme ceci :

```java
HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
String userEmail = (String) session.getAttribute("authenticatedUser");
```

**5. Décrivez le flux d'une inscription utilisateur, de la soumission du formulaire à l'enregistrement des données dans la base de données.**

Le flux d'inscription utilisateur commence par la soumission du formulaire HTML (`inscription.html`). Lorsque l'utilisateur soumet le formulaire, les données sont envoyées à la servlet `RegistrationServlet`. Dans cette servlet, je récupère les données, les valide, puis j'utilise JPA pour enregistrer les informations dans la base de données. Une fois l'enregistrement réussi, je fournis un message de confirmation à l'utilisateur.

**6. Quels mécanismes avez-vous mis en place pour assurer la sécurité des données sensibles, comme les mots de passe ?**

Pour assurer la sécurité des données sensibles, comme les mots de passe, j'utilise des techniques de hachage et de salage des mots de passe avant de les stocker en base de données. De plus, j'implémente HTTPS pour sécuriser la transmission des données entre le client et le serveur. Il est essentiel de ne jamais stocker de mots de passe en texte brut dans la base de données.

**7. Montrez comment vous empêchez l'accès à certaines pages à moins d'être authentifié.**

Pour empêcher l'accès à certaines pages à moins d'être authentifié, j'utilise un filtre qui vérifie la présence de l'attribut `authenticatedUser` dans la session. Si l'attribut n'est pas présent, l'accès à ces pages est refusé.


**8. Comment gérez-vous les erreurs et les validations lors de la soumission du formulaire d'inscription ?**

Pour gérer les erreurs et les validations lors de la soumission du formulaire d'inscription, je vérifie les données dans la servlet `RegistrationServlet`. Si les données ne sont pas valides, je génère des messages d'erreur et je les affiche à l'utilisateur. De plus, j'utilise des mécanismes de validation côté client (JavaScript) et côté serveur pour garantir l'intégrité des données.


**9. Quelles améliorations pourriez-vous apporter à cette application pour la rendre plus robuste et conviviale ?**

Pour rendre l'application plus robuste et conviviale, je pourrais :
- Mettre en place un mécanisme de réinitialisation de mot de passe.
- Améliorer la gestion des erreurs en fournissant des messages d'erreur plus détaillés.
- Utiliser des frameworks de sécurité tels que Spring Security pour une gestion plus avancée de l'authentification et de l'autorisation.
- Ajouter des fonctionnalités de gestion de rôles d'utilisateur pour différencier les utilisateurs standard des administrateurs.
- Utiliser des mécanismes de gestion de sessions plus avancés, comme les tokens JWT.


**10. Passez en revue le code de la servlet ProfileUpdateServlet et expliquez comment elle met à jour les informations
