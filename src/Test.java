import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String cmd = "";
//		String store = null; // "" -> 없는 데이터, null
//		ArrayList<Article> articles = new ArrayList<Article>();  // 클래스 아티클에 저장한다.
		
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
				System.out.println("add : 게시물 저장");
				System.out.println("read : 게시물 조회");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
			}
			
			if(cmd.equals("add")) {
				
				Article article = new Article();
				article.id = id;
				id++;
				
				System.out.println("제목을 입력해주세요");
				String title = sc.nextLine();
				titles.add(title);
				
				System.out.println("내용을 입력해주세요");
				String body = sc.nextLine();
				bodies.add(body);
//				bodies.add(body);
				
				System.out.println("작성자를 입력해주세요");
				String writer = sc.nextLine();
				writers.add(writer);
//								
//				articles.add(article);
				System.out.println("게시물이 등록되었습니다.");

			}
			if(cmd.equals("read")) {
				System.out.println("======== 게시물 목록 ========");
				for(int i = 0; i < ids.size() ; i++) {
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
				System.out.print("어떤 게시물을 삭제하시겠습니까? : ");
				int targetNo = Integer.parseInt(sc.nextLine());  //인티저로 박싱 ★★★★★명령어를 입력하세요가 두번뜸. 이거 안하면.
				int targetIndex = -1;
				for (int i = 0; i<ids.size();i++) {
					if(ids.get(i)==targetNo) {
						targetIndex = i ;
						break;
					}
				}
				if (targetIndex != -1) {  // 타겟인덱스가 -1이 아니면...
					
					ids.remove(targetIndex);
					titles.remove(targetIndex);   //타겟인덱스로 들어온번호가 곳 순서니까 같은 번호를 삭제한다.
					bodies.remove(targetIndex);
					writers.remove(targetIndex);
//					sc.nextLine();
					System.out.println("삭제가 완료되었습니다.");
					
				}else {
					System.out.println("없는 게시물 번호입니다.");
				}
			}
		}
		
	}

}

//저장하고 바꿔주는 클래스를  DataClass, DTO 라고한다. 
class Article{
	int id;
	String title;
	String body;
	String writer;
}

/*
1. 게시물 등록
 - 제목, 내용, 작성자 저장
 - 배열을 이용해 게시물 내용 저장
 - 등록중에 길이를 넘어서 등록할 때 오류..
 - ArrayList 도입
 
 2. 게시물 목록조회
 -제목:제목
 -작성자:작성자
 -배열에 있는 게시물들 목록화(리스팅)
 
 -게시물 목록을 위해 배열사용
 -게시물 조회했는데 한꺼번에 나옴.
 
 7. 
 
 8. 게시물 삭제.
 입력받은 번호에 해당하는 게시물 인덱스찾기!!!
 
 9. 게시물 정보를 하나하나 관리하기 어려움
 Article Class 도입 -> 게시물 데이타 구조화
 하나의 게시물을하나의 객체로 관리하므로
 저장소도 하나만 필요. ArrayList<Article>
 추가, 삭제, 수정, 조회
 
 10. 게시물 번호로 게시물 찾아노느 코드 중복발생
 -메서드로 분리(get_article_by_id)
 -분리 시 메인 메서드가 static이므로
 get_article_by_id도 static으로 정의
 articles 리스트를 메인과 get_article_by_id같이 사용
 해야하므로 메인 메서드 밖이
 */