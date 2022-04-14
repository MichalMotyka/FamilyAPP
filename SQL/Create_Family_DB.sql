create database FamilyDB;
CREATE TABLE `Family` (
  `familyName` varchar(30) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `nrOfAdults` int DEFAULT NULL,
  `nrOfChildren` int DEFAULT NULL,
  `nrOfinfants` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM FamilyDB.Family;