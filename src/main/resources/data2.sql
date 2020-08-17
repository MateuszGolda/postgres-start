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
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    phone_number character varying(20) NOT NULL,
    email character varying(100) NOT NULL,
    application integer NOT NULL
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
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nick_name character varying(50) NOT NULL,
    phone_number character varying(20) NOT NULL,
    email character varying(100) NOT NULL,
    city character varying(50) NOT NULL,
    favourite_number integer
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

COPY public.applicants (id, first_name, last_name, phone_number, email, application) FROM stdin;
1	Dominique	Williams	003630/734-4926	dolor@laoreet.co.uk	61823
3	Zeph	Massey	003630/216-5351	a.feugiat.tellus@montesnasceturridiculus.co.uk	61349
4	Joseph	Crawford	003670/923-2669	lacinia.mattis@arcu.co.uk	12916
5	Ifeoma	Bird	003630/465-8994	diam.duis.mi@orcitinciduntadipiscing.com	65603
7	Jemima	Cantu	003620/423-4261	et.risus.quisque@mollis.co.uk	10384
8	Carol	Arnold	003630/179-1827	dapibus.rutrum@litoratorquent.com	70730
9	Jane	Forbes	003670/653-5392	janiebaby@adipiscingenimmi.edu	56882
11	Markus	Schaffarzyk	003620/725-2666	djnovus@groovecoverage.com	54823
2	Jemima	Foreman	003670/223-7459	magna@etultrices.net	58324
\.


--
-- Data for Name: applicants; Type: TABLE DATA; Schema: public; Owner: newuser
--

COPY public.applicants (id, first_name, last_name, nick_name, phone_number, email, city, favourite_number) FROM stdin;
1	Pál	Monoczki	Pali	003630/327-2663	pal.monoczki@codecool.com	Miskolc	\N
2	Sándor	Szodoray	Szodi	003620/519-9152	sandor.szodoray@codecool.com	Miskolc	7
3	Dániel	Salamon	Dani	003620/508-0706	daniel.salamon@codecool.com	Budapest	4
4	Miklós	Beöthy	Miki	003630/256-8118	miklos.beothy@codecool.com	Budapest	42
5	Tamás	Tompa	Tomi	003630/370-0748	tamas.tompa@codecool.com	Budapest	42
6	Mateusz	Ostafil	Mateusz	003648/518-664-923	mateusz.ostafil@codecool.com	Krakow	13
7	Anikó	Fenyvesi	Anikó	003670/111-2222	aniko.fenyvesi@codecool.com	Budapest	11
8	Immánuel	Fodor	Immi	003620/123-6234	immanuel.fodor@codecool.com	Budapest	3
9	László	Molnár	Laci	003620/222-5566	laszlo.molnar@codecool.com	Budapest	5
10	Mátyás	Forián Szabó	Matyi	003630/111-5532	matyas.forian.szabo@codecool.com	Budapest	90
11	Zoltán	Sallay	Zozi	003670/898-3122	zoltan.sallay@codecool.com	Budapest	5
12	Szilveszter	Erdős	Sly	003620/444-5555	szilveszter.erdos@codecool.com	Budapest	13
13	László	Terray	Laci	003670/402-2435	laszlo.terray@codecool.com	Budapest	8
14	Árpád	Törzsök	Árpád	003630/222-1221	arpad.torzsok@codecool.com	Budapest	9
15	Imre	Lindi	Imi	003670/222-1233	imre.lindi@codecool.com	Miskolc	3
16	Róbert	Kohányi	Robi	003630/123-5553	robert.kohanyi@codecool.com	Miskolc	\N
17	Przemysław	Ciąćka	Przemek	003670/222-4554	przemyslaw.ciacka@codecool.com	Krakow	55
18	Marcin	Izworski	Marcin	003670/999-2323	marcin.izworski@codecool.com	Krakow	55
19	Rafał	Stępień	Rafal	003630/323-5343	rafal.stepien@codecool.com	Krakow	3
20	Agnieszka	Koszany	Agi	003630/111-5343	agnieszka.koszany@codecool.com	Krakow	77
21	Mateusz	Steliga	Mateusz	003630/123-5343	mateusz.steliga@codecool.com	Krakow	5
22	Attila	Molnár	Atesz	003670/630-0539	attila.molnar@codecool.com	Budapest	23
\.


--
-- Name: applicants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: newuser
--

SELECT pg_catalog.setval('public.applicants_id_seq', 11, true);


--
-- Name: mentors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: newuser
--

SELECT pg_catalog.setval('public.mentors_id_seq', 22, true);


--
-- Name: applicants applicants_email_key; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_email_key UNIQUE (email);


--
-- Name: applicants applicants_phone_number_key; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_phone_number_key UNIQUE (phone_number);


--
-- Name: applicants applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);


--
-- Name: applicants mentors_email_key; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT mentors_email_key UNIQUE (email);


--
-- Name: applicants mentors_phone_number_key; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT mentors_phone_number_key UNIQUE (phone_number);


--
-- Name: applicants mentors_pkey; Type: CONSTRAINT; Schema: public; Owner: newuser
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT mentors_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

