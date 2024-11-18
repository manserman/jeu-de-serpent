Description
Ce projet consiste à reproduire le célèbre jeu du serpent (Snake) en utilisant la bibliothèque Swing de Java pour l'interface graphique. Le projet met également en œuvre le concept de multi-threading pour offrir une gestion fluide et réactive des interactions et des animations du jeu. La difficulté du jeu est progressive : plus le score du joueur augmente, plus la vitesse du serpent s'accélère.

Fonctionnalités
Interface graphique avec Swing : Le jeu propose une interface utilisateur intuitive et visuelle, offrant une expérience similaire à celle du jeu classique.
Mécanique du jeu fluide grâce au multi-threading : Le serpent se déplace de manière continue et les interactions du joueur sont gérées de manière réactive.
Difficulté progressive : La vitesse du serpent augmente au fur et à mesure que le joueur accumule des points.
Système de collision : Détection des collisions avec les murs ou le corps du serpent, mettant fin à la partie.
Contrôle par le joueur : Le joueur contrôle la direction du serpent à l'aide des touches du clavier.
Points de nourriture : Chaque point consommé fait grandir le serpent, rendant le jeu de plus en plus difficile.
Prérequis
Java 11 ou version ultérieure.
IDE tel que IntelliJ IDEA, Eclipse ou tout autre éditeur de texte compatible Java.
Installation
Clonez ce dépôt :

bash
Copier le code
git clone [https://github.com/username/snake-game.git](https://github.com/manserman/jeu-de-serpent/)
Accédez au répertoire du projet :

bash
Copier le code
cd snake-game
Compilez et exécutez le projet à l'aide de votre IDE préféré ou de la ligne de commande :

bash
Copier le code
javac -d bin src/*.java
java -cp bin Main
Structure du Projet
src/ : Contient les fichiers sources du projet.
model/ : Contient la logique du jeu, y compris la gestion des déplacements du serpent, les collisions et le système de score.
view/ : Composants de l'interface graphique réalisés avec Swing pour afficher le plateau de jeu.
controller/ : Gère les interactions utilisateur et les mises à jour de l'état du jeu.
Utilisation
Lancez le jeu.
Utilisez les touches fléchées pour diriger le serpent.
Mangez les points de nourriture pour faire grandir le serpent et augmenter votre score.
Le jeu devient plus difficile à mesure que le serpent accélère en fonction de votre score.
Le jeu se termine si le serpent heurte un mur ou son propre corps.
Améliorations Futures
Ajout d'un tableau des scores pour enregistrer les meilleures performances des joueurs.
Amélioration des graphismes pour une meilleure immersion.
Intégration d'effets sonores et d'animations supplémentaires.
Création de niveaux de jeu et de challenges personnalisés.
