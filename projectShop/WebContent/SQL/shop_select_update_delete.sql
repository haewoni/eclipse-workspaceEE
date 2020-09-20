-- guard1 멤버 한 사람의 카트에 제품존재여부
SELECT COUNT(*)FROM CART c 
JOIN MEMBER m ON c.M_ID = m.M_ID
JOIN PRODUCT p
ON c.p_no=p.p_no
WHERE m.m_id='guard1' AND c.p_no=1;

--guard1 멤버 한 사람의 카트 아이템리스트
select c.p_no,c.cart_qty,c.cart_price_total,p.p_name,p.p_img,p.p_price
from cart c join member m on m.m_id=c.m_id
join product p on p.p_no=c.p_no
where m.m_id = 'guard1';

--guard1 멤버 한 사람의 카트아이템 1개의 제품 정보
select c.p_no,c.cart_qty,c.cart_price_total,p.p_name,p.p_img,p.p_price
from cart c join member m on c.m_id=m.m_id
join product p on c.p_no=p.p_no
where m.m_id='guard1' and p.p_no=3;

--guard1 멤버 한 사람의 카트정보출력(제품정보)
select c.*,p.*
from cart c join member m
on c.m_id=m.m_id 
join product p on c.p_no=p.p_no
where m.m_id='guard1' and p.p_no=1;


--guard1 카트에 있는 제품 수량증가
update cart set cart_qty=cart_qty+1
where m_id='guard1' and p_no=1;
	
--guard1님 카트아이템1개삭제
delete from cart where p_no=3;

--guard1님 카트아이템모두삭제
delete from cart where m_id='guard1';

 --1. 멤버 한사람의 특정날짜의 주문전체목록
select *
from jumun
where m_id='guard1' and to_char(jumun_date,'YYYY/MM/DD')='2020/09/20';
 
--2. 멤버 한사람의 특정날짜의 주문한개 
select *
from jumun
where m_id='guard1' and to_char(jumun_date,'YYYY/MM/DD')='2020/09/20' and jumun_no=2;

--3. 주문한개의  주문상세 정보들(주문상세)
select jd.*,j.*
from jumun j join jumun_detail jd
on j.jumun_no=jd.jumun_no
where j.m_id='guard1' and j.jumun_no=1;
 
-- 4. 주문 한 개의 주문 상세와 제품 정보들(주문상세,제품)
select *
from jumun j join jumun_detail jd
on j.jumun_no=jd.jumun_no
join product p on jd.p_no=p.p_no
where j.m_id='guard1' and j.jumun_no=1;


-- 4. 주문 한 개의 내역 삭제
delete from jumun_detail where jumun_no=1;
delete from jumun where jumun_no=1;



commit;







