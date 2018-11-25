DROP TABLE IF EXISTS coc.clanwarapp;
CREATE DATABASE `coc` /*!40100 COLLATE 'utf8_bin' */
use coc;
CREATE TABLE `clanwarapp` (
    `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `war_id` INT(8) UNSIGNED NOT NULL DEFAULT '0',
    `member_id` INT(11) UNSIGNED NOT NULL,
    `begin_date` DATE NOT NULL DEFAULT '1990-01-01',
    `status` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
)
COMMENT='Apply to Clan War'
COLLATE='utf8_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

#Data input sample for coc.clanwarapp
insert into coc.clanwarapp (war_id,member_tag,begin_date) values ('12','deidfed','1990-01-01');

CREATE TABLE `member` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`tag` CHAR(7) NOT NULL COLLATE 'utf8_bin',
	`name` CHAR(20) NOT NULL COLLATE 'utf8_bin',
	`position` CHAR(3) NOT NULL DEFAULT '0' COLLATE 'utf8_bin',
	`donations` INT(5) NOT NULL DEFAULT '0',
	`donationsReceived` INT(5) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

ALTER TABLE `member` ADD UNIQUE INDEX `tag` (`tag`);

CREATE TABLE `war` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`status` TINYINT(4) NOT NULL COMMENT '0-undefine,1-active,2-finished',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
;




