package kr.or.kosta.springmvc.member.dao;

import org.apache.ibatis.annotations.Param;

import kr.or.kosta.springmvc.member.domain.Member;

public interface MemberDAO {

	/** 멤버 생성 */
	public void create(Member member);
	/** 멤버 조회 */
	public Member read(String userid);
	/** 멤버 수정 */
	public void update(Member member);
	/** 멤버 삭제 */
	public void delete(String userid);
	/** 멤버 여부 */
	public Member isMember(@Param("userid")String userid, @Param("userpw")String userpw);
}
