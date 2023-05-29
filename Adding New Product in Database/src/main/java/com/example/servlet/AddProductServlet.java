package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.main.ProductMain;
import com.example.pojo.Product;

public class AddProductServlet extends HttpServlet {

    private ProductMain productMain;

    @Override
    public void init() throws ServletException {
        productMain = new ProductMain();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");

        if (name.isEmpty() || priceStr.isEmpty()) {
            response.sendRedirect("add-product.jsp");
            return;
        }

        double price = Double.parseDouble(priceStr);

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productMain.addProduct(product);

        // Set request attributes for success page
        request.setAttribute("name", name);
        request.setAttribute("price", price);

        // Forward to the success page
        request.getRequestDispatcher("add-product-success.jsp").forward(request, response);
    }
}
