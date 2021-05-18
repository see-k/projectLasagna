-- Cats production script
-- Author Chike Okonta, Quinn Chu, Derrick Fidleman
-- Date 05/20/2021

drop database if exists cat_tracker;
create database cat_tracker;
use cat_tracker;

-- User: assigned to Chike Okonta

-- Location: assigned to Chike Okonta

-- Cats: assigned to Derrick Fidleman

-- Alias: assigned to Derrick Fidleman

-- Sightings: assigned to Quinn Chu
create table sighting (
	sighting_id int primary key not null auto_increment,
    img_path varchar(100),
    sighting_description varchar(300),
    disabled bit not null default 0,
    constraint fk_sighting_user_id
		foreign key (user_id)
        references `user`(user_id),
	constraint fk_sighting_location_id
		foreign key (location_id)
        references location(location_id),
	constraint fk_sighting_cat_id
		foreign key (cat_id)
        references cat(cat_id)
);
-- Reports: assigned to Quinn Chu
create table report (
	report_id int not null auto_increment,
    description varchar(300),
    constraint fk_report_cat_id
		foreign key (cat_id)
        references cat(cat_id),
	constraint fk_report_user_id
		foreign key (user_id)
        references `user`(user_id),
    constraint fk_report_sighting_id
		foreign key (sighting_id)
        references sighting(sighting_id)
);


-- create tables and relationships
