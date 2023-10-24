package com.ll;

import java.util.Scanner;
import java.util.ArrayList;
class Main {
    static ArrayList<phrase> phraseList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        String order;
        while(true){


            System.out.println("명령을 입력하세요 : ");
            order = scanner.next();
            if(order.equals("종료")){
                System.out.println("명언 앱을 종료 합니다.");

                return;
            }else if(order.equals("등록")){
                if(register(scanner)){
                    continue;
                }else{
                    System.out.println("명언 등록 실패");
                }
            }else if(order.equals("목록")){
                read();
            }else if(order.equals("삭제")){
                read();
                delete(scanner);
            }else if(order.equals("수정")){
                read();
                update(scanner);
            }


        }
    }

    static boolean register(Scanner sc){

        String a;
        String b;
        System.out.println("작가를 입력하세요 : ");
        a = sc.next();
        System.out.println("명언을 입력하세요 : ");
        b = sc.next();
        phrase rgst_phrase = new phrase(a,b);


        phraseList.add(rgst_phrase);
        System.out.println(phraseList.size() + "번 명언이 등록되었습니다");
        return true;

    }

    static void update(Scanner sc){
        System.out.println("몇번 명언을 수정하시겠습니까?");
        int a= Integer.parseInt(sc.next());
        if(a < 0 || a > phraseList.size()){
            System.out.println(a+"번 명언은 존재하지 않습니다");
            return;
        }

        String phrase;
        System.out.println("기존 명언 : " + phraseList.get(a-1).phrase);
        System.out.println("수정할 명언을 입력하세요 : ");
        phrase = sc.next();
        phraseList.get(a-1).phrase = phrase;

        String name;
        System.out.println("기존 작가명 : " + phraseList.get(a-1).name);
        System.out.println("수정할 작가명을 입력하세요 : ");
        name = sc.next();
        phraseList.get(a-1).name = name;
    }
    static void read(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i=0;i<phraseList.size();i++){
            System.out.println(i+1 + " / " +phraseList.get(i).name + " / " + phraseList.get(i).phrase);
        }
    }

    static void delete(Scanner sc){
        System.out.println("몇번 명언을 삭제하시겠습니까?");
        int a= Integer.parseInt(sc.next());
        if(a < 0 || a > phraseList.size()){
            System.out.println(a+"번 명언은 존재하지 않습니다");
            return;
        }
        phraseList.remove(a-1);
        System.out.println(a+"번 명언 삭제됨");
    }
    static void save(){


    }
}
class phrase{
    //작가
    String name;
    //명언
    String phrase;


    phrase(String name , String phrase){
        this.name=name;
        this.phrase=phrase;
    }


}