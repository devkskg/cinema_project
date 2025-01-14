package cinema_project.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
//	테스트용 임의의 시간 설정
//		LocalDateTime ldtNow = LocalDateTime.now();
	private LocalDateTime ldtNow = LocalDateTime.of(2025, 01, 17, 13, 0, 0);
//	test용 현재 시간
	private DateTimeFormatter testdtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일, a KK시 mm분 SS초");
	private DateTimeFormatter qualification = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
	private String testNowDateTime = ldtNow.format(testdtf);
	private String qualificationDateTime = ldtNow.format(qualification);
//	리뷰용 검증 시간(현재시간 + 3시간)
//	생각해보니 구지? 그냥 영화 끝나는 시간 < 현재시간이면 되는거 아님?
//	private LocalDateTime ldtHour = ldtNow.plusHours(3);
//	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
//	private String createReviewHour = ldtHour.format(dtf);
	
	
	
//	유저 메뉴
	public void userMenu() {
		System.out.println("ㅇㅇㅇ님 ㅎㅇㅎㄴㄷ");
		System.out.println(testNowDateTime);

		while (true) {
			System.out.println("1. 티켓 예매");
			System.out.println("2. 예매 내역 조회");
			System.out.println("3. 예매 내역 취소");
			System.out.println("4. 후기 남기기");
			System.out.println("5. 영화 후기 조회");
			System.out.println("10. 로그아웃");

			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				ticketRes();
				break;
			case 2:
				searchRes();
				break;
			case 3:
				deleteRes();
				break;
			case 4:
				createReviewOne();
				break;
			case 5:
				searchReviewOne();
				break;
			case 10:
				System.out.println("로그아웃");
				return;
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				break;
			}
		}
	}

//		티켓 예매
	public void ticketRes() {
//		영화 목록 조회
		System.out.println("*** 상영중인 영화 목록 ***");
		List<Movieksk> movieList = searchMovieList();

		System.out.println("*** 티켓 예매 ***");
		int resSeatNum = 0;
		int resMovieNum = 0;
		while (true) {
			System.out.print("예매하실 영화 번호를 선택해주세요. : ");
			resMovieNum = sc.nextInt();
			sc.nextLine();

			if (resMovieNum <= 0 || movieList.size() < resMovieNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				break;
			}
		

		}
		while (true) {
			System.out.print("예매하실 \"좌석 수\"를 입력해주세요. : ");
			resSeatNum = sc.nextInt();
			if (resSeatNum <= 0) {
				System.out.println("잘못된 인원입니다.");
			} else {
//				선택한 영화의 영화 시간표 조회
//				연령제한 -- 처음부터 사용자의 나이 정보를 인자로 넣어서 timetableList 가져오자.
				List<Timetableksk> timetableList = co
						.searchTimetableListByMovieTitleDate(movieList.get(resMovieNum - 1).getmTitle(), resSeatNum, qualificationDateTime);
				if (timetableList.isEmpty()) {
					System.out.println("예매할 수 없는 영화입니다.");
					return;
				} else {
					System.out.println("*** [" + movieList.get(resMovieNum - 1).getmTitle() + "]의 상영 시간표 ***");
					for (int i = 1; i <= timetableList.size(); i++) {
						System.out.println("[" + i + "번] " + timetableList.get(i - 1));
					}
					while (true) {
						System.out.print("예매하실 시간을 선택해주세요. : ");
						int timeNum = sc.nextInt();

						sc.nextLine();

						if (timeNum <= 0 || timetableList.size() < timeNum) {
							System.out.println("예매하실 시간을 잘못 입력하셨습니다.");
						} else {

							int ticketPrice = movieList.get(resMovieNum-1).getmPrice();
//							여기서 할인된 가격 물어보고 진짜 예매할건지 확인 필요
//								if(생일자 && 남은 좌석수 <= 3 * 한줄 좌석수 ) {
							System.out.println("생일을 축하드립니다!\n생일 할인과 앞좌석 할인을 적용했습니다.\n할인 가격은 " + (int)(ticketPrice * (1-0.1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
//								} else if (생일자) {
							System.out.println("생일을 축하드립니다!\n생일 할인을 적용했습니다.\n할인 가격은 " + (int)(ticketPrice * (1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
//							} else if(남은 좌석수 <= 3 * 한줄 좌석수) {
							System.out.println("앞좌석 할인을 적용했습니다.\n할인 가격은 " + (int)(ticketPrice * (1-0.1)) + "원 입니다."+"\n예매 하시겠습니까?(Y/N) : ");
							
//							} else {
							System.out.println("가격은 " + ticketPrice * (1) + "입니다."+"\n예매 하시겠습니까?(Y/N) : ");
//							}
							String yn = sc.nextLine().toUpperCase();
							if("Y".equals(yn)) {
								
							}else {
								System.out.println("예매를 취소합니다.");
								return;
							}
//							시간표로 예매 진행, Transaction 사용
							int ticketResResult = co.ticketRes(timetableList.get(timeNum - 1), resSeatNum);
							if (ticketResResult <= 0) {
								System.out.println("예매에 실패했습니다.");
							} else {
								System.out.println("예매가 완료되었습니다.");
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
//		System.out.println("*** 상영중인 영화 목록 ***");
		List<Movieksk> movieList = co.searchMovieList();
		if (movieList.isEmpty()) {
			System.out.println("상영중인 영화가 없습니다.");
		} else {
			for (int i = 1; i <= movieList.size(); i++) {
				System.out.println("[" + i + "번] " + movieList.get(i - 1));
			}
		}
		return movieList;
	}

//	예매 내역 조회
	public List<Reservationksk> searchRes() {
		System.out.println("*** 예매 내역 조회 ***");
		List<Reservationksk> searchResList = co.searchRes();
		if (searchResList.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
		} else {
//			기능 추가
//			현재 시간 이전/이후로 나눠서 목록 조회
//			reservation 테이블에 컬럼 하나 만들어서 default로 시간값 넣어주기 필요
			for (int i = 1; i <= searchResList.size(); i++) {
				System.out.println("[" + i + "번] " + searchResList.get(i - 1));
			}
		}
		return searchResList;
	}

//	예매 내역 취소
	public void deleteRes() {
		List<Reservationksk> searchResList = searchRes();
		System.out.println("*** 예매 내역 취소 ***");
		while (true) {
			System.out.print("취소할 예매 내역을 선택해주세요 : ");
			int deleteNum = sc.nextInt();
			sc.nextLine();
			if (deleteNum <= 0 || searchResList.size() < deleteNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				int result = co.deleteRes(searchResList.get(deleteNum - 1));
				if (result > 0) {
					System.out.println("예매 내역 취소가 완료되었습니다.");
				} else {
					System.out.println("예매 내역이 없습니다.");
				}
				return;
			}

		}
	}

//	후기 남기기 자격 확인 // 리뷰 자격 - 예매 기록이 있고 그 기록이 3시간 이상 흐를 것
//	위 조건 안됨. 예매를 하루 전에 하는 경우도 있으니까. -> 예매한 영화의 시작시간 + 3시간 이상 흐를 것.
	public List<Reservationksk> createReviewQualification() {
		List<Reservationksk> qualifList = co.createReviewQualification(qualificationDateTime);
		return qualifList;
	}

//	후기 남기기
	public void createReviewOne() {
		System.out.println("*** 후기 남기기 ***");
		int result = 0;
		List<Reservationksk> qualifList = createReviewQualification();
		if (qualifList.isEmpty()) {
			System.out.println("후기를 작성할 수 있는 영화가 없습니다.");
		} else {
			for (int i = 1; i <= qualifList.size(); i++) {
				System.out.println("[" + i + "번] " + qualifList.get(i - 1));
			}
			while (true) {
				System.out.print("후기를 작성할 영화를 선택해주세요. : ");
				int reviewNum = sc.nextInt();
				sc.nextLine();
				if (reviewNum <= 0 || qualifList.size() < reviewNum) {
					System.out.println("잘못 입력하셨습니다.");
				} else {
					System.out.print("후기 작성 : ");
					String reviewStr = sc.nextLine();
//					reviewStr += 김*수+" : "; 이렇게 처리한거
					reviewStr += "\n";
					result = co.createReviewOne(qualifList.get(reviewNum - 1), reviewStr);
					if (result > 0) {
						System.out.println("후기 작성이 완료되었습니다.");
					} else {
						System.out.println("후기 작성에 실패하였습니다.");
					}
					return;
				}
			}
		}
	}

//	영화 후기 조회
	public void searchReviewOne() {
		System.out.println("*** 후기 조회 ***");
		List<Movieksk> list = searchMovieList();
		while (true) {
			System.out.print("후기를 조회할 영화를 선택해주세요. : ");
			int reviewNum = sc.nextInt();
			sc.nextLine();
			if (reviewNum <= 0 || list.size() < reviewNum) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				Movieksk searchReviewMovie = co.searchReviewOne(list.get(reviewNum-1));
//				Movieksk searchReviewMovie = co.searchReviewOne(list.get(reviewNum-1, 유저의 정보(이름)));
				if (searchReviewMovie.getmReview().length() == 0 || searchReviewMovie == null) {
					System.out.println("--작성된 후기가 없습니다.--");
				} else {
					System.out.println("\n" + searchReviewMovie.getmReview());
				}
				return;
			}
		}
	}

}
