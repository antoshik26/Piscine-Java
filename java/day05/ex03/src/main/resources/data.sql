INSERT INTO "User"(login, password) VALUES ('a', 'a');
INSERT INTO "User"(login, password) VALUES ('b', 'b');
INSERT INTO "User"(login, password) VALUES ('c', 'c');
INSERT INTO "User"(login, password) VALUES ('d', 'd');
INSERT INTO "User"(login, password) VALUES ('e', 'e');

INSERT INTO rooms(nameroom, userroom) values ('a_chat', 1);
INSERT INTO rooms(nameroom, userroom) values ('b_chat', 2);
INSERT INTO rooms(nameroom, userroom) values ('c_chat', 3);
INSERT INTO rooms(nameroom, userroom) values ('d_chat', 4);
INSERT INTO rooms(nameroom, userroom) values ('e_chat', 5);

INSERT INTO messages(idcreatmessages, idroommassages, textmassages, datamassages) values (1, 1, 'ab', '1999-01-08 04:05:06');
INSERT INTO messages(idcreatmessages, idroommassages, textmassages, datamassages) values (1, 1, 'ba', '1999-01-08 04:05:06');
INSERT INTO messages(idcreatmessages, idroommassages, textmassages, datamassages) values (1, 1, 'da', '1999-01-08 04:05:06');
INSERT INTO messages(idcreatmessages, idroommassages, textmassages, datamassages) values (1, 1, 'de', '1999-01-08 04:05:06');
INSERT INTO messages(idcreatmessages, idroommassages, textmassages, datamassages) values (1, 1, 'ee', '1999-01-08 04:05:06');