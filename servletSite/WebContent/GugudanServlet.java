package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GugudanServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src='tomcat.gif'/>");
		

		out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		// loop start
		for (int i = 0; i < 9; i++) {
			out.println("<tr>");
			out.println("<td align=center>2*1=2</td>");
			out.println("<td align=center>3*1=3</td>");
			out.println("<td align=center>4*1=4</td>");
			out.println("<td align=center>5*1=5</td>");
			out.println("<td align=center>6*1=6</td>");
			out.println("<td align=center>7*1=7</td>");
			out.println("<td align=center>8*1=8</td>");
			out.println("<td align=center>9*1=9</td>");
			out.println("</tr>");
		}
		// loop end
		out.println("</table>");
		out.println("<br/>");
		out.println("</BODY>");
		out.println("</HTML>");

	}
}
