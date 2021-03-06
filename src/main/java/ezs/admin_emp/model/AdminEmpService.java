package ezs.admin_emp.model;

import java.util.List;

import ezs.admin_func.model.AdminFuncJDBCDAO;

public class AdminEmpService {
	
	private AdminEmpDAO_interface dao;
	
	public AdminEmpService() {
		dao = new AdminEmpDAO();
	}
	
	public AdminEmpVO addAdminEmp(String admUsername,String admPassword,Integer admStatus) {
		
		AdminEmpVO adminEmpVO = new AdminEmpVO();
		
		adminEmpVO.setAdmUsername(admUsername);
		adminEmpVO.setAdmPassword(admPassword);
		adminEmpVO.setAdmStatus(admStatus);
		dao.insert(adminEmpVO);
		
		return adminEmpVO;
	}
	
	public AdminEmpVO updateAdminEmp(String admUsername,String admPassword,Integer admStatus) {
		
		AdminEmpVO adminEmpVO = new AdminEmpVO();
		
		adminEmpVO.setAdmUsername(admUsername);
		adminEmpVO.setAdmPassword(admPassword);
		adminEmpVO.setAdmStatus(admStatus);
		dao.update(adminEmpVO);
		
		return adminEmpVO;
	}

	public  void  deletAdminEmp(Integer adminID) {

		dao.delete(adminID);
	}

	public  AdminEmpVO  getOneAdminEmp(Integer adminID) {
		return dao.findByPrimaryKey(adminID);
	}

	public  List<AdminEmpVO> getAll() {
		return dao.getAll();
	}
	
	public AdminEmpVO Search(String admUsername ,String admPassword) {
		return dao.Search(admUsername ,admPassword);
	}

	
}
