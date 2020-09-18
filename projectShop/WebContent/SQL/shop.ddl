DROP TABLE jumun_detail CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE jumun CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: member */
/**********************************/
CREATE TABLE member(
		m_id                          		VARCHAR2(50)		 NULL ,
		m_password                    		VARCHAR2(50)		 NULL ,
		m_name                        		VARCHAR2(50)		 NULL ,
		m_email                       		VARCHAR2(150)		 NULL ,
		m_address                     		VARCHAR2(250)		 NULL ,
		m_phone                       		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE member is 'member';
COMMENT ON COLUMN member.m_id is 'm_id';
COMMENT ON COLUMN member.m_password is 'm_password';
COMMENT ON COLUMN member.m_name is 'm_name';
COMMENT ON COLUMN member.m_email is 'm_email';
COMMENT ON COLUMN member.m_address is 'm_address';
COMMENT ON COLUMN member.m_phone is 'm_phone';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(150)		 NULL ,
		p_img                         		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(150)		 NULL ,
		p_price                       		NUMBER(20)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_no is 'p_no';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_img is 'p_img';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_price is 'p_price';


/**********************************/
/* Table Name: jumun */
/**********************************/
CREATE TABLE jumun(
		jumun_no                      		NUMBER(10)		 NULL ,
		jumun_name                    		VARCHAR2(150)		 NULL ,
		jumun_tot_price               		NUMBER(20)		 NULL ,
		jumun_date                    		DATE		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE jumun_jumun_no_SEQ;

CREATE SEQUENCE jumun_jumun_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE jumun is 'jumun';
COMMENT ON COLUMN jumun.jumun_no is 'jumun_no';
COMMENT ON COLUMN jumun.jumun_name is 'jumun_name';
COMMENT ON COLUMN jumun.jumun_tot_price is 'jumun_tot_price';
COMMENT ON COLUMN jumun.jumun_date is 'jumun_date';
COMMENT ON COLUMN jumun.m_id is 'm_id';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL ,
		cart_price_total              		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

DROP SEQUENCE cart_p_no_SEQ;

CREATE SEQUENCE cart_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_no is 'cart_no';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN cart.cart_price_total is 'cart_price_total';
COMMENT ON COLUMN cart.m_id is 'm_id';
COMMENT ON COLUMN cart.p_no is 'p_no';


/**********************************/
/* Table Name: borad */
/**********************************/
CREATE TABLE board(
		board_no                      		NUMBER(10)		 NULL ,
		board_title                   		NUMBER(10)		 NULL ,
		board_date                    		NUMBER(10)		 NULL ,
		board_content                 		NUMBER(10)		 NULL ,
		m_id                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE board_board_no_SEQ;

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


COMMENT ON TABLE board is 'borad';
COMMENT ON COLUMN board.board_no is 'board_no';
COMMENT ON COLUMN board.board_title is 'board_title';
COMMENT ON COLUMN board.board_date is 'board_date';
COMMENT ON COLUMN board.board_content is 'board_content';
COMMENT ON COLUMN board.m_id is 'm_id';


/**********************************/
/* Table Name: jumun_detail */
/**********************************/
CREATE TABLE jumun_detail(
		j_detail_no                   		NUMBER(10)		 NULL ,
		jumun_no                      		NUMBER(10)		 NULL ,
		jumun_qty                     		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE jumun_detail_j_detail_no_SEQ;

CREATE SEQUENCE jumun_detail_j_detail_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

DROP SEQUENCE jumun_detail_p_no_SEQ;

CREATE SEQUENCE jumun_detail_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE jumun_detail is 'jumun_detail';
COMMENT ON COLUMN jumun_detail.j_detail_no is 'j_detail_no';
COMMENT ON COLUMN jumun_detail.jumun_no is 'jumun_no';
COMMENT ON COLUMN jumun_detail.jumun_qty is 'jumun_qty';
COMMENT ON COLUMN jumun_detail.p_no is 'p_no';



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

COMMIT;
