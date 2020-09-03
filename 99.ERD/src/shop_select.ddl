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

/*************************관리자***************************/
-- 1. 모든 멤버의 특정 날짜의 주문 전체 목록
 select j.* 
 from user1 u
 join jumun1 j
 on u.user_id=j.user_id
 and to_char(j.jumun_date,'YYYY/MM/DD')='2020/09/02';
-- 3. 주문 한 개의 멤버의 정보
select u.*
from user1 u
join jumun1 j
on u.user_id=j.user_id
where j.jumun_no=3004;

-- 5. 주문 한 개의 주문자정보 & 제품 여러개 정보들(주문상세)


/*********************************************************/


 