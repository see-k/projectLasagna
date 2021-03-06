  
-- Cats production script
-- Author Chike Okonta, Quinn Chu, Derrick Fidleman
-- Date 05/20/2021

drop database if exists cat_tracker;
create database cat_tracker;
use cat_tracker;

-- User: assigned to Chike Okonta
CREATE TABLE users (
	users_id int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(25) NOT NULL,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    users_email VARCHAR(50),
    disabled BIT NOT NULL DEFAULT 0
);

-- Location: assigned to Chike Okonta
CREATE TABLE location (
	location_id int PRIMARY KEY AUTO_INCREMENT,
    latitude DECIMAL(8,6),
    longitude DECIMAL(9,6)
);

-- Cat: assigned to Derrick Fidelman
CREATE TABLE cat (
	cat_id int PRIMARY KEY AUTO_INCREMENT,
    cat_name varchar(50) NOT NULL,
    img_path varchar(100) NULL,
    cat_description varchar(300) NULL,
    disabled bit NOT NULL default 0,
    users_id int NULL,
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
create table sighting (
	sighting_id int primary key not null auto_increment,
    img_path varchar(100),
    visual_description varchar(300),
    sighting_description varchar(300),
    sighting_date date not null,
    sighting_time time not null,
    latitude decimal(16,14) not null,
    longitude decimal(17,14) not null,
    disabled bit not null default 0,
    users_id int NOT NULL,
    cat_id int,
    constraint fk_sighting_users_id
		foreign key (users_id)
        references users(users_id),
	constraint fk_sighting_cat_id
		foreign key (cat_id)
        references cat(cat_id)
);
-- Reports: assigned to Quinn Chu
create table report (
	report_id int primary key not null auto_increment,
    report_description varchar(300),
    cat_id int,
    users_id int,
    sighting_id int,
    constraint fk_report_cat_id
		foreign key (cat_id)
        references cat(cat_id),
	constraint fk_report_users_id
		foreign key (users_id)
        references users(users_id),
    constraint fk_report_sighting_id
		foreign key (sighting_id)
        references sighting(sighting_id)
);


 insert into users(users_id, username, first_name, last_name, users_email, disabled) values
		(1, 'COkonta', 'Chike', 'Okonta', 'COkonta@dev-10.com', 0),
        (2, 'QChu', 'Quinn', 'Chu', 'QChu@dev-10.com', 0),
        (3, 'DFidelman', 'Derrick', 'Fidelman', 'DFidelman@dev-10.com', 0);
        
	insert into location(location_id, latitude, longitude) values
		(1, 44.943687, -93.296228),
        (2, 44.947434, -93.292580),
        (3, 44.944966, -93.290499);
        
	insert into cat(cat_id, cat_name, img_path, cat_description, disabled, users_id) values
		(1, 'Noodle', 'noodle.jpg', '', 0, 2),
        (2, 'Garfield', 'garfield.jpg', '', 0, 1),
        (3, 'Gary', 'gary.jpg', '', 0, 3);

        
	insert into alias(alias_id, alias_name, cat_id) values
		(1, 'Garfield', 2),
        (2, 'The Snail', 3);
        
	insert into sighting(sighting_id, img_path, visual_description, sighting_description, sighting_date, sighting_time, latitude, longitude, disabled, users_id, cat_id) values 
		(1, './database/images/gary_sighting_01-01-2001.jpg','black and white cat, small, name tag says gary','saw this guy outside CVS, very friendly and requested many pets','2001-01-01','18:50:12', 44.947434, -93.292580, 0, 3, 3);
        
	insert into report(report_id, report_description, cat_id, users_id, sighting_id) values
		(1, 'it is not a cat. its a snail', 3, 1, 1);
    
-- create tables and relationships

drop table if exists app_user_role;
drop table if exists app_role;
drop table if exists app_user;

create table app_user (
    app_user_id int primary key auto_increment,
    username varchar(50) not null unique,
    password_hash varchar(2048) not null,
    disabled boolean not null default(0)
);

create table app_role (
    app_role_id int primary key auto_increment,
    `name` varchar(50) not null unique
);

create table app_user_role (
    app_user_id int not null,
    app_role_id int not null,
    constraint pk_app_user_role
        primary key (app_user_id, app_role_id),
    constraint fk_app_user_role_user_id
        foreign key (app_user_id)
         references app_user(app_user_id),
	constraint fk_app_user_role_role_id
         foreign key (app_role_id)
         references app_role(app_role_id)
);

insert into app_role (`name`) values
    ('USER'),
    ('ADMIN');

