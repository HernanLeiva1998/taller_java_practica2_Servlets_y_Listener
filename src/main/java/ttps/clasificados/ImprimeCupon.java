package ttps.clasificados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImprimeCupon
 */
@WebServlet("/ImprimeCupon")
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ImprimeCupon() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream outputStream= response.getOutputStream();
		//BufferedImage image = new BufferedImage(300, 500, BufferedImage.TYPE_INT_BGR);
		BufferedImage cupon = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/cupon.jpg"));
		Graphics2D graphics = cupon.createGraphics();
		graphics.setFont(new Font("TimesRoman", Font.BOLD,100));
		graphics.setColor(Color.WHITE);
		graphics.drawString(request.getParameter("frase"), 525, 850);
		graphics.drawString("#" + String.valueOf(ThreadLocalRandom.current().nextInt(1000000,99999999)), 1350, 1050);
		graphics.drawImage(cupon, 0,0,null,null);
		javax.imageio.ImageIO.write(cupon, "jpg", outputStream);
		outputStream.close();
	}
;
}
