CREATE TABLE reply (
	rno INT NOT NULL,
	bno INT DEFAULT 0 NOT NULL,
	replytext VARCHAR2(1000) NOT NULL,
	replyer VARCHAR2(50) NOT NULL,
	regdate DATE DEFAULT sysdate NOT NULL ,
	updatedate DATE DEFAULT sysdate NOT NULL
);

CREATE SEQUENCE reply_rno_seq
START WITH 1
INCREMENT BY 1;

DESC reply;


ALTER TABLE reply ADD CONSTRAINT reply_rno_pk PRIMARY KEY (rno); 

ALTER TABLE reply ADD CONSTRAINT board_bno_fk FOREIGN KEY (bno) REFERENCES board(bno);


-- 조회
select * from reply;

-- 페이징 처리
SELECT rn
     , rno
     , bno
     , replytext
     , replyer
     , TO_CHAR(regdate, 'YYYY-MM-DD HH24:mi:ss') regdate
     , TO_CHAR(updatedate, 'YYYY-MM-DD HH24:mi:ss') updatedate
  FROM (SELECT CEIL(rn / 10) as page
             , rn
             , rno
             , bno
             , replytext
             , replyer
             , regdate
             , updatedate
          FROM (SELECT rownum as rn
                     , rno
                     , bno
                     , replytext
                     , replyer
                     , regdate
                     , updatedate
                  FROM reply
                 WHERE bno = #{bno}
                 ORDER BY rno DESC)
       )
 WHERE page = #{page}

;
