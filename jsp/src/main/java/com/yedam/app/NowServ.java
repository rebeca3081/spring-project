package com.yedam.app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NowServ")
public class NowServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NowServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 호출 DAO 호출
		
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
		String str = format.format(today);
		
		// 결과저장
		request.setAttribute("today", str);
		
		// view페이지의 이동(forward)
		request.getRequestDispatcher("now.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
