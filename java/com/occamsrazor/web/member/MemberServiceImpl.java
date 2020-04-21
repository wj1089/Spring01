package com.occamsrazor.web.member;

import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService{
	
	private Member[] members;
	private int count;
	
	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}
	@Override
	public void add(Member member) {
		member = members[count];
		count++;
	}

	@Override
	public Member[] list(Member member) {
		return members;
	}


	@Override
	public Member detail(String userid) {
		Member returnMember = null;
		for(int i=0; i<count; i++) {
			if(userid.equals(members[i].getUserid())) {
				returnMember = members[i];
				break;
			}
		}
		return returnMember;
	}

	@Override
	public int count() {
		return count;
	}
	@Override
	public boolean login(Member member) {
		boolean ok = false;
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())&&
					member.getPasswd().equals(members[i].getPasswd())) {
				ok = true;
				break;
			}
		}
		return ok;
	}


	@Override
	public void update(Member member) {
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				member.setPasswd(members[i].getPasswd());
				break;
			}
		}
	}

	@Override
	public void delete(Member member) {
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
					member.getPasswd().equals(members[i].getPasswd())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
			}
		}
	}
}