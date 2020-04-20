package com.occamsrazor.web.member;

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
	public Member[] list() {
		return members;
	}

	@Override
	public Member[] searchByName(String name) {
		Member[] returnMember = null;
		int searchCount = count(name);
		if(searchCount !=0) {
			returnMember = new Member[searchCount];
			int j=0;
			for(int i=0; i<count; i++) {
				if(name.equals(members[i].getName())) {
					returnMember[j] =  members[i];
					j++;
					if(searchCount == j);
					break;
				}
			}
		}
		return returnMember;
	}

	@Override
	public Member[] searchByGender(String gender) {
		return null;
	}

	@Override
	public Member detail(String userid) {
		Member member = new Member();
		for(int i=0; i<count; i++) {
			if(userid.equals(members[i].getUserid())) {
				members[i].equals(member.getUserid());
			}
		}
		return member;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int count(String name) {
		int searchCount =0;
		for(int i=0; i<count; i++) {
			if(name.equals(members[i].getName())) {
				searchCount++;
			}
		}
	return searchCount;
	}

	@Override
	public Member login(Member member) {
		Member returnMember = null;
		for(int i=0;i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())&&
					member.getPasswd().equals(members[i].getPasswd())) {
				returnMember  =  members[i];
			}
		}
		
		return returnMember;
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
			if(member.getUserid().equals(members[i].getUserid())&&
					member.getPasswd().equals(members[i].getPasswd())) {
				members[i] = members[count -1];
				members[count-1]=null;
				count--;
			}
		}
		
		
	}
	
	
}
