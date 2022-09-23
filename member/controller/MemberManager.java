package member.controller;

import member.model.vo.Gold;
import member.model.vo.Silver;
import member.model.vo.Vip;
import member.model.vo.Vvip;

public class MemberManager {

	
	private int sindex= 0;
	private int gindex= 0;
	private int vindex= 0;
	private int vvindex= 0;
	Silver [] silvers ;
	Gold [] golds;
	Vip [] vips;
	Vvip [] vvips;
	
	public MemberManager() {
		silvers = new Silver [10] ;
		golds = new Gold [10];
		vips = new Vip [10];
		vvips = new Vvip[10];
	}
	
	public void silverInsert(Silver s) {
		silvers[sindex++] =s;
	}
	public void goldInsert(Gold g) {
		golds[gindex++] = g;
	}
	public void vipInsert(Vip v) {
		vips[vindex++] = v;
	}
	public void vvipInsert(Vvip vv) {
		vvips[vvindex++] = vv;
	}
	
	
	public void printDate(){
		
		System.out.println("-----------------<<회원정보>>--------------------");
		System.out.println("이름\t등급\t포인트\t이자포인트");
		System.out.println("----------------------------------------------");
		for (int i = 0 ; i <sindex ; i++) {
			System.out.println(silvers[i].silverInfo());
			
		}
		for (int i = 0 ; i <gindex ; i++) {
			System.out.println(golds[i].goldInfo());
			
		}
		for (int i = 0 ; i <vindex ; i++) {
			System.out.println(vips[i].vipInfo());
			
		}
		for (int i = 0 ; i <vvindex ; i++) {
			System.out.println(vvips[i].vvipInfo());
			
		}
	}
	
	
	
	
	
}
