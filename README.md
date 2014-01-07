proxy
=====

##Projet LPSIL Génie Logiciel SAR Proxy Web


###Equipe Projet :
- Brice CASTAGNA
- Colin DASSONVILLE
- Pascal CHEVALLOT


###Réalisation d'un proxy HTTP :
- proxy entre le client et le site web souhaité
- mise en cache de sites visités
- interdiction / autorisation de sites de fonction de certaines adresses (surf dans LAN mais blocage de certains sites WAN)
- interdiction de télécharger .exe et jeux

* * *

Proposition de l'utilisation du Design Pattern "Chaîne de responsabilités" :
http://rpouiller.developpez.com/tutoriel/java/design-patterns-gang-of-four/?page=page_4#LVI-A

###OBJECTIFS :

Eviter le couplage entre l'émetteur d'une requête et son récepteur en donnant à plus d'un objet une chance de traiter la requête.
Chaîner les objets récepteurs et passer la requête tout le long de la chaîne jusqu'à ce qu'un objet la traite.

###RAISONS DE L'UTILISER :

Le système doit gérer un requête. La requête implique plusieurs objets pour la traiter.

Cela peut être le cas d'un système complexe d'habilitations possèdant plusieurs critères afin d'autoriser l'accès. Ces critères peuvent varier en fonction de la configuration.

Le traitement est réparti sur plusieurs objets : les maillons. Les maillons sont chaînés. Si un maillon ne peut réaliser le traitement (vérification des droits), il donne sa chance au maillon suivant. Il est facile de faire varier les maillons impliqués dans le traitement.

###RESULTAT :

Le Design Pattern permet d'isoler les différentes parties d'un traitement.

###RESPONSABILITES :

Maillon : définit l'interface d'un maillon de la chaîne. La classe implèmente la gestion de la succession des maillons.
MaillonA, MaillonB et MaillonC : sont des sous-classes concrètes qui définissent un maillon de la chaîne. Chaque maillon a la responsabilité d'une partie d'un traitement.
La partie cliente appelle la méthode operation() du premier maillon de la chaîne.

* * *

* Proxy.java à intégrer dans CherchePageMaillon.java
* ChainProxy.java
* Maillon.java
* CherchePageMaillon.java
* CacheMaillon.java
* Requete.java
* Application.java : traitements réalisés dans le thread 'fil' instancié dans ChainProxy.java

* * *

###GIT, GITHUB ET ECLIPSE

* Branche Master : https://github.com/pchevallot/proxy
* Tutoriels pour eGit et Eclipse - L'excellent blog de Lars Vogel :
http://www.vogella.com/articles/EclipseGit/article.html

* Tutoriel en français (mais moins complet) :
http://www.php-geek.fr/configurer-et-utiliser-egit-eclipse.html
