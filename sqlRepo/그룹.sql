--그룹

/*
    <GROUP BY>
        그룹 기준을 제시할 수 있는 구문
        여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/

SELECT SUM (SAL) 
FROM EMP
GROUP BY JOB
;

SELECT ENAME, JOB
FROM EMP
WHERE JOB = '사원';

SELECT JOB, SUM(SAL) AS 합계--5
FROM EMP --1
WHERE JOB IN ('사원','주임','대표')--3
GROUP BY JOB--2
HAVING SUM (SAL) > 900--4
ORDER BY 합계--6
;

/*
    <HAVING>
        그룹에 대한 조건을 제시할 때 사용하는 구문(주로 그룹 함수의 결과를 가지고 비교 수행)
    
    * 실행 순서
        5: SELECT      조회하고자 하는 컬럼명 AS "별칭" | 계산식 | 함수식
        1: FROM        조회하고자 하는 테이블명
        2: WHERE       조건식
        3: GROUP BY    그룹 기준에 해당하는 컬럼명 | 계산식 | 함수식
        4: HAVING      그룹에 대한 조건식
        6: ORDER BY    정렬 기준에 해당하는 컬럼명 | 별칭 | 컬럼 순번
*/

/*
    <집계 함수>
        그룹별 산출한 결과 값의 중간 집계를 계산 해주는 함수
*/

-- ROLLUP(컬럼 1, 컬럼 2, ...) -> 컬럼 1을 가지고 중간집계를 내는 함수
-- CUBE(컬럼 1, 컬럼 2, ...) -> 컬럼 1을 가지고 중간집계를 내고, 컬럼 2를 가지고 중간집계를 낸다. 즉, 전달되는 컬럼 모두 집계하는 함수

/*
    <GROUPING>
        ROLLUP이나 CUBE에 의해 산출된 값이 해당 컬럼의 집합의 산출물이면 0을 반환, 아니면 1을 반환하는 함수
*/

/*
    <집합 연산자>
        여러 개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자이다.
        
        UNION       : 두 쿼리문을 수행한 결과값을 더한 후 중복되는 행은 제거한다. (합집합)
        UNION ALL   : UNION과 동일하게 두 쿼리문을 수행한 결과값을 더하고 중복은 허용한다. (합집합)
        INTERSECT   : 두 쿼리문을 수행한 결과값에 중복된 결과값만 추출한다. (교집합)
        MINUS       : 선행 쿼리의 결과값에서 후행 쿼리의 결과값을 뺀 나머지 결과값만 추출한다. (차집합)
*/
-- EMPLOYEE 테이블에서 부서 코드가 D5인 사원들만 조회

/*
    <GROUPING SET>
        그룹 별로 처리된 여러 개의 SELECT 문을 하나로 합친 결과를 원할 때 사용한다.
*/



