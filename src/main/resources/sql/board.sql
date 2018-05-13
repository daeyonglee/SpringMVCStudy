create table board (
  bno int not null,
  title varchar2(200) not null,
  content varchar2(4000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate ,
  viewcnt int default 0
);

create sequence board_bno_seq
start with 1
increment by 1;

alter table board add constraint board_pk PRIMARY KEY (bno);
ALTER TABLE board ADD (replycnt INT DEFAULT 0);

select * from board;

INSERT INTO board(bno, title, content, writer) (SELECT board_bno_seq.nextval, title, content, writer from board);

commit;

SELECT rn
     , bno
     , title
     , content
     , writer
     , regdate
     , viewcnt
  FROM (SELECT CEIL(rn / 10) as page
             , rn
             , bno
             , title
             , content
             , writer
             , regdate
             , viewcnt
          FROM (SELECT rownum as rn
                     , bno
                     , title
                     , content
                     , writer
                     , regdate
                     , viewcnt
                  FROM board
                  ORDER BY bno desc
               ))
 WHERE page = 1;
 
 select board_bno_seq.currval from dual;
 
 SELECT count(bno) FROM board WHERE bno > 0;
 
 SELECT rn , bno , title , content , writer , to_char(regdate, 'YYYY-MM-DD HH24:mi:ss') regdate , viewcnt FROM (SELECT CEIL(rn / 10) as page , rn , bno , title , content , writer , regdate , viewcnt FROM (SELECT rownum as rn , bno , title , content , writer , regdate , viewcnt FROM board WHERE bno > 0 AND title LIKE '%' || '��' || '%' ORDER BY bno desc )) WHERE page = 1;
 
 UPDATE board SET replycnt = (SELECT COUNT(bno) FROM reply WHERE bno = 5121) WHERE bno = 5121;
 
 select * from board where bno = 5121;
 rollback;