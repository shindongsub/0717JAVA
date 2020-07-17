import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String cmd = "";
//		String store = null; // "" -> 없는 데이터, null
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> bodies = new ArrayList<String>();
		ArrayList<String> writers = new ArrayList<String>();
		int id = 1;
				
		while(true) {
			
			System.out.print("명령어를 입력해주세요 : ");
			cmd = sc.nextLine();
			if(cmd.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
			if(cmd.equals("help")) {
				System.out.println("add : 데이터 저장");
				System.out.println("read : 데이터 조회");
				System.out.println("update : 데이터 수정");
				System.out.println("delete : 데이터 삭제");
			}
			
			if(cmd.equals("add")) {
				
				ids.add(id);
				id++;
				
				System.out.println("제목을 입력해주세요");
				String title = sc.nextLine();
				titles.add(title);
				
//				System.out.println("내용을 입력해주세요");
//				String body = sc.nextLine();
//				bodies.add(body);
//				
//				System.out.println("작성자를 입력해주세요");
//				String writer = sc.nextLine();
//				writers.add(writer);
//								
				System.out.println("게시물이 등록되었습니다.");

			}
			if(cmd.equals("read")) {
				System.out.println("======== 게시물 목록 ========");
				for(int i = 0; i < titles.size() ; i++) {
					System.out.println("번호 : " + ids.get(i));
					System.out.println("제목 : " + titles.get(i));
					//System.out.println("내용 : " + bodies.get(i) + "\n");
				}
			}
			if(cmd.equals("update")) {
				System.out.println("어떤 게시물을 수정하시겠습니까? : ");
				int targetIndex = sc.nextInt();
				sc.nextLine();
				System.out.println("수정할 제목을 입력해주세요 : ");
				String updated_title = sc.nextLine();
				titles.set(targetIndex - 1, updated_title);
				System.out.println("수정이 완료되었습니다.");
				
			}
			if(cmd.equals("delete")) {
//				store = null;
//				System.out.println("삭제가 완료되었습니다.");
			}
		}
		
	}

}