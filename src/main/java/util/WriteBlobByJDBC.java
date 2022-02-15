package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Util;

public class WriteBlobByJDBC {

	public static final String URLheader = "src/main/webapp/NoData/";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(Util.DRIVER);
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);

			// 請先到SQL下指令找出你的PIC欄位
			pstmt = con.prepareStatement("UPDATE ser_dmd SET dmd_pic = ? WHERE dmd_id = ? ");

			File file = new File("src/main/webapp/NoData/");
			File[] listFile = file.listFiles();
			int j = 0;
			for (int i = 0; i < file.listFiles().length; i++) {
				j = 1 + j;
				String url = listFile[i].toString();
				// 2. setBytes 萬用做法
				byte[] pic = getPictureByteArray(url);
				pstmt.setBytes(1, pic);
				pstmt.setInt(2, i);
				pstmt.executeUpdate();

			}

			System.out.println("新增成功");

		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			Util.closeResource(con, pstmt, null);
		}
	}

	// 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];// 資料流有多少byte資料
		fis.read(buffer);
		fis.close();
		return buffer;
	}
}

