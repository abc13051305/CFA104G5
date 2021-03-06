package ezs.ren_listing.model;

import java.util.List;


public interface RenListingDAO_interface {
	public void insert(RenListingVO listingVO);
    public void update(RenListingVO listingVO);
    public void delete(Integer lisID);
    public RenListingVO findByPrimaryKey(Integer lisID);
    public List<RenListingVO> getAll();

}
