# JEE_TP2_Project

Projet de gestion d'utilisateurs en Java EE
Objectif : L'objectif de ce projet est de développer une application de gestion d'utilisateurs en utilisant la plateforme Java EE. Cette application permettra aux utilisateurs de s'inscrire, de se connecter et de gérer leur profil. Les utilisateurs pourront saisir leurs informations personnelles, s'authentifier, accéder à leur profil, mettre à jour leurs informations, et se déconnecter en toute sécurité.
Étapes :
1. Création du projet :![tomcat server](https://github.com/Walid-AMARA/JEE_TP2_Project/assets/59109675/8397da5b-4c46-447d-b426-ee833b24e873)

• Créez un projet Java EE dans votre environnement de développement intégré (IDE) de choix. Utilisez un nom de projet significatif, par exemple "GestionUtilisateursJavaEE."
• Configurez un serveur d'application (comme Apache Tomcat) pour le projet. Assurez-vous que votre IDE est correctement configuré pour déployer et exécuter des applications Java EE sur ce serveur.
2. Base de données : ![database creation](https://github.com/Walid-AMARA/JEE_TP2_Project/assets/59109675/c76e226f-f704-4c39-bd54-57be70f5d0b8)

3. 
• Créez une base de données pour stocker les informations des utilisateurs. Vous pouvez utiliser un système de gestion de base de données (SGBD) tel que MySQL, PostgreSQL ou une base de données intégrée comme H2 pour faciliter la configuration. Créez une nouvelle base de données avec un nom approprié, par exemple "gestion_utilisateurs_db."
• Concevez la structure de la base de données pour stocker les utilisateurs et leurs informations. Vous aurez besoin d'une table "utilisateurs" avec des colonnes pour l'ID, le nom, le prénom, l'e-mail et le mot de passe. Assurez-vous de spécifier les types de données appropriés pour chaque colonne.
4. Modèle de données :
• Créez une classe Java User qui représente un utilisateur. La classe User doit avoir des attributs correspondant aux colonnes de la table "utilisateurs" dans la base de données. Par exemple :
public class User {
private Long id;
private String nom;
private String prenom;
private String email;
private String motDePasse;
// Getters et Setters
}
• Utilisez JPA (Java Persistence API) pour mapper l'entité User à la base de données. Assurez-vous d'annoter la classe User avec les annotations JPA appropriées, telles que @Entity, @Id, @GeneratedValue, etc.
5. Formulaire d'inscription :
• Créez une page HTML (inscription.html) avec un formulaire d'inscription. Le formulaire doit permettre aux utilisateurs de saisir leur nom, prénom, e-mail et mot de passe. Veillez à inclure des champs de saisie, des balises <form>, et des boutons pour soumettre les données.
• Créez une servlet (RegistrationServlet) pour traiter les données soumises lors de l'inscription. La servlet doit recevoir les données du formulaire, les valider, puis les enregistrer dans la base de données à l'aide de JPA. Assurez-vous de gérer les erreurs et les cas d'utilisation incorrecte, et fournissez des messages de confirmation aux utilisateurs après une inscription réussie.
6. Authentification :
• Mettez en place un mécanisme d'authentification pour permettre aux utilisateurs de se connecter à l'application. Vous pouvez utiliser la technologie de votre choix pour cela, par exemple Form-Based Authentication, filtres, etc. L'authentification est cruciale pour garantir que seuls les utilisateurs autorisés peuvent accéder à leur profil.
• Créez une page de connexion (login.html) permettant aux utilisateurs de saisir leur e-mail et leur mot de passe pour se connecter. Le formulaire de connexion doit être distinct du formulaire d'inscription.
• Créez une servlet (LoginServlet) pour gérer l'authentification des utilisateurs. La servlet doit vérifier les informations d'identification soumises par les utilisateurs, comparer les données avec celles de la base de données et autoriser l'accès aux utilisateurs authentifiés.
7. Sessions utilisateur :
• Utilisez les sessions HTTP pour stocker les informations d'authentification des utilisateurs. Lorsqu'un utilisateur se connecte avec succès, stockez les informations pertinentes dans la session pour permettre un suivi de l'authentification.
• Créez une servlet (ProfileServlet) qui permet aux utilisateurs authentifiés d'accéder à leur profil. La servlet doit vérifier si l'utilisateur est connecté avant de permettre l'accès au profil.
8. Gestion de profil :
• Créez une page de profil (profile.html) permettant aux utilisateurs de voir et de modifier leurs informations personnelles. Cette page doit être accessible uniquement aux utilisateurs authentifiés.
• Créez une servlet (ProfileUpdateServlet) pour permettre aux utilisateurs de mettre à jour leurs informations de profil. La servlet doit gérer les mises à jour des données d'utilisateur dans la base de données.
9. Déconnexion :
• Permettez aux utilisateurs de se déconnecter en invalidant leur session. Lorsqu'un utilisateur choisit de se déconnecter, la session actuelle doit être invalidée, ce qui empêche l'accès non autorisé au profil.
