package TodoBoard;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import netscape.javascript.JSObject;
 
public class BoardService {

	BoardDAO dao = new BoardDAO();
	
	private BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }
    
    public Board getBoardOne(String code) {
		Board b =  dao.selectOne(code);
		return b;
	}

    public ArrayList<Board> getBoardData() {
        return boardDAO.showAllTodo();
    }
    
    public void changeBoardData(Board b) {
    	dao.changeTodo(b);
    }
		
    
 // 할일등록 - 민지
 	public String registerTodo(Board b) {
 		return dao.registerTodo(b);
 	}
     
     
     
 	
 	
 	// 할일삭제 - 민지
 	public void deleteTodo(String code) {
 		dao.deleteTodo(code);
 	}

	

	// 할일등록 - 민지
	// registerTodo()
	
	// 할일삭제 - 민지
	// deleteTodo()

 	
}
