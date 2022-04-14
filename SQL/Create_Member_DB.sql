Create database FamilyMemberDB;
Create Table FamilyMember(
familyId int not null,
familyName varchar(30) not null,
givenName varchar(30) not null,
id int auto_increment primary key)