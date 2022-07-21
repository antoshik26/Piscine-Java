Create TABLE "User"(
                       Id serial
                           constraint user_id_uindex
                               primary key,
                       Login text NOT NULL UNIQUE,
                       Password text NOT NULL
);
create unique index user_id_uindex
    on "User"(Id);

CREATE TABLE rooms(
                      Id serial
                          constraint table_name_pk
                              primary key,
                      NameRoom text NOT NULL UNIQUE,
                      UserRoom INTEGER REFERENCES "User"(Id)
);
create unique index rooms_id_uindex
    on rooms(Id);

CREATE TABLE Messages(
                         Id serial
                             constraint Messages_id_uindex
                                 primary key,
                         IdCreatMessages INTEGER REFERENCES "User"(Id),
                         IdRoomMassages INTEGER REFERENCES rooms(Id),
                         TextMassages text NOT NULL,
                         DataMassages timestamp not null
);
create unique index Messages_id_uindex
    on Messages (Id);