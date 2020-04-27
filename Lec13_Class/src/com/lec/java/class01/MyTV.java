package com.lec.java.class01;

/*
클래스:
우리가 만들고자 하는 대상의 '상태(특성) = 변수' 와 '기능(동작) = 메소드' 을
 함께 가지고 있는 '데이터 타입'
상태(속성, 필드) -> 클래스의 멤버변수로 정의 
    field, attribute, member variable 라고 함
기능(동작) -> 클래스의 멤버메소드로 정의  
    behavior, member method 라고 함


일반적으로 
 멤버변수(필드)는 private 으로 설정. 
 멤버메소드는 public 으로 설정.
*/

public class MyTV {
	
	// TV 의 상태(특성) --> 필드, (멤버변수)
	// 멤버변수 : 같은 클래스에서 정의된 모든 메소드에서 사용 가능.
	private boolean isPowerOn; // 전원 on/off
	private int channel; // 현재 채널
	private int volume; // 현재 볼륨
	
	// ******* 텔리비젼 설계도 *******
	
	// TV 의 기능(동작) --> (멤버) 메소드
	// 현재 상태 표시
	public void displayStatus() {
		System.out.println("TV 현재 상태");
		System.out.println("---------------------------------");
		System.out.println("전원상태 : " + isPowerOn); // 동일클래스 안의 멤버들 서로 사용 가능
		System.out.println("채널상태 : " + channel);
		System.out.println("볼륨상태 : " + volume);
		System.out.println("---------------------------------");
	} // displayStatus()
	
	// 전원 토글 동작
	public void powerOnOff() {
		if(isPowerOn) { // TV가 켜져 있다면
			isPowerOn = false;
			System.out.println("TV를 끕니다.");
		} else {
			isPowerOn = true;
			System.out.println("TV를 킵니다.");
		} // else
	} // powerOnoff()
	
	// 채널+ 동작
	public int channelUp() {
		channel++;
		System.out.println("현재 채널 : " + channel);
		return channel;
	} //channelUp()
	
	// 채널- 동작
	public int channelDown() {
		channel--;
		System.out.println("현재 채널 : " + channel);
		return channel;
	} // channelDown
	
	// 볼륨+ 동작
	public int volumeUp() {
		volume++;
		System.out.println("현재 볼륨 : " + volume);
		return volume;
	} // volumeUp()
	
	// 볼륨- 동작
	public int volumeDown() {
		volume--;
		System.out.println("현재볼륨 : " + volume);
		return volume;
	}

	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	
} // MyTV


