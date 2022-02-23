
DROP SCHEMA IF EXISTS sg CASCADE;
DROP TABLE IF EXISTS sg.family CASCADE;
DROP SEQUENCE IF EXISTS sg_family_s CASCADE;

CREATE SCHEMA sg;

CREATE SEQUENCE sg_family_s
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE sg.family
(
    id                 bigint NOT NULL DEFAULT nextval('sg_family_s'::regclass),
    sg_name            text,
    sg_description     text,
    sg_type            varchar(256) NOT NULL,
    start_date         TIMESTAMP    NOT NULL,
    end_date           TIMESTAMP
);
