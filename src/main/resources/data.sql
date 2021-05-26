delete from Sideeffects;
delete from vaccines;
delete from user_authority;
delete from user;
delete from authority;

INSERT INTO Vaccines(id,research_name, manufacturer_name, type_vaccine, necessary_vaccine, available_vaccine)VALUES
(1,'PF123', 'Phizer-Biotech', 'MRNA', 2, 1000),
(2,'Mod23', 'Moderna', 'Vrna', 2, 1000),
(3,'Az02', 'Astra Zeneca', 'Krna', 2, 1000),
(4,'J&J2', 'Johnson&Johnson', 'OVOZ', 2, 1000);

INSERT INTO Sideeffects(id,short_description, percentage, long_description, idvaccine, research_name)VALUES
(1,'Agresija', 2, 'jako agresivno ponasanje',1,'PF123' ),
(2,'CudnoPonasanje', 2, 'jcudno agresivno ponasanje',2,'Mod23');

INSERT INTO user(id,username, password, first_name, last_name)VALUES
(1,'admin', '$2b$10$lPXjqrhDJDgXP5r7l7D9XONAl07DuMVDd0HTG4Q1QewX/ks3/2NVS'  , 'admin', 'admin'),
(2,'user', '$2b$10$lPXjqrhDJDgXP5r7l7D9XONAl07DuMVDd0HTG4Q1QewX/ks3/2NVS', 'user', 'user'),
(3, 'deleter', '$2b$10$lPXjqrhDJDgXP5r7l7D9XONAl07DuMVDd0HTG4Q1QewX/ks3/2NVS', 'deleter', 'deleter' );

INSERT INTO authority(id, name)VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'DELETER');

INSERT INTO user_authority(user_id, authority_id)VALUES
(1,1),
(2,2),
(3,3);