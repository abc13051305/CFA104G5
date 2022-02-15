package ezs.ser_dmd.model;

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

public class SerDmdDAO implements SerDmdDAO_interface {
	public static final String INSERT_STMT = "INSERT INTO ser_dmd(dmd_status,dmd_mem_id,dmd_ser_cla_id,dmd_name,dmd_tel,dmd_mail,dmd_county,dmd_region,dmd_address,dmd_space_class,dmd_square,dmd_budget,dmd_intro,dmd_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE = "UPDATE ser_dmd SET dmd_status = ?,dmd_mem_id = ?,dmd_ser_cla_id = ?,dmd_name = ?,dmd_tel = ?,dmd_mail = ?,dmd_county = ?,dmd_region = ?,dmd_address = ?,dmd_space_class = ?,dmd_square = ?,dmd_budget = ?,dmd_intro = ?,dmd_pic = ? WHERE dmd_id = ?";
	public static final String DELETE = "DELETE FROM ser_dmd WHERE dmd_id = ?";
	public static final String FIND_BY_DMDID = "SELECT * FROM ser_dmd WHERE dmd_id = ?";
	public static final String GET_ALL = "SELECT * FROM ser_dmd";

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CFA104G5");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(SerDmdVO serDmdVO) {

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setByte(1, serDmdVO.getDmdStatus());
			pstmt.setInt(2, serDmdVO.getDmdMemID());
			pstmt.setInt(3, serDmdVO.getDmdSerClaID());
			pstmt.setString(4, serDmdVO.getDmdName());
			pstmt.setString(5, serDmdVO.getDmdTel());
			pstmt.setString(6, serDmdVO.getDmdMail());
			pstmt.setString(7, serDmdVO.getDmdCounty());
			pstmt.setString(8, serDmdVO.getDmdRegion());
			pstmt.setString(9, serDmdVO.getDmdAddress());
			pstmt.setString(10, serDmdVO.getDmdSpaceClass());
			pstmt.setInt(11, serDmdVO.getDmdSquare());
			pstmt.setInt(12, serDmdVO.getDmdBudget());
			pstmt.setString(13, serDmdVO.getDmdIntro());
			pstmt.setBytes(14, serDmdVO.getDmdPic());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}

	}

	@Override
	public void update(SerDmdVO serDmdVO) {

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setByte(1, serDmdVO.getDmdStatus());
			pstmt.setInt(2, serDmdVO.getDmdMemID());
			pstmt.setInt(3, serDmdVO.getDmdSerClaID());
			pstmt.setString(4, serDmdVO.getDmdName());
			pstmt.setString(5, serDmdVO.getDmdTel());
			pstmt.setString(6, serDmdVO.getDmdMail());
			pstmt.setString(7, serDmdVO.getDmdCounty());
			pstmt.setString(8, serDmdVO.getDmdRegion());
			pstmt.setString(9, serDmdVO.getDmdAddress());
			pstmt.setString(10, serDmdVO.getDmdSpaceClass());
			pstmt.setInt(11, serDmdVO.getDmdSquare());
			pstmt.setInt(12, serDmdVO.getDmdBudget());
			pstmt.setString(13, serDmdVO.getDmdIntro());
			pstmt.setBytes(14, serDmdVO.getDmdPic());
			pstmt.setInt(15, serDmdVO.getDmdID());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);

		}

	}

	@Override
	public void delete(Integer dmdID) {

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, dmdID);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}

	}

	@Override
	public SerDmdVO findByPrimaryKey(Integer dmdID) {
		SerDmdVO serDmdVO = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_DMDID);
			pstmt.setInt(1, dmdID);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				serDmdVO = new SerDmdVO();
				serDmdVO.setDmdID(rs.getInt("dmd_id"));
				serDmdVO.setDmdStatus(rs.getByte("dmd_status"));
				serDmdVO.setDmdMemID(rs.getInt("dmd_mem_id"));
				serDmdVO.setDmdSerClaID(rs.getInt("dmd_ser_cla_id"));
				serDmdVO.setDmdName(rs.getString("dmd_name"));
				serDmdVO.setDmdTel(rs.getString("dmd_tel"));
				serDmdVO.setDmdMail(rs.getString("dmd_mail"));
				serDmdVO.setDmdCounty(rs.getString("dmd_county"));
				serDmdVO.setDmdRegion(rs.getString("dmd_region"));
				serDmdVO.setDmdAddress(rs.getString("dmd_address"));
				serDmdVO.setDmdSpaceClass(rs.getString("dmd_space_class"));
				serDmdVO.setDmdSquare(rs.getInt("dmd_square"));
				serDmdVO.setDmdBudget(rs.getInt("dmd_budget"));
				serDmdVO.setDmdIntro(rs.getString("dmd_intro"));
				serDmdVO.setDmdPic(rs.getBytes("dmd_pic"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}

		return serDmdVO;
	}

	@Override
	public List<SerDmdVO> getAll() {
		List<SerDmdVO> serDmdVOList = new ArrayList<SerDmdVO>();

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SerDmdVO serDmdVO = new SerDmdVO();

				serDmdVO.setDmdID(rs.getInt("dmd_id"));
				serDmdVO.setDmdStatus(rs.getByte("dmd_status"));
				serDmdVO.setDmdMemID(rs.getInt("dmd_mem_id"));
				serDmdVO.setDmdSerClaID(rs.getInt("dmd_ser_cla_id"));
				serDmdVO.setDmdName(rs.getString("dmd_name"));
				serDmdVO.setDmdTel(rs.getString("dmd_tel"));
				serDmdVO.setDmdMail(rs.getString("dmd_mail"));
				serDmdVO.setDmdCounty(rs.getString("dmd_county"));
				serDmdVO.setDmdRegion(rs.getString("dmd_region"));
				serDmdVO.setDmdAddress(rs.getString("dmd_address"));
				serDmdVO.setDmdSpaceClass(rs.getString("dmd_space_class"));
				serDmdVO.setDmdSquare(rs.getInt("dmd_square"));
				serDmdVO.setDmdBudget(rs.getInt("dmd_budget"));
				serDmdVO.setDmdIntro(rs.getString("dmd_intro"));
				serDmdVO.setDmdPic(rs.getBytes("dmd_pic"));

				serDmdVOList.add(serDmdVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeResource(con, pstmt, rs);
		}

		return serDmdVOList;
	}

}
