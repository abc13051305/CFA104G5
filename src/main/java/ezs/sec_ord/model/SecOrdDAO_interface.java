package ezs.sec_ord.model;

import java.util.List;

public interface SecOrdDAO_interface {
    public void insert(SecOrdVO secOrdVO);
    public void update(SecOrdVO secOrdVO);
    public void delete(Integer shOrdID);
    public SecOrdVO findByPrimaryKey(Integer shOrdID);
    public List<SecOrdVO> getAll();
    public List<SecOrdVO> getAllByMemID(Integer shBuyerID);
}
