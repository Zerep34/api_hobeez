use HobeezDataBase;

CREATE TABLE `Utilisateurs`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `email` varchar(50) NOT NULL,
    `pass` varchar(64) NOT NULL,
    `full_name` varchar(50) NOT NULL,
    `birthday` date NOT NULL,
    `hasChild` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `CentreInteret`
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `libelle`   VARCHAR(10) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `UserHasInteret`
(
    `id_user`   int NOT NULL,
    `id_interet` int NOT NULL,
    PRIMARY KEY (`id_user`, `id_interet`),
    FOREIGN KEY (id_user) REFERENCES Utilisateurs (id) On Delete Cascade,
    FOREIGN KEY (id_interet) REFERENCES CentreInteret (id) On Delete Cascade
);

Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("romain@mail.com", "password", "romain perez",  CAST("1999-09-15" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("antoine@mail.com", "password", "antoine guenard",  CAST("1999-03-22" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("camille@mail.com", "password", "camille vidal",  CAST("1993-06-15" AS date), true);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("lucas@mail.com", "password", "lucas gayraud",  CAST("1999-08-23" AS date), false);

Insert Into CentreInteret(libelle) Values ("Football");
Insert Into CentreInteret(libelle) Values ("Tennis");
Insert Into CentreInteret(libelle) Values ("Escalade");
Insert Into CentreInteret(libelle) Values ("Bar");
Insert Into CentreInteret(libelle) Values ("Boutique");

Insert Into UserHasInteret(id_user, id_interet)
Values (1, 1);
Insert Into UserHasInteret(id_user, id_interet)
Values (1, 2);
Insert Into UserHasInteret(id_user, id_interet)
Values (1, 4);
Insert Into UserHasInteret(id_user, id_interet)
Values (2, 1);
Insert Into UserHasInteret(id_user, id_interet)
Values (2, 3);
Insert Into UserHasInteret(id_user, id_interet)
Values (3, 1);
Insert Into UserHasInteret(id_user, id_interet)
Values (3, 4);
Insert Into UserHasInteret(id_user, id_interet)
Values (3, 5);
Insert Into UserHasInteret(id_user, id_interet)
Values (4, 1);
Insert Into UserHasInteret(id_user, id_interet)
Values (4, 5);
Insert Into UserHasInteret(id_user, id_interet)
Values (4, 4);