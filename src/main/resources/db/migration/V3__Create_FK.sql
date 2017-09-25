ALTER TABLE events.users ADD CONSTRAINT users_id_pk PRIMARY KEY (id);

-- CREATE FK FOR USERS

ALTER TABLE events.participants
  ADD CONSTRAINT user_id
FOREIGN KEY (user_id) REFERENCES users (id);