--미니프로젝트

-- MEMBER
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    NO              NUMBER          PRIMARY KEY 
    , ID            VARCHAR2(100)   NOT NULL UNIQUE
    , PWD           VARCHAR2(100)   NOT NULL
    , NICK          VARCHAR2(100)   NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , QUIT_YN       CHAR(1)         DEFAULT 'N' CHECK( QUIT_YN IN('Y','N') )
);

DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- BOARD
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(400)   NOT NULL
    , WRITER        NUMBER          NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT  SYSDATE
    , DELETE_YN     CHAR(1)         DEFAULT 'N' CHECK( DELETE_YN IN('Y','N') )
    , CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER) REFERENCES MEMBER(NO)
);

DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;






--테스트용 (삭제할것들)

DROP TABLE MEMBER CASCADE CONSTRAINTS;

CREATE TABLE MEMBER(
    ID              VARCHAR2(100) UNIQUE NOT NULL
    ,PWD          VARCHAR2(100)
    ,NICK          VARCHAR2(100)
);

SELECT * FROM MEMBER;

DELETE MEMBER WHERE ID = ?



