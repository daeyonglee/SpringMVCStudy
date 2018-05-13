create table member (
  userid varchar2(50) not null,
  userpw varchar2(50) not null,
  username varchar2(50) not null,
  email varchar2(100),
  regdate date default sysdate,
  updatedate date default sysdate
);

alter table member add constraint member_pk primary key (userid);