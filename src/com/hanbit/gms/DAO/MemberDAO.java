package com.hanbit.gms.DAO;
import java.util.List;
import com.hanbit.gms.domain.MemberBean;
public interface MemberDAO {
	public int insertMember(MemberBean bean);
	public List<MemberBean> selectAll();
	public int countMembers();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByName(String name);
	public int updateProfile(MemberBean bean);
	public int deleteUser(String id);

}
