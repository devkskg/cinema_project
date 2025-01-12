package cinema_project.view;

import java.util.List;
import java.util.Scanner;

import cinema_project.controller.Controllerksk;
import cinema_project.model.vo.Movieksk;
import cinema_project.model.vo.Reservationksk;
import cinema_project.model.vo.Timetableksk;

public class Menuksk {
	private Scanner sc = new Scanner(System.in);
	private Controllerksk co = new Controllerksk();
//	private String phone = "010-1111-1111";
//	유저 메뉴
	public void userMenu() {
		System.out.println("ㅇㅇㅇ님 ㅎㅇㅎㄴㄷ");
		
		while(true) {
			System.out.println("1. 티켓 예매");
			System.out.println("2. 예매 내역 조회");
			System.out.println("3. 예매 내역 취소");
			System.out.println("10. 로그아웃");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : ticketRes(); break;
			case 2 : searchRes(); break;
			case 3 : deleteRes(); break;
			case 10 : System.out.println("로그아웃"); return;
			default : System.out.println("메뉴를 잘못 입력하셨습니다."); break;
			}
		}
	}


//		티켓 예매
	public void ticketRes() {
//		영화 목록 조회
		List<Movieksk> movieList = searchMovieList();
		
		System.out.println("*** 티켓 예매 ***");
		int resSeatNum = 0;
		while(true) {
			System.out.print("예매하실 \"좌석 수\"를 입력해주세요. : ");
			resSeatNum = sc.nextInt();
			if(resSeatNum <= 0) {
				System.out.println("잘못된 인원입니다.");
			} else {
				break;
			}
			
		}
		while(true) {
			System.out.print("예매하실 영화 번호를 선택해주세요. : ");
			int resMovieNum = sc.nextInt();
			sc.nextLine();
			
			if(resMovieNum <= 0 || movieList.size() < resMovieNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
//				선택한 영화의 영화 시간표 조회
				List<Timetableksk> timetableList = co.searchTimetableListByMovieTitle(movieList.get(resMovieNum-1).getmTitle(), resSeatNum);
				if(timetableList.isEmpty()) {
					System.out.println("예매할 수 없는 영화입니다.");
					return;
				} else {
					System.out.println("*** [" + movieList.get(resMovieNum-1).getmTitle() + "]의 상영 시간표 ***");
					for(int i = 1; i <= timetableList.size(); i++) {
						System.out.println("[" + i + "번] " + timetableList.get(i-1));
					}
					while(true) {
						System.out.print("예매하실 시간을 선택해주세요. : ");
						int timeNum = sc.nextInt();
						
						sc.nextLine();
						
						if(timeNum <= 0 || timetableList.size() < timeNum) {
							System.out.println("예매하실 시간을 잘못 입력하셨습니다.");
						} else {
//							여기서 할인된 가격 물어보고 진짜 예매할건지 확인 필요
							
//							시간표로 예매 진행, Transaction 사용
							int ticketResResult = co.ticketRes(timetableList.get(timeNum-1), resSeatNum);
							if(ticketResResult > 0) {
								System.out.println("예매가 완료되었습니다.");
							} else {
								System.out.println("예매에 실패했습니다.");
							}
							return;
						}
					}
				}
				
			}
		}
	}
//	상영중인 영화 목록 조회
	public List<Movieksk> searchMovieList() {
		System.out.println("*** 상영중인 영화 목록 ***");
		List<Movieksk> movieList = co.searchMovieList();
		if(movieList.isEmpty()) {
			System.out.println("상영중인 영화가 없습니다.");
		} else {
			for(int i = 1; i <= movieList.size(); i++) {
				System.out.println("[" + i + "번] " + movieList.get(i-1));
			}
		}
		return movieList;
	}
//	예매 내역 조회
	private List<Reservationksk> searchRes() {
		System.out.println("*** 예매 내역 조회 ***");
		List<Reservationksk> searchResList = co.searchRes();
		if(searchResList.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
		} else {
//			기능 추가
//			현재 시간 이전/이후로 나눠서 목록 조회
//			reservation 테이블에 컬럼 하나 만들어서 default로 시간값 넣어주기 필요
			for(int i = 1; i <= searchResList.size(); i++) {
				System.out.println("[" + i + "번] " + searchResList.get(i-1));
			}
		}
		return searchResList;
	}
//	예매 내역 취소
	private void deleteRes() {
		List<Reservationksk> searchResList = searchRes();
		System.out.println("*** 예매 내역 취소 ***");
		while(true) {
			System.out.print("취소할 예매 내역을 선택해주세요 : ");
			int deleteNum = sc.nextInt();
			sc.nextLine();
			if(deleteNum <= 0 || searchResList.size() < deleteNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				int result = co.deleteRes(searchResList.get(deleteNum-1));
				if(result > 0) {
					System.out.println("예매 내역 취소가 완료되었습니다.");
				} else {
					System.out.println("예매 내역이 없습니다.");
				}
				return;
			}
			
		}
	}
	
	
}
