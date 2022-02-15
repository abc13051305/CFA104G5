package ezs.ser_vdr.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SerVdrTest {
	public static void main(String[] args) {
		SerVdrDAO_interface dao = new SerVdrJDBCDAO();
		
		//新增 測試OK
		SerVdrVO ven = new SerVdrVO();
		ven.setVdrID(10);
		ven.setVdrStatus((byte) 1);
		ven.setVdrName("吳永智");
		ven.setVdrTel("0944789321");
		ven.setVdrVatno(null);
		ven.setVdrCounty("台北市");
		ven.setVdrDist("松山區松山路");
		ven.setVdrAddr("一段一號");
		ven.setVdrOpen("8:00-18:00");
		ven.setVdrIntro("你好");
		ven.setVdrPic(null);
		ven.setVdrRevCount(5);
		ven.setVdrRevScore(5);
		dao.insert(ven);
		
		
		//修改 測試ok
//		SerVdrVO ven2 = new SerVdrVO();
//		ven2.setVdrID(5);
//		ven2.setVdrStatus((byte) 1);
//		ven2.setVdrName("郭惠民");
//		ven2.setVdrTel("0956789899");
//		ven2.setVdrVatno(null);
//		ven2.setVdrCounty("台北市");
//		ven2.setVdrDist("大安區");
//		ven2.setVdrAddr("忠孝西路一段");
//		ven2.setVdrOpen("09:00-18:00");
//		ven2.setVdrIntro("你好");
//		ven2.setVdrPic(null);
//		ven2.setVdrRevCount(5);
//		ven2.setVdrRevScore(5);
//		dao.update(ven2);
		
		//刪除 測試ok
//		dao.delete(10);
		
		//查詢 測試OK
//		SerVdrVO ver3 =dao.findByPrimaryKey(2);
//		System.out.print(ver3.getVdrID()+" ");
//		System.out.print(ver3.getVdrStatus()+" ");
//		System.out.print(ver3.getVdrname()+" ");
//		System.out.print(ver3.getVdrTel()+" ");
//		System.out.print(ver3.getVdrVatno()+" ");
//		System.out.print(ver3.getVdrCounty()+" ");
//		System.out.print(ver3.getVdrDist()+" ");
//		System.out.print(ver3.getVdrAddr()+" ");
//		System.out.print(ver3.getVdrOpen()+" ");
//		System.out.print(ver3.getVdrIntro()+" ");
//		System.out.print(ver3.getVdrPic()+" ");
//		System.out.print(ver3.getVdrRevCount()+" ");
//		System.out.print(ver3.getVdrRevScore()+" ");
		
		//查詢2 測試ok
		List<SerVdrVO> list = dao.getAll();
		for (SerVdrVO ver4 : list) {
			System.out.print(ver4.getVdrID()+" ");
			System.out.print(ver4.getVdrStatus()+" ");
			System.out.print(ver4.getVdrName()+" ");
			System.out.print(ver4.getVdrTel()+" ");
			System.out.print(ver4.getVdrVatno()+" ");
			System.out.print(ver4.getVdrCounty()+" ");
			System.out.print(ver4.getVdrDist()+" ");
			System.out.print(ver4.getVdrAddr()+" ");
			System.out.print(ver4.getVdrOpen()+" ");
			System.out.print(ver4.getVdrIntro()+" ");
			System.out.print(ver4.getVdrPic()+" ");
			System.out.print(ver4.getVdrRevCount()+" ");
			System.out.print(ver4.getVdrRevScore()+" ");
		}
			
		
		
		
        }

}
