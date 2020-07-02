package com.lec.sts15_mybatis.ticket;

public interface ITicketDAO {
	// *** 아래의 두 동작이 하나의 transaction으로 처리 되어야 한다. ***
	int insertCard(String userId, int buyAmount);
	int insertTicket(String userId, int ticketCount);
	
	
}
