-- TODO: Set up with Flyway migrations rather than this script
CREATE DATABASE joke_db;
CREATE TABLE jokes (
	id uuid default gen_random_uuid () PRIMARY key,
	joke VARCHAR(255) not null,
	punchline VARCHAR(255) not null
);