
-- CREATE TABLE USERS

create table events.users
(
  id serial,
  users_login character(100) not null,
  users_password varchar(1000),
  full_name varchar(300),
  users_email varchar(150),
  isadmin boolean
);
create unique index users_users_login_uindex on events.users (users_login);
comment on table events.users is 'table for information about users';

--

-- CREATE TABLE PARTICIPANTS

create table events.participants
(
  id serial primary key,
  user_id int,
  event_id int
);
comment on table events.participants is 'table for information about users as participants';

--

-- CREATE TABLE EVENTS

create table events.events
(
  id serial primary key,
  type_id int,
  event_name character(300),
  date_start date,
  owner_id int not null,
  column_6 int,
  is_protected_event boolean,
  qr_enable boolean,
  description varchar(4000)
);

--

-- CREATE TABLE CHECKPOINTS

create table events.checkpoints
(
  id serial primary key,
  checkpoints_name int,
  event_id int,
  latitude float8,
  longitude float8,
  description varchar(4000)
);

--

-- CREATE TABLE PASSED CHECKPOINTS

create table events.passes_checkpoints
(
  id serial primary key,
  participant_id int,
  checkpoint_id int,
  passed_time date,
  is_questionably boolean,
  description varchar(3000)
);

--

--CREATE TABLE TIME SLICES

create table events.time_slices
(
  id serial primary key,
  segment_from int,
  segment_to int,
  event_id int,
  time_count int
);

--

--CREATE TABLE LOCATIONS

CREATE TABLE events.locations
(
  id SERIAL PRIMARY KEY,
  user_id INT,
  event_id INT,
  latitude FLOAT8,
  longitude FLOAT8
);

--

--CREATE TABLE DICTIONARY

CREATE TABLE events.dictionary
(
  id INT,
  dict_value CHARACTER(200)
);

--