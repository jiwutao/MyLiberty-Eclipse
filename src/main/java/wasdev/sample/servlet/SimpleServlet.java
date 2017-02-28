package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        // response.getWriter().print("Hello World!");
        String text =
        	      "I know the times are difficult! Our sales have been "
        	          + "disappointing for the past three quarters for our data analytics "
        	          + "product suite. We have a competitive data analytics product "
        	          + "suite in the industry. But we need to do our job selling it! "
        	          + "We need to acknowledge and fix our sales challenges. "
        	          + "We can’t blame the economy for our lack of execution! "
        	          + "We are missing critical sales opportunities. "
        	          + "Our product is in no way inferior to the competitor products. "
        	          + "Our clients are hungry for analytical tools to improve their "
        	          + "business outcomes. Economy has nothing to do with it.";
        response.getWriter().print(AnalyzeTone(text));
    }

    
    private ToneAnalysis AnalyzeTone(String text) {
    ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
    service.setUsernameAndPassword("b5cd853e-e974-416b-9448-0d6d4697a882", "pXYljtxiZqlT");

    // Call the service and get the tone
    ToneAnalysis tone = service.getTone(text, null).execute();
    System.out.println(tone);
    return (tone);
    }
    
}
