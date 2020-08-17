--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: applicants; Type: TABLE; Schema: public; Owner: newuser
--

CREATE TABLE public.applicants (
    first_name text,
    last_name text,
    phone_number text,
    email text,
    application_code text,
    id integer NOT NULL
);


ALTER TABLE public.applicants OWNER TO newuser;

--
-- Name: applicants_id_seq; Type: SEQUENCE; Schema: public; Owner: newuser
--

CREATE SEQUENCE public.applicants_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.applicants_id_seq OWNER TO newuser;

--
-- Name: applicants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: newuser
--

ALTER SEQUENCE public.applicants_id_seq OWNED BY public.applicants.id;


--
-- Name: applicants; Type: TABLE; Schema: public; Owner: newuser
--

CREATE TABLE public.applicants (
    first_name text,
    last_name text,
    nick_name text,
    phone_number text,
    email text,
    city text,
    favourite_number integer,
    id integer NOT NULL
);


ALTER TABLE public.applicants OWNER TO newuser;

--
-- Name: mentors_id_seq; Type: SEQUENCE; Schema: public; Owner: newuser
--

CREATE SEQUENCE public.mentors_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mentors_id_seq OWNER TO newuser;

--
-- Name: mentors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: newuser
--

ALTER SEQUENCE public.mentors_id_seq OWNED BY public.applicants.id;


--
-- Name: applicants id; Type: DEFAULT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants ALTER COLUMN id SET DEFAULT nextval('public.applicants_id_seq'::regclass);


--
-- Name: applicants id; Type: DEFAULT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants ALTER COLUMN id SET DEFAULT nextval('public.mentors_id_seq'::regclass);


--
-- Data for Name: applicants; Type: TABLE DATA; Schema: public; Owner: newuser
--

COPY public.applicants (first_name, last_name, phone_number, email, application_code, id) FROM stdin;
\.


--
-- Data for Name: applicants; Type: TABLE DATA; Schema: public; Owner: newuser
--

COPY public.applicants (first_name, last_name, nick_name, phone_number, email, city, favourite_number, id) FROM stdin;
\.


--
-- Name: applicants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: newuser
--

SELECT pg_catalog.setval('public.applicants_id_seq', 1, false);


--
-- Name: mentors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: newuser
--

SELECT pg_catalog.setval('public.mentors_id_seq', 1, false);


--
-- Name: applicants applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);


--
-- Name: applicants mentors_pkey; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT mentors_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

