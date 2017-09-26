-- CREATE FK FOR PARTICIPANTS --> USERS

alter table events.participants
  add constraint "participants_events.users_id_fk"
foreign key (user_id) references events.users (id);

--

-- CREATE FK FOR EVENTS --> USERS

alter table events.events
  add constraint events_participants_id_fk
foreign key (owner_id) references events.users (id);

--

-- CREATE FK FOR LOCATIONS --> PARTICIPANTS

alter table events.locations
  add constraint locations_participants_id_fk
foreign key (user_id) references events.participants (id);

--

-- CREATE FK FOR LOCATIONS --> EVENTS

alter table events.locations
  add constraint locations_events_id_fk
foreign key (event_id) references events.events (id);

--

-- CREATE FK FOR CHECKPOINTS --> EVENTS

alter table events.checkpoints
  add constraint checkpoints_events_id_fk
foreign key (event_id) references events.events (id);

--

-- CREATE FK FOR PASSED_CHECKPOINTS --> PARTICIPANTS

alter table events.passes_checkpoints
  add constraint passes_checkpoints_participants_id_fk
foreign key (participant_id) references events.participants (id);

--

-- CREATE FK FOR PASSED_CHECKPOINTS --> CHECKPOINTS

alter table events.passes_checkpoints
  add constraint passes_checkpoints_checkpoints_id_fk
foreign key (checkpoint_id) references events.checkpoints (id);

--

-- CREATE FK FOR TIME_SLICES --> CHECKPOINTS

alter table events.time_slices
  add constraint time_slices_checkpoints_from_id_fk
foreign key (segment_from) references events.checkpoints (id);

alter table events.time_slices
  add constraint time_slices_checkpoints_to_id_fk
foreign key (segment_to) references events.checkpoints (id);

--

-- CREATE FK FOR TIME_SLICES --> EVENTS

alter table events.time_slices
  add constraint time_slices_events_id_fk
foreign key (event_id) references events.events (id);

--