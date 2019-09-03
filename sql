insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, '홍길동', '테스트용', '자바용 테스트다', 0, mvc_board_seq.currval, 0, 0 );

Commit(커밋) : 해당 Connection의 요청을 완료하고 특별한 에러가 없다면 결과를 DB에 반영한다. 
RollBack(롤백) : 해당 Connection 수행 중 예기치 않은 에러가 발생하였다면 모든 과정을 취소하고 DB를 Connection이 수행되기 이전상태로 변경한다.
트랜잭션 우선순위는 메소드 > 클래스 >인터페이스 메소드 > 인터페이스순

트랜잭션 처리는 DB에서도 지원함.

어쩔수없이 프로그램에 의한 트랜잭션을 사용해야할 경우를 제외하고, 
최대한 선언적인 트랜잭션 방식으로 프로그램을 설계해야 한다. 

설명한 3가지 방식 모두 설정해서 사용해도 된다.
하지만 무조건 통일적인 방식으로 할것 

다음과 같이 빈의 클래스에 직접 @Transactional 을 적용할 수도 있다.

