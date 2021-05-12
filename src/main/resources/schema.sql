create table if not exists Vaccines(
    id identity,
    research_name varchar(20) not null,
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
    research_name varchar(20) not null,
    foreign key (research_name) references Vaccines(research_name)
);

create table if not exists user(
    id identity,
    username varchar(100) not null,
    password varchar(250) not null,
    first_name varchar(250) not null,
    last_name varchar(250) not null
);

create table if not exists authority(
    id identity,
    name varchar(100) not null
);

create table if not exists user_authority(
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key(authority_id) references authority(id)
)







