INSERT INTO user1 (user_id, user_password, user_name, user_email) 
VALUES ('guard1','1111','FIRST','guard1@gamil.com');

INSERT INTO user1 (user_id, user_password, user_name, user_email) 
VALUES ('guard2','2222','SECOND','guard2@gamil.com');

INSERT INTO user1 (user_id, user_password, user_name, user_email) 
VALUES ('guard3','3333','THIRD','guard3@gamil.com');

INSERT INTO user1 (user_id, user_password, user_name, user_email) 
VALUES ('guard4','4444','FOURTH','guard4@gamil.com');



INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1001, '아이폰', 54000, 'iphone.jpg', '아이폰 좋아요', 0);

INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1002, '아이패드', 89700, 'ipad.jpg', '아이패드 좋아요', 0);

INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1003, '갤럭시20', 54400, 'galaxy20.jpg', '갤럭시20 좋아요', 0);

INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1004, '갤럭시탭', 32700, 'tab.jpg', '갤럭시탭 좋아요', 0);

INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1005, '테슬라', 999990, 'tesela.jpg', '테슬라 좋아요', 0);

INSERT INTO product1 (product_no, product_name, product_price, product_image, product_desc, product_click_count) 
VALUES (1006, '블랙베리', 54000, 'blackberry.jpg', '블랙배리 좋아요', 0);

commit;
/*
* 회원 아이디 guard1이 로그인한 후 제품들을 주문
*/


--
--INSERT INTO jumun_detail1 (jumun_detail_no, jumun_no, product_no) 
--VALUES (jumun_detail_no, jumun_no, product_no);
--
--INSERT INTO jumun1 (jumun_no, jumun_desc, jumun_date, jumun_price, user_id) 
--VALUES (jumun_no, jumun_desc, jumun_date, jumun_price, user_id);

