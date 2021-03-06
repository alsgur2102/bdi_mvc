package com.board.bdi.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 댓글정보 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class CommentInfoVO implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 댓글번호. */
	private Integer cinum;

	/** 댓글내용. */
	private String citext;

	/** 댓글등록일. */
	private String cicredat;

	/** 댓글수정일. */
	private String cimoddat;
	
	private Integer uinum;
	
	private Integer binum;
	
	private String uiname;

	public Integer getUinum() {
		return uinum;
	}

	public void setUinum(Integer uinum) {
		this.uinum = uinum;
	}

	public Integer getBinum() {
		return binum;
	}

	public void setBinum(Integer binum) {
		this.binum = binum;
	}

	public String getUiname() {
		return uiname;
	}

	public void setUiname(String uiname) {
		this.uiname = uiname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 생성자.
	 */
	public CommentInfoVO() {
	}

	/**
	 * 댓글번호을 설정합니다..
	 * 
	 * @param cinum
	 *            댓글번호
	 */
	public void setCinum(Integer cinum) {
		this.cinum = cinum;
	}

	/**
	 * 댓글번호을 가져옵니다..
	 * 
	 * @return 댓글번호
	 */
	public Integer getCinum() {
		return this.cinum;
	}

	/**
	 * 댓글내용을 설정합니다..
	 * 
	 * @param citext
	 *            댓글내용
	 */
	public void setCitext(String citext) {
		this.citext = citext;
	}

	/**
	 * 댓글내용을 가져옵니다..
	 * 
	 * @return 댓글내용
	 */
	public String getCitext() {
		return this.citext;
	}

	
	public String getCicredat() {
		return cicredat;
	}

	public void setCicredat(String cicredat) {
		this.cicredat = cicredat;
	}

	public String getCimoddat() {
		return cimoddat;
	}

	public void setCimoddat(String cimoddat) {
		this.cimoddat = cimoddat;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinum == null) ? 0 : cinum.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommentInfoVO other = (CommentInfoVO) obj;
		if (cinum == null) {
			if (other.cinum != null) {
				return false;
			}
		} else if (!cinum.equals(other.cinum)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CommentInfoVO [cinum=" + cinum + ", citext=" + citext + ", cicredat=" + cicredat + ", cimoddat="
				+ cimoddat + ", uinum=" + uinum + ", binum=" + binum + ", uiname=" + uiname + "]";
	}
	

}
