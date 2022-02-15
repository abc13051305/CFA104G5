package ezs.ser_repo.model;

import ezs.sec_refund.model.SecRefundJDBCDAO;

public class SerRepoService {
	private SerRepoDAO_interface dao;
	
	public SerRepoService() {
		dao = new SerRepoJBDCDAO();
		
	}

}
