package com.hanbit.gms.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.gms.DAO.MemberDAO;
import com.hanbit.gms.DAOImpl.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;


public class MemberServiceImpl implements MemberService {
	MemberBean member;
	Map<String, MemberBean> map; // key 값은 String으로 주고 object(instance) =
									// MemberBean이다
	List<MemberBean> list;

	public MemberServiceImpl() {
		member = new MemberBean();
		map = new HashMap<>(); // key값들은 hashCode이다
		// 방 개수를 만들어주고
		list = new ArrayList<>();
	}

	@Override
	public String addMember(MemberBean bean) {
		String result="";
		if(bean.getId().equals("")){
			result="회원가입이 실패하였습니다";
		}else{
			
			MemberDAO dao=new MemberDAOImpl();
			result= (dao.insertMember(bean)==1)?"회원가입성공 되었습니다.":"회원가입이 실패하였습니다.";
			System.out.println("service impl:"+result);}
		
		return result;
	}

	@Override
	public int countMembers() {
		return new MemberDAOImpl().countMembers(); // memberList.length;
	}

	@Override
	public List<MemberBean> getMembers() {
		MemberDAO dao=new MemberDAOImpl();
		list=dao.selectAll();
		return list; // ArrayList가 된다
	}

	@Override
	public MemberBean findById(String id) {
		MemberDAO dao = new MemberDAOImpl();
		MemberBean member = new MemberBean();
		member = dao.selectById(id);
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		MemberDAO dao=new MemberDAOImpl();
		return dao.selectByName(name);
	}

	@Override
	public String modifiyProfile(MemberBean bean) {
		String result = "";
		// findById(bean.getPw()).setPw(bean.getPw());

		MemberBean mem = findById(bean.getId());

		if (!bean.getName().equals("")) {
			mem.setName(bean.getName());
		}
		if (!bean.getPw().equals("")) {
			mem.setPw(bean.getPw());
		}
		if (!bean.getSsn().equals("")) {
			mem.setSsn(bean.getSsn());
		}
		System.out.println("serviceImpl*****" + mem.toString());
		return result;
	}

	@Override
	public String removeUser(String id) {
		String removeResult = "";
		for (MemberBean m : list) {
			if (id.equals(m.getId())) {
				// list.get(i)=list[count-1];
				map.remove(id);
				break;
			}
		}
		// list.get(i)=null;
		// count--;
		return removeResult;
	}

}