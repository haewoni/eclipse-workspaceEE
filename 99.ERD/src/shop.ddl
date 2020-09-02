DROP TABLE cart1 CASCADE CONSTRAINTS;
DROP TABLE jumun_detail1 CASCADE CONSTRAINTS;
DROP TABLE jumun1 CASCADE CONSTRAINTS;
DROP TABLE product1 CASCADE CONSTRAINTS;
DROP TABLE user1 CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: user1 */
/**********************************/
CREATE TABLE user1(
		user_id                       		VARCHAR2(50)		 NULL ,
		user_password                 		VARCHAR2(50)		 NULL ,
		user_name                     		VARCHAR2(50)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE user1 is 'user1';
COMMENT ON COLUMN user1.user_id is 'user_id';
COMMENT ON COLUMN user1.user_password is 'user_password';
COMMENT ON COLUMN user1.user_name is 'user_name';
COMMENT ON COLUMN user1.user_email is 'user_email';


/**********************************/
/* Table Name: product1 */
/**********************************/
CREATE TABLE product1(
		product_no                    		NUMBER(10)		 NULL ,
		product_name                  		VARCHAR2(100)		 NULL ,
		product_price                 		NUMBER(10)		 DEFAULT 0		 NULL ,
		product_image                 		VARCHAR2(50)		 NULL ,
		product_desc                  		VARCHAR2(1024)		 NULL ,
		product_click_count           		NUMBER(10)		 DEFAULT 0		 NULL 
);

COMMENT ON TABLE product1 is 'product1';
COMMENT ON COLUMN product1.product_no is 'product_no';
COMMENT ON COLUMN product1.product_name is 'product_name';
COMMENT ON COLUMN product1.product_price is 'product_price';
COMMENT ON COLUMN product1.product_image is 'product_image';
COMMENT ON COLUMN product1.product_desc is 'product_desc';
COMMENT ON COLUMN product1.product_click_count is 'product_click_count';


/**********************************/
/* Table Name: jumun1 */
/**********************************/
CREATE TABLE jumun1(
		jumun_no                      		NUMBER(10)		 NULL ,
		jumun_desc                    		VARCHAR2(50)		 NULL ,
		jumun_date                    		DATE		 DEFAULT sysdate		 NULL ,
		jumun_price                   		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE jumun1 is 'jumun1';
COMMENT ON COLUMN jumun1.jumun_no is 'jumun_no';
COMMENT ON COLUMN jumun1.jumun_desc is 'jumun_desc';
COMMENT ON COLUMN jumun1.jumun_date is 'jumun_date';
COMMENT ON COLUMN jumun1.jumun_price is 'jumun_price';
COMMENT ON COLUMN jumun1.user_id is 'user_id';


/**********************************/
/* Table Name: jumun_detail1 */
/**********************************/
CREATE TABLE jumun_detail1(
		jumun_detail_no               		NUMBER(10)		 NULL ,
		jumun_no                      		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		jumun_detail_count            		NUMBER(10)		 NULL 
);

COMMENT ON TABLE jumun_detail1 is 'jumun_detail1';
COMMENT ON COLUMN jumun_detail1.jumun_detail_no is 'jumun_detail_no';
COMMENT ON COLUMN jumun_detail1.jumun_no is 'jumun_no';
COMMENT ON COLUMN jumun_detail1.product_no is 'product_no';
COMMENT ON COLUMN jumun_detail1.jumun_detail_count is 'jumun_detail_count';


/**********************************/
/* Table Name: cart1 */
/**********************************/
CREATE TABLE cart1(
		cart_item_no                  		NUMBER(10)		 NULL ,
		cart_item_qty                 		NUMBER(10)		 NULL ,
		cart_item_tot_price           		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(50)		 NULL ,
		product_no                    		NUMBER(10)		 NULL 
);

COMMENT ON TABLE cart1 is 'cart1';
COMMENT ON COLUMN cart1.cart_item_no is 'cart_item_no';
COMMENT ON COLUMN cart1.cart_item_qty is 'cart_item_qty';
COMMENT ON COLUMN cart1.cart_item_tot_price is 'cart_item_tot_price';
COMMENT ON COLUMN cart1.user_id is 'user_id';
COMMENT ON COLUMN cart1.product_no is 'product_no';



ALTER TABLE user1 ADD CONSTRAINT IDX_user1_PK PRIMARY KEY (user_id);

ALTER TABLE product1 ADD CONSTRAINT IDX_product1_PK PRIMARY KEY (product_no);

ALTER TABLE jumun1 ADD CONSTRAINT IDX_jumun1_PK PRIMARY KEY (jumun_no);
ALTER TABLE jumun1 ADD CONSTRAINT IDX_jumun1_FK0 FOREIGN KEY (user_id) REFERENCES user1 (user_id);

ALTER TABLE jumun_detail1 ADD CONSTRAINT IDX_jumun_detail1_PK PRIMARY KEY (jumun_detail_no);
ALTER TABLE jumun_detail1 ADD CONSTRAINT IDX_jumun_detail1_FK0 FOREIGN KEY (jumun_no) REFERENCES jumun1 (jumun_no);
ALTER TABLE jumun_detail1 ADD CONSTRAINT IDX_jumun_detail1_FK1 FOREIGN KEY (product_no) REFERENCES product1 (product_no);

ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_PK PRIMARY KEY (cart_item_no);
ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_FK0 FOREIGN KEY (user_id) REFERENCES user1 (user_id);
ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_FK1 FOREIGN KEY (product_no) REFERENCES product1 (product_no);

