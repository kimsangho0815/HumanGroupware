package com.human.springboot;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.springboot.dao.JieunDAO;
import com.human.springboot.dto.DepartmentDTO;
import com.human.springboot.dto.EmployeeDTO;
import com.human.springboot.dto.PositionDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JeController {

	@Autowired
	private JieunDAO JiDao;
	
// 페이지 접속 (풀네임)
	
	// 사원 조회 ( 페이지 접속 )
	@GetMapping("/hw/employee/inquiry")
	public String employeeInquiry() {
		return "employee/employee_inquiry";
	}
	// 사원 등록 ( 페이지 접속 )
	@GetMapping("/hw/employee/registration")
	public String employeeRegistration() {
		return "employee/employee_registration";
	}
	// 조직도 ( 페이지 접속 )
	@GetMapping("/hw/employee/organization")
	public String employeeOrganization() {
		return "employee/employee_organization";
	}
	// 근태 현황 ( 페이지 접속 )
	@GetMapping("/hw/attendance/current")
	public String attendanceCurrent() {
		return "attendance/attendance_current";
	}
	// 근태 관리 ( 페이지 접속 )
	@GetMapping("/hw/attendance/management")
	public String attendanceManagement() {
		return "attendance/attendance_management";
	}
	// 사원별 근태 현황
	@GetMapping("/hw/attendance/byEmployee")
	public String attendanceByEmployee() {
		return "attendance/attendance_ByEmployee";
	}
	
	// 사원 정보 등록 ( update )
	@PostMapping("/employee_update0")
	@ResponseBody
	public String doEmpUpdate(HttpServletRequest req) {
		
	    String retval = "ok";
	    try {
	    	String 입사일자=req.getParameter("입사일자");
			String emp_depart=req.getParameter("emp_depart");
			String emp_name=req.getParameter("emp_name");
			int emp_mobile=Integer.parseInt(req.getParameter("emp_mobile"));
			String emp_address=req.getParameter("emp_address");
			String emp_email=req.getParameter("emp_email");
			int emp_position=Integer.parseInt(req.getParameter("emp_position"));
			
			JiDao.employee_update0(입사일자, emp_depart, emp_name ,emp_mobile);
	    } catch (Exception e) {
	        retval = "fail";
	    }
	    return retval;
	}
	
	// 사원 조회 ( DB 정보 불러오기, select )
//	@PostMapping("/employee_list")
//	@ResponseBody
//	public String employee_list(HttpServletRequest req) {
//		String mid = req.getParameter("m_id");
//		ArrayList<EmpDTO> employee_list=EmpDao.employee_list(mid);
//		JSONArray ja = new JSONArray();
//		for(int i=0; i<employee_list.size(); i++) {
//		JSONObject jo = new JSONObject();
//		jo.put("cart_id", employee_list.get(i).getCart_id());
//		
//		ja.put(jo);
//	}
//	return ja.toString();
//	}
	
// select option 설정
	// 사원 정보 추가 ( 부서명 불러오기, select )
	@PostMapping("/department_select0")
	@ResponseBody
	public String doDepSelect() {			
		ArrayList<DepartmentDTO> department_select0 = JiDao.department_select0();
		JSONArray ja = new JSONArray();
		for(int i=0; i<department_select0.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("dep_name", department_select0.get(i).getDep_name());
			
			ja.put(jo);
		}
		return ja.toString();
	}
	// 사원 정보 추가 ( 직급명 불러오기, select )
	@PostMapping("/position_select0")
	@ResponseBody
	public String doPosSelect() {
		ArrayList<PositionDTO> position_select0 = JiDao.position_select0();
		JSONArray ja = new JSONArray();
		for(int i=0; i<position_select0.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("position_name",position_select0.get(i).getPosition_name());
			ja.put(jo);
		}
		return ja.toString();
	}
	// 사원 정보 추가 ( 고용형태 불러오기, select )
	@PostMapping("/form_select0")
	@ResponseBody
	public String doFormSelect() {
		ArrayList<PositionDTO> form_select0 = JiDao.form_select0();
		JSONArray ja = new JSONArray();
		for(int i=0; i<form_select0.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("job_type",form_select0.get(i).getJob_type());
			ja.put(jo);
		}
		return ja.toString();
	}
	// 수신인 ( 수신인+이메일 불러오기, select )
	@PostMapping("/attendance_employee0")
	@ResponseBody
	public String doAttenEmployee() {
		ArrayList<EmployeeDTO> attendance_employee0 = JiDao.attendance_employee0();
		JSONArray ja = new JSONArray();
		for(int i=0; i<attendance_employee0.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("emp_name", attendance_employee0.get(i).getEmp_name());
			jo.put("emp_email", attendance_employee0.get(i).getEmp_email());
			ja.put(jo);
		}
		return ja.toString();
	}

	// 걍 해보는거
	@PostMapping("/ExEmployee555")
	@ResponseBody
	public String doExEmployee() {
			ArrayList<PositionDTO> ExEmployee555 = JiDao.ExEmployee555();
			JSONArray ja = new JSONArray();
			for(int i=0; i<ExEmployee555.size(); i++) {
				JSONObject jo = new JSONObject();
				jo.put("position_id", ExEmployee555.get(i).getPosition_id());
				ja.put(jo);
			}
			return ja.toString();
}
}
