# language: fr
Fonctionnalité: Ajouter Personne

  Scénario: Ajouter une personne
    Soit l'utilisateur veut ajouter une personne avec les attributs suivants
      | nom | prenom | dateNaiss   |
      | Ross      | Geller   | 2003-11-14 |
  Quand l'utilisateur enregistre une nouvel personne
    Alors  la nouvelle personne contient un id non null

  Scénario: Ajouter plusieurs personnes
    Soit l'utilisateur veut ajouter plusieurs personnes avec les attributs suivants
      | nom | prenom | dateNaiss   |
      | Ross      | Geller   | 2003-11-14 |
      | Jerde      | Myrle   | 1945-05-28 |
      | Rice      | Devin   | 2001-01-24 |
      | Aufderhar      | Denver   | 1980-07-06 |
      | Collins      | Adolfo   | 1998-09-18 |
    Quand l'utilisateur enregistre la liste des personnes
    Alors  la liste des personnes non null
    Et a un taille de 5
    Et chaque personne a un id non null
