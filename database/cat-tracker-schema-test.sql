-- Cats test script
-- Author Chike Okonta, Quinn Chu, Derrick Fidleman
-- Date 05/20/2021

drop database if exists cat_tracker_test;
create database cat_tracker_test;
use cat_tracker_test;

-- Set known good state: assigned to Chike Okonta, Quinn Chu, Derrick Fidleman

-- User: assigned to Chike Okonta

-- Location: assigned to Chike Okonta

-- Alias: assigned to Derrick Fidelman
CREATE TABLE alias (
	alias_id int PRIMARY KEY AUTO_INCREMENT,
    alias_name varchar(50) NOT NULL,
    cat_id int NOT NULL,
    CONSTRAINT fk_alias_cat_id
		FOREIGN KEY (cat_id)
        REFERENCES cat(cat_id)
);

-- Cat: assigned to Derrick Fidelman
CREATE TABLE cat (
	cat_id int PRIMARY KEY AUTO_INCREMENT,
    cat_name varchar(50) NOT NULL,
    img_path varchar(100) NULL,
    cat_description varchar(300) NULL,
    disabled bit NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT fk_cat_user_id
		FOREIGN KEY (user_id)
        REFERENCES `user`(user_id)
);

-- Sighting: assigned to Quinn Chu

-- Report: assigned to Quinn Chu

-- create tables and relationships