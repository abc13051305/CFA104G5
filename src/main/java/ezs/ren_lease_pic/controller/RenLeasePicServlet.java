package ezs.ren_lease_pic.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezs.ren_landlord.model.RenLandlordService;
import ezs.ren_landlord.model.RenLandlordVO;

public class RenLeasePicServlet extends HttpServlet {

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			
			if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String str = req.getParameter("lddId");
					if (str == null || (str.trim()).length() == 0) {
						errorMsgs.add("請輸入房東編號");
					}
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/backend/ren/select.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					Integer lddId = null;
					try {
						lddId = new Integer(str);
					} catch (Exception e) {
						errorMsgs.add("房東編號格式不正確");
					}
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/backend/ren/select.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					/***************************2.開始查詢資料*****************************************/
					RenLandlordService renlandlordSvc = new RenLandlordService();
					RenLandlordVO  renLandlordVO = renlandlordSvc.getOneLandlord(lddId);
					if (renLandlordVO == null) {
						errorMsgs.add("查無資料");
					}
					
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/backend/ren/select.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}

					/***************************3.查詢完成,準備轉交(Send the Success view)*************/
					req.setAttribute("renLandlordVO", renLandlordVO); // 資料庫取出的LandlordVO物件,存入req
					String url = "/backend/ren/listOneLandlord.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得資料:" + e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/backend/ren/select.jsp");
					failureView.forward(req, res);
				}
			}
			
			
//			if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//				
//				try {
//					/***************************1.接收請求參數****************************************/
//					Integer lddId = new Integer(req.getParameter("ldd_id"));
//					
//					/***************************2.開始查詢資料****************************************/
//					RenLandlordService renLandlordSvc = new RenLandlordService();
//					RenLandlordVO renLandlordVO = renLandlordSvc.getOneLandlord(lddId);
//									
//					/***************************3.查詢完成,準備轉交(Send the Success view)************/
//					req.setAttribute("renLandlordVO", renLandlordVO);         // 資料庫取出的LandlordVO物件,存入req
//					String url = "/backend/update_landlord_input.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//					successView.forward(req, res);
//
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/backend/listAllLandlord.jsp");
//					failureView.forward(req, res);
//				}
//			}
			
			
//			if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//
//				try {
////					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//					Integer lddId = new Integer(req.getParameter("lddId").trim());
//					Integer lddMemId = new Integer(req.getParameter("lddMemId").trim());
//					Integer lddApproval=new Integer(req.getParameter("lddApproval").trim());
//					
//					RenLandlordVO renLandlordVO = new RenLandlordVO();
//					renLandlordVO.setLddId(lddId);
//					renLandlordVO.setLddMemId(lddMemId);
//					renLandlordVO.setLddApproval(lddApproval);
//
//					if (!errorMsgs.isEmpty()) {
//						req.setAttribute("renLandlordVO", renLandlordVO); // 含有輸入格式錯誤的LandlordVO物件,也存入req
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/backend/update_landlord_input.jsp");
//						failureView.forward(req, res);
//						return; //程式中斷
//					}
//					
//					/***************************2.開始修改資料*****************************************/
//					RenLandlordService renLandlordSvc = new RenLandlordService();
//					renLandlordVO = renLandlordSvc.updateLandlord(lddId,lddMemId,lddApproval);
//					
//					/***************************3.修改完成,準備轉交(Send the Success view)*************/
//					req.setAttribute("renLandlordVO", renLandlordVO); // 資料庫update成功後,正確的的LandlordVO物件,存入req
//					String url = "/backend/listOneLandlord.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//					successView.forward(req, res);
//
//					/***************************其他可能的錯誤處理*************************************/
//				} catch (Exception e) {
//					errorMsgs.add("修改資料失敗:"+e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/backend/update_landlord_input.jsp");
//					failureView.forward(req, res);
//				}
//			}
		}
	}