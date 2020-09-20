DROP TABLE jumun_detail CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE jumun CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;

CREATE TABLE member(
		m_id                          		VARCHAR2(50)		 NULL ,
		m_password                    		VARCHAR2(50)		 NOT NULL,
		m_name                        		VARCHAR2(50)		 NULL ,
		m_email                       		VARCHAR2(150)		 NULL ,
		m_address                     		VARCHAR2(250)		 NULL ,
		m_phone                       		VARCHAR2(50)		 NULL 
);


CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(150)		 NULL ,
		p_img                         		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(150)		 NULL ,
		p_price                       		NUMBER(20)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE jumun(
		jumun_no                      		NUMBER(10)		 NULL ,
		jumun_name                    		VARCHAR2(150)		 NULL ,
		jumun_tot_price               		NUMBER(20)		 NULL ,
		jumun_date                    		DATE		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE jumun_jumun_no_SEQ;

CREATE SEQUENCE jumun_jumun_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		cart_price_total              		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

DROP SEQUENCE cart_p_no_SEQ;

CREATE SEQUENCE cart_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE board(
		board_no                      		NUMBER(10)		 NULL ,
		board_title                   		VARCHAR2(50)		 NULL ,
		board_date                    		DATE		 NULL ,
		board_content                 		VARCHAR2(200)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE board_board_no_SEQ;

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE jumun_detail(
		j_detail_no                   		NUMBER(10)		 NULL ,
		j_detail_name                 		VARCHAR2(50)		 NULL ,
		jumun_no                      		NUMBER(10)		 NULL ,
		jumun_qty                     		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE jumun_detail_j_detail_no_SEQ;

CREATE SEQUENCE jumun_detail_j_detail_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

DROP SEQUENCE jumun_detail_p_no_SEQ;

CREATE SEQUENCE jumun_detail_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (m_id);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE jumun ADD CONSTRAINT IDX_jumun_PK PRIMARY KEY (jumun_no);
ALTER TABLE jumun ADD CONSTRAINT IDX_jumun_FK0 FOREIGN KEY (m_id) REFERENCES member (m_id);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (m_id) REFERENCES member (m_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE board ADD CONSTRAINT IDX_board_FK0 FOREIGN KEY (m_id) REFERENCES member (m_id);

ALTER TABLE jumun_detail ADD CONSTRAINT IDX_jumun_detail_PK PRIMARY KEY (j_detail_no);
ALTER TABLE jumun_detail ADD CONSTRAINT IDX_jumun_detail_FK0 FOREIGN KEY (jumun_no) REFERENCES jumun (jumun_no);
ALTER TABLE jumun_detail ADD CONSTRAINT IDX_jumun_detail_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

