//package com.telusko;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.servlet.ModelAndView;
//
//import com.telusko.Bean.LeaderBoardBean;
//import com.telusko.service.LeaderBoardService;
//
///**
// * Servlet implementation class LeaderBoard
// */
//public class LeaderBoard extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public LeaderBoard() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		LeaderBoardService lb = new LeaderBoardService();
//		ArrayList<LeaderBoardBean> lblist= new ArrayList<LeaderBoardBean>();
//		try {
//			lblist = lb.getLeaderboard();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(lblist.size());
//		request.setAttribute("lblist", lblist);
//		request.getRequestDispatcher("leaderboard.jsp").forward(request, response);
//	}
//
//}
