package ezs.ren_listing.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.Util;

public class RenListingJNDIDAO implements RenListingDAO_interface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CFA104G5");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO `CFA104G5`.`REN_LISTING` (LIS_LDD_ID, LIS_RT_ID, LIS_AREA_ID, LIS_TITLE, LIS_ABT, LIS_ADDRESS, LIS_RENT, LIS_MNG_FEE, LIS_PFEE, LIS_SQFT, LIS_FLR, LIS_RM_NO, LIS_CMN_AREA, LIS_BR_NO, LIS_ETHERNET, LIS_WIFI, LIS_WH, LIS_SHENC, LIS_AC, LIS_FRIDGE, LIS_TV, LIS_WASHER, LIS_DRYER, LIS_TC, LIS_BED, LIS_CABINET, LIS_SOFA, LIS_PARKING, LIS_COOK, LIS_PET, LIS_SMOKING, LIS_MONLY, LIS_FONLY, LIS_SONLY, LIS_STATUS, LIS_APPROVAL) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?)";
	private static final String GET_ALL_STMT = "SELECT LIS_ID, LIS_LDD_ID, LIS_RT_ID, LIS_AREA_ID, LIS_TITLE, LIS_ABT, LIS_ADDRESS, LIS_RENT, LIS_MNG_FEE, LIS_PFEE, LIS_SQFT, LIS_FLR, LIS_RM_NO, LIS_CMN_AREA, LIS_BR_NO, LIS_ETHERNET, LIS_WIFI, LIS_WH, LIS_SHENC, LIS_AC, LIS_FRIDGE, LIS_TV, LIS_WASHER, LIS_DRYER, LIS_TC, LIS_BED, LIS_CABINET, LIS_SOFA, LIS_PARKING, LIS_COOK, LIS_PET, LIS_SMOKING, LIS_MONLY, LIS_FONLY, LIS_SONLY, LIS_STATUS, LIS_APPROVAL FROM `CFA104G5`.`REN_LISTING` order by LIS_ID";
	private static final String GET_ONE_STMT = "SELECT LIS_ID, LIS_LDD_ID, LIS_RT_ID, LIS_AREA_ID, LIS_TITLE, LIS_ABT, LIS_ADDRESS, LIS_RENT, LIS_MNG_FEE, LIS_PFEE, LIS_SQFT, LIS_FLR, LIS_RM_NO, LIS_CMN_AREA, LIS_BR_NO, LIS_ETHERNET, LIS_WIFI, LIS_WH, LIS_SHENC, LIS_AC, LIS_FRIDGE, LIS_TV, LIS_WASHER, LIS_DRYER, LIS_TC, LIS_BED, LIS_CABINET, LIS_SOFA, LIS_PARKING, LIS_COOK, LIS_PET, LIS_SMOKING, LIS_MONLY, LIS_FONLY, LIS_SONLY, LIS_STATUS, LIS_APPROVAL FROM `CFA104G5`.`REN_LISTING`where LIS_ID = ?";
	private static final String DELETE = "DELETE FROM `CFA104G5`.`REN_LISTING` where LIS_ID = ?";
	private static final String UPDATE = "UPDATE `CFA104G5`.`REN_LISTING` set LIS_LDD_ID=?, LIS_RT_ID=?, LIS_AREA_ID=?, LIS_TITLE=?, LIS_ABT=?, LIS_ADDRESS=?, LIS_RENT=?, LIS_MNG_FEE=?, LIS_PFEE=?, LIS_SQFT=?, LIS_FLR=?, LIS_RM_NO=?, LIS_CMN_AREA=?, LIS_BR_NO=?, LIS_ETHERNET=?, LIS_WIFI=?, LIS_WH=?, LIS_SHENC=?, LIS_AC=?, LIS_FRIDGE=?, LIS_TV=?, LIS_WASHER=?, LIS_DRYER=?, LIS_TC=?, LIS_BED=?, LIS_CABINET=?, LIS_SOFA=?, LIS_PARKING=?, LIS_COOK=?, LIS_PET=?, LIS_SMOKING=?, LIS_MONLY=?, LIS_FONLY=?, LIS_SONLY=?, LIS_STATUS=?, LIS_APPROVAL=? where LIS_ID = ?";

	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(RenListingVO listingVO) {
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, listingVO.getLisLddID());
			pstmt.setInt(2, listingVO.getLisRtID());
			pstmt.setInt(3, listingVO.getLisAreaID());
			pstmt.setString(4, listingVO.getLisTitle());
			pstmt.setString(5, listingVO.getLisAbt());
			pstmt.setString(6, listingVO.getLisAddress());
			pstmt.setBigDecimal(7, listingVO.getLisRent());
			pstmt.setBigDecimal(8, listingVO.getLisMngFee());
			pstmt.setBigDecimal(9, listingVO.getLisPfee());
			pstmt.setDouble(10, listingVO.getLisSqft());
			pstmt.setString(11, listingVO.getLisFlr());
			pstmt.setInt(12, listingVO.getLisRmNo());
			pstmt.setInt(13, listingVO.getLisCmnArea());
			pstmt.setInt(14, listingVO.getLisBrNo());
			pstmt.setInt(15, listingVO.getLisEthernet());
			pstmt.setInt(16, listingVO.getLisWifi());
			pstmt.setInt(17, listingVO.getLisWh());
			pstmt.setInt(18, listingVO.getLisShenc());
			pstmt.setInt(19, listingVO.getLisAc());
			pstmt.setInt(20, listingVO.getLisFridge());
			pstmt.setInt(21, listingVO.getLisTv());
			pstmt.setInt(22, listingVO.getLisWasher());
			pstmt.setInt(23, listingVO.getLisDryer());
			pstmt.setInt(24, listingVO.getLisTc());
			pstmt.setInt(25, listingVO.getLisBed());
			pstmt.setInt(26, listingVO.getLisCabinet());
			pstmt.setInt(27, listingVO.getLisSofa());
			pstmt.setInt(28, listingVO.getLisParking());
			pstmt.setInt(29, listingVO.getLisCook());
			pstmt.setInt(30, listingVO.getLisPet());
			pstmt.setInt(31, listingVO.getLisSmoking());
			pstmt.setInt(32, listingVO.getLisMonly());
			pstmt.setInt(33, listingVO.getLisFonly());
			pstmt.setInt(34, listingVO.getLisSonly());
			pstmt.setInt(35, listingVO.getLisStatus());
			pstmt.setInt(36, listingVO.getLisApproval());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public void update(RenListingVO listingVO) {
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, listingVO.getLisLddID());
			pstmt.setInt(2, listingVO.getLisRtID());
			pstmt.setInt(3, listingVO.getLisAreaID());
			pstmt.setString(4, listingVO.getLisTitle());
			pstmt.setString(5, listingVO.getLisAbt());
			pstmt.setString(6, listingVO.getLisAddress());
			pstmt.setBigDecimal(7, listingVO.getLisRent());
			pstmt.setBigDecimal(8, listingVO.getLisMngFee());
			pstmt.setBigDecimal(9, listingVO.getLisPfee());
			pstmt.setDouble(10, listingVO.getLisSqft());
			pstmt.setString(11, listingVO.getLisFlr());
			pstmt.setInt(12, listingVO.getLisRmNo());
			pstmt.setInt(13, listingVO.getLisCmnArea());
			pstmt.setInt(14, listingVO.getLisBrNo());
			pstmt.setInt(15, listingVO.getLisEthernet());
			pstmt.setInt(16, listingVO.getLisWifi());
			pstmt.setInt(17, listingVO.getLisWh());
			pstmt.setInt(18, listingVO.getLisShenc());
			pstmt.setInt(19, listingVO.getLisAc());
			pstmt.setInt(20, listingVO.getLisFridge());
			pstmt.setInt(21, listingVO.getLisTv());
			pstmt.setInt(22, listingVO.getLisWasher());
			pstmt.setInt(23, listingVO.getLisDryer());
			pstmt.setInt(24, listingVO.getLisTc());
			pstmt.setInt(25, listingVO.getLisBed());
			pstmt.setInt(26, listingVO.getLisCabinet());
			pstmt.setInt(27, listingVO.getLisSofa());
			pstmt.setInt(28, listingVO.getLisParking());
			pstmt.setInt(29, listingVO.getLisCook());
			pstmt.setInt(30, listingVO.getLisPet());
			pstmt.setInt(31, listingVO.getLisSmoking());
			pstmt.setInt(32, listingVO.getLisMonly());
			pstmt.setInt(33, listingVO.getLisFonly());
			pstmt.setInt(34, listingVO.getLisSonly());
			pstmt.setInt(35, listingVO.getLisStatus());
			pstmt.setInt(36, listingVO.getLisApproval());
			pstmt.setInt(37, listingVO.getLisID());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public void delete(Integer lisID) {
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, lisID);

			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public RenListingVO findByPrimaryKey(Integer lisID) {
		RenListingVO listingVO = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, lisID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				listingVO = new RenListingVO();
				listingVO.setLisID(rs.getInt("LIS_ID"));
				listingVO.setLisLddID(rs.getInt("LIS_LDD_ID"));
				listingVO.setLisRtID(rs.getInt("LIS_RT_ID"));
				listingVO.setLisAreaID(rs.getInt("LIS_AREA_ID"));
				listingVO.setLisTitle(rs.getString("LIS_TITLE"));
				listingVO.setLisAbt(rs.getString("LIS_ABT"));
				listingVO.setLisAddress(rs.getString("LIS_ADDRESS"));
				listingVO.setLisRent(rs.getBigDecimal("LIS_RENT"));
				listingVO.setLisMngFee(rs.getBigDecimal("LIS_MNG_FEE"));
				listingVO.setLisPfee(rs.getBigDecimal("LIS_PFEE"));
				listingVO.setLisSqft(rs.getDouble("LIS_SQFT"));
				listingVO.setLisFlr(rs.getString("LIS_FLR"));
				listingVO.setLisRmNo(rs.getInt("LIS_RM_NO"));
				listingVO.setLisCmnArea(rs.getInt("LIS_CMN_AREA"));
				listingVO.setLisBrNo(rs.getInt("LIS_BR_NO"));
				listingVO.setLisEthernet(rs.getInt("LIS_ETHERNET"));
				listingVO.setLisWifi(rs.getInt("LIS_WIFI"));
				listingVO.setLisWh(rs.getInt("LIS_WH"));
				listingVO.setLisShenc(rs.getInt("LIS_SHENC"));
				listingVO.setLisAc(rs.getInt("LIS_AC"));
				listingVO.setLisFridge(rs.getInt("LIS_FRIDGE"));
				listingVO.setLisTv(rs.getInt("LIS_TV"));
				listingVO.setLisWasher(rs.getInt("LIS_WASHER"));
				listingVO.setLisDryer(rs.getInt("LIS_DRYER"));
				listingVO.setLisTc(rs.getInt("LIS_TC"));
				listingVO.setLisBed(rs.getInt("LIS_BED"));
				listingVO.setLisCabinet(rs.getInt("LIS_CABINET"));
				listingVO.setLisSofa(rs.getInt("LIS_SOFA"));
				listingVO.setLisParking(rs.getInt("LIS_PARKING"));
				listingVO.setLisCook(rs.getInt("LIS_COOK"));
				listingVO.setLisPet(rs.getInt("LIS_PET"));
				listingVO.setLisSmoking(rs.getInt("LIS_SMOKING"));
				listingVO.setLisMonly(rs.getInt("LIS_MONLY"));
				listingVO.setLisFonly(rs.getInt("LIS_FONLY"));
				listingVO.setLisSonly(rs.getInt("LIS_SONLY"));
				listingVO.setLisStatus(rs.getInt("LIS_STATUS"));
				listingVO.setLisApproval(rs.getInt("LIS_APPROVAL"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
		return listingVO;
	}

	@Override
	public List<RenListingVO> getAll() {
		List<RenListingVO> list = new ArrayList<RenListingVO>();
		RenListingVO listingVO = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				listingVO = new RenListingVO();
				listingVO.setLisID(rs.getInt("LIS_ID"));
				listingVO.setLisLddID(rs.getInt("LIS_LDD_ID"));
				listingVO.setLisRtID(rs.getInt("LIS_RT_ID"));
				listingVO.setLisAreaID(rs.getInt("LIS_AREA_ID"));
				listingVO.setLisTitle(rs.getString("LIS_TITLE"));
				listingVO.setLisAbt(rs.getString("LIS_ABT"));
				listingVO.setLisAddress(rs.getString("LIS_ADDRESS"));
				listingVO.setLisRent(rs.getBigDecimal("LIS_RENT"));
				listingVO.setLisMngFee(rs.getBigDecimal("LIS_MNG_FEE"));
				listingVO.setLisPfee(rs.getBigDecimal("LIS_PFEE"));
				listingVO.setLisSqft(rs.getDouble("LIS_SQFT"));
				listingVO.setLisFlr(rs.getString("LIS_FLR"));
				listingVO.setLisRmNo(rs.getInt("LIS_RM_NO"));
				listingVO.setLisCmnArea(rs.getInt("LIS_CMN_AREA"));
				listingVO.setLisBrNo(rs.getInt("LIS_BR_NO"));
				listingVO.setLisEthernet(rs.getInt("LIS_ETHERNET"));
				listingVO.setLisWifi(rs.getInt("LIS_WIFI"));
				listingVO.setLisWh(rs.getInt("LIS_WH"));
				listingVO.setLisShenc(rs.getInt("LIS_SHENC"));
				listingVO.setLisAc(rs.getInt("LIS_AC"));
				listingVO.setLisFridge(rs.getInt("LIS_FRIDGE"));
				listingVO.setLisTv(rs.getInt("LIS_TV"));
				listingVO.setLisWasher(rs.getInt("LIS_WASHER"));
				listingVO.setLisDryer(rs.getInt("LIS_DRYER"));
				listingVO.setLisTc(rs.getInt("LIS_TC"));
				listingVO.setLisBed(rs.getInt("LIS_BED"));
				listingVO.setLisCabinet(rs.getInt("LIS_CABINET"));
				listingVO.setLisSofa(rs.getInt("LIS_SOFA"));
				listingVO.setLisParking(rs.getInt("LIS_PARKING"));
				listingVO.setLisCook(rs.getInt("LIS_COOK"));
				listingVO.setLisPet(rs.getInt("LIS_PET"));
				listingVO.setLisSmoking(rs.getInt("LIS_SMOKING"));
				listingVO.setLisMonly(rs.getInt("LIS_MONLY"));
				listingVO.setLisFonly(rs.getInt("LIS_FONLY"));
				listingVO.setLisSonly(rs.getInt("LIS_SONLY"));
				listingVO.setLisStatus(rs.getInt("LIS_STATUS"));
				listingVO.setLisApproval(rs.getInt("LIS_APPROVAL"));
				list.add(listingVO); // Store the row in the list
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
		return list;
	}
	
	
	
	
}
