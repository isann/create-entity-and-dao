package ifno.isann.data.access.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ifno.isann.data.access.entity.AcceptOrderEntity;

public class AcceptOrderDao {

	private Connection conn;

	/**
	* コンストラクタ
	* @throws ClassNotFoundException JDBCドライバのクラスが見つからないときスローされます。
	* @throws SQLException コネクション取得に失敗したとき、スローされます。
	*/
	public AcceptOrderDao() throws ClassNotFoundException, SQLException{

		// ドライバクラスをロード
		Class.forName("org.gjt.mm.mysql.Driver");
		// データベースへ接続
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		// オートコミットのオフ
		this.conn.setAutoCommit(false);

	}

	/**
	 * テーブル accept_order のレコードを全件取得します。
	 * @return AcceptOrderEntity のリストを返却します。
	 * @throws SQLException 
	 */
	public List<AcceptOrderEntity> selectAll() throws SQLException{

		List<AcceptOrderEntity> list = new ArrayList<AcceptOrderEntity>();

		String query = "SELECT "
			+ "A.o_num, "
			+ "A.c_num, "
			+ "A.p_num, "
			+ "A.dc_rate, "
			+ "A.option_price, "
			+ "A.employee, "
			+ "A.accept_date "
			+ "FROM accept_order A ";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				AcceptOrderEntity entity = new AcceptOrderEntity();
				entity.setONum(rs.getString("o_num"));
				entity.setCNum(rs.getString("c_num"));
				entity.setPNum(rs.getString("p_num"));
				entity.setDcRate(rs.getInt("dc_rate"));
				entity.setOptionPrice(rs.getInt("option_price"));
				entity.setEmployee(rs.getString("employee"));
				entity.setAcceptDate(new Date(rs.getTimestamp("insert_date").getTime()));
				list.add(entity);
			}
		} finally {
			rs.close();
			ps.close();
		}

		return list;
	}

	/**
	 * テーブル accept_order のレコードを主キーで検索し、データを取得します。
	 * @return AcceptOrderEntity のリストを返却します。
	 * @throws SQLException 
	 */
	public List<AcceptOrderEntity> selectId(AcceptOrderEntity entity) throws SQLException{

		List<AcceptOrderEntity> list = new ArrayList<AcceptOrderEntity>();

		String query = "SELECT "
			+ "A.o_num, "
			+ "A.c_num, "
			+ "A.p_num, "
			+ "A.dc_rate, "
			+ "A.option_price, "
			+ "A.employee, "
			+ "A.accept_date "
			+ "FROM accept_order A "
			+ "WHERE A.o_num = ? "
			;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, entity.getONum());
			rs = ps.executeQuery();
			while(rs.next()){
				AcceptOrderEntity newentity = new AcceptOrderEntity();
				newentity.setONum(rs.getString("o_num"));
				newentity.setCNum(rs.getString("c_num"));
				newentity.setPNum(rs.getString("p_num"));
				newentity.setDcRate(rs.getInt("dc_rate"));
				newentity.setOptionPrice(rs.getInt("option_price"));
				newentity.setEmployee(rs.getString("employee"));
				newentity.setAcceptDate(new Date(rs.getTimestamp("accept_date").getTime()));
				list.add(newentity);
			}
		} finally {
			rs.close();
			ps.close();
		}

		return list;
	}

	/**
	 * テーブル accept_order のレコードを挿入します。
	 * @return 挿入件数を返却します。
	 * @throws SQLException 
	 */
	public int insert(AcceptOrderEntity entity) throws SQLException{

		int ret = 0 ;

		String query = "INSERT INTO accept_order( "
			+ "o_num, "
			+ "c_num, "
			+ "p_num, "
			+ "dc_rate, "
			+ "option_price, "
			+ "employee, "
			+ "accept_date "
			+ ") VALUES ( "
			+ "?, "
			+ "?, "
			+ "?, "
			+ "?, "
			+ "?, "
			+ "?, "
			+ "? "
			+ ")";

		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, entity.getONum());
			ps.setString(2, entity.getCNum());
			ps.setString(3, entity.getPNum());
			ps.setInt(4, entity.getDcRate());
			ps.setInt(5, entity.getOptionPrice());
			ps.setString(6, entity.getEmployee());
			ps.setTimestamp(7, new Timestamp(entity.getAcceptDate().getTime()));
			ret = ps.executeUpdate();
		} finally {
			ps.close();
			conn.commit();
		}

		return ret;
	}

	/**
	 * テーブル accept_order のレコードを更新します。
	 * @return 更新件数を返却します。
	 * @throws SQLException 
	 */
	public int updateId(AcceptOrderEntity entity) throws SQLException{

		int ret = 0 ;

		String query = "UPDATE accept_order A SET "
			+ "A.c_num = ?, "
			+ "A.p_num = ?, "
			+ "A.dc_rate = ?, "
			+ "A.option_price = ?, "
			+ "A.employee = ?, "
			+ "A.accept_date = ? "
			+ "WHERE A.o_num = ? "
		;

		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, entity.getCNum());
			ps.setString(2, entity.getPNum());
			ps.setInt(3, entity.getDcRate());
			ps.setInt(4, entity.getOptionPrice());
			ps.setString(5, entity.getEmployee());
			ps.setTimestamp(6, new Timestamp(entity.getAcceptDate().getTime()));
			ps.setString(7, entity.getONum());
			ret = ps.executeUpdate();
		} finally {
			ps.close();
			conn.commit();
		}

		return ret;
	}

	/**
	 * テーブル accept_order のレコードをすべて削除します。
	 * @return 削除件数を返却します。
	 * @throws SQLException 
	 */
	public int deleteAll() throws SQLException{

		int ret = 0 ;

		String query = "DELETE FROM accept_order ";

		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ret = ps.executeUpdate();
		} finally {
			ps.close();
			conn.commit();
		}

		return ret;
	}

	/**
	 * テーブル accept_order のレコードを主キーで検索し削除します。
	 * @return 削除件数を返却します。
	 * @throws SQLException 
	 */
	public int deleteId(AcceptOrderEntity entity) throws SQLException{

		int ret = 0 ;

		String query = "DELETE FROM accept_order A "
			+ "WHERE A.o_num = ? "
			;

		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, entity.getONum());
			ret = ps.executeUpdate();
		} finally {
			ps.close();
			conn.commit();
		}

		return ret;
	}

	/**
	 * コネクションをクローズします。
	 */
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("コネクションクローズに失敗しました。");
		}
	}

}

