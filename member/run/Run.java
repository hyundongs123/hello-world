package com.sh.api.member.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import com.sh.api.member.model.vo.Member;

public class Run {

	public static void main(String[] args) {
// 간단하게 하다 싫패
//		String str = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
//		StringTokenizer token = new StringTokenizer(str, "|");
//		
//		Member[] memberarr = new Member[token.countTokens()];
//		int i = 0; // 인덱스 쓸것
//
//		while (token.hasMoreTokens()) { // 분리하고 다음토큰으로 넘어감
//		
//			String member = token.nextToken();
//			String[] memberstr = member.split(",");
//
//			Member m = new Member();
//
//			m.setMemberNo(Integer.parseInt(memberstr[0]));
//			m.setMemberName(memberstr[1]);
//			m.setHeight(Integer.parseInt(memberstr[2]));
//			m.setWeight(Integer.parseInt(memberstr[3]));
//
//			int y = Integer.parseInt(memberstr[4].substring(0, 4));
//			int mm = Integer.parseInt(memberstr[4].substring(4, 6));
//			int d = Integer.parseInt(memberstr[4].substring(6));
//			m.setBirth(new GregorianCalendar(y, mm-1, d));
//
//			memberarr[i++] = m; // Member 데이터형 m ( 정보 하나가 객체에 담겨서) 객체배열 memberarr 에담긴다.
//		}
//
//		for (Member s : memberarr) { // s 에 넣어서 리턴값 받기
//			System.out.println(s.infomation());
//		}
//
//	}
//}

 Member m = new Member();
		StringTokenizer tokenizer = new StringTokenizer(m.infomation(),"|"); // 먼저 객체배열을 | 로 나눠서 넣어준다
		Member arr [] = new Member [tokenizer.countTokens()];     // 객체 배열 은 토크나이저 카운트 길이로 선언해준다.
		
		int i = 0;                       // 멤버에 사람이 하나 다들어가면 인덱스 넘어가게끔  i를 바깥에다 선언             
		while (tokenizer.hasMoreTokens()) {        //토큰이 하나 써지면 다음넘어가게끔  hasMoretokens 
			StringTokenizer tokenizer1 = new StringTokenizer(tokenizer.nextToken(),",");
		
			int memberNo = Integer.parseInt(tokenizer1.nextToken());         //  String 을 잘라서 인트변환해서 넘버에 넣는다
			String memberName =  tokenizer1.nextToken();       // String 이니까 그냥 넣어준다 
 			int height =  Integer.parseInt (tokenizer1.nextToken()); 
			int weight = Integer.parseInt (tokenizer1.nextToken());
			String birth = tokenizer1.nextToken();
			
			  // 생년 월일 19900905
			 SimpleDateFormat sf = new SimpleDateFormat ("yyyymmdd"); // 오늘배운 날짜 형식 포맷 문법 
			Calendar cal = Calendar.getInstance();      // String 을 calendar 로 변환하는 문법
			cal.set(Integer.valueOf(birth.substring(0,4)),Integer.valueOf(birth.substring(4,6)),Integer.valueOf(birth.substring(6,8)));           //yyyy mm dd 스트링을 잘라서 셋팅 캘린더를 셋팅한다.
			
			 Member mem = new Member(memberNo,memberName,height,weight,cal);
			
			arr [i++] = mem ;
		}
		
		
		for (int s = 0 ; s <  i ; s ++) {
			System.out.println(arr[s].toString());
		}
	}
}
