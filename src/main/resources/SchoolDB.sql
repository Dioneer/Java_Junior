drop table courses;
Create table if not exists courses(
id serial primary key,
title varchar(255),
duration time
);