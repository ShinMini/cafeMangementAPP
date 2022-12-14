package controller.feature;

import java.io.IOException;
import java.util.Scanner;

import controller.cafe.SelectModel;
import controller.management.Login;
import controller.management.SearchClient;
import controller.management.SignIn;
import model.Clients;

public class PrintFunctions {
   public static Scanner sc = new Scanner(System.in);

   // 1번: 아이디 중복, 2번: 아이디가 중복되지 않은 경우. 3번 :
   public static void print_sginup_request(boolean id_overlapChecker) throws IOException { // 해당 아이디값이 이미 존재할 경우 호출되는 창
      ConsoleController.ClearScreen(); // 콘솔 clear

      if (id_overlapChecker) {
         System.out.println("## 해당 아이디값이 이미 존재합니다 \n\n##");
      }
      System.out.println("###############################");
      System.out.println("### 1. Login ###\n");
      System.out.println("### 2. Sign up###\n");
      System.out.println("### 3. find ID password ###\n");
      System.out.println("### 4. Exit process ###\n");
      System.out.println("###############################");

      String input_option = sc.next();
      switch (OptionChecker(input_option)) {
         case -1: // 정상적인 값이 아닌경우.
            print_sginup_request(false);

            break;
         case 1: // 로그인출력
            Login.login();

            break;
         case 2: // 회원가입 화면 출력
            SignIn.signIn(false);

            break;
         case 3: // 아이디 비밀번호 찾기
            SearchClient.FindClients();

            break;
         case 4: // 프로그램 종료 화면 출력
            ConsoleController.KillScreen();

            break;
         default:

            break;
      }
   }

   // 규리님이 완성해보셔용
   public static void print_success_login(Clients client){
      System.out.println(client.getClientName()+"고객님 안녕하세요");
      SelectModel.ManagementCafe();

   }

   public static int OptionChecker(String case1_option) { // 정상적인 숫자가 아닌경우 -1반환
      char check_option = case1_option.charAt(0); // 문자열 첫번째 글자 가져옴

      if (Character.isDigit(check_option)) { // 해당 input text가 숫자로 변환 가능한 경우.
         return check_option - '0'; // return 선택한 입력값
      } else
         return -1;
   }
}
