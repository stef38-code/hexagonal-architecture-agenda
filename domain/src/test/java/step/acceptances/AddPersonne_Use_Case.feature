# language: fr
Fonctionnalité: Ajouter Personne

  Scénario: Ajouter Personne
    Soit l'utilisateur veut ajouter une personne avec les attributs suivants
      | nom | prenom | dateNaiss   |
      | Ross      | Geller   | 2003-11-14 |
  Quand l'utilisateur enregistre une nouvel personne
    Alors  la nouvelle personne contient un id non null
