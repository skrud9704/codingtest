package study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 16434 드래곤앤던전 
// 1차 시도 : 2%대에서 바로 틀림 ) 원인 - 중간에 현재 HP가 딸려서 죽는 경우를 생각하지 않음
// 2차 시도 : 2%대에서 바로 틀림 ) 원인 - 풀이방법 바꾸자.. -> 이분탐색
// 3차 시도 : 컴파일에러 클래스명 Main으로 안바꿔줌.
// 4차 시도 : 2%대에서 바로 틀림 ) 원인 - while(start<end) -> while(start<=end), curHp > mid인 경우 간과
// 5차 시도 : 성공.
public class DragonAndDungeon{	
	public static void main(final String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		
		int[][] dungeon = new int[Integer.parseInt(s1[0])][3];
		long hAttack = Long.parseLong(s1[1]);
		
		for(int i=0;i<dungeon.length;i++) {
			String[] s2 = br.readLine().split(" ");
			dungeon[i][0] = Integer.parseInt(s2[0]);
			dungeon[i][1] = Integer.parseInt(s2[1]);
			dungeon[i][2] = Integer.parseInt(s2[2]);
		}
		
		solution2(dungeon, hAttack);
	}
	
	
	private static void solution2(int[][] dungeon, long hAttack) {
		long start = 1, end = ((long)2 << 62)-1;
		while(start <= end) {
			long mid = (start + end) / 2;
			long curAttack = hAttack;
			long curHp = mid;			// 포션, 싸움 등으로 mid정보가 손실되므로 따로 curHP만듬.
			boolean isDead = false;
			
			// 던전 돌기 시작
			for(int i=0;i<dungeon.length;i++) {
				if(dungeon[i][0] == 1) {	// 몬스터
					long figthCount = (long) Math.ceil((double)dungeon[i][2] / curAttack);
					curHp -= dungeon[i][1] * (figthCount-1);
					if(curHp < 1) {
						isDead = true;
						break;
					}
				}else {						// 포션
					curAttack += dungeon[i][1];
					curHp += dungeon[i][2];
					if(curHp>mid) curHp = mid;
				}
			}
			
			if(isDead) 	// maxHP를 올린다
				start = mid + 1;
			else 		// maxHP를 내린다
				end = mid - 1;
			
		}
		System.out.println(start);
	}
	
	/*private static void solution() {
		hCurHp = hMaxHp = 0;
		long hCurAttack = hAttack;
		
		// 던전 돌기
		for(int i=0;i<dType.length;i++) {
			if(dType[i] == 1) {	// 몬스터
				int hitMonster = (int) Math.ceil((double)dHp[i] / hCurAttack);
				long humanDamage = dAttack[i] * (hitMonster-1) +1;
				hCurHp -= (humanDamage + 1);
				if(humanDamage > hMaxHp)
					hMaxHp = humanDamage;
				if(Math.abs(hCurHp) == hMaxHp) {
					hMaxHp = Math.abs(hCurHp) + 1;
					hCurHp = -1;
				}else if(Math.abs(hCurHp) < hMaxHp) {
					hMaxHp = Math.abs(hCurHp);
					hCurHp = -1;
				}
			}else if(dType[i] == 2) {	// 포션
				hCurAttack += dAttack[i];
				hCurHp += dHp[i];
				if(hCurHp > 0)
					hCurHp = 0;
			}
		}
		System.out.println(hMaxHp);
	}*/
}
