DROP TABLE tbl_message;
DROP TABLE tbl_user;

CREATE TABLE tbl_user (
  uno VARCHAR2(50) NOT NULL,
  upw VARCHAR2(50) NOT NULL,
  uname VARCHAR2(100) NOT NULL,
  upoint NUMBER(11) DEFAULT 0
);

CREATE TABLE tbl_message (
  mno INT NOT NULL,
  targetid VARCHAR2(50) NOT NULL,
  sender VARCHAR2(50) NOT NULL,
  message VARCHAR2(4000) NOT NULL,
  opendate DATE,
  senddate DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE message_mno_seq
START WITH 1
INCREMENT BY 1;

ALTER TABLE tbl_user ADD CONSTRAINT user_uid_pk PRIMARY KEY (uno);
ALTER TABLE tbl_message ADD CONSTRAINT message_mno_pk PRIMARY KEY(mno);
ALTER TABLE tbl_message ADD CONSTRAINT message_sender_fk FOREIGN KEY(sender) REFERENCES tbl_user(uno);

-- 회원 추가
INSERT INTO tbl_user(uno, upw, uname) VALUES ('user00', 'user00', 'IRON MAN');
INSERT INTO tbl_user(uno, upw, uname) VALUES ('user01', 'user01', 'CAPTAIN');
INSERT INTO tbl_user(uno, upw, uname) VALUES ('user02', 'user02', 'HULK');
INSERT INTO tbl_user(uno, upw, uname) VALUES ('user03', 'user03', 'Thor');
INSERT INTO tbl_user(uno, upw, uname) VALUES ('user04', 'user04', 'Quick Silver');

COMMIT;

SELECT * FROM tbl_message;
SELECT * FROM tbl_user;