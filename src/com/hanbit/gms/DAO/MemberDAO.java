package com.hanbit.gms.DAO;
import java.util.List;
import com.hanbit.gms.domain.MemberBean;
public interface MemberDAO {
	public String insertMember(MemberBean bean);
	public List<MemberBean> selectAll();
	public String countMembers();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByName(String name);
	public String updateProfile(MemberBean bean);
	public String deleteUser(String id);

}
