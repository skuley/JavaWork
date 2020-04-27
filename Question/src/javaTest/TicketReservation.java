package javaTest;

import java.util.Date;

public class TicketReservation {

	private int uid;
	private int movieId;
	private int seatId;
	private Date regDate;
	
	// 기본 생성자 Default Constructor
	public TicketReservation() {
		// TODO Auto-generated constructor stub
	}
	
	// Constructor using Fields
	public TicketReservation(int uid, int movieId, int seatId, Date regDate) {
		super();
		this.uid = uid;
		this.movieId = movieId;
		this.seatId = seatId;
		this.regDate = regDate;
	}

	
	// getters and setters
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
	
	
}
