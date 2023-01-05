create table person
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*SET character_set_client = utf8mb4 ;*/
CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint(20) DEFAULT NULL
) /*ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `hibernate_sequence`
VALUES (1);