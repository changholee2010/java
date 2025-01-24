package com.yedam.reference;
/*
 * << 도서명, 저자, 출판사, 판매가격 >>
 */

import java.util.Scanner;

public class BookExe {

	public static void main(String[] args) {

		Book[] bookRepository = new Book[100];
		// 초기데이터.
		bookRepository[0] = new Book("이것이   자바다", "신용권", "한빛미디어", 30000);
		bookRepository[1] = new Book("자바스크립트기초", "김기초", "한빛미디어", 20000);
		bookRepository[2] = new Book("혼자공부하는자바", "김자바", "자바출판사", 25000);

		boolean run = true;
		Scanner scn = new Scanner(System.in);

		// 1.전체목록 2.도서등록 3.조회(출판사) 9.종료
		while (run) {
			System.out.println("1.전체목록 2.도서등록 3.조회(출판사) 4.금액수정 9.종료");
			System.out.print("메뉴를 선택하세요> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 목록출력. 도서명, 저자, 가격
				System.out.println("도서명        저자    가격");
				System.out.println("========================");
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] != null) {
						System.out.println(bookRepository[i].showBookInfo());
					}
				}
				System.out.println("========================");
				break;

			case 2: // 입력.
				// 등록하기.
				System.out.print("도서명 입력>>");
				String name = scn.nextLine();
				System.out.print("저자 입력>>");
				String author = scn.nextLine();
				System.out.print("출판사 입력>>");
				String press = scn.nextLine();
				System.out.print("가격 입력>>");
				int price = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] == null) {
						bookRepository[i] = new Book(name, author, press, price);
						System.out.println("등록완료.");
						break; // for 종료.
					}
				}
				break; // switch case 종료.

			case 3: // 조회(출판사)
				System.out.print("출판사 입력>>");
				press = scn.nextLine();

				System.out.println("도서명        저자    가격");
				System.out.println("========================");
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] != null && //
							bookRepository[i].getBookPress().equals(press)) {
						System.out.println(bookRepository[i].showBookInfo());
					}
				}
				System.out.println("========================");
				break;

			case 4: // 수정.
				System.out.print("도서명 입력>>");
				name = scn.nextLine();
				System.out.print("가격 입력>>");
				price = Integer.parseInt(scn.nextLine());
				// 도서명으로 검색 => 입력값으로 필드변경.
				boolean isExist = false; //
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] != null //
							&& bookRepository[i].getBookTitle().equals(name)) {
						bookRepository[i].setBookPrice(price);
						System.out.println("수정완료.");
						isExist = true;
						break; // 수정완료되면 반복문 종료.
					}
				} // end of for.
				if (!isExist) {
					System.out.println("찾는 도서가 없습니다.");
				}
				break;

			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}

		} // end of while.
		System.out.println("end of prog.");

	} // end of main.

}
