--insert member
INSERT INTO member (m_id, m_password, m_name, m_email, m_address, m_phone) 
VALUES ('guard1', '1111', '신혜원', 'guard1@gmail.com', '강서구', '010-1111-2222');
INSERT INTO member (m_id, m_password, m_name, m_email, m_address, m_phone) 
VALUES ('guard2', '2222', '신지원', 'guard2@gmail.com', '강서구', '010-1111-3333');


--insert product
INSERT INTO product (p_no, p_name, p_img, p_desc, p_price) 
VALUES (product_p_no_SEQ.nextval, '쉬반단반피자', 'banban.png', '#닭고기#단호박#새우#치즈', 28000);
INSERT INTO product (p_no, p_name, p_img, p_desc, p_price) 
VALUES (product_p_no_SEQ.nextval, '꿈을피자', 'dream.png', '#불고기#바질#해남산고구마', 28000);
INSERT INTO product (p_no, p_name, p_img, p_desc, p_price) 
VALUES (product_p_no_SEQ.nextval, '어깨피자', 'shoulder.png', '#9가지맛#닭고기#단호박#새우', 28000);


--insert cart
INSERT INTO cart (cart_no, cart_qty, cart_price_total, m_id, p_no) 
VALUES (cart_cart_no_SEQ.nextval, 2, 56000, 'guard1', 1);
INSERT INTO cart (cart_no, cart_qty, cart_price_total, m_id, p_no) 
VALUES (cart_cart_no_SEQ.nextval, 1, 28000, 'guard1', 3);
INSERT INTO cart (cart_no, cart_qty, cart_price_total, m_id, p_no) 
VALUES (cart_cart_no_SEQ.nextval, 1, 28000, 'guard2', 2);


--insert jumun
INSERT INTO jumun (jumun_no, jumun_name, jumun_tot_price, jumun_date, m_id) 
VALUES (JUMUN_JUMUN_NO_SEQ.nextval, '꿈을피자 외 1종', 56000, sysdate, 'guard1');

--insert jumun_detail
INSERT INTO jumun_detail (j_detail_no, j_detail_name, jumun_no, jumun_qty, p_no) 
VALUES (JUMUN_DETAIL_J_DETAIL_NO_SEQ.nextval,'꿈을피자', 1,JUMUN_JUMUN_NO_SEQ.currval, 2);
INSERT INTO jumun_detail (j_detail_no, j_detail_name, jumun_no, jumun_qty, p_no) 
VALUES (JUMUN_DETAIL_J_DETAIL_NO_SEQ.nextval, '어깨피자', 1, JUMUN_JUMUN_NO_SEQ.currval, 3);



--insert board
INSERT INTO board (board_no, board_title, board_date, board_content, m_id) 
VALUES (BOARD_BOARD_NO_SEQ.nextval, '어깨피자 맛있어요', sysdate, '너무 맛있어요~!!!', 'guard1');


commit;


