INSERT INTO Vaccines(science_name, producer_name, type_vaccine, necessary_vaccine, available_vaccine)VALUES
('PF123', 'Phizer-Biotech', 'MRNA', 2, 1000),
('Mod23', 'Moderna', 'Vrna', 2, 1000),
('Az02', 'Astra Zeneca', 'Krna', 2, 1000),
('J&J2', 'Johnson&Johnson', 'OVOZ', 2, 1000);

INSERT INTO Sideeffects(short_description, percentage, long_description, idvaccineside,vaccinename)VALUES
('Agresija', 2, 'jako agresivno ponasanje',1,'PF123' ),
('CudnoPonasanje', 2, 'jcudno agresivno ponasanje',2,'Mod23');
