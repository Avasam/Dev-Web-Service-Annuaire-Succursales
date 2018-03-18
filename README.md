# Service d'annuaire des succursales membres pour le projet en développement web
Le service doit s'occupper de fournir une liste de succursales contenue dans une distance à partir d'un point.

Notre endpoint sera `/api/annuaire/succursales` avec en paramètres `distance`, `longitude` et `latitude` qui sont tous des float.

Diagramme de Base de Donnée  
![Diagramme de Base de Donnée](Documentation/DiagrammeBaseDeDonnée.PNG)

Diagramme de séquence  
![Diagramme de séquence](Documentation/DiagrammeSéquence.jpg)

Ce projet requiert une installation manuelle des librairies suivantes en plaçant le fichier .JAR dans le dossier /lib:
* /lib
  * gson-2.8.0.jar
  * okhttp-2.5.0.jar
  * okio-1.14.0.jar
