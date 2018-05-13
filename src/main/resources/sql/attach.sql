CREATE TABLE attach (
  fullName VARCHAR2(150) NOT NULL,
  bno INT NOT NULL,
  regdate DATE DEFAULT SYSDATE
);

ALTER TABLE attach ADD CONSTRAINT attach_board_bno_fk FOREIGN KEY (bno) REFERENCES board (bno);

select * from attach;