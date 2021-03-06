package ezs.sec_pics.model;

import java.util.List;

public interface SecPicsDAO_interface {
	 public void insert(SecPicsVO secPicsVO);
	    public void update(SecPicsVO secPicsVO);
	    public void delete(Integer shPicID);
	    public SecPicsVO findByPrimaryKey(Integer shPicID);
	    public List<SecPicsVO> getAll();
	    public List<SecPicsVO> getEachItemFirstPic();
}
