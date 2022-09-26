CREATE TABLE KIOSK_MENU(
MENU_NO NUMBER,
MENU_COFFEE_NO NUMBER,
MENU_NOCOFFEE_NO NUMBER,
MENU_DESERT_NO NUMBER,
MENU_ECT_NO NUMBER,
MENU_NAME VARCHAR2(30) PRIMARY KEY,
MENU_PRICE NUMBER NOT NULL,
MENU_TYPE VARCHAR2(20) NOT NULL
);


ALTER TABLE KIOSK_MENU ADD (MENU_NO NUMBER);
INSERT INTO KIOSK_MENU (MENU_NO) VALUES (SEQ_MENU_NO.NEXTVAL);

SELECT MENU_NO FROM KIOSK_MENU ;

CREATE SEQUENCE SEQ_MENU_NO NOCACHE;
CREATE SEQUENCE SEQ_MENU_COFFEE_NO NOCACHE;
CREATE SEQUENCE SEQ_MENU_NOCOFFEE_NO NOCACHE;
CREATE SEQUENCE SEQ_MENU_DESERT_NO NOCACHE;
CREATE SEQUENCE SEQ_MENU_ECT_NO NOCACHE;



INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'아메리카노', 3000, '커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'아이스 아메리카노', 3000, '커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'카페라떼', 4000, '커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'아이스 카페라뗴', 4000, '커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'콜드브루', 4500, '커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_COFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_COFFEE_NO.NEXTVAL,'민트초코 프라푸치노', 6000, '커피');



INSERT INTO KIOSK_MENU (MENU_NO, MENU_NOCOFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES (SEQ_MENU_NO.NEXTVAL, SEQ_MENU_NOCOFFEE_NO.NEXTVAL, '디카페인커피', 4000, '논커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_NOCOFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_NOCOFFEE_NO.NEXTVAL, '블루베리에이드', 5000, '논커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_NOCOFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_NOCOFFEE_NO.NEXTVAL, '레몬에이드', 5000, '논커피');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_NOCOFFEE_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_NOCOFFEE_NO.NEXTVAL, '허브티', 4500, '논커피');


INSERT INTO KIOSK_MENU (MENU_NO, MENU_DESERT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_DESERT_NO.NEXTVAL, '초코케이크', 5000, '디저트');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_DESERT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_DESERT_NO.NEXTVAL, '레드벨벳케이크', 5000, '디저트');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_DESERT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_DESERT_NO.NEXTVAL, '티라미수', 5000, '디저트');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_DESERT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_DESERT_NO.NEXTVAL, '푸딩', 5000, '디저트');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_DESERT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_DESERT_NO.NEXTVAL, '샌드위치', 5000, '디저트');

INSERT INTO KIOSK_MENU (MENU_NO, MENU_ECT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_ECT_NO.NEXTVAL,'샷 추가', 500, '기타');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_ECT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_ECT_NO.NEXTVAL, '휘핑크림 추가', 500, '기타');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_ECT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_ECT_NO.NEXTVAL, '텀블러 할인', -500, '기타');
INSERT INTO KIOSK_MENU (MENU_NO, MENU_ECT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
	VALUES(SEQ_MENU_NO.NEXTVAL, SEQ_MENU_ECT_NO.NEXTVAL, '텀블러 구매', 20000, '기타');


DROP TABLE KIOSK_MENU;

DROP SEQUENCE SEQ_MENU_COFFEE_NO;
DROP SEQUENCE SEQ_MENU_NOCOFFEE_NO;
DROP SEQUENCE SEQ_MENU_DESERT_NO;
DROP SEQUENCE SEQ_MENU_ECT_NO;
DROP SEQUENCE SEQ_MENU_NO;

SELECT * FROM KIOSK_MENU;
COMMIT;

	SELECT MENU_COFFEE_NO, MENU_NAME, MENU_PRICE
	FROM KIOSK_MENU
	WHERE MENU_TYPE = '커피';


SELECT (DECODE(MENU_TYPE, '커피', SEQ_MENU_COFFEE_NO.NEXTVAL, '논커피', SEQ_MENU_NOCOFFEE_NO.NEXTVAL, 
	'디저트', SEQ_MENU_DESERT_NO.NEXTVAL, SEQ_MENU_ECT_NO.NEXTVAL)) "NO",
	MENU_NAME, MENU_PRICE
FROM KIOSK_MENU
WHERE MENU_TYPE = '논커피';

INSERT INTO KIOSK_MENU (MENU_ECT_NO, MENU_NAME, MENU_PRICE, MENU_TYPE)
VALUES (SEQ_MENU_ECT_NO.NEXTVAL, '임시메뉴2', 200, '기타');
ROLLBACK;
