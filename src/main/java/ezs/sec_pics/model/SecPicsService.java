package ezs.sec_pics.model;

import java.util.List;

public class SecPicsService {
	private SecPicsDAO_interface dao;

	public SecPicsService() {
		dao = new SecPicsDAO();
	}

	public SecPicsVO addSecPics(Integer shID, byte[] shPic) {

		SecPicsVO secPicsVO = new SecPicsVO();

		secPicsVO.setShID(shID);
		secPicsVO.setShPic(shPic);
		
		dao.insert(secPicsVO);

		return secPicsVO;
	}

	public SecPicsVO updateSecPics(Integer shPicID, Integer shID, byte[] shPic) {

		SecPicsVO secPicsVO = new SecPicsVO();
		secPicsVO.setShPicID(shPicID);
		secPicsVO.setShID(shID);
		secPicsVO.setShPic(shPic);
		dao.update(secPicsVO);

		return secPicsVO;
	}

	public void deleteSecPics(Integer shPicID) {
		dao.delete(shPicID);
	}

	public SecPicsVO getOneSecPics(Integer shPicID) {
		return dao.findByPrimaryKey(shPicID);
	}

	public List<SecPicsVO> getAll() {
		return dao.getAll();
	}
	
	public List<SecPicsVO>getEachFirst(){
		return dao.getEachItemFirstPic();
	}

}
