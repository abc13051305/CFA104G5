package ezs.ren_location.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class RenLocationJDBCDAO implements RenLocationDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO `CFA104G5`.`REN_LOCATION` (loc_city, loc_dist) VALUES(?,?)";
	private static final String GET_ALL_STMT = "SELECT loc_id, loc_city, loc_dist FROM `CFA104G5`.`REN_LOCATION` ORDER BY loc_id";
	private static final String GET_ONE_STMT = "SELECT loc_id, loc_city, loc_dist FROM `CFA104G5`.`REN_LOCATION` WHERE loc_id = ?";
	private static final String DELETE = "DELETE FROM `CFA104G5`.`REN_LOCATION` WHERE loc_id = ?";
	private static final String UPDATE = "UPDATE `CFA104G5`.`REN_LOCATION` SET  loc_city=?, loc_dist=? WHERE loc_id = ?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(RenLocationVO locationVO) {
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, locationVO.getLocCity());
			pstmt.setString(2, locationVO.getLocDist());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public void update(RenLocationVO locationVO) {
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, locationVO.getLocCity());
			pstmt.setString(2, locationVO.getLocDist());
			pstmt.setInt(3, locationVO.getLocID());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public void delete(Integer locID) {
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, locID);

			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
	}

	@Override
	public RenLocationVO findByPrimaryKey(Integer locID) {
		RenLocationVO locationVO = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, locID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				locationVO = new RenLocationVO();
				locationVO.setLocID(rs.getInt("LOC_ID"));
				locationVO.setLocCity(rs.getString("LOC_CITY"));
				locationVO.setLocDist(rs.getString("LOC_DIST"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
		return locationVO;
	}

	@Override
	public List<RenLocationVO> getAll() {
		List<RenLocationVO> list = new ArrayList<RenLocationVO>();
		RenLocationVO locationVO = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				locationVO = new RenLocationVO();
				locationVO.setLocID(rs.getInt("LOC_ID"));
				locationVO.setLocCity(rs.getString("LOC_CITY"));
				locationVO.setLocDist(rs.getString("LOC_DIST"));
				list.add(locationVO); // Store the row in the list
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}
		return list;
	}

}
