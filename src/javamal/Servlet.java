package javamal;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String init = request.getParameter("init");
		String grammar = request.getParameter("grammar");
		int depth = Integer.parseInt(request.getParameter("depth"));
		double angle = Double.parseDouble(request.getParameter("angle"));
		Tree myTree = new Tree(init, grammar, depth, angle);
		response.setContentType("image/gif");
		ImageIO.write(myTree.getBufferedImage(), "GIF",
				response.getOutputStream());
	}
}
