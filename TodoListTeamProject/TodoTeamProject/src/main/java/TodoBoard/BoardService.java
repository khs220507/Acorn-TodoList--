package TodoBoard;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import netscape.javascript.JSObject;

public class BoardService {

	BoardDAO dao = new BoardDAO();
	// 전체조회 - 현수
	/*public JSONArray showAllTodo() {
		ArrayList<Board> list = dao.showAllTodo();
		JSONArray arr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			Board b = list.get(i);
			JSONObject o = new JSONObject();
			o.put("code", b.getCode());
			o.put("no", b.getNo());
			o.put("id", b.getId());
			o.put("contents", b.getContents());
			o.put("date", b.getDate());
			o.put("star", b.getStar());
			o.put("finished", b.getFinished());
			
			arr.put(o);
		}
		
		return arr;*/
	
	private BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }

    public ArrayList<Board> getBoardData() {
        return boardDAO.showAllTodo();
    }
		
	

	// 할일등록 - 민지
	public String registerTodo(Board b) {
		return dao.registerTodo(b);
	}
    
    
    
	// 할일수정 - 현수
	// changeTodo()
	
	
	// 할일삭제 - 민지
	public void deleteTodo(String code) {
		dao.deleteTodo(code);
	}

}
