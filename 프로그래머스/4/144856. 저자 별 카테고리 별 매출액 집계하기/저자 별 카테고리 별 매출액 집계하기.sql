SELECT b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, SUM(s.SALES * b.PRICE) TOTAL_SALES
FROM BOOK b
    JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
    JOIN BOOK_SALES s ON b.BOOK_ID = s.BOOK_ID
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 1
GROUP BY b.AUTHOR_ID, b.CATEGORY
ORDER BY b.AUTHOR_ID, b.CATEGORY DESC;


#select b.author_id 'AUTHOR_ID',
#        a.author_name 'AUTHOR_NAME',
#        b.category 'CATEGORY',
#        sum(bs.sales * b.price) 'TOTAL_SALES'
# from BOOK b
#     join AUTHOR a on b.author_id = a.author_id
#     join BOOK_SALES bs on b.book_id = bs.book_id
# where bs.sales_date >= '2022-01-01' and bs.sales_date <= '2022-01-31'
# group by b.author_id, b.category
# order by b.author_id, b.category desc