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

Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("romain@mail.com", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", "romain perez",  CAST("1999-09-15" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("antoine@mail.com", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", "antoine guenard",  CAST("1999-03-22" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("camille@mail.com", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", "camille vidal",  CAST("1993-06-15" AS date), true);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("lucas@mail.com", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", "lucas gayraud",  CAST("1999-08-23" AS date), false);
