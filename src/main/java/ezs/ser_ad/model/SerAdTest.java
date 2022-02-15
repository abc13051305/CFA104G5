package ezs.ser_ad.model;

import java.util.List;


public class SerAdTest {
	public static void main(String[] args) {
		SerAdJDBCDAO dao = new SerAdJDBCDAO();

		// 新增 測試OK
		SerAdVO ser1 = new SerAdVO();
		ser1.setAdVdrID(5);
		ser1.setAdStatus((byte) 1);
		ser1.setAdSerClaID(1);
		ser1.setAdDiSt("中部");
		ser1.setAdTxt("中壢區中豐路一段一號");
		ser1.setAdPic(null);
		dao.insert(ser1);

		// 修改 測試ok
		SerAdVO ser2 = new SerAdVO();
		ser2.setAdVdrID(2);
		ser2.setAdStatus((byte) 1);
		ser2.setAdSerClaID(3);
		ser2.setAdDiSt("北部");
		ser2.setAdTxt("松山區松山路一段一號");
		ser2.setAdPic(null);
		dao.update(ser2);

		// 刪除 測試OK
		dao.delete(5, 4);

//		//查詢 測試OK
		SerAdVO ser3 = dao.findByPrimartKey(3, 2);
		System.out.print(ser3.getAdVdrID());
		System.out.print(ser3.getAdStatus());
		System.out.print(ser3.getAdSerClaID());
		System.out.print(ser3.getAdDiSt());
		System.out.print(ser3.getAdTxt());
		System.out.print(ser3.getAdPic());
//		
		// 查詢2 測試OK
		List<SerAdVO> list = dao.getAll();
		for (SerAdVO ser4 : list) {
			System.out.print(ser4.getAdVdrID() + " ");
			System.out.print(ser4.getAdStatus() + " ");
			System.out.print(ser4.getAdSerClaID() + " ");
			System.out.print(ser4.getAdDiSt() + " ");
			System.out.print(ser4.getAdTxt() + " ");
			System.out.print(ser4.getAdPic() + " ");
		}

	}
}
