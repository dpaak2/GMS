package com.hanbit.gms.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.serviceImpl.MemberServiceImpl;


public class MemberController {
	public static void main(String[] args) {
		
		MemberBean bean = null;
		// EXIT,ADD,LIST,FIND_NAME,FIND_ID,COUNT,UPDATE,DEL;
		Butt[] buttons = { Butt.EXIT, Butt.ADD, Butt.COUNT, Butt.LIST, Butt.FIND_ID, Butt.FIND_NAME, Butt.UPDATE,
				Butt.DEL };
		do {
			flag: switch ((Butt) JOptionPane.showInputDialog(null, // frame
					"MEMBER ADMIN", // frame title
					"SELECT MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] /* default */
			)) {
			case EXIT:
				JOptionPane.showMessageDialog(null, "Admin service close");
				return;
			case ADD:
				bean= new MemberBean();
				bean.setName(JOptionPane.showInputDialog("name"));
				bean.setId(JOptionPane.showInputDialog("ID"));
				bean.setPw(JOptionPane.showInputDialog("PassWord"));
				bean.setSsn(JOptionPane.showInputDialog("SSN"));
				System.out.println("controller==" + bean.toString());
				System.out.println("condrolelr add: "+MemberServiceImpl.getInstance().addMember(bean));
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().addMember(bean));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().countMembers());
				break flag;

			case LIST:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().getMembers());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().findById(JOptionPane.showInputDialog("찾으실 ID로 검색하여 주세요")).toString());
				break flag;
			case FIND_NAME:
				String searchName = JOptionPane.showInputDialog("찾으실 이름으로 검색하여 주세요");
				List<MemberBean> members = MemberServiceImpl.getInstance().findByName(searchName);
				System.out.println("controller findByNme:"+members);
				JOptionPane.showMessageDialog(null, members);
				break;
			case UPDATE:
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("로그인 아이디를 입력하여 주세요"));
				bean.setPw(JOptionPane.showInputDialog("변경하실 비번을 입력하여 주세요"));
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().modifiyProfile(bean));
				break flag;
			case DEL:
				MemberServiceImpl.getInstance().removeUser(JOptionPane.showInputDialog("삭제하려는 아이디 를 입력하세요"));
				break flag;
			case FIND_SEQ:
				break;
			default:
				break;
		
			}
		} while (true);
	}
}