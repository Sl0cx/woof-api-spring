#Application Woof (Simon Maniez)

##Mise en place d’une API qui permet de :
###Endpoint rôle PROPRIETAIRE : 
- Inscrire des propriétaires de chien [X]
- L’inscription sera réalisée à partir d’un endpoint (url /inscription) [X]
- Crypter le mot de passe [X]
- Inscrire des chiens au propriétaire connecté. (authentification Basic) [X]
https://www.baeldung.com/get-user-in-spring-security (récupérer l’utilisateur connecté) [X]
- Lister les chiens du propriétaire. [X]
- Rechercher des compagnons canins en fonction de critères spécifiques tels que la taille, la race, l'âge, et la localisation géographique.​ [X]
###Endpoint rôle ADMIN : 
- Inscrire des admins via un utilisateur SUPERADMIN crée lors de l’exécution du programme. [ ]
- Lister les propriétaires et leurs chiens. (attention aux données du propriétaire, le nom et prénom sont suffisants) [ ]
- Lister les propriétaires et leurs chiens n’ayant pas de vaccinations à jour. []

###URLS GET :
http://localhost:8083/m2i/woof/api/dog
Récupère tous les chiens

http://localhost:8083/m2i/woof/api/dog/list
Récupère tous les chiens de l'utilisateur connecté

http://localhost:8083/m2i/woof/api/dog/list/properties
Récupère tous les chiens selon les filtres :
hauteur : height
race : race
age : age
geoloc : geoloc

###URLS POST :
http://localhost:8083/m2i/woof/api/user/login
Connecte un user
Basic Auth :
username
password

http://localhost:8083/m2i/woof/api/user/inscription
Inscris un user
Basic Auth :
username admin
password admin
Body exemple :
{
    "identifiant": "testing", (optional)
    "password": "testing",
    "nom": "testing", (optional)
    "prenom": "testing", (optional)
    "role": "PROPRIETAIRE" (optional)
}

http://localhost:8083/m2i/woof/api/dog/create
Inscris un Chien pour l'Utilisateur Connecté
Basic Auth :
username
password
Body exemple :
{
    "age": 7,
    "geoloc": "lille",
    "height": "90cm",
    "race": "shiba",
    "vaccin": "TO_DO"
}