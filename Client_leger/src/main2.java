import model.DaoHistoConn;
import model.DaoTitre;

public class main2 {
	public static void main(String[] args) {
DaoHistoConn dao = new DaoHistoConn();
System.out.println(dao.getListDate(34));
System.out.println(dao.getListEtat(34));
System.out.println(dao.getListIp(34));
System.out.println(dao.getListLogin(34));
	}

}