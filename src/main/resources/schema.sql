create table if not exists Vaccines(
    id identity,
    science_name varchar(20) not null,
    producer_name varchar(20) not null,
    type_vaccine varchar(20) not null,
    necessary_vaccine integer not null,
    available_vaccine integer not null
);
create table if not exists Sideeffects(
    id identity,
    short_description varchar(20) not null,
    percentage integer not null,
    long_description varchar(40) not null,
    idvaccine integer not null,
    science_name varchar(20) not null,
    foreign key (science_name) references Vaccines(science_name)
);









