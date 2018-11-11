DROP TABLE IF EXISTS coc.clanwarapp;
CREATE database coc;
use coc;
CREATE TABLE `clanwarapp` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`war_id` INT(8) UNSIGNED NOT NULL DEFAULT '0',
	`member_tag` CHAR(7) NOT NULL DEFAULT '\'\'' COLLATE 'utf8_bin',
	`begin_date` DATE NOT NULL DEFAULT '1990-01-01',
	PRIMARY KEY (`id`)
)
COMMENT='Apply to Clan War'
COLLATE='utf8_bin'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

#Data input sample for coc.clanwarapp
insert into coc.clanwarapp (war_id,member_tag,begin_date) values ('12','deidfed','1990-01-01');



