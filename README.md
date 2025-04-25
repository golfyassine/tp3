# Gestion des Patients - Application Hospitalière

<div align="center">
  <img src="images/app-screenshot.svg" alt="Application Screenshot" width="800">
</div>

## 📋 Description

Cette application web de gestion des patients permet aux établissements hospitaliers de gérer efficacement les informations des patients. Développée avec Spring Boot, elle offre une interface intuitive pour consulter, rechercher et supprimer des dossiers patients.

## 🛠️ Technologies Utilisées

<div align="center">
  <img src="images/spring-boot-icon.svg" alt="Spring Boot" width="50" height="50">
  <img src="images/java-icon.svg" alt="Java" width="50" height="50">
  <img src="images/mysql-icon.svg" alt="MySQL" width="50" height="50">
  <img src="images/bootstrap-icon.svg" alt="Bootstrap" width="50" height="50">
</div>

- **Spring Boot 3.4.4** - Framework Java pour le développement d'applications
- **Java 17** - Langage de programmation
- **Spring Data JPA** - Simplification de l'accès aux données
- **Thymeleaf** - Moteur de templates pour les vues
- **MySQL** - Base de données relationnelle
- **Bootstrap 5.3.3** - Framework CSS pour l'interface utilisateur
- **Lombok** - Bibliothèque pour réduire le code boilerplate

## ✨ Fonctionnalités

- **Affichage des patients** - Liste paginée des patients
- **Recherche** - Filtrage des patients par nom
- **Suppression** - Possibilité de supprimer des dossiers patients
- **Pagination** - Navigation facile entre les pages de résultats

## 🚀 Installation et Configuration

### Prérequis
- Java 17 ou supérieur
- Maven
- MySQL

### Étapes d'installation

1. **Cloner le dépôt**
   ```bash
   git clone [URL_DU_REPO]
   cd Tp03-hopital
   ```

2. **Configurer la base de données**

   Modifiez le fichier `src/main/resources/application.properties` selon votre configuration MySQL :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hopital?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=votre_mot_de_passe
   ```

3. **Compiler et exécuter l'application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Accéder à l'application**

   Ouvrez votre navigateur et accédez à `http://localhost:8084`

## 📊 Structure du Projet

- **Entités** - Modèles de données (Patient)
- **Repositories** - Accès aux données (PatientRepository)
- **Controllers** - Gestion des requêtes HTTP (PatientController)
- **Templates** - Vues Thymeleaf (patients.html)

## 📝 Modèle de Données

L'entité **Patient** contient les attributs suivants :
- `id` - Identifiant unique
- `nom` - Nom du patient
- `dateDeNaissance` - Date de naissance
- `malade` - État de santé (malade ou non)
- `score` - Score médical

## 🔍 Fonctionnalités de Recherche

L'application permet de rechercher des patients par nom avec pagination des résultats. La recherche est implémentée via Spring Data JPA avec des méthodes personnalisées dans le repository.

## 🔄 Pagination

La pagination est gérée côté serveur avec Spring Data et affichée dans l'interface utilisateur avec Bootstrap, permettant une navigation facile entre les pages de résultats.

## 🔒 Sécurité

Cette version de l'application ne contient pas encore de fonctionnalités d'authentification et d'autorisation. Ces fonctionnalités pourront être ajoutées dans une version future.

## 🔮 Évolutions Futures

- Ajout de fonctionnalités d'authentification
- Implémentation de rôles utilisateurs (médecin, infirmier, administrateur)
- Ajout et modification de patients
- Gestion des rendez-vous
- Statistiques et rapports
- Interface responsive pour mobile

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

## 👥 Contributeurs

- [Votre Nom] - Développeur principal
