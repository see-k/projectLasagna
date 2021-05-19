-- Cats production script
-- Author Chike Okonta, Quinn Chu, Derrick Fidleman
-- Date 05/20/2021

drop database if exists cat_tracker;
create database cat_tracker;
use cat_tracker;

-- User: assigned to Chike Okonta
CREATE TABLE users (
	users_id int PRIMARY KEY AUTO_INCREMENT,
    users_name VARCHAR(25) NOT NULL,
    users_email VARCHAR(50),
    diabled BOOLEAN NOT NULL DEFAULT(0)
);

-- Location: assigned to Chike Okonta
CREATE TABLE location (
	location_id int PRIMARY KEY AUTO_INCREMENT,
    latitude DECIMAL(8,6),
    longitude DECIMAL(8,6)
);

-- Cat: assigned to Derrick Fidelman
CREATE TABLE cat (
	cat_id int PRIMARY KEY AUTO_INCREMENT,
    cat_name varchar(50) NOT NULL,
    img_path varchar(100) NULL,
    cat_description varchar(300) NULL,
    disabled bit NOT NULL,
    users_id int NOT NULL,
    CONSTRAINT fk_cat_users_id
		FOREIGN KEY (users_id)
        REFERENCES users(users_id)
);

-- Alias: assigned to Derrick Fidelman
CREATE TABLE alias (
	alias_id int PRIMARY KEY AUTO_INCREMENT,
    alias_name varchar(50) NOT NULL,
    cat_id int NOT NULL,
    CONSTRAINT fk_alias_cat_id
		FOREIGN KEY (cat_id)
        REFERENCES cat(cat_id)
);

-- Sightings: assigned to Quinn Chu

-- Reports: assigned to Quinn Chu

-- create tables and relationships


