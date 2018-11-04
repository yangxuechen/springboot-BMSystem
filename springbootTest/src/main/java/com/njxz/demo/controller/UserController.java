package com.njxz.demo.controller;



import com.njxz.demo.domain.Department;
import com.njxz.demo.domain.User;
import com.njxz.demo.domain.Vo.BookVo;
import com.njxz.demo.domain.Vo.BorrowingBooksVo;
import com.njxz.demo.service.IBookService;
import com.njxz.demo.service.IBorrowingBooksRecordService;
import com.njxz.demo.service.IUserService;
import com.njxz.demo.utils.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IBorrowingBooksRecordService borrowingBooksRecordService;

    @Resource
    private IBookService bookService;

    /**
     * 用户登录
     * @param userName
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLogin(@Param("userName") String userName,
                            @Param("password") String password, HttpServletRequest request){
        User user=userService.userLogin(userName,password);
        if(null!=user){
            request.getSession().setAttribute("user",user);
            return "user/index";
        }
        return "index";
    }

    /**
     * //验证用户是否存在
     * @param userName
     * @return
     */
    @RequestMapping("/isUserExist")
    @ResponseBody
    public String isUserExist(@Param("userName") String userName){
        List<User> users=userService.findUserByUserName(userName);
        if(null==users){
            return "false";
        }
        if(users.size()<1){
            return "false";
        }
        return "true";
    }

    /**
     * 查找所有部门
     * @return
     */
    @RequestMapping("/getDepts")
    @ResponseBody
    public List<Department> getDepts(){
        List<Department> depts=userService.findAllDepts();
        return depts;
    }

    /**
     * 返回用户借书记录页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/userBorrowingBooksPage")
    public String userBorrowingBooksPage(Model model,HttpServletRequest request,@RequestParam("pageNum") int pageNum){
        Page<BorrowingBooksVo> res;
        if(request.getSession().getAttribute("borrowingBooksPageNum")==null){
           res= borrowingBooksRecordService.userSelectByPageNum(1,request);
            request.getSession().setAttribute("borrowingBooksPageNum",1);
        }else{
            res= borrowingBooksRecordService.userSelectByPageNum(pageNum,request);
        }
       model.addAttribute("borrowingBooksList",res);
        return "user/borrowingBooksRecord";
    }

    /**
     * 返回还书页面
     * @return
     */
    @RequestMapping("/userReturnBooksPage")
    public String userReturnBooksPage(){
        return "user/returnBooks";
    }

    /**
     * 返回个人信息页面
     * @return
     */
    @RequestMapping("/userMessagePage")
    public String userMessagePage(Model model,HttpServletRequest request){
        User session_user= (User) request.getSession().getAttribute("user");
        User user=userService.findUserById(session_user.getUserId());
        model.addAttribute("message_user",user);
        return "user/userMessage";
    }

    /**
     * 返回借书页面
     * @return
     */
    @RequestMapping("/borrowingPage")
    public String borrowing(){
        return "user/borrowingBooks";
    }
    /**
     * 返回用户首页
     * @return
     */
    @RequestMapping("/userIndex")
    public String userIndex(){
        return "user/index";
    }
    /**
     * @author yangxuechen
     * @date  2018/10/11
     * 更新用户信息
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(User user,HttpServletRequest request){
        return userService.updateUser(user,request);
    }

    /**
     * 用户还书
     * @param bookId
     * @param request
     * @return
     */
    @RequestMapping("/userReturnBook")
    @ResponseBody
    public boolean returnBook(int bookId,HttpServletRequest request){
        return userService.userReturnBook(bookId,request);
    }

    /**
     * 用户借书
     * @param bookId
     * @param request
     * @return
     */
    @RequestMapping("/userBorrowingBook")
    @ResponseBody
    public boolean borrowingBook(int bookId,HttpServletRequest request){
        return userService.userBorrowingBook(bookId,request);
    }

    /**
     * 返回管理员登陆界面
     * @return
     */
    @RequestMapping("/adminLoginPage")
    public String adminLoginPage(){
        return "adminLogin";
    }

    /**
     * 用户退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

    /**
     * 返回用户索书页面
     * @return
     */
    @RequestMapping("/findBookPage")
    public String findBookPage(){
        return "user/findBook";
    }


    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUserByUserId(@RequestParam("userId") int userId){
        int res=userService.deleteUserById(userId);
        if(res>0){
            return "true";
        }
        return "false";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        int res=userService.insertUser(user);
        if(res>0){
            return "true";
        }else{
            return "false";
        }
    }
}
