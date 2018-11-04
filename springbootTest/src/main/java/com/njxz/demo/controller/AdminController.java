package com.njxz.demo.controller;

import com.njxz.demo.domain.Book;
import com.njxz.demo.domain.BookCategory;
import com.njxz.demo.domain.User;
import com.njxz.demo.domain.Vo.BookVo;
import com.njxz.demo.domain.Vo.BorrowingBooksVo;
import com.njxz.demo.service.*;
import com.njxz.demo.utils.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private IAdminService adminService;
    @Resource
    private IBookCategoryService bookCategoryService;
    @Resource
    private IUserService userService;

    /**
     * 判断admin是否存在
     * @param adminName
     * @return
     */
    @RequestMapping("/isAdminExist")
    @ResponseBody
    public String adminIsExist(@Param("adminName") String adminName){
        boolean b=adminService.adminIsExist(adminName);
        if(b){
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 管理员登陆
     * @param adminName
     * @param password
     * @return
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(@Param("adminName") String adminName,@Param("password") String password,HttpServletRequest request){
        boolean res=adminService.adminLogin(adminName,password);
        if(res==false){
            return "adminLogin";
        }
        request.getSession().setAttribute("admin","admin");
        return "admin/index";
    }

    /**
     * 返回添加书籍页面
     * @return
     */
    @RequestMapping("/addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }

    /**
     * 返回添加类别页面
     * @return
     */
    @RequestMapping("/addCategoryPage")
    public String addCategoryPage(@RequestParam("pageNum") int pageNum, Model model){
        Page<BookCategory> page=bookCategoryService.selectBookCategoryByPageNum(pageNum);
        model.addAttribute("page",page);
        return "admin/addCategory";
    }

    /**
     * 返回查询状态页面
     * @return
     */
    @RequestMapping("/showStausPage")
    public String showStausPage(){
        return "admin/showStaus";
    }

    /**
     * 返回管理员首页
     * @return
     */
    @RequestMapping("/adminIndex")
    public String returnAdminIndexPage(){
        return "admin/index";
    }



    /**
     * 返回查询用户页面
     * @return
     */
    @RequestMapping("/showUsersPage")
    public String showUsersPage(Model model,@RequestParam("pageNum") int pageNum){
        Page<User> page=userService.findUserByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/showUsers";
    }

    /**
     * 返回查询书籍页面
     * @return
     */
    @RequestMapping("/showBooksPage")
    public String showBooksPage(Model model){
        Page<BookVo> page=new Page<BookVo>();
        page.setPageCount(1);
        page.setPageNum(1);
        model.addAttribute("page",page);
        return "admin/showBooks";
    }



    /**
     * 管理员退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/adminLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "adminLogin";
    }

    /**
     * 返回新增用户页面
     * @return
     */
    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "admin/addUser";
    }

}
