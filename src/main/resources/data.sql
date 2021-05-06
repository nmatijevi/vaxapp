INSERT INTO Vaccines(id,science_name, producer_name, type_vaccine, necessary_vaccine, available_vaccine)VALUES
(1,'PF123', 'Phizer-Biotech', 'MRNA', 2, 1000),
(2,'Mod23', 'Moderna', 'Vrna', 2, 1000),
(3,'Az02', 'Astra Zeneca', 'Krna', 2, 1000),
(4,'J&J2', 'Johnson&Johnson', 'OVOZ', 2, 1000);

INSERT INTO Sideeffects(id,short_description, percentage, long_description, idvaccine, science_name)VALUES
(1,'Agresija', 2, 'jako agresivno ponasanje',1,'PF123' ),
(2,'CudnoPonasanje', 2, 'jcudno agresivno ponasanje',2,'Mod23');
