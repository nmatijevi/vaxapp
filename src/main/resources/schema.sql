create table if not exists Vaccines(
    id identity,
    scienceName varchar(20) not null,
    producerName varchar(20) not null,
    typeOfVaccine varchar(20) not null,
    necessaryNumOfVaccine integer not null,
    availableVaccine integer not null
);

create table if not exists SideEffect(
    shortDescription varchar(20) not null,
    percentageOfEffect integer not null,
    longDescription varchar(40) not null

)






