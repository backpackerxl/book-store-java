package cn.backpackerxl.servlet;

import cn.backpackerxl.entity.Compents;
import cn.backpackerxl.pojo.CommentFactory;
import cn.backpackerxl.pojo.UserCommpment;
import cn.backpackerxl.service.CommentService;
import cn.backpackerxl.service.impl.CommentServiceImp;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookCommentServlet", value = "/comment")
public class BookCommentServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");//接受数据的编码格式
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");//响应数据的编码格式

        String actionType = request.getParameter("actionType");
        try {
            Method method = this.getClass().getDeclaredMethod(actionType,HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void submit(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getParameter("userId");
        String content = request.getParameter("content");
        String productCode = request.getParameter("product_code");
        String parentCommentId = request.getParameter("parent_comment_id");
        Compents compents = new Compents();
        compents.setCreateTime(new Date());
        compents.setUserId(Integer.parseInt(userId));
        compents.setContent(content);
        compents.setProductCode(productCode);
        compents.setParentCommentId(Integer.parseInt(parentCommentId));
        int target = commentService.addComment(compents);
    }
}
