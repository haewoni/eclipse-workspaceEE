-- guard1 ë©¤ë²„ ?•œ ?‚¬?Œ?˜ ì¹´íŠ¸?— ? œ?’ˆì¡´ì¬?—¬ë¶?
SELECT COUNT(*)FROM CART c 
JOIN MEMBER m ON c.M_ID = m.M_ID
JOIN PRODUCT p
ON c.p_no=p.p_no
WHERE m.m_id='guard1' AND c.p_no=1;

--guard1 ë©¤ë²„ ?•œ ?‚¬?Œ?˜ ì¹´íŠ¸ ?•„?´?…œë¦¬ìŠ¤?Š¸
select c.p_no,c.cart_qty,c.cart_price_total,p.p_name,p.p_img,p.p_price
from cart c join member m on m.m_id=c.m_id
join product p on p.p_no=c.p_no
where m.m_id = 'guard1';

--guard1 ë©¤ë²„ ?•œ ?‚¬?Œ?˜ ì¹´íŠ¸?•„?´?…œ 1ê°œì˜ ? œ?’ˆ ? •ë³?
select c.p_no,c.cart_qty,c.cart_price_total,p.p_name,p.p_img,p.p_price
from cart c join member m on c.m_id=m.m_id
join product p on c.p_no=p.p_no
where m.m_id='guard1' and p.p_no=3;

--guard1 ë©¤ë²„ ?•œ ?‚¬?Œ?˜ ì¹´íŠ¸? •ë³´ì¶œ? ¥(? œ?’ˆ? •ë³?)
select c.*,p.*
from cart c join member m
on c.m_id=m.m_id 
join product p on c.p_no=p.p_no
where m.m_id='guard1' and p.p_no=1;


--guard1 ì¹´íŠ¸?— ?ˆ?Š” ? œ?’ˆ ?ˆ˜?Ÿ‰ì¦ê?
update cart set cart_qty=cart_qty+1
where m_id='guard1' and p_no=1;
	
--guard1?‹˜ ì¹´íŠ¸?•„?´?…œ1ê°œì‚­? œ
delete from cart where p_no=3;

--guard1?‹˜ ì¹´íŠ¸?•„?´?…œëª¨ë‘?‚­? œ
delete from cart where m_id='guard1';

 --1. ë©¤ë²„ ?•œ?‚¬?Œ?˜ ?Š¹? •?‚ ì§œì˜ ì£¼ë¬¸? „ì²´ëª©ë¡?
select *
from jumun
where m_id='guard1' and to_char(jumun_date,'YYYY/MM/DD')='2020/09/20';
 
--2. ë©¤ë²„ ?•œ?‚¬?Œ?˜ ?Š¹? •?‚ ì§œì˜ ì£¼ë¬¸?•œê°? 
select *
from jumun
where m_id='guard1' and to_char(jumun_date,'YYYY/MM/DD')='2020/09/20' and jumun_no=2;

--3. ì£¼ë¬¸?•œê°œì˜  ì£¼ë¬¸?ƒ?„¸ ? •ë³´ë“¤(ì£¼ë¬¸?ƒ?„¸)
select jd.*,j.*
from jumun j join jumun_detail jd
on j.jumun_no=jd.jumun_no
where j.m_id='guard1' and j.jumun_no=1;
 
-- 4. ì£¼ë¬¸ ?•œ ê°œì˜ ì£¼ë¬¸ ?ƒ?„¸?? ? œ?’ˆ ? •ë³´ë“¤(ì£¼ë¬¸?ƒ?„¸,? œ?’ˆ)
select *
from jumun j join jumun_detail jd
on j.jumun_no=jd.jumun_no
join product p on jd.p_no=p.p_no
where j.m_id='guard1' and j.jumun_no=1;


-- 4. ì£¼ë¬¸ ?•œ ê°œì˜ ?‚´?—­ ?‚­? œ
delete from jumun_detail where jumun_no=1;
delete from jumun where jumun_no=1;



commit;







