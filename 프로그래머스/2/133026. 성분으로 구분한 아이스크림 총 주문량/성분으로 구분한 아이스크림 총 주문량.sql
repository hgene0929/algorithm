-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, SUM(h.TOTAL_ORDER) TOTAL_ORDER
FROM FIRST_HALF h
    JOIN ICECREAM_INFO i ON h.FLAVOR = i.FLAVOR
GROUP BY i.INGREDIENT_TYPE
ORDER BY SUM(h.TOTAL_ORDER);
