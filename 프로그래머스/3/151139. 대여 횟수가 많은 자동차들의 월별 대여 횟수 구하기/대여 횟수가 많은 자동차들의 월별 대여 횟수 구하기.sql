SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE YEAR(START_DATE) = 2022 AND MONTH(START_DATE) BETWEEN 8 AND 10
GROUP BY MONTH, CAR_ID
HAVING CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                  WHERE YEAR(START_DATE) = 2022 AND MONTH(START_DATE) BETWEEN 8 AND 10
                  GROUP BY CAR_ID HAVING COUNT(HISTORY_ID) >= 5)
ORDER BY MONTH, CAR_ID DESC;

-- 코드를 입력하세요
# SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE YEAR(START_DATE) = 2022 AND MONTH(START_DATE) BETWEEN 8 AND 10
# GROUP BY MONTH(START_DATE), CAR_ID
# HAVING CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                    WHERE YEAR(START_DATE) = 2022 AND MONTH(START_DATE) BETWEEN 8 AND 10
#                    GROUP BY CAR_ID HAVING COUNT(CAR_ID) >= 5)
# ORDER BY MONTH(START_DATE), CAR_ID DESC;