package web.servlet;

import domain.Product;
import factory.ProductServiceFactory;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zzp on 2017/3/26.
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("findAll".equals(method) || method == null){
            try {
                findAll(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ProductService productService = ProductServiceFactory.getInstance();
        List<Product> productList = productService.findAll();
        request.setAttribute("ps", productList);
        request.getRequestDispatcher("/page.jsp").forward(request, response);
    }

}
