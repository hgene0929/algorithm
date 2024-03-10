SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM USED_GOODS_BOARD b
    JOIN USED_GOODS_REPLY r ON b.BOARD_ID = r.BOARD_ID
WHERE YEAR(b.CREATED_DATE) = 2022 AND MONTH(b.CREATED_DATE) = 10
ORDER BY r.CREATED_DATE, b.TITLE;














-- 코드를 입력하세요
# SELECT brd.TITLE, brd.BOARD_ID, rep.REPLY_ID, rep.WRITER_ID, rep.CONTENTS, DATE_FORMAT(rep.CREATED_DATE, '%Y-%m-%d') 'CREATED_DATE'
# FROM USED_GOODS_REPLY rep
#     INNER JOIN USED_GOODS_BOARD brd ON rep.BOARD_ID = brd.BOARD_ID
# WHERE brd.CREATED_DATE like '2022-10%'
# ORDER BY rep.CREATED_DATE, brd.TITLE;