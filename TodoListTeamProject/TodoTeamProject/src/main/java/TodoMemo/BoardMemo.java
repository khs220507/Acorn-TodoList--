package TodoMemo;

public class BoardMemo {

	String m_code;
	String m_contents;
	
	public BoardMemo() {
		// TODO Auto-generated constructor stub
	}

	
	public BoardMemo(String m_code, String m_contents) {
		super();
		this.m_code = m_code;
		this.m_contents = m_contents;
	}
	
	
	public String getM_code() {
		return m_code;
	}



	public void setM_code(String m_code) {
		this.m_code = m_code;
	}



	public String getM_contents() {
		return m_contents;
	}



	public void setM_contents(String m_contents) {
		this.m_contents = m_contents;
	}





	@Override
	public String toString() {
		return "BoardMemo [m_code=" + m_code + ", m_contents=" + m_contents + "]";
	}
	
	
}
