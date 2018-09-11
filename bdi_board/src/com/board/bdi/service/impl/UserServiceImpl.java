package com.board.bdi.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;
import com.board.bdi.vo.UserInfoVO;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	
	@Override
	public void joinUser(HttpServletRequest req) throws SQLException, ServletException {
		UserInfoVO ui = ParseUtil.parseRequest(req, UserInfoVO.class);
		udao.setCon(DBCon.getCon()); 
		try {
			if(udao.selectUser(ui)==null) {
				int cnt = udao.insertUser(ui);
				System.out.println(cnt);
				req.setAttribute("cnt", cnt);
				DBCon.commit();
			} else {
				throw new ServletException("아이디 이미 있음.");
			} 
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace(); 
		} finally {
			DBCon.close();
		}

	}

	@Override
	public void loginUser(HttpServletRequest req) throws SQLException, ServletException{
		UserInfoVO ui = ParseUtil.parseRequest(req, UserInfoVO.class);
		udao.setCon(DBCon.getCon()); 
		try {
			UserInfoVO rUi = udao.selectUser(ui);
			if (rUi != null) {
				if(rUi.getUipwd().equals(ui.getUipwd())) {
					HttpSession hs = req.getSession();
					hs.setAttribute("user",rUi);
					req.setAttribute("msg", rUi.getUiname() + "님 환영합니다.");
				} else {
					req.setAttribute("err", "비밀번호를 확인해주세요."); 
				}
			} else {
				req.setAttribute("err", "아이디를 확인해주세요.");
			} 
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace(); 
		} finally {
			DBCon.close();
		}
	}

	@Override
	public void logoutUser(HttpServletRequest req) throws SQLException, ServletException {
		HttpSession hs = req.getSession();
		hs.invalidate(); // session 강제 종료
	}

	@Override
	public void daleteUser(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void userList(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

}
