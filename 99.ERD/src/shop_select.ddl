/*
 * 1. 멤버 한 사람의 특정날짜의 주문 전체 목록
 * 2. 멤버 한 사람의 특정 날짜의 주문 한 개
 * 3. 주문 한 개의  멤버의 정보
 * 4. 주문 한 개의 제품 여러개 정보들(주문 상세,제품)
 * 5. 주문 한 개의 주문자정보 & 제품 여러개 정보들(주문상세)
 */
 
-- 1. 멤버 한 사람의 특정 날짜의 주문 전체 목록
 select j.* 
 from user1 u
 join jumun1 j
 on u.user_id=j.user_id and u.user_id='guard1' 
 and to_char(j.jumun_date,'YYYY/MM/DD')='2020/09/02';
 
 --2. 멤버 한 사람의 특정 날짜의 주문 한 개
 select j.* 
 from user1 u
 join jumun1 j
 on u.user_id=j.user_id and u.user_id='guard1' 
 and to_char(j.jumun_date,'YYYY/MM/DD')='2020/09/02'
 where j.jumun_no=3001;
 
-- 4. 주문 한 개의 제품 여러개 정보들(주문 상세,제품)
select *
from jumun1 j
join jumun_detail1 d
on j.jumun_no=d.jumun_no
join product1 p
on d.product_no=p.product_no
where j.jumun_no=3002;

/*************************관리자***************************/
-- 1. 모든 멤버의 특정 날짜의 주문 전체 목록
 select j.* 
 from user1 u
 join jumun1 j
 on u.user_id=j.user_id
 and to_char(j.jumun_date,'YYYY/MM/DD')='2020/09/02';
-- 3-1. 주문 한 개의 멤버의 정보
select u.*
from user1 u
join jumun1 j
on u.user_id=j.user_id
where j.jumun_no=3004;
--3-2.특정 멤버의 정보를 주문 정보 포함하여 출력
select*
from user1 u
left outer join jumun1 j
on u.user_id=j.user_id
where u.user_id='guard4';

-- 5. 주문 한 개의 주문자정보 & 제품 여러개 정보들(주문상세)

select u.*,p.*
from user1 u
join jumun1 j
on u.user_id=j.user_id 
join jumun_detail1 d
on j.jumun_no=d.jumun_no
join product1 p 
on d.product_no = p.product_no
where j.jumun_no=3001;



/********************************guard1이 cart에 제품 담기****************************************/
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2001,1,54400,'guard1',1001);
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2002,2,179400,'guard1',1002);
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2003,1,54400,'guard1',1003);
commit;

/********************************guard2이 cart에 제품 담기****************************************/
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2004,1,32700,'guard2',1004);
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2005,1,999990,'guard2',1005);


/********************************guard3이 cart에 제품 담기****************************************/
INSERT INTO cart1 (cart_item_no, cart_item_qty, cart_item_tot_price, user_id, product_no) 
VALUES (2006,1,34000,'guard3',1006);
commit;


/*
1. 멤바 한 사람의 카트 아이템 리스트
2. 카트 아이템 1개의 제품 정보
3. 멤버 한 사람의 카트 정보 출력(제품정보)
*/
--1. 멤버 한 사람의 카트 아이템리스트
select * from cart1 c where c.user_id='guard1';
select * from cart1 c where c.user_id='guard2';
select * from cart1 c where c.user_id='guard3';
--2. 카트 아이템 1개의 제품 정보
select * 
from cart1 c 
join product1 p
on c.product_no=p.product_no
where c.cart_item_no=2001;
--3. 멤버 한 사람의 카트 정보 출력(제품정보)
select p.product_name 제품이름 ,c.cart_item_qty 수량,p.product_price*c.cart_item_qty 총가격 
from cart1 c
join product1 p
on c.product_no=p.product_no
where c.user_id='guard1';






 