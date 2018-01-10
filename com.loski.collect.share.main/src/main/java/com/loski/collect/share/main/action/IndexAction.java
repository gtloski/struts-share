package com.loski.collect.share.main.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.loski.collect.share.common.action.StrutsAction;
import com.loski.collect.share.main.entity.StudentData;
import com.loski.collect.share.main.entity.UserData;
import com.loski.collect.share.main.service.StudentService;
import com.loski.collect.share.main.service.UserService;
import com.loski.collect.share.main.util.UuidUtil;

@Namespace("/welcome")
public class IndexAction extends StrutsAction {

	private static final long serialVersionUID = 4410127450425946546L;

	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	private UserData user;
	
	private List<UserData> userList;
	
	@Action(value="index", results = { @Result(name = "success", type="freemarker", location = "/ui/html/index.html") })
	public String index(){
		
//		TestPlugin tp = new TestPlugin();
//		System.out.println( tp.getClass() + "退出拦截器");
		return SUCCESS;
	}
	
	@Action(value="add", results = { 
			@Result(name="success",type="freemarker",location = "/ui/html/success.html"),
			@Result(name="faile", type="freemarker",location="/ui/html/fail.html")})
	public String add(){
		try {
			user.setId(UuidUtil.getUUIDfor32());
			userService.insertUsers(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@Action(value="batchAdd", results = { 
			@Result(name="success",type="freemarker",location = "/ui/html/success.html"),
			@Result(name="faile", type="freemarker",location="/ui/html/fail.html")})
	public String batchAdd(){
		try {
			userService.batchAddUser(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@Action(value="list",results = { @Result(name="success",type="freemarker",location="/ui/html/list.html") })
	public String list(){
		
		try {
			PageHelper.startPage(2, 4);
			List<UserData> list = userService.userList();
			Page<UserData> page = (Page<UserData>) list;
			request.setAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@Action(value="byId",results = { @Result(name="success",type="freemarker",location="/ui/html/byId.html") })
	public String byId(){
		String str = "1";
		StudentData sData = studentService.selectById(str);
		request.setAttribute("sData", sData);
		
		return "success";
	}
	
	@Action(value="byAccount",results = { @Result(name="success",type="freemarker",location="/ui/html/list.html") })
	public String byAccount(){
		List<UserData> list = userService.selectByAccount();
		request.setAttribute("list", list);
		
		return "success";
	}
	
	@Action(value="byPassAndAcc",results = { @Result(name="success",type="freemarker",location="/ui/html/byId.html") })
	public String byPassAndAcc(){
		
		List<StudentData> list = studentService.select();
		request.setAttribute("user", list);
		/*try {
			UserData user = userService.byPassAndAcc();
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return "success";
	}

	
	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public List<UserData> getUserList() {
		return userList;
	}

	public void setUserList(List<UserData> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
