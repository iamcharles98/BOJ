-- 코드를 입력하세요
SELECT * from FOOD_PRODUCT where PRICE = (SELECT max(PRICE) from FOOD_PRODUCT);