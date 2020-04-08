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
Values ("romain@mail.com", "$2y$10$CNjuXv5DrS3PeeeRJNiGV.Yzx8aYhP3TvLIo4P/M0OWemmgTZ62s2", "romain perez",  CAST("1999-09-15" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("antoine@mail.com", "$2y$10$CNjuXv5DrS3PeeeRJNiGV.Yzx8aYhP3TvLIo4P/M0OWemmgTZ62s2", "antoine guenard",  CAST("1999-03-22" AS date), false);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("camille@mail.com", "$2y$10$CNjuXv5DrS3PeeeRJNiGV.Yzx8aYhP3TvLIo4P/M0OWemmgTZ62s2", "camille vidal",  CAST("1993-06-15" AS date), true);
Insert Into Utilisateurs(email, pass, full_name, birthday, hasChild)
Values ("lucas@mail.com", "$2y$10$CNjuXv5DrS3PeeeRJNiGV.Yzx8aYhP3TvLIo4P/M0OWemmgTZ62s2", "lucas gayraud",  CAST("1999-08-23" AS date), false);
