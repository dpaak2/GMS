package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;


public interface MemberService {
	public String addMember(MemberBean bean);
	public List<MemberBean> getMembers();
	public int countMembers();
	//MemberBean[] list = new MemberBean[4];
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public String modifiyProfile(MemberBean bean);
	public String removeUser(String id);
	
}
