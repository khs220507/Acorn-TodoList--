package TodoReg;

public class RegService {
	RegDAO dao = new RegDAO();
	
	public int regUser(User u ) {
		dao.insertUser(u);
		boolean result = u.id.isEmpty() || u.pw.isEmpty() || u.name.isEmpty()|| u.birth.isEmpty()||u.tel.isEmpty();
		int num;
		if(result) {
			num = 1;
		}else {
			num =0;
		}

		return num;
		
		
	}
	public void deleteUser(String id ) {
		dao.deleteUser(id);;
	}
}
